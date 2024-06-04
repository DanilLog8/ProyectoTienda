package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Tablas.Tarjetas;
import java.math.BigDecimal;
import javax.persistence.TypedQuery;

public class TarjetasDAO {

    private EntityManagerFactory emf;

    public TarjetasDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public boolean validarTarjeta(String numeroTarjeta, String cvc) {
        EntityManager em = emf.createEntityManager();
        try {
            Tarjetas tarjeta = em.createQuery("SELECT t FROM Tarjetas t WHERE t.numeroDeTarjeta = :numeroTarjeta AND t.cvc = :cvc", Tarjetas.class)
                    .setParameter("numeroTarjeta", numeroTarjeta)
                    .setParameter("cvc", cvc)
                    .getSingleResult();
            return tarjeta != null;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    public boolean descontarDinero(String numeroTarjeta, BigDecimal cantidad) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Tarjetas tarjeta = em.createQuery("SELECT t FROM Tarjetas t WHERE t.numeroDeTarjeta = :numeroTarjeta", Tarjetas.class)
                    .setParameter("numeroTarjeta", numeroTarjeta)
                    .getSingleResult();
            BigDecimal nuevoSaldo = tarjeta.getDinero().subtract(cantidad);
            tarjeta.setDinero(nuevoSaldo);
            em.merge(tarjeta);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public BigDecimal obtenerSaldoTarjeta(String numeroTarjeta) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            TypedQuery<BigDecimal> query = entityManager.createQuery(
                    "SELECT t.dinero FROM Tarjetas t WHERE t.numeroDeTarjeta = :numeroTarjeta", BigDecimal.class);
            query.setParameter("numeroTarjeta", numeroTarjeta);
            return query.getSingleResult();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
