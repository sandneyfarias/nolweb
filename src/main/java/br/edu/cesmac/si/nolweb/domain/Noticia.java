package br.edu.cesmac.si.nolweb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private Long idNoticia;

    @NotEmpty(message = "Obrigatório informar o título!")
    private String titulo;

    @NotNull(message = "Obrigatório informar o jornalista!")
    @ManyToMany(mappedBy = "noticias", cascade = CascadeType.ALL)
    private List<Jornalista> jornalistas;

    @NotNull(message = "Obrigatório informar a editoria!")
    @ManyToOne(cascade = CascadeType.ALL)
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
}
