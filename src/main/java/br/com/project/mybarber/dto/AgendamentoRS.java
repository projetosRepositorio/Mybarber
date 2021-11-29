package br.com.project.mybarber.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.project.mybarber.model.Agendamento;
import br.com.project.mybarber.model.Barbeiro;
import br.com.project.mybarber.model.Servico;
import lombok.Data;

@Data
public class AgendamentoRS {

	private Barbeiro barbeiro;

	private Servico servico;

	private String nomeCliente;

	private String contatoCliente;

	private Long idAgendamento;

	// Construtor para fazer a conversão
	public AgendamentoRS(Agendamento agendamento) {

		this.idAgendamento = agendamento.getIdAgendamento();

		this.servico = agendamento.getServico();

		this.barbeiro = agendamento.getBarbeiro();

		this.contatoCliente = agendamento.getContatoCliente();

		this.nomeCliente = agendamento.getNomeCliente();

	}

	// Método que faz a conversão
	public static List<AgendamentoRS> converter(List<Agendamento> agendamento) {

		return agendamento.stream().map(AgendamentoRS::new).collect(Collectors.toList());

	}

	public AgendamentoRS() {

	}

	//////////////////////////////////////////////
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

	public Long getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

}
