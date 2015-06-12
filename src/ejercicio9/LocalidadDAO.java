package ejercicio9;


import java.util.List;

public interface LocalidadDAO {
	List<String> getNombreLocalidades();
	int getIdByNombre (String nombre);
}
