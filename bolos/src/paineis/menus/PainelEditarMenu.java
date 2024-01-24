package paineis.menus;

import classes.Clientes;
import conexao.ConexaoMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelEditarMenu extends JPanel {
    private JLabel jlNomeBolo, jlprecoBolo, jlID;
    private JTextField jtfNomeBolo, jtfprecoBolo, jtfID;
    private JButton jbEditarMenu;
    private List<Clientes> cliente;
    public PainelEditarMenu(List<Clientes> clientes) {
        this.cliente = cliente;
        setSize(400,400);
        setBackground(Color.BLUE);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }



    private void iniciarComponentes() {
        jtfprecoBolo = new JTextField();
        jtfNomeBolo = new JTextField();
        jtfID = new JTextField();

        jlprecoBolo = new JLabel("Alterar valor do Bolo");
        jlNomeBolo = new JLabel("Alterar nome do Bolo");
        jlID = new JLabel("Id do bolo");

        jbEditarMenu = new JButton("Editar");

        add(jtfprecoBolo);
        add(jtfNomeBolo);
        add(jtfID);
        add(jlprecoBolo);
        add(jlNomeBolo);
        add(jlID);
        add(jbEditarMenu);


        jlNomeBolo.setBounds(30,40,120,20);
        jlprecoBolo.setBounds(250,40,120,20);
        jtfNomeBolo.setBounds(30,60,120,20);
        jtfprecoBolo.setBounds(250,60,120,20);
        jlID.setBounds(175,90,100,20);
        jtfID.setBounds(150,110,100,20);
        jbEditarMenu.setBounds(150,150,100,40);

    }
    private void criarEventos() {
    jbEditarMenu.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String id_bolos = jtfID.getText();
        String nome_bolo = jtfNomeBolo.getText();
        String  preco_bolo = jtfprecoBolo.getText();

        if (!jtfID.equals("")||!jtfNomeBolo.equals("")||!jtfprecoBolo.equals(""))  {

            ConexaoMenu.editarmenu(id_bolos, nome_bolo, preco_bolo);
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Editar", JOptionPane.INFORMATION_MESSAGE);
            //limpa
            jtfID.setText("");
            jtfNomeBolo.setText("");
            jtfprecoBolo.setText("");

        }

        else {
            JOptionPane.showMessageDialog(null, "Não deixe campos vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
});
    }
}
