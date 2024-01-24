package conexao;

import javax.swing.*;
import java.sql.*;

public class ConexaoPedido {
    public static void cadastrarPedido( String nome_cliente,String telefone_cliente,String id_bolo,String data_pedido, String data_entrega) {
    String query ="INSERT INTO pedido VALUE(null,?,?,?,?,?)";
    Connection connection = ConexaoMySql.iniciarConexao();

    try {
        PreparedStatement ps = connection.prepareStatement(query);




        ps.setString(1,nome_cliente);
        ps.setString(2,telefone_cliente);
        ps.setString(3,id_bolo);
        ps.setString(4,data_pedido);
        ps.setString(5,data_entrega);



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
    public static void mostrarPedidos(JTextArea jtaCampo){
        String query;

        query = "SELECT * FROM pedido;";




        Connection connection = ConexaoMySql.iniciarConexao();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                String id_pedido = rs.getString("id_pedido");
                String nome_cliente = rs.getString("nome_cliente");
                String telefone_cliente  = rs.getString("telefone_cliente");
                String id_bolo  = rs.getString("id_bolo");
                String data_pedido  = rs.getString("data_pedido");
                String data_entrega  = rs.getString("data_entrega");


                jtaCampo.append("Id Pedido: "+id_pedido+"\nNome: "+ nome_cliente + "\nTelefone cliente: "+telefone_cliente+"\nBolo id:"+id_bolo+ "\ndata pedido: "+data_pedido+"\ndata entrega: "+ data_entrega+ "\n -------------------------------------------------------------------------------------------------------------------------------------------------\n");

            }
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void pesquisarP(String idPedido, JTextArea jtaCampo) {
        String query = "SELECT * FROM pedido WHERE id_pedido = ?";

        Connection connection = ConexaoMySql.iniciarConexao();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idPedido);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id_pedido = rs.getString("id_pedido");
                String nome_cliente = rs.getString("nome_cliente");
                String telefone_cliente = rs.getString("telefone_cliente");
                String id_bolo = rs.getString("id_bolo");
                String data_pedido = rs.getString("data_pedido");
                String data_entrega = rs.getString("data_entrega");

                jtaCampo.append("Id Pedido: " + id_pedido + "\nNome: " + nome_cliente + "\nTelefone cliente: " + telefone_cliente + "\nBolo id: " + id_bolo + "\ndata pedido: " + data_pedido + "\ndata entrega: " + data_entrega + "\n -------------------------------------------------------------------------------------------------------------------------------------------------\n");
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deletarPedido(String id_pedido){
        String query = "DELETE FROM pedido WHERE id_pedido = ?;";
        Connection connection = ConexaoMySql.iniciarConexao();
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(id_pedido));

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
}

