package cursoDAgil.dao.direccion;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.DireccionMapper;

/** 
 * Equipo 5
 * @author Abner Ely Castellanos Diaz
 * 20/04/2022
 * Esta es una clase para la implementacion de los metodos para
 * la entidad direccion.
 */

@Named
public class DireccionDaoImp implements DireccionDao {
	SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<Direccion> obtenerDirecciones() {
		try{
			DireccionMapper direccionMapper = 
			sqlSession.getMapper(DireccionMapper.class);
			return direccionMapper.obtenerDirecciones();
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		try{
			DireccionMapper direccionMapper = 
			sqlSession.getMapper(DireccionMapper.class);
			System.out.println("direccion creada con éxito");
			return direccionMapper.nuevaDireccionCliente(direccion);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;

	}

	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion) {
		try{
			DireccionMapper direccionMapper = 
			sqlSession.getMapper(DireccionMapper.class);
			return direccionMapper.obtenerDireccionPorId(mapDireccion);
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	@Override
	public void darDeBajaDireccionPorId(int id) {
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			direccionMapper.darDeBajaDireccionPorId(id);
			System.out.println("Se ha dado de baja la direccion con id: " + id);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
	@Override
	public void modificarDireccionPorId(Direccion direccion) {
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			direccionMapper.modificarDireccionPorId(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
