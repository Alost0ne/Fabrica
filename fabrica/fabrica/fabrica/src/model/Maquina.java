package model;

public class Maquina {
    private int numMaquina;
    private String nomeMaquina;
    
    public Maquina(int numMaquina, String nomeMaquina) {
		this.numMaquina = numMaquina;
		this.nomeMaquina = nomeMaquina;
	}

	public Maquina(int numMaquina) {
		this.numMaquina = numMaquina;
    }

	public int getNumMaquina() {
		return numMaquina;
	}

	public void setNumMaquina(int numMaquina) {
		this.numMaquina = numMaquina;
	}

	public String getNomeMaquina() {
		return nomeMaquina;
	}

	public void setNomeMaquina(String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}

	@Override
	public String toString() {
		return "Maquina [numMaquina=" + numMaquina + ", nomeMaquina=" + nomeMaquina + "]";
	}
	
}
