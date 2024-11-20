package model;

import java.util.ArrayList;
import java.util.List;

public class OrdemProducao {
    private int numOrdemProducao;
    private Produto produto;
    private double qtdProducao;
	
    public OrdemProducao(int numOrdemProducao, Produto produto, double qtdProducao) {
		super();
		this.numOrdemProducao = numOrdemProducao;
		this.produto = produto;
		this.qtdProducao = qtdProducao;
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

	public double getQtdProducao() {
		return qtdProducao;
	}

	public void setQtdProducao(double qtdProducao) {
		this.qtdProducao = qtdProducao;
	}

	@Override
	public String toString() {
		return "OrdemProducao [numOrdemProducao=" + 
				numOrdemProducao + 
				", produto=" + 
				produto + 
				", qtdProducao=" + 
				qtdProducao + "]";
	}



}
