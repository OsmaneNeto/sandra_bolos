package paineis.pedidos;

import classes.Clientes;
import conexao.ConexaoMenu;
import conexao.ConexaoPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelPedidos extends JPanel {
        private JScrollPane scrollPane;
        private JLabel  jlTodos;

        private JTextArea jtaCampo;
        private JButton jbMostrarP;
        private List<Clientes> cliente;

        public PainelPedidos(List<Clientes> clientes) {
            this.cliente = cliente;
            setSize(400, 400);
            setBackground(Color.lightGray);
            setLayout(null);
            iniciarComponentes();
            criarEventos();
        }

        private void iniciarComponentes() {


            jbMostrarP = new JButton("Mostrar pedidos");

            jtaCampo = new JTextArea();
            scrollPane = new JScrollPane(jtaCampo);

            add(scrollPane);

            add(jbMostrarP);

            jbMostrarP.setBounds(150, 50, 130, 40);

            scrollPane.setBounds(10, 100, 380, 290);
        }

        private void criarEventos() {
            // Adicione aqui os eventos se necessário
            jbMostrarP.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConexaoPedido.mostrarPedidos(jtaCampo);
                }
            });


        }
    }


