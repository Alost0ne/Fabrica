package model;

public class Estoque {
	
	private final int COD_ESTOQUE = 10;
	
	 private int codEstoque = COD_ESTOQUE;
	    private String tipoItem; // Deve ser "Produto" ou "MateriaPrima"
	    private int codigoItem; // Código relacionado ao tipo do item
	    private double quantidade; // Quantidade no estoque

	 public Estoque(int idEstoque, String tipoItem, int codigoItem, double quantidade) {
		 this.codEstoque = idEstoque;
		 setTipoItem(tipoItem); // Validações podem ocorrer nos setters
		 this.codigoItem = codigoItem;
		 this.quantidade = quantidade;
	    }

	public int getCodEstoque() {
        return codEstoque;
    }

	public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        // Validação do tipo do item
        if (!tipoItem.equals("Produto") && !tipoItem.equals("MateriaPrima")) {
            throw new IllegalArgumentException("Tipo de item deve ser 'Produto' ou 'MateriaPrima'");
        }
        this.tipoItem = tipoItem;
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
                ", tipoItem='" + tipoItem + '\'' +
                ", codigoItem=" + codigoItem +
                ", quantidade=" + quantidade +
                '}';
    }
}