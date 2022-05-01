package cursoDAgil.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.dao.cliente.ClienteDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ClienteDaoImplTest {
	@Inject
	ClienteDao clienteDao;
	
	@Test
	public void pruebaConsultarTodo() {
		System.out.println("Test consultar todos los clientes");
		try {
			List<Cliente> lista = clienteDao.listarTodosClientes();
			assertEquals(lista.size(), 5);
		} catch (Exception ex) {
			System.out.println("error: " + ex);
		}
	}
	
	@Test
	public void pruebaConsultarUnCliente() {
		System.out.println("Test para obtener un cliente por Id");
		try {
			Cliente cliente = clienteDao.obtenerClientePorId(6);
			assertNotNull(cliente);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	
	@Ignore
	public void pruebaDarAltaCliente() {
		Cliente cliente = new Cliente();
		System.out.println("Test para obtener dar de alta un cliente");
		try {
			cliente.setNombre("Prueba Cliente 1");
			cliente.setApellido("Apellido prueba 1");
			cliente.setEmail("Prueba1@prueba.com");
			cliente.setSexo("Prueba1");
			cliente.setIddireccion(6);
			clienteDao.darAltaCliente(cliente);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	
	@Ignore
	public void pruebaDarBajaCliente() {
		System.out.println("Test para dar de baja un cliente");
		try {
			clienteDao.darDeBajaClientePorId(11);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	
	@Ignore
	public void pruebaModificarCliente() {
		Cliente cliente = new Cliente();
		System.out.println("Test para modificar un cliente");
		try {
			cliente.setId(12);
			cliente.setNombre("Prueba Cliente Mod");
			cliente.setApellido("Apellido prueba Mod");
			cliente.setEmail("PruebaMod@prueba.com");
			cliente.setSexo("PruebaM");
			cliente.setIddireccion(7);
			clienteDao.modificarClientePorId(cliente);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
}
