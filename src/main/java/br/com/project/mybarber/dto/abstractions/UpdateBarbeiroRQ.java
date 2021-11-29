package br.com.project.mybarber.dto.abstractions;

import java.util.List;

import br.com.project.mybarber.model.Barbeiro;
import br.com.project.mybarber.model.Servico;
import br.com.project.mybarber.repository.BarbeiroRepository;

public class UpdateBarbeiroRQ {

	private String nomeBarbeiro;

	private List<Servico> servicos;

/////////////////////////////////////

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

	public Barbeiro atualizarBarbeiro(Long idBarbeiro, BarbeiroRepository barbeiroRepository) {

		Barbeiro barbeiro = barbeiroRepository.getById(idBarbeiro);

		barbeiro.setNomeBarbeiro(this.nomeBarbeiro);
		barbeiro.setServicos(this.servicos);

		return barbeiro;
	}

	public UpdateBarbeiroRQ() {

	}

}
