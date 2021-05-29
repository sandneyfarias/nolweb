package br.edu.cesmac.si.nolweb.controller;

import br.edu.cesmac.si.nolweb.domain.Noticia;
import br.edu.cesmac.si.nolweb.service.NoticiaService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class NoticiaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Noticia noticia;
    private List<Noticia> noticias;

    private boolean operacaoConsultar;
    private boolean operacaoCadastrar;
    private boolean operacaoAlterar;

    @Inject
    private NoticiaService noticiaService;

    public NoticiaBean() {
        this.noticia = new Noticia();
        noticias = new ArrayList<>();

        inicializarOperacoes();
        operacaoConsultar = true;
    }

    public List<Noticia> getNoticias() {
        if (this.noticias == null || this.noticias.size() == 0) {
            this.noticias = this.noticiaService.listarTodos();
        }
        return this.noticias;
    }

    public String salvar() {
        this.noticiaService.salvar(noticia);
        return "consultar?faces-redirect=true";
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public boolean isOperacaoConsultar() {
        return operacaoConsultar;
    }

    public void setOperacaoConsultar(boolean operacaoConsultar) {
        inicializarOperacoes();
        this.operacaoConsultar = operacaoConsultar;
    }

    public boolean isOperacaoCadastrar() {
        return operacaoCadastrar;
    }

    public void setOperacaoCadastrar(boolean operacaoCadastrar) {
        inicializarOperacoes();
        this.operacaoCadastrar = operacaoCadastrar;
    }

    public boolean isOperacaoAlterar() {
        return operacaoAlterar;
    }

    public void setOperacaoAlterar(boolean operacaoAlterar) {
        inicializarOperacoes();
        this.operacaoAlterar = operacaoAlterar;
    }

    /**
     * Demais métodos
     */
    private void inicializarOperacoes() {
        this.operacaoConsultar = false;
        this.operacaoCadastrar = false;
        this.operacaoAlterar = false;
    }

    public void preAlterar(Noticia noticia) {
        this.noticia = noticia;
        inicializarOperacoes();
        this.operacaoAlterar = true;
    }

    public void preCadastrar() {
        this.noticia = new Noticia();
        inicializarOperacoes();
        this.operacaoCadastrar = true;
    }

    public void remover(Noticia noticia) {
        this.noticiaService.remover(noticia);
        this.noticias = this.noticiaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void alterar() {
        this.noticiaService.salvar(this.noticia);
        this.limparEntidade();
        inicializarOperacoes();
        this.noticias = this.noticiaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void cadastrar() {
        this.noticiaService.salvar(this.noticia);
        this.limparEntidade();
        inicializarOperacoes();
        this.noticias = this.noticiaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void limparEntidade() {
        this.noticia = new Noticia();
    }

}
