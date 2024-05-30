import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JButton btnVoltar;

    public Login() {
        setTitle("Loja de Jogos PS4 - Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JLabel lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField();
        btnEntrar = new JButton("Entrar");
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
        add(btnVoltar);
    }
}