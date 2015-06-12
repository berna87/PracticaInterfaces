package ejercicio9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocalidadDaoImp implements LocalidadDAO{
	@Override
	public List<String> getNombreLocalidades() {
		Connection conexion = Conexion.getConexion("loc");
		List<String> lista = new ArrayList<String>();
		String sentenciaSQL ="select * from localidad";
		Statement stat = null;
		try {
			stat = conexion.createStatement();
			ResultSet result = stat.executeQuery(sentenciaSQL);
			while(result.next()){
				lista.add(result.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stat != null)
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if(conexion != null){
			Conexion.closeConexion();
		}
		
		return lista;
	}

	@Override
	public int getIdByNombre(String nombre) {
		Connection conexion = Conexion.getConexion("loc");
		int id=0;
		String sentenciaSQL ="select id from localidad where nombre=?";
		PreparedStatement stat = null;
		
		try {
			stat = conexion.prepareStatement(sentenciaSQL);
			stat.setString(1, nombre);
			ResultSet r =stat.executeQuery();
			id = r.getInt("id");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stat != null)
					stat.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conexion != null){
			Conexion.closeConexion();
		}	
		return id;
	}
	
	
	
	
	/* metodo para comprobar que funcionan correctamente las sentencias
	public static void main(String[] args) {
		LocalidadDaoImp locDAO = new LocalidadDaoImp();
		System.out.println(locDAO.getNombreLocalidades());
		System.out.println(locDAO.getIdByNombre("Torres"));
		Conexion.closeConexion();
	}*/
	
	
}

