package telas;

import classes.Clientes;
import paineis.clientes.PainelCadastroCliente;
import paineis.clientes.PainelClientes;
import paineis.clientes.PainelDeletarCliente;
import paineis.clientes.PainelEditarCliente;
import paineis.menus.PainelCadastroMenu;
import paineis.menus.PainelDeletarMenu;
import paineis.menus.PainelEditarMenu;
import paineis.menus.PainelMenu;
import paineis.pedidos.PainelCadastroPedido;
import paineis.pedidos.PainelPedidos;
import paineis.pedidos.PainelRemoverPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaInicial extends JFrame { private JLabel jlNomePaciente;
    private  JLabel jlletreiro;
    private CardLayout cardLayout;//contêiner que gerencia dois ou mais componentes
    private JMenuBar jmbBarra;
    private JMenu jmArquivo, jmMenu, jmPedido, jmCliente;
    private JMenuItem jmiSair,jmiCadastrarM,jmiCadastrarC,jmiCadastrarP,jmiPesquisarM,jmiPesquisarC,jmiPesquisarP,
            jmiAlterarM,jmiAlterarC,jmiRemoverM,jmiRemoverC,jmiRemoverP;
    private List<Clientes> clientes;
    private Container container;

    public TelaInicial(String title) throws HeadlessException{
    super("Sandra Bolos");
    setSize(400, 400);
    setLayout(null);//tira  o dimensionamento automatico
    getContentPane().setBackground(Color.magenta);
    setLocationRelativeTo(this);//centraliza a tela
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    iniciarComponentes();
    criarEventos();

    }

    private void iniciarComponentes() {
        //instancia
        container = getContentPane();
        jmbBarra = new JMenuBar();
        jmArquivo = new JMenu("Arquivo");
        jmMenu = new JMenu("Menu");
        jmCliente = new JMenu("Clientes");
        jmPedido = new JMenu("Pedidos");
        jlNomePaciente = new JLabel("Sandra Bolos");

        jmiSair = new JMenuItem("Sair");
        jmiSair.setOpaque(true);
        //cadastros
        jmiCadastrarM =new JMenuItem("Cadastrar Menu");
        jmiCadastrarM.setOpaque(true);
        jmiCadastrarC =new JMenuItem("Cadastrar Cliente");
        jmiCadastrarC.setOpaque(true);
        jmiCadastrarP =new JMenuItem("Cadastrar Pedido");
        jmiCadastrarP.setOpaque(true);
        //Pesquisas
        jmiPesquisarM = new JMenuItem("Pesquisar Menu");
        jmiPesquisarM.setOpaque(true);
        jmiPesquisarC = new JMenuItem("Pesquisar Cliente");
        jmiPesquisarC.setOpaque(true);
        jmiPesquisarP = new JMenuItem("Pesquisar Pedido");
        jmiPesquisarP.setOpaque(true);
        //Alteralções
        jmiAlterarM = new JMenuItem("Alterar Menu");
        jmiAlterarM.setOpaque(true);
        jmiAlterarC = new JMenuItem("Alterar Cliente");
        jmiAlterarC.setOpaque(true);

        //Deletes
        jmiRemoverM = new JMenuItem("Remover Menu");
        jmiRemoverM.setOpaque(true);
        jmiRemoverC = new JMenuItem("Remover Cliente");
        jmiRemoverC.setOpaque(true);
        jmiRemoverP = new JMenuItem("Remover Pedido");
        jmiRemoverP.setOpaque(true);

    // Add
        setJMenuBar(jmbBarra);

        jmbBarra.add(jmArquivo);
        jmbBarra.add(jmMenu);
        jmbBarra.add(jmCliente);
        jmbBarra.add(jmPedido);
        //Arquivo
        jmArquivo.add(jmiSair);
        //Menu
        jmMenu.add(jmiCadastrarM);
        jmMenu.add(jmiPesquisarM);
        jmMenu.add(jmiAlterarM);
        jmMenu.add(jmiRemoverM);
        //Cliente
        jmCliente.add(jmiCadastrarC);
        jmCliente.add(jmiPesquisarC);
        jmCliente.add(jmiAlterarC);
        jmCliente.add(jmiRemoverC);
        //Pedido
        jmPedido.add(jmiCadastrarP);
        jmPedido.add(jmiPesquisarP);
        jmPedido.add(jmiRemoverP);

    }
    private void criarEventos() {

            //menuitem sair
            jmiSair.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        //Cadastros
        jmiCadastrarM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelCadastroMenu painelCadastroMenu = new PainelCadastroMenu(clientes);
                container.removeAll();
                container.add(painelCadastroMenu);
                container.revalidate();
                container.repaint();
            }
        });
jmiPesquisarM.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PainelMenu painelmenu = new PainelMenu(clientes);
        container.removeAll();
        container.add(painelmenu);
        container.revalidate();
        container.repaint();

    }
});
jmiAlterarM.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PainelEditarMenu painelEditarMenu = new PainelEditarMenu(clientes);
        container.removeAll();
        container.add(painelEditarMenu);
        container.revalidate();
        container.repaint();
    }
});

jmiRemoverM.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PainelDeletarMenu painelDeletarMenu =new PainelDeletarMenu(clientes);
        container.removeAll();
        container.add(painelDeletarMenu);
        container.revalidate();
        container.repaint();

    }
});

jmiCadastrarC.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PainelCadastroCliente painelCadastroCliente= new PainelCadastroCliente(clientes);
        container.removeAll();
        container.add(painelCadastroCliente);
        container.revalidate();
        container.repaint();
    }
});
jmiPesquisarC.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PainelClientes painelClientes= new PainelClientes(clientes);
        container.removeAll();
        container.add(painelClientes);
        container.revalidate();
        container.repaint();
    }
});
jmiRemoverC.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PainelDeletarCliente painelDeletarCliente = new PainelDeletarCliente(clientes);
        container.removeAll();
        container.add(painelDeletarCliente);
        container.revalidate();
        container.repaint();
    }
});
jmiAlterarC.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        PainelEditarCliente painelEditarCliente = new PainelEditarCliente(clientes);
        container.removeAll();
        container.add(painelEditarCliente);
        container.revalidate();
        container.repaint();
    }
});

jmiCadastrarP.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PainelCadastroPedido painelCadastroPedido = new PainelCadastroPedido(clientes);
        container.removeAll();
        container.add(painelCadastroPedido);
        container.revalidate();
        container.repaint();
    }
});

jmiPesquisarP.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PainelPedidos painelPedidos = new PainelPedidos(clientes);
        container.removeAll();
        container.add(painelPedidos);
        container.revalidate();
        container.repaint();
    }
});
        jmiRemoverP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelRemoverPedido painelRemoverPedido = new PainelRemoverPedido(clientes);
                container.removeAll();
                container.add(painelRemoverPedido);
                container.revalidate();
                container.repaint();
            }
        });

    }


}
