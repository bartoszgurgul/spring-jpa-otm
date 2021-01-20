package pl.javastart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.javastart.model.Client;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDao {

    private EntityManager entityManager;

    @Autowired
    public ClientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //CRUD
    public void create(Client client){
        client.getOrders().forEach(order -> entityManager.persist(order));
        entityManager.persist(client);
    }

    public Client read(Long id){
        return entityManager.find(Client.class, id);
    }
}
