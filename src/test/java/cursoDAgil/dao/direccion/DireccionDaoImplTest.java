package cursoDAgil.dao.direccion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Direccion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
public class DireccionDaoImplTest {
	@Inject
	DireccionDao direccionDao;
	@Test
	public void consultarDireccionPorId(){
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion",1);
		try{
			direccion=direccionDao.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			System.out.println("id:" + direccion.getIdDireccion());
			System.out.println("calle:" + direccion.getCalle());
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Test
	public void pruebaConsultarTodo(){
		int reg;
		System.out.println("Test consultar todas las direcciones");
		try{
			List<Direccion> lista = direccionDao.obtenerDirecciones();
			reg=lista.size();
			assertEquals(lista.size(),reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	
	@Ignore
	public void nuevoRegistro(){
		Direccion direccion= new Direccion();
		System.out.println("Test nuevo registro de direccion");
		try{
			direccion.setCalle("Calle Prueba");
			direccion.setNumero(3);
			direccion.setColonia("Colonia Prueba");
			direccion.setCiudad("Ciudad Prueba");
			direccion.setEstado("Estado Prueba");
			direccion.setPais("Pais Prueba");
			direccion.setCodigoPostal(69000);
			direccionDao.nuevaDireccionCliente(direccion);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void pruebaDarBajaDireccion() {
		System.out.println("Test para dar de baja una direccion");
		try {
			direccionDao.darDeBajaDireccionPorId(6);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	
	@Test
	public void pruebaModificarDireccion() {
		Direccion direccion = new Direccion();
		System.out.println("Test para modificar una direccion");
		try {
			direccion.setIdDireccion(8);
			direccion.setCalle("CalleMod");
			direccion.setNumero(69);
			direccion.setColonia("ColoniaMod");
			direccion.setCiudad("CiudadMod");
			direccion.setEstado("EstadoMod");
			direccion.setPais("PaisMod");
			direccion.setCodigoPostal(69000);
			direccionDao.modificarDireccionPorId(direccion);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
}

