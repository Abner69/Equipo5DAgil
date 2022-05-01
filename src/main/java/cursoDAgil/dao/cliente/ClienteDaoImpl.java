package cursoDAgil.dao.cliente;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.ClienteMapper;

/** 
 * Equipo 5
 * @author Abner Ely Castellanos Diaz
 * 20/04/2022
 * Esta es una clase para la implementacion de los metodos para
 * la entidad cliente.
 */
@Named
public class ClienteDaoImpl implements ClienteDao, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2996238527625357987L;
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Cliente> listarTodosClientes() {
		List<Cliente> list = null;
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list = clienteMapper.listarTodosClientes();
			for(Cliente c : list) {
				System.out.println("Id: " + c.getId());
				System.out.println("Nombre: " + c.getNombre());
				Direccion cdir = c.getDireccion();
				System.out.println("Direccion: " + cdir.getCalle() + ", " + cdir.getNumero() + ", "  + cdir.getColonia() + ", " + cdir.getCiudad() + ", " +  cdir.getCodigoPostal() + ", " + cdir.getEstado());
			}
			return list;
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	@Override
	public Cliente obtenerClientePorId(int id) {
		Cliente cliente = null;
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			cliente = clienteMapper.obtenerClientePorId(id);
			System.out.println("El cliente obtenido es:");
			System.out.println("Id: " + cliente.getId());
			System.out.println("Nombre: " + cliente.getNombre());
			Direccion cdir = cliente.getDireccion();
			System.out.println("Direccion: " + cdir.getCalle() + ", " + cdir.getNumero() + ", "  + cdir.getColonia() + ", " + cdir.getCiudad() + ", " +  cdir.getCodigoPostal() + ", " + cdir.getEstado());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cliente;
	}
	
	@Override
	public void darAltaCliente(Cliente cliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.darAltaCliente(cliente);
			System.out.println("Cliente con Id: " + cliente.getId() + "\nInsertado Exitosamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Override
	public void modificarClientePorId(Cliente cliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.modificarClientePorId(cliente);
			System.out.println("Se modifico el cliente con id: " + cliente.getId());
			System.out.println("Con los siguiente datos: ");
			System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("Id Direccion: " + cliente.getIddireccion());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Override
	public void darDeBajaClientePorId(int  id) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.darDeBajaClientePorId(id);
			System.out.println("Se ha dado de baja el cliente con id: " + id);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}

	
}
