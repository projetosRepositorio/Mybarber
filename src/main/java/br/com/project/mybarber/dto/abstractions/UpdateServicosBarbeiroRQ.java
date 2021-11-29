package br.com.project.mybarber.dto.abstractions;

import java.util.List;

import br.com.project.mybarber.model.Barbeiro;
import br.com.project.mybarber.model.Servico;
import br.com.project.mybarber.repository.BarbeiroRepository;

public class UpdateServicosBarbeiroRQ {

	private List<Servico> servicos;

	public Barbeiro atualizarServicosBarbeiro(Long idBarbeiro, BarbeiroRepository barbeiroRepository) {

		Barbeiro barbeiro = barbeiroRepository.getById(idBarbeiro);

		barbeiro.setServicos(this.servicos);

		return barbeiro;
	}

	public UpdateServicosBarbeiroRQ() {

	}

	// -----------------------------------------------------------------------------//
	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}
