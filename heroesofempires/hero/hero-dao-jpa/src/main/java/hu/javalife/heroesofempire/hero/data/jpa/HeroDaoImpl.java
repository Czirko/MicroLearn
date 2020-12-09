package hu.javalife.heroesofempire.hero.data.jpa;

import hu.javalife.heroesofempires.hero.datamodel.HeroDao;
import hu.javalife.heroesofempires.hero.datamodel.HeroDataModel;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;

@RequestScoped
public class HeroDaoImpl implements HeroDao {

    private EntityManager em = Persistence
            .createEntityManagerFactory("HeroPU")
            .createEntityManager();


    public List<HeroDataModel> getAllHero() {
        return em.createQuery("SELECT h FROM HeroDataModel h").getResultList();
    }

    public HeroDataModel getById(long id) {

        return em.find(HeroDataModel.class,id);
    }

    public boolean isAviable(String name) {
        return false;
    }

    public HeroDataModel getByName(String name) {
        return null;
    }

    public HeroDataModel modify(long id, HeroDataModel h) {
        return null;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(getById(id));
        em.getTransaction().commit();
    }

    public HeroDataModel add(HeroDataModel h) {
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();
        return h;
    }

    public long getItemCount() {
        return 0;
    }
}
