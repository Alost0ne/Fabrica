package model;

public class MateriaPrima {
    private int codMateriaPrima;
    private String nomeMateriaPrima;
    private String tipo;

	public MateriaPrima(int codMateriaPrima, String nomeMateriaPrima, String tipo) {
		this.codMateriaPrima = codMateriaPrima;
		this.nomeMateriaPrima = nomeMateriaPrima;
		this.tipo = tipo;
	}

	public int getCodMateriaPrima() {
        return codMateriaPrima;
    }

    public void setCodMateriaPrima(int codMateriaPrima) {
        this.codMateriaPrima = codMateriaPrima;
    }

    public String getNomeMateriaPrima() {
        return nomeMateriaPrima;
    }

    public void setNomeMateriaPrima(String nomeMateriaPrima) {
        this.nomeMateriaPrima = nomeMateriaPrima;
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "MateriaPrima [codMateriaPrima=" + codMateriaPrima + ", nomeMateriaPrima=" + nomeMateriaPrima + ", tipo="
				+ tipo + "]";
	}


    
    
}
