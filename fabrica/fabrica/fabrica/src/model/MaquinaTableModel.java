package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MaquinaTableModel extends AbstractTableModel {

    private List<Maquina> maquinas;  // Lista de máquinas
    private String[] columnNames = {"Número da Máquina", "Nome da Máquina"};  // Nomes das colunas da tabela

    public MaquinaTableModel(List<Maquina> maquinas) {
        this.maquinas = maquinas;  // Inicializa a lista de máquinas
    }

    @Override
    public int getRowCount() {
        return maquinas.size();  // Número de linhas será o tamanho da lista de máquinas
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;  // O número de colunas é o tamanho do array columnNames
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];  // Retorna o nome da coluna
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Maquina maquina = maquinas.get(rowIndex);  // Obtendo a máquina na linha correspondente
        switch (columnIndex) {
            case 0:
                return maquina.getNumMaquina();  // Retorna o número da máquina
            case 1:
                return maquina.getNomeMaquina();  // Retorna o nome da máquina
            default:
                return null;
        }
    }

    // Atualiza a lista de máquinas na tabela
    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
        fireTableDataChanged();  // Notifica que os dados foram alterados
    }

    // Adiciona uma nova máquina na tabela
    public void addMaquina(Maquina maquina) {
        maquinas.add(maquina);
        fireTableRowsInserted(maquinas.size() - 1, maquinas.size() - 1);  // Adiciona a nova linha
    }

    // Exclui uma máquina da tabela
    public void removeMaquina(int rowIndex) {
        if (rowIndex != -1) {
            maquinas.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);  // Remove a linha
        }
    }
}
