package br.edu.cesmac.si.nolweb.service;

import br.edu.cesmac.si.nolweb.domain.Jornalista;
import br.edu.cesmac.si.nolweb.repository.JornalistaRepositoryJPA;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class JornalistaService implements Serializable {

    @Inject
    JornalistaRepositoryJPA jornalistaRepository;

    public List<Jornalista> listarTodos() {
        return this.jornalistaRepository.listarTodos();
    }

    public void salvar(Jornalista jornalista) {
        this.jornalistaRepository.salvar(jornalista);
    }

    public void remover(Jornalista jornalista) {
        this.jornalistaRepository.remover(jornalista);
    }

}
