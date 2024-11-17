package model;

public class Produto {
    private int codigoProduto;
    private String nomeProduto;
    
    public Produto(int codigoProduto, String nomeProduto) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
    }
    
    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

	@Override
	public String toString() {
		return "Produto [codigoProduto=" + 
	codigoProduto + 
	", nomeProduto=" + 
	nomeProduto + "]";
	}
    
}
