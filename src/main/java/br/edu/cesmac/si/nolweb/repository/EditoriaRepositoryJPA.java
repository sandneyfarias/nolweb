package br.edu.cesmac.si.nolweb.repository;

import br.edu.cesmac.si.nolweb.domain.Editoria;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class EditoriaRepositoryJPA implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public EditoriaRepositoryJPA() {}

    public EditoriaRepositoryJPA(EntityManager manager) {
        this.manager = manager;
    }

    public void salvar(Editoria editoria) {
        manager.getTransaction().begin();
        manager.merge(editoria);
        manager.getTransaction().commit();
    }

    public List<Editoria> listarTodos() {
        CriteriaQuery<Editoria> query = manager.getCriteriaBuilder().createQuery(Editoria.class);
        query.select(query.from(Editoria.class));

        List<Editoria> lista = manager.createQuery(query).getResultList();

        return lista;
    }

    public void remover(Editoria editoria) {
        editoria = manager.merge(editoria);
        manager.getTransaction().begin();
        manager.remove(editoria);
        manager.getTransaction().commit();
    }

}

