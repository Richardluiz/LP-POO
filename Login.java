

import BancoDados.ConexaoBD;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JButton btnCadastrar;
    private JButton btnVoltar;

    // Dados de conexão com o banco de dados (usando a classe ConexaoBD)
    //private static final String URL = "jdbc:sqlite:src/bd/BancodadosLoja.db.sql"; // Caminho para o arquivo do banco de dados
    // Não precisa mais definir URL, pois a classe ConexaoBD já define

    public Login() {
        setTitle("Loja de Jogos PS4 - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JLabel lblUsuario = new JLabel("Usuário (E-mail):"); // Mudar para "Usuário (E-mail)"
        txtUsuario = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField();
        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        // Ação do botão "Entrar"
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtUsuario.getText(); // Usar "email" como nome da variável
                String senha = new String(txtSenha.getPassword());

                try (Connection conexao = ConexaoBD.obterConexao()) {
                    // Verifica se a conexão foi estabelecida com sucesso
                    assert conexao != null;
                    // Obter a conexão usando ConexaoBD
                    try (PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM Usuarios WHERE Email = ? AND Senha = ?")) {
                        // Define os parâmetros da consulta
                        stmt.setString(1, email);
                        // Criptografar a senha antes de comparar com a senha do banco de dados
                        String senhaCriptografada = gerarHash(senha);
                        stmt.setString(2, senhaCriptografada);
                        // Executa a consulta SQL
                        ResultSet resultado = stmt.executeQuery();
                        // Verifica se o login foi bem-sucedido
                        if (resultado.next()) {
                            System.out.println("Login realizado com sucesso!");
                            // Abre a tela Home
                            Home home = new Home();
                            home.setVisible(true);
                            // Fecha a tela de Login
                            dispose();
                        } else {
                            // Exibe uma mensagem de erro caso as credenciais estejam incorretas
                            JOptionPane.showMessageDialog(Login.this, "Usuário ou senha inválidos!", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    // Trata erros de SQL
                    System.err.println("Erro ao fazer login: " + ex.getMessage());
                    JOptionPane.showMessageDialog(Login.this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // Fecha a conexão com o banco de dados, mesmo que ocorra um erro
                    ConexaoBD.fecharConexao();
                }
            }
        });

        // Ação do botão "Cadastrar"
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastro cadastro = new Cadastro();
                cadastro.setVisible(true);
                dispose();
            }
        });

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui, você precisa definir o que deve acontecer ao clicar em "Voltar"
                // Por exemplo, você pode sair do programa ou voltar para outra tela
                System.exit(0); // Sair do programa como exemplo
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Função para gerar o hash da senha (SHA-256)
    static String gerarHash(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(senha.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
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

    // Dados de conexão com o banco de dados (usando a classe ConexaoBD)
    //private static final String URL = "jdbc:sqlite:src/bd/BancoDeDados.db"; // Caminho para o arquivo do banco de dados
    // Não precisa mais definir URL, pois a classe ConexaoBD já define

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

        // Ação do botão "Cadastrar"
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

                    // Validação dos dados
                    if (nomeCompleto.isEmpty() || email.isEmpty() || cep.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
                        throw new IllegalArgumentException("Cadastro inválido: preencha todos os campos.");
                    }
                    // Adicione mais validações para email, cpf, cep e senha aqui ...

                    // Lógica de cadastro (salve os dados do usuário em um banco de dados ou arquivo)
                    try (Connection conexao = ConexaoBD.obterConexao()) {
                        assert conexao != null;
                        try (// Obter a conexão usando ConexaoBD
                             PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Usuarios (NomeCompleto, Email, CEP, CPF, Senha) VALUES (?, ?, ?, ?, ?)")) {
                            stmt.setString(1, nomeCompleto);
                            stmt.setString(2, email);
                            // Criptografar a senha antes de inserir no banco de dados
                            String senhaCriptografada = Login.gerarHash(senha); // Use a mesma função para gerar o hash da senha
                            stmt.setString(3, senhaCriptografada);
                            stmt.setString(4, cep);
                            stmt.setString(5, cpf);
                            stmt.executeUpdate();
                            JOptionPane.showMessageDialog(Cadastro.this, "Usuário cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

                            // Após o cadastro, volta para a tela de Login
                            Login login = new Login();
                            login.setVisible(true);
                            dispose();
                        }
                    } catch (SQLException ex) {
                        System.err.println("Erro ao cadastrar usuário: " + ex.getMessage());
                        // Exibir uma mensagem de erro mais específica para o usuário
                        JOptionPane.showMessageDialog(Cadastro.this, "Erro ao cadastrar usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(Cadastro.this, ex.getMessage(), "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    ConexaoBD.fecharConexao(); // Fechar a conexão com o banco de dados
                }
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