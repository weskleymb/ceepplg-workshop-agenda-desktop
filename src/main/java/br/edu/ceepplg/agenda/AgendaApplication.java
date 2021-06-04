package br.edu.ceepplg.agenda;

import br.edu.ceepplg.agenda.model.Contato;
import br.edu.ceepplg.agenda.repository.ContatoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AgendaApplication {

    public static void main(String[] args) {

        ContatoRepository repository = new ContatoRepository();

        System.out.println(repository.buscarTodos());

    }

}
