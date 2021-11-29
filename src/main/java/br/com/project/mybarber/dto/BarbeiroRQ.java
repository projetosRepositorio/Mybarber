package br.com.project.mybarber.dto;

import java.util.List;

import br.com.project.mybarber.model.Barbeiro;
import br.com.project.mybarber.model.Servico;

import lombok.Data;

@Data
public class BarbeiroRQ {
	private String nomeBarbeiro;
	private List<Servico> servicos;

	public Barbeiro converter() {

		return new Barbeiro(servicos, nomeBarbeiro);
	}

	public BarbeiroRQ() {

	}
	///////////////////////////////

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