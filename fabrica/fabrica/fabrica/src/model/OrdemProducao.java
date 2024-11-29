package model;

public class OrdemProducao {
    private int numOrdemProducao;
    private Produto produto;
    private Maquina maquina;
    private double qtdProducao;
    
	public OrdemProducao(int numOrdemProducao, Produto produto, Maquina maquina, double qtdProducao) {
		super();
		this.numOrdemProducao = numOrdemProducao;
		this.produto = produto;
		this.maquina = maquina;
		this.qtdProducao = qtdProducao;
	}
    
	public OrdemProducao() {
		// TODO Auto-generated constructor stub
	}

	public int getNumOrdemProducao() {
		return numOrdemProducao;
	}

	public void setNumOrdemProducao(int numOrdemProducao) {
		this.numOrdemProducao = numOrdemProducao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public double getQtdProducao() {
		return qtdProducao;
	}

	public void setQtdProducao(double qtdProducao) {
		this.qtdProducao = qtdProducao;
	}

	@Override
	public String toString() {
		return "OrdemProducao [numOrdemProducao=" + numOrdemProducao + ", produto=" + produto + ", maquina=" + maquina
				+ ", qtdProducao=" + qtdProducao + "]";
	}

}