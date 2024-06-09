import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Home extends JFrame {
    private JButton btnCarrinho;
    private JButton btnLogin;
    private List<Produto> carrinhoDeCompras = new ArrayList<>(); // Lista para armazenar os jogos no carrinho

    public Home() {
        setTitle("Loja de Jogos PS4 - Home");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para a vitrine de jogos
        JPanel vitrinePanel = new JPanel(new GridLayout(2, 2));

        // Adicione aqui os 4 jogos com suas imagens e informações (nome, preço, etc.)
        Produto jogo1 = new Produto("Fifa 22 ", 60.00, "Esporte", 10);
        Produto jogo2 = new Produto("Ghost of Tsushima ", 50.00, "Aventura e Ação", 15);
        Produto jogo3 = new Produto("God of War Ragnarok", 40.00, "Ação e Aventura", 20);
        Produto jogo4 = new Produto("Horizon Zero Dawn Forbidden-West ", 30.00, "Aventura", 8);

        // Carregue as imagens usando ImageIcon
        ImageIcon imagemJogo1 = new ImageIcon(getClass().getResource("Imagem/Fifa 22.png"));
        ImageIcon imagemJogo2 = new ImageIcon(getClass().getResource("Imagem/Ghost of tsushima.png"));
        ImageIcon imagemJogo3 = new ImageIcon(getClass().getResource("Imagem/GOD OF WAR RAGNAROK PS4.png"));
        ImageIcon imagemJogo4 = new ImageIcon(getClass().getResource("Imagem/Jogo-Ps4-Horizon-Forbidden-West-.png"));

        // Crie os labels com as imagens
        JLabel labeljogo1 = new JLabel(imagemJogo1);
        JLabel labeljogo2 = new JLabel(imagemJogo2);
        JLabel labeljogo3 = new JLabel(imagemJogo3);
        JLabel labeljogo4 = new JLabel(imagemJogo4);

        Image image1 = imagemJogo1.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        Image imagem2 = imagemJogo2.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        Image img3 = imagemJogo3.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        Image imagen4 = imagemJogo4.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);


        ImageIcon imgRedimensionada = new ImageIcon(image1);
        JLabel Labeljogo1 = new JLabel(imgRedimensionada);

        ImageIcon imgRedimensionada2 = new ImageIcon(imagem2);
        JLabel Labeljogo2 = new JLabel(imgRedimensionada2);


        ImageIcon imgRedimensionada3 = new ImageIcon(img3);
        JLabel Labeljogo3 = new JLabel(imgRedimensionada3);

        ImageIcon imgRedimensionada4 = new ImageIcon(imagen4);
        JLabel Labeljogo4 = new JLabel(imgRedimensionada4);


        // Adicione informações (nome e preço) aos labels
        labeljogo1.setText("<html><center><h2>" + jogo1.getNome() + "</h2><br>R$" + jogo1.getPreco() + "</center></html>");
        labeljogo2.setText("<html><center><h2>" + jogo2.getNome() + "</h2><br>R$" + jogo2.getPreco() + "</center></html>");
        labeljogo3.setText("<html><center><h2>" + jogo3.getNome() + "</h2><br>R$" + jogo3.getPreco() + "</center></html>");
        labeljogo4.setText("<html><center><h2>" + jogo4.getNome() + "</h2><br>R$" + jogo4.getPreco() + "</center></html>");

        // Adicione os labels ao painel
        vitrinePanel.add(Labeljogo1);
        vitrinePanel.add(Labeljogo2);
        vitrinePanel.add(Labeljogo3);
        vitrinePanel.add(Labeljogo4);


        // Crie um painel para cada jogo e adicione os botões "Comprar"
        JPanel panelJogo1 = new JPanel(new BorderLayout());
        panelJogo1.add(Labeljogo1, BorderLayout.CENTER);
        JButton btnComprarJogo1 = new JButton("Comprar");
        btnComprarJogo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de pagamento para o jogo1
                TelaPagamento telaPagamento = new TelaPagamento(jogo1);
                telaPagamento.setVisible(true);
            }
        });
        JPanel btnPanelJogo1 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Cria um painel para os botões
        JButton btnAddCarrinhoJogo1 = new JButton("Adicionar ao Carrinho"); // Botão "Adicionar ao Carrinho"
        btnAddCarrinhoJogo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona o jogo ao carrinho
                carrinhoDeCompras.add(jogo1);
                JOptionPane.showMessageDialog(null, "Jogo adicionado ao carrinho!");
                updateCarrinhoButton(); // Atualiza o botão "Carrinho"
            }
        });
        btnPanelJogo1.add(btnAddCarrinhoJogo1); // Adiciona o botão ao painel
        btnPanelJogo1.add(btnComprarJogo1); // Adiciona o botão "Comprar" ao painel
        panelJogo1.add(btnPanelJogo1, BorderLayout.SOUTH); // Adiciona o painel de botões ao painel do jogo
        vitrinePanel.add(panelJogo1); // Adicione o painel ao GridLayout

        JPanel panelJogo2 = new JPanel(new BorderLayout());
        panelJogo2.add(Labeljogo2, BorderLayout.CENTER);
        JButton btnComprarJogo2 = new JButton("Comprar");
        btnComprarJogo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de pagamento para o jogo2
                TelaPagamento telaPagamento = new TelaPagamento(jogo2);
                telaPagamento.setVisible(true);
            }
        });
        JPanel btnPanelJogo2 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Cria um painel para os botões
        JButton btnAddCarrinhoJogo2 = new JButton("Adicionar ao Carrinho"); // Botão "Adicionar ao Carrinho"
        btnAddCarrinhoJogo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona o jogo ao carrinho
                carrinhoDeCompras.add(jogo2);
                JOptionPane.showMessageDialog(null, "Jogo adicionado ao carrinho!");
                updateCarrinhoButton(); // Atualiza o botão "Carrinho"
            }
        });
        btnPanelJogo2.add(btnAddCarrinhoJogo2); // Adiciona o botão ao painel
        btnPanelJogo2.add(btnComprarJogo2); // Adiciona o botão "Comprar" ao painel
        panelJogo2.add(btnPanelJogo2, BorderLayout.SOUTH); // Adiciona o painel de botões ao painel do jogo
        vitrinePanel.add(panelJogo2); // Adicione o painel ao GridLayout

        JPanel panelJogo3 = new JPanel(new BorderLayout());
        panelJogo3.add(Labeljogo3, BorderLayout.CENTER);
        JButton btnComprarJogo3 = new JButton("Comprar");
        btnComprarJogo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de pagamento para o jogo3
                TelaPagamento telaPagamento = new TelaPagamento(jogo3);
                telaPagamento.setVisible(true);
            }
        });
        JPanel btnPanelJogo3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Cria um painel para os botões
        JButton btnAddCarrinhoJogo3 = new JButton("Adicionar ao Carrinho"); // Botão "Adicionar ao Carrinho"
        btnAddCarrinhoJogo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona o jogo ao carrinho
                carrinhoDeCompras.add(jogo3);
                JOptionPane.showMessageDialog(null, "Jogo adicionado ao carrinho!");
                updateCarrinhoButton(); // Atualiza o botão "Carrinho"
            }
        });
        btnPanelJogo3.add(btnAddCarrinhoJogo3); // Adiciona o botão ao painel
        btnPanelJogo3.add(btnComprarJogo3); // Adiciona o botão "Comprar" ao painel
        panelJogo3.add(btnPanelJogo3, BorderLayout.SOUTH); // Adiciona o painel de botões ao painel do jogo
        vitrinePanel.add(panelJogo3); // Adicione o painel ao GridLayout

        JPanel panelJogo4 = new JPanel(new BorderLayout());
        panelJogo4.add(Labeljogo4, BorderLayout.CENTER);
        JButton btnComprarJogo4 = new JButton("Comprar");
        btnComprarJogo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de pagamento para o jogo4
                TelaPagamento telaPagamento = new TelaPagamento(jogo4);
                telaPagamento.setVisible(true);
            }
        });
        JPanel btnPanelJogo4 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Cria um painel para os botões
        JButton btnAddCarrinhoJogo4 = new JButton("Adicionar ao Carrinho"); // Botão "Adicionar ao Carrinho"
        btnAddCarrinhoJogo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona o jogo ao carrinho
                carrinhoDeCompras.add(jogo4);
                JOptionPane.showMessageDialog(null, "Jogo adicionado ao carrinho!");
                updateCarrinhoButton(); // Atualiza o botão "Carrinho"
            }
        });
        btnPanelJogo4.add(btnAddCarrinhoJogo4); // Adiciona o botão ao painel
        btnPanelJogo4.add(btnComprarJogo4); // Adiciona o botão "Comprar" ao painel
        panelJogo4.add(btnPanelJogo4, BorderLayout.SOUTH); // Adiciona o painel de botões ao painel do jogo
        vitrinePanel.add(panelJogo4); // Adicione o painel ao GridLayout


        ImageIcon icone = new ImageIcon(getClass().getResource("Imagem/Carrinho.png"));
        Image image = icone.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Redimensiona a imagem
        icone = new ImageIcon(image);
        JLabel carrinhoIcon = new JLabel(icone);
        carrinhoIcon.setToolTipText("Ver Carrinho");
        carrinhoIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 1) { // Clique simples
                    Carrinho carrinho = new Carrinho(carrinhoDeCompras); // Cria uma nova instância da tela Carrinho, passando o carrinho de compras
                    carrinho.setVisible(true); // Exibe a tela do Carrinho
                }
            }
        });

        // Painel para o ícone do carrinho (canto superior esquerdo)
        JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        iconPanel.add(carrinhoIcon);
        add(iconPanel, BorderLayout.NORTH); // Adiciona o painel ao topo da janela

        // Painel para botões de navegação
        JPanel botaoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Altera o layout do botaoPanel para FlowLayout à esquerda
        btnCarrinho = new JButton("Carrinho");
        btnCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela do carrinho
                Carrinho carrinho = new Carrinho(carrinhoDeCompras);
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
        add(botaoPanel, BorderLayout.NORTH); // Move o botaoPanel para o norte

        // Atualiza o texto do botão "Carrinho" quando um jogo é adicionado
        updateCarrinhoButton(); // Chama a função para atualizar o botão inicialmente
    }

    private void updateCarrinhoButton() {
        if (carrinhoDeCompras.isEmpty()) {
            btnCarrinho.setText("Carrinho");
        } else {
            StringBuilder text = new StringBuilder("Carrinho (");
            for (int i = 0; i < carrinhoDeCompras.size(); i++) {
                text.append(carrinhoDeCompras.get(i).getNome());
                if (i < carrinhoDeCompras.size() - 1) {
                    text.append(", ");
                }
            }
            text.append(")");
            btnCarrinho.setText(text.toString());
        }
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