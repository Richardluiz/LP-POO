import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPagamento extends JFrame {

    private JLabel labelTitulo;
    private JComboBox<String> comboParcelas;
    private JButton btnPix;
    private JButton btnBoleto;
    private JButton btnCartao;
    private JPanel painelOpcoes;
    private JPanel painelParcelas;
    private Produto produto; // Referência ao produto que será comprado

    public TelaPagamento(Produto produto) {
        this.produto = produto;

        setTitle("Pagamento - Loja de Jogos PS4");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        labelTitulo = new JLabel("Pagamento de " + produto.getNome(), SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelTitulo, BorderLayout.NORTH);

        painelOpcoes = new JPanel(new FlowLayout(FlowLayout.CENTER));

        btnPix = new JButton("Pix");
        btnPix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para pagamento via Pix
                JOptionPane.showMessageDialog(null, "Pagamento via Pix selecionado!");
                // Ex: Abrir tela específica para inserir dados do Pix
                // ...
            }
        });
        painelOpcoes.add(btnPix);

        btnBoleto = new JButton("Boleto");
        btnBoleto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para pagamento via Boleto
                JOptionPane.showMessageDialog(null, "Pagamento via Boleto selecionado!");
                // Ex: Abrir tela específica para gerar boleto
                // ...
            }
        });
        painelOpcoes.add(btnBoleto);

        btnCartao = new JButton("Cartão de Crédito");
        btnCartao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibir opções de parcelamento
                painelParcelas.setVisible(true);
            }
        });
        painelOpcoes.add(btnCartao);

        add(painelOpcoes, BorderLayout.CENTER);

        // Painel para opções de parcelamento (invisível inicialmente)
        painelParcelas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelParcelas.setVisible(false); // Inicia invisível

        comboParcelas = new JComboBox<>(new String[] {"1x", "2x", "3x", "4x", "5x", "6x", "7x", "8x", "9x", "10x"});
        painelParcelas.add(comboParcelas);

        JButton btnConfirmarParcelas = new JButton("Confirmar");
        btnConfirmarParcelas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para finalizar a compra com cartão parcelado
                String parcelaSelecionada = (String) comboParcelas.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Compra finalizada com cartão em " + parcelaSelecionada + "x!");
                // Ex: Abrir tela de confirmação de pagamento
                // ...
            }
        });
        painelParcelas.add(btnConfirmarParcelas);

        add(painelParcelas, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Crie um produto de exemplo
        Produto produtoExemplo = new Produto("Fifa 22", 60.00, "Esporte", 10);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPagamento(produtoExemplo).setVisible(true);
            }
        });
    }
}