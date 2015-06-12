package ejercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class Conexion {
	//usando el patron singleton que solo nos permite crear un objeto de esta clase
	private static Connection conexion = null;
	
	private Conexion(){} //creo un constructor por defecto privado, para impedir que se creen objetos de esta clase
	/**
	 * 
	 * @param bdd nombre de la base de datos sqlite hayada en el raiz de nuestro proyecto
	 * @return una conexion con la bdd
	 */
	public static Connection getConexion(String bdd){
		String nombreBD = "jdbc:sqlite:"+bdd; //el fichero con la base de datos debe encontrarse en el raiz del proyecto
		String driver = "org.sqlite.JDBC"; //nombre del driver de la base de datos que vamos a utilizar, no se debe olvidar importarlo en nuestro proyecto 
		
		SQLiteConfig config = new SQLiteConfig(); //debemos instanciar un objeto con la configuracion de nuestra bdd
		config.enforceForeignKeys(false); //en mi base de datos no voy a utilizar foraneas pero necesitariamos ponerlo como true si fuesemos a utilizarlas	
		try {
			Class.forName(driver); //hay que instanciar la clase con el driver, que debe hayarse en la libreria importada
			conexion = DriverManager.getConnection(nombreBD, config.toProperties()); // abrimos la conexion sobre la base de datos con la cofiguracion del objeto sqliteconfig
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion; 
	}
	/**
	 * Cierra la conexion si ha sido abierta
	 */
	public static void closeConexion(){
		if(conexion != null ){
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
