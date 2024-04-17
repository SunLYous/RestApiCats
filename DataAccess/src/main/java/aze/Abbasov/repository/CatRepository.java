/*
package aze.Abbasov.Repository;

import aze.Abbasov.Abstractions.ICatRepository;
import aze.Abbasov.Models.Cat;
import aze.Abbasov.Models.CatColor;
import aze.Abbasov.Models.CatFriends;
import aze.Abbasov.Models.CatFriendsId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CatRepository {
    private final EntityManagerFactory factory;

    public CatRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Cat getCat(Long catId) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();

            Cat cat = em.find(Cat.class, catId);
            if (cat != null) {
                cat.setFriends(getFriend(catId));
            }
            em.getTransaction().commit();

            return cat;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Long addCat(String name, LocalDate birthDate, String breed, CatColor color, Long ownerId) {
        EntityManager em = factory.createEntityManager();
        var cat = new Cat(name, birthDate, breed, color, ownerId, new ArrayList<>());
        try {
            em.getTransaction().begin();
            em.persist(cat);
            em.getTransaction().commit();
            return cat.getId();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Long> getFriend(Long catId) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Long> query = em.createQuery(
                    "SELECT cf.id.friendCatId" +
                            " FROM CatFriends cf" +
                            " WHERE cf.id.catId = :catId", Long.class);
            query.setParameter("catId", catId);
            return query.getResultList();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void addCatFriend(Long catId, Long friendCatId) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();

            var catFriend = new CatFriends();
            var catFriendId = new CatFriendsId();
            catFriendId.setCatId(catId);
            catFriendId.setFriendCatId(friendCatId);
            catFriend.setId(catFriendId);

            em.persist(catFriend);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Long> getCatsByOwner(Long ownerId) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            var query = em.createQuery(
                    "SELECT c FROM Cat c WHERE c.owner = :ownerId",
                    Long.class
            );
            em.getTransaction().commit();
            return query.getResultList();
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
