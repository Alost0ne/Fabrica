package view;

import model.ProdutoDAO;
import model.Produto;
import model.MaquinaDAO;

import java.util.List;

import model.Maquina;
import model.MateriaPrima;
import model.MateriaPrimaDAO;

public class usaInterface {
	
	public static void main(String[] args) {
	
		//Produto produto = new Produto(1, "ferro", "PDT", 10);
		//Produto produto = new Produto(2, "madeira", "PDT", 12);

		//System.out.println(produtoDAO.obterProduto(12));
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.listarTodosProdutos();
	    for (Produto produto : produtos) {
	        System.out.println(produto);
	    }
		
		MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
		List<MateriaPrima> materiasPrimas = materiaPrimaDAO.listarTodasMateriasPrimas();
	    for (MateriaPrima materiasPrima : materiasPrimas) {
	        System.out.println(materiasPrima);
	    }
	    
	    //produtoDAO.excluir(1);
		//MateriaPrima materiaPrima = new MateriaPrima(3, "Master", "MP");
		//MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
		//materiaPrimaDAO.cadastrar(materiaPrima);
		//materiaPrimaDAO.excluir(3);
		
		//Maquina maquina = new Maquina(2, "Maquina");
		//MaquinaDAO maquinaDAO = new MaquinaDAO();
		//maquinaDAO.cadastrar(maquina);
		//maquinaDAO.excluir(2);
		
		
	}
}
