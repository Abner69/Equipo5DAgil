package cursoDAgil.dao.cliente;

import java.util.List;

import cursoDAgil.bd.domain.Cliente;

/** 
 * Equipo 5
 * @author Abner Ely Castellanos Diaz
 * 20/04/2022
 * Esta es una clase para el DAO de la entidad Cliente
 */

public interface ClienteDao {
	/**
	 * Metodo para listar todos los clientes registrados
	 * @return List<Cliente>
	 */
	List<Cliente> listarTodosClientes();
	
	/**
	 * Metodo para dar de alta un cliente en la base de datos
	 * @return Cliente
	 */
	Cliente darDeAlta();
	
	/**
	 * Metodo para dar de baja un cliente en la base de datos
	 * @return void
	 */
	void darDeBaja();
}
