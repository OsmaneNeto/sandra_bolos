package conexao;

import javax.swing.*;
import java.sql.*;

public class ConexaoCliente {
    public static void cadastrarCliente( String telefone_cliente, String nome_cliente) {
        String query ="INSERT INTO cliente VALUE(?,?)";
        Connection connection = ConexaoMySql.iniciarConexao();

        try {
            PreparedStatement ps = connection.prepareStatement(query);




            ps.setString(1,telefone_cliente);

            ps.setString(2,nome_cliente);



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
    public static void mostrarClientes(JTextArea jtaCampo){
        String query;

        query = "SELECT * FROM cliente;";




        Connection connection = ConexaoMySql.iniciarConexao();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){

                String nome = rs.getString("nome_cliente");
                String telefoneCliente  = rs.getString("telefone_cliente");


                jtaCampo.append("Nome: "+ nome + "\nTelefone: "+ telefoneCliente+ "\n -------------------------------------------------------------------------------------------------------------------------------------------------\n");

            }
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void deletarCliente(String telefone_cliente) {
        String query = "DELETE FROM cliente WHERE telefone_cliente = ?;";
        Connection connection = ConexaoMySql.iniciarConexao();
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(telefone_cliente));

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
    public static void editarCliente(String telefone, String nome_cliente){

        String query = null;

        // Verifica se o telefone fornecido é válido
        try {
            int id = Integer.parseInt(telefone);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("telefone inválido: " + telefone);
        }

        // Monta a query de atualização com base no ID e no tipo de edição
        query = "UPDATE cliente SET nome_cliente =? WHERE telefone_cliente = ?;";



        Connection connection = ConexaoMySql.iniciarConexao();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            // Atribui os valores aos parâmetros da query
            ps.setString(2, telefone);
            ps.setString(1, nome_cliente);



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
}

