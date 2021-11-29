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

import br.com.project.mybarber.dto.AgendamentoRQ;
import br.com.project.mybarber.dto.AgendamentoRS;
import br.com.project.mybarber.model.Agendamento;
import br.com.project.mybarber.repository.AgendamentoRepository;
import br.com.project.mybarber.repository.BarbeiroRepository;
import br.com.project.mybarber.repository.ServicoRepository;

@Service
public class AgendamentoService {
	@Autowired // instanciando o repositório
	private AgendamentoRepository agendamentoRepository;

	@Autowired // instanciando o repositório
	private BarbeiroRepository barbeiroRepository;

	@Autowired // instanciando o repositório
	private ServicoRepository servicoRepository;

	// criando o método para listar todos os Agendamentos
	public List<AgendamentoRS> getAgendamentos() {

		List<Agendamento> agendamentos = agendamentoRepository.findAll();

		return AgendamentoRS.converter(agendamentos);
	}

	// criando o método para adicionar todos os Agendamentos
	public ResponseEntity<AgendamentoRS> addAgendamentos(@RequestBody AgendamentoRQ agendamentoRQ,
			UriComponentsBuilder uriBuilder) {

		Agendamento agendamento = agendamentoRQ.converter(barbeiroRepository, servicoRepository);
		agendamentoRepository.save(agendamento);

		URI uri = uriBuilder.path("api/v1/agendamento/{idAgendamento}").buildAndExpand(agendamento.getIdAgendamento())
				.toUri();
		return ResponseEntity.created(uri).body(new AgendamentoRS(agendamento));
	}

	// criando o método para buscar somente um agendamento (detalhamento)

	public ResponseEntity<AgendamentoRS> detailAgendamento(@PathVariable("idAgendamento") Long idAgendamento) {

		Optional<Agendamento> optional = agendamentoRepository.findById(idAgendamento);

		if (optional.isPresent()) {
			return ResponseEntity.ok(new AgendamentoRS(optional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	// Criando o método para deletar um Agendamento

	public ResponseEntity<?> deleteAgendamento(@PathVariable("idAgendamento") Long idAgendamento) {

		Optional<Agendamento> optional = agendamentoRepository.findById(idAgendamento);

		if (optional.isPresent()) {

			agendamentoRepository.deleteById(idAgendamento);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}

	// criando o método para apagar todos os Agendamentos

	public ResponseEntity<?> deleteAllAgendamentos() {

		List<Agendamento> optional = agendamentoRepository.findAll();
		if (optional.isEmpty()) {

			return ResponseEntity.ok().build();
		} else {
			agendamentoRepository.deleteAll();
			return ResponseEntity.ok().build();
		}

	}
}
