package DAO;

import Tablas.ArticuloTallapie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArticuloTallapieDAO {

    private EntityManagerFactory emf;

    public ArticuloTallapieDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public boolean insertarArticuloTallapie(ArticuloTallapie articuloTallapie) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(articuloTallapie);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public ArticuloTallapie findByArticuloAndTalla(Integer idArticulo, Integer idTalla) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT atp FROM ArticuloTallapie atp WHERE atp.idArticulo.id = :idArticulo AND atp.idtallaPie.id = :idTalla", ArticuloTallapie.class)
                    .setParameter("idArticulo", idArticulo)
                    .setParameter("idTalla", idTalla)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public boolean actualizarArticuloTallaPie(Integer idArticulo, Integer idTalla) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ArticuloTallapie articuloTallapie = em.createQuery("SELECT at FROM ArticuloTalla at WHERE at.idArticulo.id = :idArticulo AND at.idTalla.id = :idTalla", ArticuloTallapie.class)
                    .setParameter("idArticulo", idArticulo)
                    .setParameter("idTalla", idTalla)
                    .getSingleResult();

            // Actualizar la cantidad disponible
            int nuevaCantidad = articuloTallapie.getCantidadDisponible() - 1;
            System.out.println(nuevaCantidad);
            if (nuevaCantidad < 0) {
                throw new IllegalStateException("La cantidad disponible no puede ser negativa");
            }
            articuloTallapie.setCantidadDisponible(nuevaCantidad);

            em.merge(articuloTallapie);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
