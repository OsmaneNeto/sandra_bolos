package paineis.pedidos;

import classes.Clientes;
import conexao.ConexaoMenu;
import conexao.ConexaoPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelRemoverPedido extends JPanel {
    private JLabel jlidpedido;
    private JTextField jtfIdpedido;
    private JButton jbDeletarPedido;
    private List<Clientes> cliente;
    public PainelRemoverPedido(List<Clientes> clientes) {
        this.cliente = cliente;
        setSize(400,400);
        setBackground(Color.RED);
        setLayout(null);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jlidpedido = new JLabel("ID pedido");
        jtfIdpedido = new JTextField();
        jbDeletarPedido = new JButton("Deletar Bolo");

        add(jlidpedido);
        add(jtfIdpedido);
        add(jbDeletarPedido);

        jlidpedido.setBounds(160,40,100,20);
        jtfIdpedido.setBounds(100,60,200,20);
        jbDeletarPedido.setBounds(130,150,120,40);

    }
    private void criarEventos() {
        jbDeletarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_pedido = jtfIdpedido.getText();


                if (!jtfIdpedido.equals(""))  {
                    ConexaoPedido.deletarPedido(id_pedido);
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Deletar", JOptionPane.INFORMATION_MESSAGE);
                    //limpa
                    jtfIdpedido.setText("");

                }

                else {
                    JOptionPane.showMessageDialog(null, "Não deixe campos vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
