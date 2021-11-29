package br.com.project.mybarber.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Data
@Entity
@Table
public class Barbeiro {
	
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy="increment")
	private Long idBarbeiro;
	
	
	
	private String nomeBarbeiro;
	
	
	@ManyToMany
	@JoinColumn(name = "servico_id")
	private List<Servico> servicos;

	//Construtor do RQ
		public Barbeiro(List<Servico> servicos, String nomeBarbeiro) {
			
			this.nomeBarbeiro = nomeBarbeiro;
			this.servicos = servicos;
			
		}
	public Barbeiro() {
		
	}
	
	//////////////////////////////////////////////////
	public Long getIdBarbeiro() {
		return idBarbeiro;
	}
	public void setIdBarbeiro(Long idBarbeiro) {
		this.idBarbeiro = idBarbeiro;
	}
	public String getNomeBarbeiro() {
		return nomeBarbeiro;
	}
	public void setNomeBarbeiro(String nomeBarbeiro) {
		this.nomeBarbeiro = nomeBarbeiro;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	

}