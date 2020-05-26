package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.sun.istack.NotNull;

@Entity
@Table(schema = "public",name = "cat_categoria")
public class categoria {
	
	@Id
	@Column(name = "c_categoria")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "s_categoria")
	@NotEmpty(message = "El campo nombre categoria no puede estar vacio")
	@Length(max = 50,message = "El campo sobre pasa los 50 caracteres" )
	private String categoria;
	
	public categoria() {
		System.out.println("entra");
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	

	

}
