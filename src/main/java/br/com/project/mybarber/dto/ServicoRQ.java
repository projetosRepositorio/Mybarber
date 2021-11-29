package br.com.project.mybarber.dto;

import br.com.project.mybarber.model.Servico;
import lombok.Data;

@Data
public class ServicoRQ {
	private String nomeServico;

	public Servico converter() {

		return new Servico(nomeServico);
	}

	public ServicoRQ() {

	}

	///////////////////////////////////////

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

}