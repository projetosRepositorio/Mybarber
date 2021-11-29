package br.com.project.mybarber.controller;

import java.util.List;

import javax.transaction.Transactional;

import br.com.project.mybarber.dto.abstractions.UpdateNomeBarbeiroRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.project.mybarber.dto.BarbeiroRQ;
import br.com.project.mybarber.dto.BarbeiroRS;
import br.com.project.mybarber.dto.abstractions.UpdateBarbeiroRQ;
import br.com.project.mybarber.dto.abstractions.UpdateServicosBarbeiroRQ;
import br.com.project.mybarber.service.BarbeiroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/barbeiro")
@Api(value = "API REST Barbearia")
@CrossOrigin(origins = "*") // Mudar para os domínios específicos
public class BarbeiroController {

	// Instanciando barbeiroService
	private final BarbeiroService barbeiroService;

	@Autowired
	public BarbeiroController(BarbeiroService barbeiroService) {

		this.barbeiroService = barbeiroService;
	}

	// ---------------------------------------------------------------------------------//

	// Chamando um método dentro do serviço Barbeiro
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	@ApiOperation("Acessa a tabela barbeiro")
	public List<BarbeiroRS> getBarbeiro() {

		return barbeiroService.getBarbeiros();
	}

	// Chamando um método dentro do serviço barbeiro
	@ApiOperation("Adiciona um barbeiro na tabela barbeiro")
	@Transactional
	@PostMapping
	public ResponseEntity<BarbeiroRS> addAgendamento(@RequestBody BarbeiroRQ barbeiroRQ,
			UriComponentsBuilder uriBuilder) {

		return barbeiroService.addBarbeiros(barbeiroRQ, uriBuilder);
	}

	// Chamando um método dentro do serviço Barbeiro
	@ApiOperation("Seleciona um barbeiro pelo id")
	@Transactional
	@GetMapping("/{idBarbeiro}")
	public ResponseEntity<BarbeiroRS> detalhar(@PathVariable("idBarbeiro") Long idBarbeiro) {

		return barbeiroService.detailBarbeiro(idBarbeiro);

	}

	// Chamando um método dentro do serviço Barbeiro
	@ApiOperation("Deleta um barbeiro pelo id")
	@Transactional
	@DeleteMapping("{idBarbeiro}")
	public ResponseEntity<?> deleteBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro) {

		return barbeiroService.deleteBarbeiro(idBarbeiro);
	}

	// Chamando um método dentro do serviço Barbeiro
	@ApiOperation("Atualiza um barbeiro pelo id")
	@Transactional
	@PutMapping("/{idBarbeiro}")
	public ResponseEntity<BarbeiroRS> updateBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro,
			@RequestBody UpdateBarbeiroRQ updateBarbeiroRQ) {

		return barbeiroService.updateBarbeiro(idBarbeiro, updateBarbeiroRQ);
	}

	// Chamando um método dentro do serviço Barbeiro
	@ApiOperation("Deleta todos os barbeiros")
	@Transactional
	@DeleteMapping("/all")
	public ResponseEntity<?> deleteAllBarbeiros() {

		return barbeiroService.deleteAllBarbeiros();

	}

	// Chamando um método dentro do serviço Barbeiro
	@ApiOperation("Altera os serviços do barbeiro")
	@Transactional
	@PatchMapping("/{idBarbeiro}/servicos")
	public ResponseEntity<BarbeiroRS> updateServicosBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro,
			@RequestBody UpdateServicosBarbeiroRQ updateServicosBarbeiroRQ) {

		return barbeiroService.updateServicosBarbeiro(idBarbeiro, updateServicosBarbeiroRQ);
	}

	// Chamando um método dentro do serviço Barbeiro
	@ApiOperation("Altera o nome do barbeiro")
	@Transactional
	@PatchMapping(value = "/{idBarbeiro}/nomeBarbeiro")
	public ResponseEntity<BarbeiroRS> updateServicosBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro,
															 @RequestBody UpdateNomeBarbeiroRQ updateNomeBarbeiroRQ) {

		return barbeiroService.updateNomeBarbeiro(idBarbeiro, updateNomeBarbeiroRQ);
	}

}
