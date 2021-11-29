package br.com.project.mybarber.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.project.mybarber.model.Servico;
import lombok.Data;

@Data
public class ServicoRS {
	private Long idServico;

	private String nomeServico;

	// Construtor para fazer a conversão
	public ServicoRS(Servico servico) {

		this.idServico = servico.getIdServico();

		this.nomeServico = servico.getNomeServico();

	}

	// Método que faz a conversão
	public static List<ServicoRS> converter(List<Servico> servico) {

		return servico.stream().map(ServicoRS::new).collect(Collectors.toList());
	}

	public ServicoRS() {

	}

	//////////////////////////////
	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

}