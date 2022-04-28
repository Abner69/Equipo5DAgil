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
	public void nuevoCLiente(Cliente cliente) {
		try {
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.nuevoCLiente(cliente);
			System.out.println("Cliente con Id: " + cliente.getId() + "\nInsertado Exitosamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		
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
	public void moficiarClientePorId(int id) {
		Cliente cliente = new Cliente();
		
		try {
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Override
	public void darDeBajaClientePorId(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	
}
