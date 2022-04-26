package cursoDAgil.bd.domain;

/** 
 * Equipo 5
 * @author Abner Ely Castellanos Diaz
 * 20/04/2022
 * Esta es una clase POJO para la entidad Cliente
 */

public class Cliente {
	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String sexo;
	private Integer idDireccion;
	private Direccion direccion;
	
	public Cliente(){
		setDireccion(new Direccion());
	} 
	
	//Getters y setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getIddireccion() {
		return idDireccion;
	}
	public void setIddireccion(Integer iddireccion) {
		this.idDireccion = iddireccion;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
