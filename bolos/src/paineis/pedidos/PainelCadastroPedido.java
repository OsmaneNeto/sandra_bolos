package paineis.pedidos;

import classes.Clientes;
import conexao.ConexaoCliente;
import conexao.ConexaoPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelCadastroPedido extends JPanel{
    private JLabel jlTelefone, jlNome, jlIdbolo,jldataP,jldataE;
    private JTextField jtfTelefone, jtfNome, jtfIdbolo,jtfdataP,jtfdataE;
    private JButton jbCadastrarPedido;
    private List<Clientes> cliente;
    public PainelCadastroPedido(List<Clientes> cliente) {
        this.cliente = cliente;
        setSize(400,400);
        setBackground(Color.magenta);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        {
            jtfNome = new JTextField();
            jtfTelefone = new JTextField();
            jtfIdbolo = new JTextField();
            jtfdataP = new JTextField();
            jtfdataE = new JTextField();

            jlNome = new JLabel("Nome Cliente");
            jlTelefone = new JLabel("Telefone");
            jlIdbolo = new JLabel("Id bolo");
            jldataP = new JLabel("Data do pedido");
            jldataE = new JLabel("Data de entrega");


            jbCadastrarPedido = new JButton("Cadastrar");

            add(jtfNome);
            add(jtfTelefone);
            add(jtfIdbolo);
            add(jtfdataP);
            add(jtfdataE);

            add(jlNome);
            add(jlTelefone);
            add(jlIdbolo);
            add(jldataE);
            add(jldataP);

            add(jbCadastrarPedido);

            jlTelefone.setBounds(30,40,100,20);
            jtfTelefone.setBounds(30,60,100,20);

            jlIdbolo.setBounds(270,40,100,20);
            jtfIdbolo.setBounds(270,60,100,20);

            jlNome.setBounds(30,100,100,20);
            jtfNome.setBounds(30,120,100,20);

            jldataP.setBounds(30,160,100,20);
            jtfdataP.setBounds(30,180,100,20);

            jldataE.setBounds(270,100,100,20);
            jtfdataE.setBounds(270,120,100,20);

            jbCadastrarPedido.setBounds(270,160,100,40);

        }
    }

    private void criarEventos() {
        jbCadastrarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nullid = null;
                String telefoneC = jtfTelefone.getText();
                String  nomeC = jtfNome.getText();
                String boloid = jtfIdbolo.getText();
                String datap = jtfdataP.getText();
                String datae =jtfdataE.getText();

                if (!telefoneC.equals("")|| !nomeC.equals("")|| !boloid.equals("")|| !datap.equals("")|| !datae.equals(""))  {

                    ConexaoPedido.cadastrarPedido(telefoneC,nomeC,boloid,datap,datae);

                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    //limpa
                    jtfTelefone.setText("");
                    jtfNome.setText("");
                    jtfIdbolo.setText("");
                    jtfdataE.setText("");
                    jtfdataP.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Não deixe campos vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
