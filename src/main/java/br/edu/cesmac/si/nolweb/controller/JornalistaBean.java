package br.edu.cesmac.si.nolweb.controller;

import br.edu.cesmac.si.nolweb.domain.Jornalista;
import br.edu.cesmac.si.nolweb.service.JornalistaService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class JornalistaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Jornalista jornalista;
    private List<Jornalista> jornalistas;

    private boolean operacaoConsultar;
    private boolean operacaoCadastrar;
    private boolean operacaoAlterar;

    @Inject
    private JornalistaService jornalistaService;

    public JornalistaBean() {
        this.jornalista = new Jornalista();
        jornalistas = new ArrayList<>();

        inicializarOperacoes();
        operacaoConsultar = true;
    }

    public List<Jornalista> getJornalistas() {
        if (this.jornalistas == null || this.jornalistas.size() == 0) {
            this.jornalistas = this.jornalistaService.listarTodos();
        }
        return this.jornalistas;
    }

    public String salvar() {
        this.jornalistaService.salvar(jornalista);
        return "consultar?faces-redirect=true";
    }

    public Jornalista getJornalista() {
        return jornalista;
    }

    public void setJornalista(Jornalista jornalista) {
        this.jornalista = jornalista;
    }

    public void setJornalistas(List<Jornalista> jornalistas) {
        this.jornalistas = jornalistas;
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
     * */

    private void inicializarOperacoes() {
        this.operacaoConsultar = false;
        this.operacaoCadastrar = false;
        this.operacaoAlterar = false;
    }

    public void preAlterar(Jornalista jornalista) {
        this.jornalista = jornalista;
        inicializarOperacoes();
        this.operacaoAlterar = true;
    }

    public void preCadastrar() {
        this.jornalista = new Jornalista();
        inicializarOperacoes();
        this.operacaoCadastrar = true;
    }

    public void remover(Jornalista jornalista) {
        this.jornalistaService.remover(jornalista);
        this.jornalistas = this.jornalistaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void alterar() {
        this.jornalistaService.salvar(this.jornalista);
        this.limparEntidade();
        inicializarOperacoes();
        this.jornalistas = this.jornalistaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void cadastrar() {
        this.jornalistaService.salvar(this.jornalista);
        this.limparEntidade();
        inicializarOperacoes();
        this.jornalistas = this.jornalistaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void limparEntidade() {
        this.jornalista = new Jornalista();
    }

}
