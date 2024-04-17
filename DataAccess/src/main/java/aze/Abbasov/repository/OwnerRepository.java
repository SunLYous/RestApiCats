/*
package aze.Abbasov.Repository;

import aze.Abbasov.Abstractions.IOwnerRepository;
import aze.Abbasov.Models.Owner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class OwnerRepository implements IOwnerRepository {
    private final EntityManagerFactory factory;
    @Autowired
    public OwnerRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Owner getOwner(Long id) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            var owner = em.find(Owner.class, id);
            em.getTransaction().commit();
            return owner;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Long addOwner(String name, LocalDate birthDate) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            var owner = new Owner();
            owner.setName(name);
            owner.setBirthDate(birthDate);
            em.persist(owner);
            em.getTransaction().commit();
            return owner.getId();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
*/
