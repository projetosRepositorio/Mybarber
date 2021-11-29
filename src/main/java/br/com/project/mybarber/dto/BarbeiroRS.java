package br.com.project.mybarber.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.project.mybarber.model.Barbeiro;
import br.com.project.mybarber.model.Servico;
import lombok.Data;

@Data
public class BarbeiroRS {

	private Long idBarbeiro;

	private String nomeBarbeiro;

	private List<Servico> servicos;

	// Construtor para fazer a conversão
	public BarbeiroRS(Barbeiro barbeiro) {

		this.idBarbeiro = barbeiro.getIdBarbeiro();

		this.servicos = barbeiro.getServicos();

		this.nomeBarbeiro = barbeiro.getNomeBarbeiro();

	}

	// Método que faz a conversão
	public static List<BarbeiroRS> converter(List<Barbeiro> barbeiro) {

		return barbeiro.stream().map(BarbeiroRS::new).collect(Collectors.toList());

	}

	public BarbeiroRS() {

	}

	/////////////////////////////////////////////////

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