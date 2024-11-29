package model;

public class Estoque {
	
	private final int COD_ESTOQUE = 10;
	
	 private int codEstoque;
	    private int codigoItem; // Código relacionado ao tipo do item
	    private double quantidade; // Quantidade no estoque

	public Estoque(int codEstoque) {
			this.codEstoque = codEstoque;
		}
	
	public int getCodEstoque() {
		return codEstoque;
	}

	public void setCodEstoque(int codEstoque) {
	    if (codEstoque == COD_ESTOQUE) {
	        this.codEstoque = codEstoque;
	    } else {
	        System.out.println("O código do estoque deve ser 10!");
	    }
	}

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "idEstoque=" + codEstoque +
                ", codigoItem=" + codigoItem +
                ", quantidade=" + quantidade +
                '}';
    }
}