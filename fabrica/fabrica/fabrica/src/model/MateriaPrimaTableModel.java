package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MateriaPrimaTableModel extends AbstractTableModel {

    private List<MateriaPrima> materiaPrimas;
    private String[] colunas = {"Código", "Nome", "Tipo", "Quantidade"};

    // Construtor
    public MateriaPrimaTableModel() {
        // Inicializando a lista de matérias-primas
        this.materiaPrimas = new MateriaPrimaDAO().listarTodasMateriasPrimas();
    }

    // Atualiza os dados na tabela
    public void atualizarTabela() {
        this.materiaPrimas = new MateriaPrimaDAO().listarTodasMateriasPrimas();
        fireTableDataChanged(); // Atualiza a tabela
    }

    @Override
    public int getRowCount() {
        return materiaPrimas.size();  // Retorna o número de linhas (matérias-primas)
    }

    @Override
    public int getColumnCount() {
        return colunas.length;  // Número de colunas (Código, Nome, Tipo, Quantidade)
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];  // Retorna o nome da coluna
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MateriaPrima materiaPrima = materiaPrimas.get(rowIndex);
        switch (columnIndex) {
            case 0: return materiaPrima.getCodigoMateriaPrima();
            case 1: return materiaPrima.getNomeMateriaPrima();
            case 2: return materiaPrima.getTipoMateriaPrima();
            case 3: return materiaPrima.getQuantidadeMateriaPrima();
            default: return null;
        }
    }
}
