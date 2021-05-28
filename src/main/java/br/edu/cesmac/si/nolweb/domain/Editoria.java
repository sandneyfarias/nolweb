package br.edu.cesmac.si.nolweb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Editoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editoria")
	private Long idEditoria;

	@NotEmpty(message = "Obrigatório informar o nome da Editoria!")
	private String nome;

	@OneToMany(mappedBy = "editoria")
	List<Noticia> noticias;

	public Long getIdEditoria() {
		return idEditoria;
	}

	public void setIdEditoria(Long idEditoria) {
		this.idEditoria = idEditoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
