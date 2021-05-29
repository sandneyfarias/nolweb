package br.edu.cesmac.si.nolweb.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private Long idNoticia;

    //@NotEmpty(message = "Obrigatório informar o título!")
    private String titulo;

    //@NotNull(message = "Obrigatório informar o jornalista!")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "jornalista_noticia",
            joinColumns = @JoinColumn(name = "id_noticia"),
            inverseJoinColumns = @JoinColumn(name = "id_jornalista"))
    private List<Jornalista> jornalistas;

    //@NotNull(message = "Obrigatório informar a editoria!")
    @ManyToOne
    private Editoria editoria;

    public Long getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Jornalista> getJornalistas() {
        return jornalistas;
    }

    public void setJornalistas(List<Jornalista> jornalistas) {
        this.jornalistas = jornalistas;
    }

    public Editoria getEditoria() {
        return editoria;
    }

    public void setEditoria(Editoria editoria) {
        this.editoria = editoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noticia noticia = (Noticia) o;
        return Objects.equals(titulo, noticia.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
