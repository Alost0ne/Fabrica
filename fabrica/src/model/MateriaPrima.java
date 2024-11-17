package model;

public class MateriaPrima {
    private int codMateriaPrima;
    private String nomeMateriaPrima;

    public MateriaPrima(int codMateriaPrima, String nomeMateriaPrima) {
        this.codMateriaPrima = codMateriaPrima;
        this.nomeMateriaPrima = nomeMateriaPrima;
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

	@Override
	public String toString() {
		return "MateriaPrima [codMateriaPrima=" + 
				codMateriaPrima + 
				", nomeMateriaPrima=" + 
				nomeMateriaPrima + "]";
	}
    
    
}
