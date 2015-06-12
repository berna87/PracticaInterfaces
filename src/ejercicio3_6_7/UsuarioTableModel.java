package ejercicio3_6_7;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel{
	private List<Usuario> lista;
	private String [] nombreColumnas;
	
	
	
	public UsuarioTableModel(List<Usuario> lista, String[] nombreColumnas) {
		super();
		this.lista = lista;
		this.nombreColumnas = nombreColumnas;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return nombreColumnas[column];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String aux ="";
		Usuario u = lista.get(rowIndex);
		if (columnIndex == 0) aux = u.getNombre();
		if (columnIndex == 1) aux = u.getApellidos();
		if (columnIndex == 2) aux = u.getEmail();
		if (columnIndex == 3) aux = u.getLogin();
		if (columnIndex == 4) aux = "??????";
		return aux;
	}

}
