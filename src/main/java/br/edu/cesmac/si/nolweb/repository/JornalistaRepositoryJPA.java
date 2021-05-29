package br.edu.cesmac.si.nolweb.repository;

import br.edu.cesmac.si.nolweb.domain.Jornalista;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class JornalistaRepositoryJPA {

    @Inject
    private EntityManager manager;

    public JornalistaRepositoryJPA() {}

    public JornalistaRepositoryJPA(EntityManager manager) {
        this.manager = manager;
    }

    public void salvar(Jornalista jornalista) {
        manager.getTransaction().begin();
        manager.merge(jornalista);
        manager.getTransaction().commit();
    }

    public List<Jornalista> listarTodos() {
        CriteriaQuery<Jornalista> query = manager.getCriteriaBuilder().createQuery(Jornalista.class);
        query.select(query.from(Jornalista.class));

        List<Jornalista> lista = manager.createQuery(query).getResultList();

        return lista;
    }

    public void remover(Jornalista jornalista) {
        jornalista = manager.merge(jornalista);
        manager.getTransaction().begin();
        manager.remove(jornalista);
        manager.getTransaction().commit();
    }

    public Jornalista findById(Long idJornalista) {
        Jornalista j = manager.find(Jornalista.class, idJornalista);
        return j;
    }

}
