package DAO;

import Tablas.Catalogos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CatalogosDAO {
    private EntityManagerFactory emf;

    public CatalogosDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    // Método para obtener todos los catálogos
    public List<Catalogos> obtenerTodos() {
    EntityManager entityManager = emf.createEntityManager();
    try {
        entityManager.getTransaction().begin();
        List<Catalogos> catalogos = entityManager.createQuery("SELECT c FROM Catalogos c", Catalogos.class).getResultList();
        entityManager.getTransaction().commit();
        return catalogos;
    } catch (Exception e) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        e.printStackTrace();
        return null;
    } finally {
        entityManager.close();
    }
}
}
