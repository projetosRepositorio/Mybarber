package br.com.project.mybarber.dto.abstractions;

import br.com.project.mybarber.model.Servico;
import br.com.project.mybarber.repository.ServicoRepository;

public class UpdateServicoRQ {

	private String nomeServico;

	////////////////////

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	// atualizando o objeto
	public Servico atualizarServico(Long idServico, ServicoRepository servicoRepository) {
		Servico servico = servicoRepository.getById(idServico);

		servico.setNomeServico(this.nomeServico);

		return servico;
	}

	public UpdateServicoRQ() {

	}

}
