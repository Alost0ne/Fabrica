package model;

public class Produto {
    private int codigoProduto;
    private String nomeProduto;
    private String tipoProduto;
    private double quantidadeProduto;
    
	public Produto(int codigoProduto, String nomeProduto, String tipoProduto, double quantidadeProduto) {
		super();
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.tipoProduto = tipoProduto;
		this.quantidadeProduto = quantidadeProduto;
	}
    
	public Produto() {
		// TODO Auto-generated constructor stub
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

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public double getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(double quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	@Override
	public String toString() {
		return "Produto [codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", tipoProduto="
				+ tipoProduto + ", quantidadeProduto=" + quantidadeProduto + "]";
	}
	
	
    
    
}
