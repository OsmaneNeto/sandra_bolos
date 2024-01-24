package conexao;

import javax.swing.*;
import java.sql.*;

public class ConexaoMenu {
    public static void cadastrarMenu( String nome_bolo, String preco_bolo) {
        String query ="INSERT INTO menu VALUE(null,?,?)";
        Connection connection = ConexaoMySql.iniciarConexao();

        try {
            PreparedStatement ps = connection.prepareStatement(query);




            ps.setString(1,nome_bolo);

            ps.setString(2,preco_bolo);



            ps.execute();

            connection.close();
        } catch (SQLException e) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

    }
    public static void deletarMenu(String id_bolo){
        String query = "DELETE FROM menu WHERE id_bolo = ?;";
        Connection connection = ConexaoMySql.iniciarConexao();
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(id_bolo));

            ps.execute();




            connection.close();
        } catch (SQLException e) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

    }
    public static void editarmenu(String id_bolo, String nome_bolo, String valor_bolo) {
        String query = null;

        // Verifica se o ID fornecido é válido
        try {
            int id = Integer.parseInt(id_bolo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido: " + id_bolo);
        }

        // Monta a query de atualização com base no ID e no tipo de edição
            query = "UPDATE menu SET nome_bolo = ?,preco =? WHERE id_bolo = ?;";



            Connection connection = ConexaoMySql.iniciarConexao();

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                // Atribui os valores aos parâmetros da query
                ps.setString(1, nome_bolo);
                ps.setInt(2, Integer.parseInt(valor_bolo));
                ps.setInt(3, Integer.parseInt(id_bolo));

                // Executa a atualização
                int linhasAfetadas = ps.executeUpdate();

                // Verifica se a atualização foi bem-sucedida
                if (linhasAfetadas > 0) {
                    System.out.println("Atualização realizada com sucesso!");
                } else {
                    System.out.println("Nenhum registro foi atualizado.");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                // Sempre feche a conexão no bloco finally para garantir a liberação adequada
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        public static void mostrarMenu(JTextArea jtaCampo){
            String query;

                query = "SELECT * FROM menu;";




            Connection connection = ConexaoMySql.iniciarConexao();
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()){
                    String id = rs.getString("id_bolo");
                    String nome = rs.getString("nome_bolo");
                    String descricao  = rs.getString("preco");


                    jtaCampo.append("Id: "+id+"\nNome: "+ nome + "\nPreco: "+ descricao+ "\n -------------------------------------------------------------------------------------------------------------------------------------------------\n");

                }
                connection.close();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

    }

