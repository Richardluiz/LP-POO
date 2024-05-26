import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private JTabbedPane abas;

    public TelaPrincipal() {
        super("Tela Principal");

        abas = new JTabbedPane();
        abas.addTab("Login", criarPainelLogin());
        abas.addTab("Carrinho", criarPainelCarrinho());
        abas.addTab("Pagamento", criarPainelPagamento());

        getContentPane().add(abas, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel criarPainelLogin() {
        // Crie os componentes do painel de login aqui
        return new JPanel();
    }

    private JPanel criarPainelCarrinho() {
        // Crie os componentes do painel de carrinho aqui
        return new JPanel();
    }

    private JPanel criarPainelPagamento() {
        // Crie os componentes do painel de pagamento aqui
        return new JPanel();
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}