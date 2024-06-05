package ar.edu.unju.fi.model;

public class Carrera {
	private String codigo;
	private String nombre;
	private int cantidadAnos;
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
	public int getCantidadAnos() {
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
	
	

}
