package DAO;

import Tablas.ArticuloTalla;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArticuloTallaDAO {

    private EntityManagerFactory emf;

    public ArticuloTallaDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public boolean insertarArticuloTalla(ArticuloTalla articuloTalla) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(articuloTalla);
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

    public ArticuloTalla findByArticuloAndTalla(Integer idArticulo, Integer idTalla) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT at FROM ArticuloTalla at WHERE at.idArticulo.id = :idArticulo AND at.idTalla.id = :idTalla", ArticuloTalla.class)
                    .setParameter("idArticulo", idArticulo)
                    .setParameter("idTalla", idTalla)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public boolean actualizarArticuloTalla(Integer idArticulo, Integer idTalla) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ArticuloTalla articuloTalla = em.createQuery("SELECT at FROM ArticuloTalla at WHERE at.idArticulo.id = :idArticulo AND at.idTalla.id = :idTalla", ArticuloTalla.class)
                    .setParameter("idArticulo", idArticulo)
                    .setParameter("idTalla", idTalla)
                    .getSingleResult();

            // Actualizar la cantidad disponible
            int nuevaCantidad = articuloTalla.getCantidadDisponible() - 1;
            System.out.println(nuevaCantidad);
            if (nuevaCantidad < 0) {
                throw new IllegalStateException("La cantidad disponible no puede ser negativa");
            }
            articuloTalla.setCantidadDisponible(nuevaCantidad);

            em.merge(articuloTalla);
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

    public int obtenerCantidadDisponiblePorTalla(Integer idArticulo, Integer idTalla) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT at.cantidadDisponible FROM ArticuloTalla at WHERE at.idArticulo.id = :idArticulo AND at.idTalla.id = :idTalla", Integer.class)
                    .setParameter("idArticulo", idArticulo)
                    .setParameter("idTalla", idTalla)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0; 
        } finally {
            em.close();
        }
    }

}
