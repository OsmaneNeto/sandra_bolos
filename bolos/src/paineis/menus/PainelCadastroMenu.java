package paineis.menus;

import classes.Clientes;
import conexao.ConexaoMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class PainelCadastroMenu extends JPanel {
    private JLabel jlNomeBolo, jlprecoBolo;
    private JTextField jtfNomeBolo, jtfprecoBolo;
    private JButton jbCadastrarMenu;
    private List<Clientes> cliente;
    public PainelCadastroMenu(List<Clientes> cliente) {
        this.cliente = cliente;
        setSize(400,400);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
    jtfprecoBolo = new JTextField();
    jtfNomeBolo = new JTextField();

    jlprecoBolo = new JLabel("Valor do Bolo");
    jlNomeBolo = new JLabel("Nome do Bolo");

    jbCadastrarMenu = new JButton("Cadastrar");

    add(jtfprecoBolo);
    add(jtfNomeBolo);
    add(jlprecoBolo);
    add(jlNomeBolo);
    add(jbCadastrarMenu);

jlNomeBolo.setBounds(30,40,100,20);
jlprecoBolo.setBounds(270,40,100,20);
jtfNomeBolo.setBounds(30,60,100,20);
jtfprecoBolo.setBounds(270,60,100,20);
jbCadastrarMenu.setBounds(150,150,100,40);

    }

    private void criarEventos() {
        jbCadastrarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome_bolo = jtfNomeBolo.getText();
                String  preco_bolo = jtfprecoBolo.getText();

                if (!nome_bolo.equals("")|| !preco_bolo.equals(""))  {
                    ConexaoMenu.cadastrarMenu(nome_bolo,preco_bolo);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    //limpa
                    jtfprecoBolo.setText("");
                    jtfNomeBolo.setText("");
                }

                else {
                    JOptionPane.showMessageDialog(null, "Não deixe campos vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        
    }
}
