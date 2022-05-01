package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

/** 
 * Equipo 5
 * @author Abner Ely Castellanos Diaz
 * 20/04/2022
 * Esta es una clase para la interfaz Mapper de la entidad Direccion
 */

public interface DireccionMapper {
	/**
	 * Metodo para listar todas las direcciones registradas
	 * @return List<Direccion>
	 */
	List<Direccion> obtenerDirecciones();
	
	/**
	 * Metodo para dar de alta una direccion en la base de datos
	 * @return Integer
	 */
	Integer nuevaDireccionCliente(Direccion direccion);
	
	/**
	 * Metodo para obtener una direccion por su Id
	 * @return Direccion
	 */
	Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion);
	
	/**
	 * Metodo para dar de baja una direccion mediante el id
	 * @return void
	 */
	void darDeBajaDireccionPorId(int id);
	
	/**
	 * Metodo para modificar una direccion mediante su Id
	 * @return void
	 */
	void modificarDireccionPorId(Direccion direccion);	
}
