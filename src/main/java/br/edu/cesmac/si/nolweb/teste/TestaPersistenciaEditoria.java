package br.edu.cesmac.si.nolweb.teste;

import br.edu.cesmac.si.nolweb.domain.Editoria;
import br.edu.cesmac.si.nolweb.repository.EditoriaRepositoryJPA;

public class TestaPersistenciaEditoria {

    public static void main(String[] args) {
        Editoria editoria = new Editoria();
        EditoriaRepositoryJPA editoriaJpa = new EditoriaRepositoryJPA();

        editoria.setNome("Ora ora");

        editoriaJpa.salvar(editoria);
    }

}
