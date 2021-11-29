package br.com.project.mybarber.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.project.mybarber.dto.ServicoRQ;
import br.com.project.mybarber.dto.ServicoRS;
import br.com.project.mybarber.dto.abstractions.UpdateServicoRQ;
import br.com.project.mybarber.model.Servico;
import br.com.project.mybarber.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired // instanciando o repositório
	private ServicoRepository servicoRepository;

	// ------------------------------------------------------------------------//

	// criando o método para listar todos os Serviços
	public List<ServicoRS> getServicos() {

		List<Servico> servico = servicoRepository.findAll();

		return ServicoRS.converter(servico);

	}

	// criando o método para adicionar os Serviços
	public ResponseEntity<ServicoRS> addServicos(@RequestBody ServicoRQ servicoRQ, UriComponentsBuilder uriBuilder) {

		Servico servico = servicoRQ.converter();
		servicoRepository.save(servico);

		URI uri = uriBuilder.path("api/v1/servico/{idServico}").buildAndExpand(servico.getIdServico()).toUri();
		return ResponseEntity.created(uri).body(new ServicoRS(servico));
	}

	// Criando o método para chamar somente um Serviço (detalhamento)

	public ResponseEntity<ServicoRS> detailServico(@PathVariable("idServico") Long idServico) {

		Optional<Servico> optional = servicoRepository.findById(idServico);
		if (optional.isPresent()) {

			return ResponseEntity.ok(new ServicoRS(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	// Criando o método para deletar um serviço

	public ResponseEntity<?> deleteServico(@PathVariable("idServico") Long idServico) {
		Optional<Servico> optional = servicoRepository.findById(idServico);
		if (optional.isPresent()) {
			servicoRepository.deleteById(idServico);

			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	// Criando o método para atualizar um serviço
	public ResponseEntity<ServicoRS> updateServico(@PathVariable("idServico") Long idServico,
			@RequestBody UpdateServicoRQ updateServicoRQ) {
		Optional<Servico> optional = servicoRepository.findById(idServico);

		if (optional.isPresent()) {
			Servico servico = updateServicoRQ.atualizarServico(idServico, servicoRepository);
			return ResponseEntity.ok(new ServicoRS(servico));

		} else {

			return ResponseEntity.notFound().build();
		}
	}
	
	// criando o método para apagar todos os Serviços

	public ResponseEntity<?> deleteAllServicos() {

		List<Servico> optional = servicoRepository.findAll();
		if (optional.isEmpty()) {

			return ResponseEntity.ok().build();
		} else {
			servicoRepository.deleteAll();
			return ResponseEntity.ok().build();
		}

	}

	
	
}
