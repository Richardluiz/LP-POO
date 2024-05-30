public class Produto {

    private String nome;
    private double preco;
    private String descricao;
    private String imagem;
    private int estoque;

    public Produto(String nome,double preco,String descricao, String imagem, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
        this.estoque = estoque;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarAoCarrinho(Carrinho carrinho) {
        if (estoque > 0) {
            carrinho.adicionarProduto(this);
            estoque--;
            System.out.println("Adicionado ao carrinho");
        } else {
            System.out.println("Produto indisponível em estoque.");
        }
    }

    public double getPreco() {
        return preco;
    }

}
