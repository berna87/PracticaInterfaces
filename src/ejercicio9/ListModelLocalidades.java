package ejercicio9;


import java.util.List;

import javax.swing.AbstractListModel;

public class ListModelLocalidades extends AbstractListModel{
	private List<String> lista = null;
	
	public ListModelLocalidades(List<String> l){
		lista = l;
	}
	
	
	
	@Override
	public String getElementAt(int index) {
		
		return lista.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return lista.size();
	}

}
