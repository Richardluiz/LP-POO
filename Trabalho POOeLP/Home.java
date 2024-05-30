import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JButton btnCarrinho;
    private JButton btnLogin;

    public Home() {
        setTitle("Loja de Jogos PS4 - Home");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para a vitrine de jogos
        JPanel vitrinePanel = new JPanel(new GridLayout(2, 2));

        // Adicione aqui os 4 jogos com suas imagens e informações (nome, preço, etc.)
        Produto jogo1 = new Produto("Fifa 22", 60.0, "Esporte", "Fifa 22 ps4.png", 10);
        Produto jogo2 = new Produto("Guardiões da Galáxia", 50.0, "Aventura e Ação", "", 15);
        Produto jogo3 = new Produto("God of War Ragnarok", 40.0, "Ação e Aventura", "GOD OF WAR RAGNAROK PS4.png", 20);
        Produto jogo4 = new Produto("Horizon Zero Dawn Forbidden-West", 30.0, "Aventura", "Jogo-Ps4-Horizon-Forbidden-West-Game_1704570487_gg.png", 8);

        JLabel labelJogo1 = new JLabel("<html><center><h2>" + jogo1.getNome() + "</h2><img src=\"" + jogo1.getImagem() + "\" width=\"150\" height=\"100\"><br>R$" + jogo1.getPreco() + "</center></html>");
        JLabel labelJogo2 = new JLabel("<html><center><h2>" + jogo2.getNome() + "</h2><img src=\"" + jogo2.getImagem() + "\" width=\"150\" height=\"100\"><br>R$" + jogo2.getPreco() + "</center></html>");
        JLabel labelJogo3 = new JLabel("<html><center><h2>" + jogo3.getNome() + "</h2><img src=\"" + jogo3.getImagem() + "\" width=\"150\" height=\"100\"><br>R$" + jogo3.getPreco() + "</center></html>");
        JLabel labelJogo4 = new JLabel("<html><center><h2>" + jogo4.getNome() + "</h2><img src=\"" + jogo4.getImagem() + "\" width=\"150\" height=\"100\"><br>R$" + jogo4.getPreco() + "</center></html>");

        vitrinePanel.add(labelJogo1);
        vitrinePanel.add(labelJogo2);
        vitrinePanel.add(labelJogo3);
        vitrinePanel.add(labelJogo4);

        // Painel para botões de navegação
        JPanel botaoPanel = new JPanel();
        btnCarrinho = new JButton("Carrinho");
        btnCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela do carrinho
                Carrinho carrinho = new Carrinho();
                carrinho.setVisible(true);
                dispose(); // Fecha a tela Home
            }
        });
        botaoPanel.add(btnCarrinho);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de login
                Login login = new Login();
                login.setVisible(true);
                dispose(); // Fecha a tela Home
            }
        });
        botaoPanel.add(btnLogin);

        add(vitrinePanel, BorderLayout.CENTER);
        add(botaoPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}