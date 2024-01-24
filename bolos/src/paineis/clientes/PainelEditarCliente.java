package paineis.clientes;

import classes.Clientes;
import conexao.ConexaoCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelEditarCliente extends JPanel{
    private JLabel jlTelefone, jlNome;
    private JTextField jtfTelefone, jtfNome;
    private JButton JBEditarCliente;
    private List<Clientes> cliente;
    public PainelEditarCliente(List<Clientes> clientes) {
        this.cliente = cliente;
        setSize(400,400);
        setBackground(Color.BLUE);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }



    private void iniciarComponentes() {
        jtfNome = new JTextField();
        jtfTelefone = new JTextField();

        jlNome = new JLabel("Alterar nome cliente");
        jlTelefone = new JLabel("Alterar Telefone");


        JBEditarCliente = new JButton("Editar");

        add(jtfNome);
        add(jtfTelefone);
        add(jlNome);
        add(jlTelefone);
        add(JBEditarCliente);


        jlTelefone.setBounds(30,40,120,20);
        jlNome.setBounds(250,40,120,20);
        jtfTelefone.setBounds(30,60,120,20);
        jtfNome.setBounds(250,60,120,20);
        JBEditarCliente.setBounds(150,150,100,40);

    }
    private void criarEventos() {
        JBEditarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String telefone = jtfTelefone.getText();
                String  nomeText = jtfNome.getText();

                if (!jtfTelefone.equals("")||!jtfNome.equals(""))  {

                    ConexaoCliente.editarCliente( telefone, nomeText);
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Editar", JOptionPane.INFORMATION_MESSAGE);
                    //limpa
                    jtfTelefone.setText("");
                    jtfNome.setText("");

                }

                else {
                    JOptionPane.showMessageDialog(null, "Não deixe campos vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

