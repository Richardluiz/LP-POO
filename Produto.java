class Produto {
    private String nome;
    private double preco;
    private String categoria;

    private int estoque;

    public Produto(String nome, double preco, String categoria, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.estoque = estoque;

    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }



    public int getEstoque() {
        return estoque;
    }


}