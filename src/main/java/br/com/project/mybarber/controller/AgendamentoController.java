package br.com.project.mybarber.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.project.mybarber.dto.AgendamentoRQ;
import br.com.project.mybarber.dto.AgendamentoRS;
import br.com.project.mybarber.service.AgendamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/agendamento")
@Api(value = "API REST Barbearia")
@CrossOrigin(origins = "*") // Mudar para os domínios específicos
public class AgendamentoController {
	// Instanciando barbeiroService
	private final AgendamentoService agendamentoService;

	@Autowired
	public AgendamentoController(AgendamentoService agendamentoService) {

		this.agendamentoService = agendamentoService;
	}

	// ---------------------------------------------------------------------------------//

	// Chamando um método dentro do serviço agendamento
	@ApiOperation("Acessa a tabela Agendamento")
	@Transactional
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List<AgendamentoRS> getAgendamento() {

		return agendamentoService.getAgendamentos();
	}

	// Chamando um método dentro do serviço agendamento
	@ApiOperation("Adiciona um agendamento na tabela agendamento")
	@Transactional
	@PostMapping
	public ResponseEntity<AgendamentoRS> addAgendamento(@RequestBody AgendamentoRQ agendamentoRQ,
			UriComponentsBuilder uriBuilder) {

		return agendamentoService.addAgendamentos(agendamentoRQ, uriBuilder);
	}
	// Chamando um método dentro do serviço agendamento

	@ApiOperation("Seleciona um agendamento pelo id")
	@Transactional
	@GetMapping("/{idAgendamento}")
	public ResponseEntity<AgendamentoRS> detalhar(@PathVariable("idAgendamento") Long idAgendamento) {

		return agendamentoService.detailAgendamento(idAgendamento);

	}

	// Chamando um método dentro do serviço agendamento
	@ApiOperation("Deleta um agendamento")
	@Transactional
	@DeleteMapping("/{idAgendamento}")

	public ResponseEntity<?> deleteAgendamento(@PathVariable("idAgendamento") Long idAgendamento) {

		return agendamentoService.deleteAgendamento(idAgendamento);
	}

	// Chamando um método dentro do serviço agendamento
	@ApiOperation("Deleta todos os Agendamentos")
	@Transactional
	@DeleteMapping("/all")
	public ResponseEntity<?> deleteAllAgendamentos() {

		return agendamentoService.deleteAllAgendamentos();

	}

}
