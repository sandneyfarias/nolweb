package br.edu.cesmac.si.nolweb.service;

import br.edu.cesmac.si.nolweb.domain.Jornalista;
import br.edu.cesmac.si.nolweb.domain.Noticia;
import br.edu.cesmac.si.nolweb.repository.JornalistaRepositoryJPA;
import br.edu.cesmac.si.nolweb.repository.NoticiaRepositoryJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class NoticiaService {

    @Inject
    NoticiaRepositoryJPA noticiaRepositoryJPA;
    @Inject
    JornalistaRepositoryJPA jornalistaRepositoryJPA;

    public List<Noticia> listarTodos() {
        return this.noticiaRepositoryJPA.listarTodos();
    }

    public void salvar(Noticia noticia) {
        if (noticia.getJornalistas().size() > 0) {
            List<Jornalista> jornalistas = new ArrayList<>();
            Noticia n = new Noticia();
            n.setIdNoticia(noticia.getIdNoticia());

            for (Jornalista jornalista : noticia.getJornalistas()) {
                Jornalista jornalistaGerenciado = jornalistaRepositoryJPA.findById(jornalista.getIdJornalista());
                jornalistas.add(jornalistaGerenciado);
            }
            noticia.setJornalistas(jornalistas);
        }

        this.noticiaRepositoryJPA.salvar(noticia);
    }

    public Noticia findById(Long idNoticia) {
        return this.noticiaRepositoryJPA.findById(idNoticia);
    }

    public void remover(Noticia noticia) {
        noticia.setJornalistas(null);
        this.noticiaRepositoryJPA.remover(noticia);
    }

}
