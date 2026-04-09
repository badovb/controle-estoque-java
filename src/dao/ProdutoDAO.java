package dao;

import model.Produto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProdutoDAO {

    public void inserir(Produto p) {
        String sql = "INSERT INTO produto (nome, quantidade, preco) VALUES (?, ?, ?)";

        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getPreco());

            stmt.execute();
            System.out.println("Produto inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
    public void listar() {
        String sql = "SELECT * FROM produto";

        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            var rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Quantidade: " + rs.getInt("quantidade"));
                System.out.println("Preço: " + rs.getDouble("preco"));
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }
    public void atualizar(Produto p) {
        String sql = "UPDATE produto SET nome=?, quantidade=?, preco=? WHERE id=?";

        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
    public void deletar(int id) {
        String sql = "DELETE FROM produto WHERE id=?";

        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Produto deletado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}