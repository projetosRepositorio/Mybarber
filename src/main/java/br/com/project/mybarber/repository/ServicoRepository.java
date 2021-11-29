package br.com.project.mybarber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.mybarber.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

	Servico findByNomeServico(String nomeServico);
	
	

	
	
	



	

}
