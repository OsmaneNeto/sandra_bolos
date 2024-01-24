


package conexao;

        import javax.swing.*;
        import java.sql.Connection;
        import java.sql.Driver;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class ConexaoMySql {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBNAME = "sandra_bolos";
    private static final String URL = "jdbc:mysql://localhost/sandra_bolos";

    //private final String URL = "jdbc:mysql://localhost/" + DBNAME;
    private static final String LOGIN = "root";
    private static final String SENHA = "32462759Obn.";

    private static Connection connection;

    public static Connection iniciarConexao() {{
        try {
            Class.forName(DRIVER);//Todas as constantes são em caixa alta como final
            //Configuração do caminho
            //getConnection() tenta iniciar a conexão com os valores
            //passados como parâmetro
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Atenção!\n Não conectou ao banco!","Conexão ao banco de dados",JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(null, "Atenção!\n Conectou ao banco","Conexão ao banco de dados",JOptionPane.INFORMATION_MESSAGE);
        return connection;
    }

//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost//sandra_bolos//", "root", "32462759obn.");
//            return connection;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
    }
}
