package view;

import model.ProdutoDAO;
import model.Produto;
import model.MaquinaDAO;
import model.Maquina;
import model.MateriaPrima;
import model.MateriaPrimaDAO;

public class usaInterface {

	public static void main(String[] args) {
	
		Produto produto = new Produto(1, "ferro", "PDT");
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.alterar(produto);
		
		
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
