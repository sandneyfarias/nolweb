package br.edu.cesmac.si.nolweb.repository;

import br.edu.cesmac.si.nolweb.domain.Noticia;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class NoticiaRepositoryJPA {

    @Inject
    private EntityManager manager;

    public NoticiaRepositoryJPA() {
    }

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
/*        manager.getTransaction().begin();
        noticia.setJornalistas(new ArrayList<>());
        noticia = manager.merge(noticia);

        manager.remove(noticia);
        manager.getTransaction().commit();*/

        noticia = manager.merge(noticia);
        manager.getTransaction().begin();
        manager.remove(noticia);
        manager.getTransaction().commit();
    }

    public Noticia findById(Long idNoticia) {
        String consulta = "select n from Noticia n join n.jornalistas join n.editoria where n.idNoticia = :idNoticia";
        TypedQuery<Noticia> query = manager.createQuery(consulta, Noticia.class);
        query.setParameter("idNoticia", idNoticia);
        Noticia resultado = null;
        try {
            resultado = query.getSingleResult();
        } catch (NoResultException e) {
            // no result found
        }
        return resultado;
    }

}
