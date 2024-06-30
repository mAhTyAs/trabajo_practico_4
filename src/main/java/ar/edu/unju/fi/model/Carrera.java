package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private String codigo;
	private String nombre;
	private Integer cantidadAnos;
	private boolean estado;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidadAnos() {
		return cantidadAnos;
	}
	public void setCantidadAnos(int cantidadAnos) {
		this.cantidadAnos = cantidadAnos;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Carrera(String codigo, String nombre, Integer cantidadAnos, boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnos = cantidadAnos;
		this.estado = estado;
	}
	public Carrera() {
		// TODO Auto-generated constructor stub
	}
	


}
