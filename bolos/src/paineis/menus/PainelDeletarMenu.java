package paineis.menus;

import classes.Clientes;
import conexao.ConexaoMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelDeletarMenu extends JPanel {
    private JLabel jlIdBolo;
    private JTextField jtfIdBolo;
    private JButton jbDeletarMenu;
    private List<Clientes> cliente;
    public PainelDeletarMenu(List<Clientes> clientes) {
        this.cliente = cliente;
        setSize(400,400);
        setBackground(Color.RED);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jlIdBolo = new JLabel("ID bolo");
        jtfIdBolo = new JTextField();
        jbDeletarMenu = new JButton("Deletar Bolo");

        add(jlIdBolo);
        add(jtfIdBolo);
        add(jbDeletarMenu);

        jlIdBolo.setBounds(160,40,100,20);
        jtfIdBolo.setBounds(100,60,200,20);
        jbDeletarMenu.setBounds(130,150,120,40);

    }
    private void criarEventos() {
        jbDeletarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_bolo = jtfIdBolo.getText();


                if (!jtfIdBolo.equals(""))  {
                    ConexaoMenu.deletarMenu(id_bolo);
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Deletar", JOptionPane.INFORMATION_MESSAGE);
                    //limpa
                    jtfIdBolo.setText("");

                }

                else {
                    JOptionPane.showMessageDialog(null, "Não deixe campos vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
