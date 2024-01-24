package paineis.clientes;

import classes.Clientes;
import conexao.ConexaoCliente;
import conexao.ConexaoMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelDeletarCliente extends JPanel{

    private JScrollPane scrollPane;
    private JLabel jlTelefone;
    private JTextField jtfTelefone;
    private JButton jbDeletar;
    private List<Clientes> cliente;

    public PainelDeletarCliente(List<Clientes> clientes) {
        this.cliente = cliente;
        setSize(400, 400);
        setBackground(Color.lightGray);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {

            jlTelefone = new JLabel("Telefone cliente");
            jbDeletar = new JButton("Deletar cliente");
            jtfTelefone=new JTextField();


            add(jlTelefone);
            add(jbDeletar);
            add(jtfTelefone);


            jlTelefone.setBounds(160,40,100,20);
            jtfTelefone.setBounds(100,60,200,20);
        jbDeletar.setBounds(130,150,120,40);


    }

    private void criarEventos() {
        // Adicione aqui os eventos se necessário
        jbDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    String telefone_cliente = jtfTelefone.getText();


                    if (!jtfTelefone.equals(""))  {
                        ConexaoCliente.deletarCliente(telefone_cliente);
                        JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Deletar", JOptionPane.INFORMATION_MESSAGE);
                        //limpa
                        jtfTelefone.setText("");

                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Não deixe campos vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}

