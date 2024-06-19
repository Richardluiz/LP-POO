package BancoDados;

import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Classe para gerenciar a conexão com o banco de dados
public class ConexaoBD {
    private static final Logger logger = Logger.getLogger(ConexaoBD.class.getName());
    private static final String URL = "jdbc:sqlite:src/bd/Bancodados2.db"; // URL do banco
    private static final String USER = ""; // Usuário do banco (deixe vazio para SQLite)
    private static final String SENHA = ""; // Senha do banco (deixe vazio para SQLite)
    private static Connection conexao;

    public static Connection obterConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(URL, USER, SENHA);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Não foi possível estabelecer uma conexão com o banco de dados.", e);
            return null;
        }
        return conexao;
    }

    public static void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Não foi possível fechar a conexão com o banco de dados.", e);
        }
    }
}