package cursoDAgil.bd.mappers;

import java.util.List;

import cursoDAgil.bd.domain.Cliente;

/** 
 * Equipo 5
 * @author Abner Ely Castellanos Diaz
 * 20/04/2022
 * Esta es una clase para la interfaz Mapper de la entidad Cliente
 */

public interface ClienteMapper {
	/**
	 * Metodo para listar todos los clientes registrados
	 * @return List<Cliente>
	 */
	List<Cliente> listarTodosClientes();
	
	/**
	 * Metodo para listar un cliente en especifico usando us Id
	 * @return Cliente
	 */
	Cliente obtenerClientePorId(int id);
	
	/**
	 * Metodo para dar de alta un cliente en la base de datos
	 * @return void
	 */
	void darAltaCliente(Cliente cliente);
	
	/**
	 * Metodo para dar de baja un cliente en la base de datos
	 * @return void
	 */
	void darDeBajaClientePorId(int id);
	
	/**
	 * Metodo para modificar un cliente mediante su Id
	 * @return void
	 */
	void modificarClientePorId(Cliente cliente);	
}
