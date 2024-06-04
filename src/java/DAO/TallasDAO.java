package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Tablas.Tallas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TallasDAO {

    private EntityManagerFactory emf;

    public TallasDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public List<Tallas> obtenerTodasLasTallas() {
        List<Tallas> listaDeTallas = new ArrayList<>();
        EntityManager entityManager = emf.createEntityManager();
        try {
            String jpql = "SELECT t FROM Tallas t";
            TypedQuery<Tallas> query = entityManager.createQuery(jpql, Tallas.class);
            listaDeTallas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return listaDeTallas;
    }
    
    public List<String> obtenerTallasPorId(int idArticulo) throws SQLException {
        List<String> tallas = new ArrayList<>();

        EntityManager entityManager = emf.createEntityManager();
        try {
            String jpql = "SELECT t.talla FROM Tallas t WHERE t.articulo.id = :idArticulo";
            TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
            query.setParameter("idArticulo", idArticulo);
            tallas = query.getResultList();
        } finally {
            entityManager.close();
        }

        return tallas;
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
