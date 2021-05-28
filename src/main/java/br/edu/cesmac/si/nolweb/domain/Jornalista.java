package br.edu.cesmac.si.nolweb.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Jornalista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jornalista")
    private Long idJornalista;

    @NotEmpty(message = "Obrigatório informar o nome!")
    private String nome;

    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotEmpty(message = "Obrigatório informar a biografia!")
    private String biografia;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "jornalista_noticia",
            joinColumns = @JoinColumn(name = "id_jornalista"),
            inverseJoinColumns = @JoinColumn(name = "id_noticia"))
    private List<Noticia> noticias;

    public Long getIdJornalista() {
        return idJornalista;
    }

    public void setIdJornalista(Long idJornalista) {
        this.idJornalista = idJornalista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
