import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carrinho extends JFrame {
    private JButton btnVoltar;
    private Carrinho carrinho; // Instância do carrinho

    public Carrinho() {
        setTitle("Loja de Jogos PS4 - Carrinho");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para os produtos no carrinho
        JPanel carrinhoPanel = new JPanel(new GridLayout(2, 2));

        // Exibe os produtos no carrinho aqui (usando a instância do carrinho)
        carrinho = new Carrinho(); // Cria a instância do carrinho

        // ... (código para exibir os produtos no carrinhoPanel) ...

        // Painel para o botão voltar
        JPanel botaoPanel = new JPanel();
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a tela Home
                Home home = new Home();
                home.setVisible(true);
                dispose(); // Fecha a tela Carrinho
            }
        });
        botaoPanel.add(btnVoltar);

        add(carrinhoPanel, BorderLayout.CENTER);
        add(botaoPanel, BorderLayout.SOUTH);
    }

    public void adicionarProduto(Produto produto) {
    }
}