package com.ipartek.formacion.editorialrestspring.modelos;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Prestamo {
	Long id;
	Date fechaPrestamo;
	Date fechaDevolucion;
	Alumno alumno;
	Libro libro;
	
	public Long diasRestantes;
	
	public Prestamo(Long id, Date fechaPrestamo, Date fechaDevolucion, Alumno alumno, Libro libro) {
		setId(id);
		setFechaPrestamo(fechaPrestamo);
		setFechaDevolucion(fechaDevolucion);
		setAlumno(alumno);
		setLibro(libro);
	}
	public Prestamo() {
	}
	
	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion
				+ ", alumno=" + alumno + ", libro=" + libro + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	/**
	 * Get a diff between two dates
	 * @param date to compare
	 */
	public void setDiasRestantes(Date date) {
		Date today = new Date();
	    //long diffInMillies = today.getTime() - date.getTime();
	    long diffInMillies = date.getTime() - today.getTime();
	    
	    diasRestantes = TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	public long getDiasRestantes() {
		return diasRestantes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((fechaDevolucion == null) ? 0 : fechaDevolucion.hashCode());
		result = prime * result + ((fechaPrestamo == null) ? 0 : fechaPrestamo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (fechaDevolucion == null) {
			if (other.fechaDevolucion != null)
				return false;
		} else if (!fechaDevolucion.equals(other.fechaDevolucion))
			return false;
		if (fechaPrestamo == null) {
			if (other.fechaPrestamo != null)
				return false;
		} else if (!fechaPrestamo.equals(other.fechaPrestamo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		return true;
	}
}
