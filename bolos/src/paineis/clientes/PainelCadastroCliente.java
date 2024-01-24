package paineis.clientes;

import classes.Clientes;
import conexao.ConexaoCliente;
import conexao.ConexaoMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelCadastroCliente extends JPanel{
    private JLabel jlTelefone, jlNome;
    private JTextField jtfTelefone, jtfNome;
    private JButton jbCadastrarCliente;
    private List<Clientes> cliente;
    public PainelCadastroCliente(List<Clientes> cliente) {
        this.cliente = cliente;
        setSize(400,400);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        {
            jtfNome = new JTextField();
            jtfTelefone = new JTextField();

            jlNome = new JLabel("Nome Cliente");
            jlTelefone = new JLabel("Telefone");

            jbCadastrarCliente = new JButton("Cadastrar");

            add(jtfNome);
            add(jtfTelefone);
            add(jlNome);
            add(jlTelefone);
            add(jbCadastrarCliente);

            jlTelefone.setBounds(30,40,100,20);
            jlNome.setBounds(270,40,100,20);
            jtfTelefone.setBounds(30,60,100,20);
            jtfNome.setBounds(270,60,100,20);
            jbCadastrarCliente.setBounds(150,150,100,40);

        }
    }

    private void criarEventos() {
        jbCadastrarCliente.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String telefoneC = jtfTelefone.getText();
            String  nomeC = jtfNome.getText();
            if (!telefoneC.equals("")|| !nomeC.equals(""))  {
                ConexaoCliente.cadastrarCliente(telefoneC,nomeC);
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                //limpa
                jtfTelefone.setText("");
                jtfNome.setText("");
            }

            }
});
    }
}
