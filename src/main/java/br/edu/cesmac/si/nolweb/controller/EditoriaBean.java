package br.edu.cesmac.si.nolweb.controller;

import br.edu.cesmac.si.nolweb.domain.Editoria;
import br.edu.cesmac.si.nolweb.service.EditoriaService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class EditoriaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Editoria editoria;
    private List<Editoria> editorias;

    private boolean operacaoConsultar;
    private boolean operacaoCadastrar;
    private boolean operacaoAlterar;

    @Inject
    private EditoriaService editoriaService;

    public EditoriaBean() {
        this.editoria = new Editoria();
        editorias = new ArrayList<>();

        inicializarOperacoes();
        operacaoConsultar = true;
    }

    public List<Editoria> getEditorias() {
        if (this.editorias == null || this.editorias.size() == 0) {
            this.editorias = this.editoriaService.listarTodos();
        }
        return this.editorias;
    }

    public String salvar() {
        this.editoriaService.salvar(editoria);
        return "consultar?faces-redirect=true";
    }

    public Editoria getEditoria() {
        return editoria;
    }

    public void setEditoria(Editoria editoria) {
        this.editoria = editoria;
    }

    public void setEditorias(List<Editoria> editorias) {
        this.editorias = editorias;
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

    public void preAlterar(Editoria editoria) {
        this.editoria = editoria;
        inicializarOperacoes();
        this.operacaoAlterar = true;
    }

    public void preCadastrar() {
        this.editoria = new Editoria();
        inicializarOperacoes();
        this.operacaoCadastrar = true;
    }

    public void remover(Editoria editoria) {
        this.editoriaService.remover(editoria);
        this.editorias = this.editoriaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void alterar() {
        this.editoriaService.salvar(this.editoria);
        this.limparEntidade();
        inicializarOperacoes();
        this.editorias = this.editoriaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void cadastrar() {
        this.editoriaService.salvar(this.editoria);
        this.limparEntidade();
        inicializarOperacoes();
        this.editorias = this.editoriaService.listarTodos();
        this.operacaoConsultar = true;
    }

    public void limparEntidade() {
        this.editoria = new Editoria();
    }

}

