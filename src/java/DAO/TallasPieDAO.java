package DAO;

import Tablas.Tallaspie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TallasPieDAO {

    private EntityManagerFactory emf;

    public TallasPieDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public List<Tallaspie> obtenerTodasLasTallasPie() {
        List<Tallaspie> listaDeTallasPie = new ArrayList<>();
        EntityManager entityManager = emf.createEntityManager();
        try {
            String jpql = "SELECT t FROM Tallaspie t";
            TypedQuery<Tallaspie> query = entityManager.createQuery(jpql, Tallaspie.class);
            listaDeTallasPie = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return listaDeTallasPie;
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
