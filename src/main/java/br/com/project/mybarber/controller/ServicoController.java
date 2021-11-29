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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.project.mybarber.dto.ServicoRQ;
import br.com.project.mybarber.dto.ServicoRS;
import br.com.project.mybarber.dto.abstractions.UpdateServicoRQ;
import br.com.project.mybarber.service.ServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "api/v1/servico")
@Api(value = "API REST Barbearia")
@CrossOrigin(origins = "*") // Mudar para os domínios específicos

public class ServicoController {

	// Instanciando servicoService
	private final ServicoService servicoService;

	@Autowired
	public ServicoController(ServicoService servicoService) {

		this.servicoService = servicoService;
	}

	// --------------------------------------------------------------------------------//

	// Chamando um método dentro do serviço servico
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Acessa a tabela Servico")
	public List<ServicoRS> getServico() {

		return servicoService.getServicos();
	}

	// Chamando um método dentro do serviço servico
	@ApiOperation("Adiciona um serviço na tabela serviço")
	@Transactional
	@PostMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServicoRS> addServico(@RequestBody ServicoRQ servicoRQ, UriComponentsBuilder uriBuilder) {

		return servicoService.addServicos(servicoRQ, uriBuilder);
	}

	// Chamando um método dentro do serviço servico
	@ApiOperation("Seleciona um serviço pelo id")
	@GetMapping(value = "/{idServico}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServicoRS> detalhar(@PathVariable("idServico") Long idServico) {

		return servicoService.detailServico(idServico);

	}

	@ApiOperation("Deleta um serviço pelo id")
	@Transactional
	@DeleteMapping("/{idServico}")
	public ResponseEntity<?> de0leteServico(@PathVariable("idServico") Long idServico) {

		return servicoService.deleteServico(idServico);

	}

	// Chamando um método dentro do serviço servico
	@ApiOperation("Atualiza um serviço pelo id")
	@Transactional
	@PutMapping(value = "/{idServico}",produces= MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServicoRS> updateServico(@PathVariable("idServico") Long idServico,
			@RequestBody UpdateServicoRQ updateServicoRQ) {

		return servicoService.updateServico(idServico, updateServicoRQ);
	}
	
	// Chamando um método dentro do serviço servico
	
	@ApiOperation("Deleta todos os serviço")
	@Transactional
	@DeleteMapping("/all")
	public ResponseEntity<?> deleteAllServicos() {

		return servicoService.deleteAllServicos();

	}

}
