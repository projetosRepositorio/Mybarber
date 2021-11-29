package br.com.project.mybarber.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table
public class Servico {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy="increment")
	private Long idServico;
	
	
	private String nomeServico;

	//Construtor do RQ
	public Servico( String nomeServico) {
		
		
		this.nomeServico = nomeServico;
		
	}

	public Servico() {
		
	}
	//////////////////////////////////////////////////////////

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	
	
	
	
	
}