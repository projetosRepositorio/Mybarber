package br.com.project.mybarber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.mybarber.model.Barbeiro;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long>{

	Barbeiro findByNomeBarbeiro(String nomeBarbeiro);

	
	
	
}
