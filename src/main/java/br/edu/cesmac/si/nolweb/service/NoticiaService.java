package br.edu.cesmac.si.nolweb.service;

import br.edu.cesmac.si.nolweb.domain.Noticia;
import br.edu.cesmac.si.nolweb.repository.NoticiaRepositoryJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class NoticiaService {

    @Inject
    NoticiaRepositoryJPA noticiaRepositoryJPA;

    public List<Noticia> listarTodos() {
        return this.noticiaRepositoryJPA.listarTodos();
    }

    public void salvar(Noticia noticia) {
        this.noticiaRepositoryJPA.salvar(noticia);
    }

    public void remover(Noticia noticia) {
        this.noticiaRepositoryJPA.remover(noticia);
    }

}
