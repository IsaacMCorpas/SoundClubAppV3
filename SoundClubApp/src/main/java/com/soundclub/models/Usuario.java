package com.soundclub.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class Usuario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="uid")
	private int uid;
	@Column(name="first_name")
	private String nombre;
	@Column(name="last_name")
	private String apellidos;
	@Column(name="mail")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="city")
	private String ciudad_recide;
	@Column(name="address")
	private String calle;
	@Column(name="birth_date")
	private Date fecha_nacimiento;
	@Column(name="sex")
	private int sexo;
	@Column(name="pic")
	private String foto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_country")
	private Pais pais_recide;
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(
			name="generoM_usuario",
			joinColumns= {@JoinColumn(name="uid")},
			inverseJoinColumns= {@JoinColumn(name="mid")}
			)
	private List<Genero_Musical> listaGenero_musical = new ArrayList<Genero_Musical>();
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(
			name="instrumento_usuario",
			joinColumns= {@JoinColumn(name="uid")},
			inverseJoinColumns= {@JoinColumn(name="iid")}
			)
	private List<Instrumento> listaInstrumento = new ArrayList<Instrumento>();
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name="amigos_usuario",
			joinColumns= {@JoinColumn(name="aid")},
			inverseJoinColumns= {@JoinColumn(name="uid")}
			)
	private List<Usuario> listaAmigos = new ArrayList<Usuario>();
	

	public Usuario(int id, String nombre, String apellidos, String email, String password) {
		this.uid = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.pais_recide = null;
		this.ciudad_recide = "";
		this.calle = "";
		this.foto = "";
//		listaInstrumento = null;
//		listaGenero_musical = null;
//		listaAmigos = null;
	}

	public Usuario(int id, String nombre, String apellidos, String email, String password, Pais pais_recide,
			String ciudad_recide, String calle, Date fecha_nacimiento, int sexo, String foto) {
		this.uid = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.pais_recide = pais_recide;
		this.ciudad_recide = ciudad_recide;
		this.calle = calle;
		this.fecha_nacimiento = fecha_nacimiento;
		this.sexo = sexo;
		this.foto = foto;
		listaInstrumento = null;
		listaGenero_musical = null;
		listaAmigos = null;

	}
	public Usuario() {
		
	}

	public int getId() {
		return uid;
	}

	public void setId(int id) {
		this.uid = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Pais getPais_recide() {
		return pais_recide;
	}

	public void setPais_recide(Pais pais_recide) {
		this.pais_recide = pais_recide;
	}

	public String getCiudad_recide() {
		return ciudad_recide;
	}

	public void setCiudad_recide(String ciudad_recide) {
		this.ciudad_recide = ciudad_recide;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}



	public List<Instrumento> getListaInstrumento() {
		return listaInstrumento;
	}

	public void setListaInstrumento(List<Instrumento> listaInstrumento) {
		this.listaInstrumento = listaInstrumento;
	}
	
	public void setNuevoInstrumento(Instrumento listaInstrumento) {
		this.listaInstrumento.add(listaInstrumento);
	}



	public List<Genero_Musical> getListaGenero_musical() {
		return listaGenero_musical;
	}

	public void setListaGenero_musical(List<Genero_Musical> listaGenero_musical) {
		this.listaGenero_musical = listaGenero_musical;
	}
	
	public void setNuevoGenero_musical(Genero_Musical listaGenero_musical) {
		this.listaGenero_musical.add(listaGenero_musical);
	}


	public List<Usuario> getListaAmigos() {
		return listaAmigos;
	}

	public void setListaAmigos(List<Usuario> listaAmigos) {
		this.listaAmigos = listaAmigos;
	}

	public void setNuevoAmigo(Usuario unAmigo) {
		this.listaAmigos.add(unAmigo);
	}
	

	
	/***********************************
	 * MOSTRAR INFORMACION DEL USUARIO BUSCADO
	 **********************************/
	public boolean esAmigo(int idUsuario) {
		boolean esAmigo = false;
		if (listaAmigos != null) {
			for (Usuario unUsuario : listaAmigos) {
				if (unUsuario.getId() == idUsuario) {
					esAmigo = true;
					break;
				}
			}
		}
		return esAmigo;
	}

	public Hashtable validar() {
		Hashtable errors = new Hashtable();
		boolean hayError = false;
		
		if (this.nombre == null || this.nombre.equals("")) {
			errors.put("nombre", "Debes indicar el nombre");
			hayError = true;
		}
		
		if (this.apellidos == null || this.apellidos.equals("")) {
			errors.put("apellidos", "Debes indicar el nombre");
			hayError = true;
		}

		if (this.email == null || this.email.equals("")) {
			errors.put("email", "Debes indicar el email");
			hayError = true;
		}

		if (this.password == null || this.password.equals("")) {
			errors.put("pass", "Debes indicar el password");
			hayError = true;
		}

		errors.put("hayError", hayError);
		
		return errors;

	}

	//////////////////////////////////////////////////////////////////////////////////
	
	
	
}
