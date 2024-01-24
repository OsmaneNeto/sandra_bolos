package paineis.menus;

import classes.Clientes;
import conexao.ConexaoMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelMenu extends JPanel {
    private JScrollPane scrollPane;

    private JTextField jtfNomeBolo;
    private JTextArea jtaCampo;
    private JButton  jbMostrarMenu;
    private List<Clientes> cliente;

    public PainelMenu(List<Clientes> clientes) {
        this.cliente = cliente;
        setSize(400, 400);
        setBackground(Color.lightGray);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jtfNomeBolo = new JTextField();


        jbMostrarMenu = new JButton("Mostrar Menu");


        jtaCampo = new JTextArea();
        scrollPane = new JScrollPane(jtaCampo);

        add(scrollPane);
        add(jtfNomeBolo);
        add(jbMostrarMenu);


        jtfNomeBolo.setBounds(30, 60, 100, 20);

        jbMostrarMenu.setBounds(150, 50, 130, 40);


        scrollPane.setBounds(10, 100, 380, 290);
    }

    private void criarEventos() {
        // Adicione aqui os eventos se necessário
        jbMostrarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexaoMenu.mostrarMenu(jtaCampo);
            }
        });
    }
}
