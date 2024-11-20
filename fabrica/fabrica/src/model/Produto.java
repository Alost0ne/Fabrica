package model;

public class Produto {
    private int codigoProduto;
    private String nomeProduto;
    private String tipo;
    
    public Produto(int codigoProduto, String nomeProduto, String tipo) {
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.tipo = tipo;
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
    
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Produto [codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", tipo=" + tipo + "]";
	}


    
}
