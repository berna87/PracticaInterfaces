package ejercicio9;




import javax.swing.table.AbstractTableModel;

public class TableModelTemperaturas extends AbstractTableModel{
	private String [][] lista;
	private String [] nombreColumnas;

	
	public TableModelTemperaturas(String[][] lista, String [] nombreColumnas) {
		super();
		this.lista = lista;
		this.nombreColumnas = nombreColumnas;
	}
	
	
	@Override
	public String getColumnName(int index) {
		// TODO Auto-generated method stub
		return nombreColumnas[index];
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		// TODO Auto-generated method stub
		return lista[columna][fila];
	}
	
	
}
