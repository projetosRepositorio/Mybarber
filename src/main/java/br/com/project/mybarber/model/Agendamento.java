package br.com.project.mybarber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table

@Data

public class Agendamento {

	
	
	@Id
	
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment",strategy="increment")
	private Long idAgendamento;
	
	@ManyToOne
	@JoinColumn(name = "barbeiro_id")
	private Barbeiro barbeiro;
	
	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;
	
	
	private String nomeCliente;
	
	
	private String contatoCliente;

//Construtor do RQ
	public Agendamento(Barbeiro barbeiro, Servico servico, String nomeCliente, String contatoCliente) {
		
		this.barbeiro = barbeiro;
		this.servico = servico;
		this.nomeCliente = nomeCliente;
		this.contatoCliente = contatoCliente;
	}


	public Agendamento() {
		
	}
	/////////////////////////////////////

	public Long getIdAgendamento() {
		return idAgendamento;
	}


	public void setIdAgendamento(Long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}


	public Barbeiro getBarbeiro() {
		return barbeiro;
	}


	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getContatoCliente() {
		return contatoCliente;
	}


	public void setContatoCliente(String contatoCliente) {
		this.contatoCliente = contatoCliente;
	}


	
	

	
	
	
	

}