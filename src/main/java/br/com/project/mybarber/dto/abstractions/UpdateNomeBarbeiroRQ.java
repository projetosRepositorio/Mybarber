package br.com.project.mybarber.dto.abstractions;


import br.com.project.mybarber.model.Barbeiro;
import br.com.project.mybarber.model.Servico;
import br.com.project.mybarber.repository.BarbeiroRepository;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class UpdateNomeBarbeiroRQ {


    private String nomeBarbeiro;

    public Barbeiro atualizarNomesBarbeiro(Long idBarbeiro, BarbeiroRepository barbeiroRepository) {

        Barbeiro barbeiro = barbeiroRepository.getById(idBarbeiro);

        barbeiro.setNomeBarbeiro(this.nomeBarbeiro);

        return barbeiro;
    }



}

