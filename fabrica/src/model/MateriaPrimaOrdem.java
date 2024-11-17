package model;

public class MateriaPrimaOrdem {
    // Atributos
    private int codOrdemDeProducao;  // Código da ordem de produção
    private int codigoMateriaPrima; // Código da matéria-prima
    private int quantidade;         // Quantidade usada

    // Construtor
    public MateriaPrimaOrdem(int codOrdemDeProducao, int codigoMateriaPrima, int quantidade) {
        this.codOrdemDeProducao = codOrdemDeProducao;
        this.codigoMateriaPrima = codigoMateriaPrima;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getCodOrdemDeProducao() {
        return codOrdemDeProducao;
    }

    public void setCodOrdemDeProducao(int codOrdemDeProducao) {
        this.codOrdemDeProducao = codOrdemDeProducao;
    }

    public int getCodigoMateriaPrima() {
        return codigoMateriaPrima;
    }

    public void setCodigoMateriaPrima(int codigoMateriaPrima) {
        this.codigoMateriaPrima = codigoMateriaPrima;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método toString para exibir os detalhes
    @Override
    public String toString() {
        return "MateriaPrimaOrdem {" +
               "codOrdemDeProducao=" + codOrdemDeProducao +
               ", codigoMateriaPrima=" + codigoMateriaPrima +
               ", quantidade=" + quantidade +
               '}';
    }
}

