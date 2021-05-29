package br.edu.cesmac.si.nolweb.repository;

import br.edu.cesmac.si.nolweb.domain.Noticia;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class NoticiaRepositoryJPA {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public NoticiaRepositoryJPA() {}

    public NoticiaRepositoryJPA(EntityManager manager) {
        this.manager = manager;
    }

    public void salvar(Noticia noticia) {
        manager.getTransaction().begin();
        manager.merge(noticia);
        manager.getTransaction().commit();
    }

    public List<Noticia> listarTodos() {
        CriteriaQuery<Noticia> query = manager.getCriteriaBuilder().createQuery(Noticia.class);
        query.select(query.from(Noticia.class));

        List<Noticia> lista = manager.createQuery(query).getResultList();

        return lista;
    }

    public void remover(Noticia noticia) {
        noticia = manager.merge(noticia);
        manager.getTransaction().begin();
        manager.remove(noticia);
        manager.getTransaction().commit();
    }

}
