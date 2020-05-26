package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;
import java.util.Date;
import com.sun.istack.NotNull;

@Entity
@Table(schema = "public", name = "cat_libro")
public class libro {

	@Id
	@Column(name = "c_libro")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "s_titulo")
	@Length(max = 500, message = "El tituto tienen mas de 500 caracteres")
	private String titulo;

	@Column(name = "s_autor")
	@Length(max = 150, message = "El autor tiene mas de 150 caracteres")
	private String autor;

	@Column(name = "s_isbn")
	@Length(max = 10, message = "El autor tiene mas de 10 caracteres")
	private String isbn;

	@Column(name = "c_categoria")
	private Integer categoria;

	@Column(name = "f_ingreso")
	private Timestamp fecha = new Timestamp(System.currentTimeMillis());

	@Column(name = "b_estado")
	private boolean estado = true;

	public libro() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
