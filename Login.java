import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JButton btnCadastrar;
    private JButton btnVoltar;

    public Login() {
        setTitle("Loja de Jogos PS4 - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JLabel lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField();
        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        // Ação do botão "Entrar" (implemente a validação de login aqui)
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());
                // Validação de login (verificar se usuário e senha estão corretos)
                // ...
                // Se a validação for bem-sucedida, abra a tela desejada após o login
                // ...
            }
        });

        // Ação do botão "Cadastrar"
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de cadastro
                Cadastro cadastro = new Cadastro();
                cadastro.setVisible(true);
                dispose();
            }
        });

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a tela Home
                Home home = new Home();
                home.setVisible(true);
                dispose();
            }
        });

        add(lblUsuario);
        add(txtUsuario);
        add(lblSenha);
        add(txtSenha);
        add(btnEntrar);
        add(btnCadastrar);
        add(btnVoltar);
    }
}

// Classe para a tela de cadastro
class Cadastro extends JFrame {
    private JTextField txtNomeCompleto;
    private JTextField txtEmail;
    private JTextField txtCEP;
    private JTextField txtCPF;
    private JPasswordField txtSenha;
    private JButton btnCadastrar;
    private JButton btnVoltar;

    public Cadastro() {
        setTitle("Loja de Jogos PS4 - Cadastro");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        JLabel lblNomeCompleto = new JLabel("Nome Completo:");
        txtNomeCompleto = new JTextField();
        JLabel lblEmail = new JLabel("E-mail:");
        txtEmail = new JTextField();
        JLabel lblCEP = new JLabel("CEP:");
        txtCEP = new JTextField();
        JLabel lblCPF = new JLabel("CPF:");
        txtCPF = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField();
        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        // Ação do botão "Cadastrar" (implemente a lógica de cadastro aqui)
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obter os valores dos campos de texto
                    String nomeCompleto = txtNomeCompleto.getText();
                    String email = txtEmail.getText();
                    String cep = txtCEP.getText();
                    String cpf = txtCPF.getText();
                    String senha = new String(txtSenha.getPassword());

                    // Verificar se algum campo está vazio
                    if (nomeCompleto.isEmpty() || email.isEmpty() || cep.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
                        throw new IllegalArgumentException("Cadastro inválido: preencha todos os campos.");
                    }

                    // Lógica de cadastro (salve os dados do usuário em um banco de dados ou arquivo)
                    // ...
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(Cadastro.this, ex.getMessage(), "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volta para a tela de login
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });

        add(lblNomeCompleto);
        add(txtNomeCompleto);
        add(lblEmail);
        add(txtEmail);
        add(lblCEP);
        add(txtCEP);
        add(lblCPF);
        add(txtCPF);
        add(lblSenha);
        add(txtSenha);
        add(btnCadastrar);
        add(btnVoltar);
    }
}