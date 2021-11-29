package br.com.project.mybarber.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.com.project.mybarber.dto.abstractions.UpdateNomeBarbeiroRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.project.mybarber.dto.BarbeiroRQ;
import br.com.project.mybarber.dto.BarbeiroRS;
import br.com.project.mybarber.dto.abstractions.UpdateBarbeiroRQ;
import br.com.project.mybarber.dto.abstractions.UpdateServicosBarbeiroRQ;
import br.com.project.mybarber.model.Barbeiro;
import br.com.project.mybarber.repository.BarbeiroRepository;

@Service
public class BarbeiroService {

	@Autowired // instanciando o repositório
	private BarbeiroRepository barbeiroRepository;

	// --------------------------------------------------------------//

	// criando o método para listar todos os Barbeiros
	public List<BarbeiroRS> getBarbeiros() {

		List<Barbeiro> barbeiro = barbeiroRepository.findAll();

		return BarbeiroRS.converter(barbeiro);
	}

	// Criando o método para adicionar os Barbeiros

	public ResponseEntity<BarbeiroRS> addBarbeiros(@RequestBody BarbeiroRQ barbeiroRQ,
			UriComponentsBuilder uriBuilder) {

		Barbeiro barbeiro = barbeiroRQ.converter();
		barbeiroRepository.save(barbeiro);

		URI uri = uriBuilder.path("/api/v1/barbeiro/{idBarbeiro}").buildAndExpand(barbeiro.getIdBarbeiro()).toUri();
		return ResponseEntity.created(uri).body(new BarbeiroRS(barbeiro));
	}

	// Criando o método para buscar somente um Barbeiro (detalhamento)

	public ResponseEntity<BarbeiroRS> detailBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro) {

		Optional<Barbeiro> optional = barbeiroRepository.findById(idBarbeiro);

		if (optional.isPresent()) {

			return ResponseEntity.ok(new BarbeiroRS(optional.get()));
		}

		return ResponseEntity.notFound().build();

	}

	// Criando o método para deletar um Barbeiro

	public ResponseEntity<?> deleteBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro) {

		Optional<Barbeiro> optional = barbeiroRepository.findById(idBarbeiro);

		if (optional.isPresent()) {
			barbeiroRepository.deleteById(idBarbeiro);

			return ResponseEntity.ok().build();
		} else {

			return ResponseEntity.notFound().build();
		}
	}

	// Criando o método para atualizar um Barbeiro

	public ResponseEntity<BarbeiroRS> updateBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro,
			@RequestBody UpdateBarbeiroRQ updateBarbeiroRQ) {

		Optional<Barbeiro> optional = barbeiroRepository.findById(idBarbeiro);

		if (optional.isPresent()) {
			Barbeiro barbeiro = updateBarbeiroRQ.atualizarBarbeiro(idBarbeiro, barbeiroRepository);

			return ResponseEntity.ok(new BarbeiroRS(barbeiro));

		}
		return ResponseEntity.notFound().build();

	}
	
	
	
	// criando o método para apagar todos os Barbeiros

	public ResponseEntity<?> deleteAllBarbeiros() {

		List<Barbeiro> optional = barbeiroRepository.findAll();
		if (optional.isEmpty()) {

			return ResponseEntity.ok().build();
		} else {
			barbeiroRepository.deleteAll();
			return ResponseEntity.ok().build();
		}

	}
	
	// criando o método para alterar somente os serviços do barbeiro

	public ResponseEntity<BarbeiroRS> updateServicosBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro,
			@RequestBody UpdateServicosBarbeiroRQ updateServicosBarbeiroRQ) {
		
		
		 updateServicosBarbeiroRQ.atualizarServicosBarbeiro(idBarbeiro, barbeiroRepository);
		
		return ResponseEntity.ok().build();
	}

	// criando o método para alterar somente o nome do barbeiro

	public ResponseEntity<BarbeiroRS> updateNomeBarbeiro(@PathVariable("idBarbeiro") Long idBarbeiro,
															 @RequestBody UpdateNomeBarbeiroRQ updateNomeBarbeiroRQ) {


		updateNomeBarbeiroRQ.atualizarNomesBarbeiro(idBarbeiro, barbeiroRepository);

		return ResponseEntity.ok().build();
	}
}
