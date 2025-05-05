package com.exemplo;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.sql.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        criarTabela();
        staticFiles.location("/public");
        Gson gson = new Gson();

        post("/salvar", (req, res) -> {
            String nome = req.queryParams("nome");
            String email = req.queryParams("email");
            String whatsapp = req.queryParams("whatsapp");

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:dados.db")) {
                String sql = "INSERT INTO contatos (nome, email, whatsapp) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nome);
                pstmt.setString(2, email);
                pstmt.setString(3, whatsapp);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                res.status(500);
                return "Erro ao salvar!";
            }
            res.status(200);
            return "Salvo com sucesso";
        });

        post("/atualizar", (req, res) -> {
            String id = req.queryParams("id");
            String nome = req.queryParams("nome");
            String email = req.queryParams("email");
            String whatsapp = req.queryParams("whatsapp");

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:dados.db")) {
                String sql = "UPDATE contatos SET nome = ?, email = ?, whatsapp = ? WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nome);
                pstmt.setString(2, email);
                pstmt.setString(3, whatsapp);
                pstmt.setString(4, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                res.status(500);
                return "Erro ao atualizar!";
            }
            res.status(200);
            return "Atualizado com sucesso";
        });

        post("/excluir", (req, res) -> {
            String id = req.queryParams("id");

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:dados.db")) {
                String sql = "DELETE FROM contatos WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                res.status(500);
                return "Erro ao excluir!";
            }
            res.status(200);
            return "Excluído com sucesso";
        });

        get("/contatos-json", (req, res) -> {
            res.type("application/json");
            List<Map<String, String>> contatos = new ArrayList<>();
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:dados.db")) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM contatos");
                while (rs.next()) {
                    Map<String, String> c = new HashMap<>();
                    c.put("id", String.valueOf(rs.getInt("id")));
                    c.put("nome", rs.getString("nome"));
                    c.put("email", rs.getString("email"));
                    c.put("whatsapp", rs.getString("whatsapp"));
                    contatos.add(c);
                }
            }
            return gson.toJson(contatos);
        });
    }

    private static void criarTabela() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:dados.db")) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS contatos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    "whatsapp TEXT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}