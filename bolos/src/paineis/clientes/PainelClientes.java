package paineis.clientes;

import classes.Clientes;
import conexao.ConexaoCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelClientes extends JPanel {
    private JScrollPane scrollPane;
    private JTextArea jtaCampo;
    private JButton jbMostrarClientes;
    private List<Clientes> cliente;

    public PainelClientes(List<Clientes> cliente){
        this.cliente = cliente;
        setSize(400, 400);
        setBackground(Color.lightGray);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
}

    private void iniciarComponentes() {


            jbMostrarClientes = new JButton("Mostrar Clientes");


            jtaCampo = new JTextArea();
            scrollPane = new JScrollPane(jtaCampo);

            add(scrollPane);
            add(jbMostrarClientes);



            jbMostrarClientes.setBounds(120, 50, 150, 40);
            scrollPane.setBounds(10, 100, 380, 290);
        }

    private void criarEventos() {
        jbMostrarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ConexaoCliente.mostrarClientes(jtaCampo);
            }
        });
    }
}
