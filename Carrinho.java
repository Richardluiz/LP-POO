import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Carrinho extends JFrame {
    private List<Produto> itensCarrinho;
    private JList<Produto> listaItens;
    private JButton btnRemover;
    private JLabel lblTotal;

    public Carrinho(List<Produto> carrinhoDeCompras) {
        setTitle("Carrinho de Compras");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        itensCarrinho = new ArrayList<>(carrinhoDeCompras); // Copia a lista do carrinho de compras

        // Painel para a lista de itens do carrinho
        JPanel listaPanel = new JPanel(new BorderLayout());
        listaItens = new JList<>();
        listaItens.setModel(new DefaultListModel<>());
        listaPanel.add(new JScrollPane(listaItens), BorderLayout.CENTER);

        // Botão para remover todos os itens
        JButton btnRemoverTodos = new JButton("Remover Todos os Itens");
        btnRemoverTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itensCarrinho.clear(); // Limpa a lista de itens
                atualizarLista(); // Atualiza a lista na tela
                calcularTotal(); // Recalcula o total
            }
        });
        listaPanel.add(btnRemoverTodos, BorderLayout.SOUTH);

        // Painel para o total
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotal = new JLabel("Total: R$ 0.00");
        totalPanel.add(lblTotal);

        // Botão para voltar à tela principal
        JButton BtnVoltar = new JButton("Voltar");
        BtnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria uma nova instância da tela Home
                Home home = new Home();
                home.setVisible(true); // Exibe a tela Home
                dispose(); // Fecha a tela Carrinho
            }
        });

        // Painel para o botão "Voltar"
        JPanel botaoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPanel.add(BtnVoltar);

        // Adicionar os painéis à tela
        add(listaPanel, BorderLayout.CENTER);
        add(totalPanel, BorderLayout.SOUTH);
        add(botaoPanel, BorderLayout.NORTH); // Adiciona o botão "Voltar" ao topo da tela

        // Inicializar a tela
        atualizarLista();
        calcularTotal();
    }

    private void atualizarLista() {
        DefaultListModel<Produto> model = (DefaultListModel<Produto>) listaItens.getModel();
        model.removeAllElements();
        for (Produto produto : itensCarrinho) {
            model.addElement(produto);
        }
    }

    private void calcularTotal() {
        double total = 0.0;
        for (Produto produto : itensCarrinho) {
            total += produto.getPreco();
        }
        lblTotal.setText("Total: R$ " + String.format("%.2f", total));
    }

    // ... outros métodos que você pode precisar ...

    public static void main(String[] args, List<Produto> carrinhoDeCompras) {
        SwingUtilities.invokeLater(() -> new Carrinho(carrinhoDeCompras).setVisible(true));
    }
}
