package br.edu.ceepplg.agenda.repository;

import br.edu.ceepplg.agenda.model.Contato;

import java.util.List;

public interface GenericRepository<T, PK> {

    T salvar(T repository);

    void deletar(PK id);

    List<T> buscarTodos();

    Contato buscarPorId(PK id);

}
