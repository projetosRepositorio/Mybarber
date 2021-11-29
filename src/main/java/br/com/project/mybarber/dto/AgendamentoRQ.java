package br.com.project.mybarber.dto;

import br.com.project.mybarber.model.Agendamento;
import br.com.project.mybarber.model.Barbeiro;
import br.com.project.mybarber.model.Servico;
import br.com.project.mybarber.repository.BarbeiroRepository;
import br.com.project.mybarber.repository.ServicoRepository;
import lombok.Data;

@Data
public class AgendamentoRQ {

	private String nomeBarbeiro;

	private String nomeServico;

	private String nomeCliente;

	private String contatoCliente;

	public Agendamento converter(BarbeiroRepository barbeiroRepository, ServicoRepository servicoRepository) {
		Barbeiro barbeiro = barbeiroRepository.findByNomeBarbeiro(nomeBarbeiro);
		Servico servico = servicoRepository.findByNomeServico(nomeServico);

		return new Agendamento(barbeiro, servico, nomeCliente, contatoCliente);
	}

	public AgendamentoRQ() {

	}
	//////////////////////////////////////////////

	public String getNomeBarbeiro() {
		return nomeBarbeiro;
	}

	public void setNomeBarbeiro(String nomeBarbeiro) {
		this.nomeBarbeiro = nomeBarbeiro;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
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
