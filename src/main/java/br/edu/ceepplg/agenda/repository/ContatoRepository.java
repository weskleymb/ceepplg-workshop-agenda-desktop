package br.edu.ceepplg.agenda.repository;

import br.edu.ceepplg.agenda.model.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ContatoRepository implements GenericRepository<Contato, Integer> {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
    private EntityManager manager = factory.createEntityManager();

    @Override
    public Contato salvar(Contato repository) {
        Contato c = buscarPorId(repository.getId());
        manager.getTransaction().begin();
        if (c == null) {
            manager.persist(repository);
            manager.getTransaction().commit();
            return repository;
        } else {
            c.setNome(repository.getNome());
            c.setFone(repository.getFone());
            manager.merge(c);
            manager.getTransaction().commit();
            return c;
        }
    }

    @Override
    public void deletar(Integer id) {
        Contato contato = buscarPorId(id);
        if (contato != null) {
//            contatos.remove(contato);
        }
    }

    @Override
    public List<Contato> buscarTodos() {
        String sql = "SELECT c FROM Contato c";
        return manager.createQuery(sql, Contato.class).getResultList();
    }

    @Override
    public Contato buscarPorId(Integer id) {
        return manager.find(Contato.class, id);
    }

}
