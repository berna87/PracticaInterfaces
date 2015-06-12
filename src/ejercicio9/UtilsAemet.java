package ejercicio9;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class UtilsAemet {
	
	public static Node getPrediccion(Node raiz){
		Node tmpNodo = raiz.getFirstChild();
		Node prediccion = null;
		 do {
	            if(tmpNodo.getNodeName().equals("prediccion")){
	            	prediccion = tmpNodo;
	            }
	        } while ( (tmpNodo = tmpNodo.getNextSibling()) != null );
		return prediccion;
	}
	
	public static List<Node> getDias(Node pred){
		Node tmpNodo = pred.getFirstChild();
		List<Node> lista = new ArrayList<Node>();
		 do {
	            if(tmpNodo.getNodeName().equals("dia")){
	            	lista.add(tmpNodo);
	            }
	        } while ( (tmpNodo = tmpNodo.getNextSibling()) != null );
		return lista;
	}
	public static Node getTemp(Node dia){
		Node tmpNodo = dia.getFirstChild();
		Node temperatura = null;
		do {
            if(tmpNodo.getNodeName().equals("temperatura")){
            	temperatura = tmpNodo;
            }
        } while ( (tmpNodo = tmpNodo.getNextSibling()) != null );
		return temperatura;
	}
	
	public static String getMaxima(Node temperatura){
		Node tmpNodo = temperatura.getFirstChild();
		String maxima = "Max : ";
		
		do {
            if(tmpNodo.getNodeName().equals("maxima")){
            	maxima += tmpNodo.getTextContent()+"°C";
            }
            
        } while ( (tmpNodo = tmpNodo.getNextSibling()) != null );
		return maxima;
	}
	public static String getMinima(Node temperatura){
		Node tmpNodo = temperatura.getFirstChild();
		String minima = "Min : ";
		
		do {
            if(tmpNodo.getNodeName().equals("minima")){
            	minima += tmpNodo.getTextContent()+"°C";
            }
            
        } while ( (tmpNodo = tmpNodo.getNextSibling()) != null );
		return minima;
	}
	
}
