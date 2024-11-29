package model;

public class MateriaPrima {
    private int codigoMateriaPrima;
    private String nomeMateriaPrima;
    private String tipoMateriaPrima;
    private double quantidadeMateriaPrima;
    
	public MateriaPrima(int codigoMateriaPrima, String nomeMateriaPrima, String tipoMateriaPrima,
			double quantidadeMateriaPrima) {
		this.codigoMateriaPrima = codigoMateriaPrima;
		this.nomeMateriaPrima = nomeMateriaPrima;
		this.tipoMateriaPrima = tipoMateriaPrima;
		this.quantidadeMateriaPrima = quantidadeMateriaPrima;
	}
    
    public MateriaPrima() {
		// TODO Auto-generated constructor stub
	}
    
	public int getCodigoMateriaPrima() {
		return codigoMateriaPrima;
	}

	public void setCodigoMateriaPrima(int codigoMateriaPrima) {
		this.codigoMateriaPrima = codigoMateriaPrima;
	}

	public String getNomeMateriaPrima() {
		return nomeMateriaPrima;
	}

	public void setNomeMateriaPrima(String nomeMateriaPrima) {
		this.nomeMateriaPrima = nomeMateriaPrima;
	}

	public String getTipoMateriaPrima() {
		return tipoMateriaPrima;
	}

	public void setTipoMateriaPrima(String tipoMateriaPrima) {
		this.tipoMateriaPrima = tipoMateriaPrima;
	}

	public double getQuantidadeMateriaPrima() {
		return quantidadeMateriaPrima;
	}
	
	public void setQuantidadeMateriaPrima(double quantidadeMateriaPrima) {
		this.quantidadeMateriaPrima = quantidadeMateriaPrima;
	}

	@Override
	public String toString() {
		return "MateriaPrima [codigoMateriaPrima=" + codigoMateriaPrima + ", nomeMateriaPrima=" + nomeMateriaPrima
				+ ", tipoMateriaPrima=" + tipoMateriaPrima + ", quantidadeMateriaPrima=" + quantidadeMateriaPrima + "]";
	}
	
}
