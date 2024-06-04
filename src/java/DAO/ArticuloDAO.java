package DAO;

import Tablas.Articulos;
import Tablas.Tallas;
import Tablas.Tallaspie;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ArticuloDAO {

    private final EntityManagerFactory emf;

    public ArticuloDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    public boolean insertarArticulo(Articulos articulo) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(articulo);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Articulos> obtenerTodosLosArticulos() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            TypedQuery<Articulos> query = entityManager.createQuery("SELECT a FROM Articulos a", Articulos.class);
            return query.getResultList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Articulos> obtenerArticulosPorCategoria(String categoria) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            TypedQuery<Articulos> query = entityManager.createQuery("SELECT a FROM Articulos a WHERE a.nombreCatalogo = :categoria", Articulos.class);
            query.setParameter("categoria", categoria);
            return query.getResultList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public Articulos obtenerArticuloPorID(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.find(Articulos.class, id);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<String> obtenerTallasDisponiblesPorID(int idProducto) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            List<String> tallasDisponibles = new ArrayList<>();

            TypedQuery<Tallas> queryTalla = entityManager.createQuery(
                    "SELECT at.idTalla FROM ArticuloTalla at WHERE at.idArticulo.id = :idProducto", Tallas.class);
            queryTalla.setParameter("idProducto", idProducto);
            List<Tallas> tallas = queryTalla.getResultList();
            for (Tallas talla : tallas) {
                tallasDisponibles.add(talla.getNombre());
            }

            TypedQuery<Tallaspie> queryTallaPie = entityManager.createQuery(
                    "SELECT atp.idtallaPie FROM ArticuloTallapie atp WHERE atp.idArticulo.id = :idProducto", Tallaspie.class);
            queryTallaPie.setParameter("idProducto", idProducto);
            List<Tallaspie> tallasPie = queryTallaPie.getResultList();
            for (Tallaspie tallaPie : tallasPie) {
                tallasDisponibles.add(String.valueOf(tallaPie.getTalla()));
            }

            return tallasDisponibles;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void ComprarArticulo(Articulos articulo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Obtener el artículo por su ID
            Articulos articuloActualizado = em.find(Articulos.class, articulo.getId());

            if (articuloActualizado == null) {
                throw new IllegalArgumentException("El artículo no existe en la base de datos");
            }

            // Restar 1 a la cantidad disponible
            int nuevaCantidad = articuloActualizado.getCantidadDisponible() - 1;
            if (nuevaCantidad < 0) {
                throw new IllegalStateException("La cantidad disponible no puede ser negativa");
            }

            articuloActualizado.setCantidadDisponible(nuevaCantidad);

            // Actualizar el artículo en la base de datos
            em.merge(articuloActualizado);

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

    public List<Integer> obtenerCantidadesDisponiblesPorID(int idProducto) {
        EntityManager em = emf.createEntityManager();
        List<Integer> cantidadesDisponibles = new ArrayList<>();
        try {
            // Consulta para obtener las cantidades disponibles de ArticuloTalla
            Query queryTalla = em.createQuery("SELECT at.cantidadDisponible FROM ArticuloTalla at WHERE at.idArticulo.id = :idProducto");
            queryTalla.setParameter("idProducto", idProducto);
            List<Integer> cantidadesTalla = queryTalla.getResultList();

            // Consulta para obtener las cantidades disponibles de ArticuloTallaPie
            Query queryTallaPie = em.createQuery("SELECT atp.cantidadDisponible FROM ArticuloTallapie atp WHERE atp.idArticulo.id = :idProducto");
            queryTallaPie.setParameter("idProducto", idProducto);
            List<Integer> cantidadesTallaPie = queryTallaPie.getResultList();

            // Unimos las listas de cantidades
            cantidadesDisponibles.addAll(cantidadesTalla);
            cantidadesDisponibles.addAll(cantidadesTallaPie);

            return cantidadesDisponibles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public BigDecimal obtenerPrecioArticulo(int idArticulo) {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            // Obtener el artículo por su ID
            Articulos articulo = entityManager.find(Articulos.class, idArticulo);
            if (articulo == null) {
                throw new IllegalArgumentException("El artículo con el ID " + idArticulo + " no existe.");
            }
            BigDecimal precio = articulo.getPrecio();
            entityManager.getTransaction().commit();
            return precio;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
