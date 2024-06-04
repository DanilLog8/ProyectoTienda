package DAO;

import Tablas.Usuarios;
import java.math.BigDecimal;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class UsuarioDAO {

    private EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    public boolean registrarUsuario(String usuario, String correo, String contrasena, String telefono, String direccion, String tipoUsuario, Date fechaNacimiento) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Usuarios user = new Usuarios();
            user.setNombre(usuario);
            user.setEmail(correo);
            user.setContrasena(contrasena);
            user.setTelefono(telefono);
            user.setDireccion(direccion);
            user.setTipoUsuario(tipoUsuario);
            user.setFechaNacimiento(fechaNacimiento);

            entityManager.persist(user);

            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException pe) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            pe.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public boolean usuarioExiste(String usuario) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT COUNT(u) FROM Usuarios u WHERE u.nombre = :nombre");
            query.setParameter("nombre", usuario);
            Long count = (Long) query.getSingleResult();
            return count > 0;
        } catch (NoResultException nre) {
            return false;
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public boolean verificarUsuario(String usuario, String contrasena) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT COUNT(u) FROM Usuarios u WHERE u.nombre = :nombre AND u.contrasena = :contrasena");
            query.setParameter("nombre", usuario);
            query.setParameter("contrasena", contrasena);
            Long count = (Long) query.getSingleResult();
            return count > 0;
        } catch (NoResultException nre) {
            return false;
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public Usuarios obtenerUsuario(String nombreUsuario) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Usuarios> query = em.createQuery("SELECT u FROM Usuarios u WHERE u.nombre = :nombreUsuario", Usuarios.class);
            query.setParameter("nombreUsuario", nombreUsuario);
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void actualizarDatosUsuario(Usuarios usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (PersistenceException pe) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            pe.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public List<Usuarios> obtenerUsuarios() {
        EntityManager entityManager = emf.createEntityManager();
        List<Usuarios> usuarios = null;
        try {
            String jpql = "SELECT u FROM Usuarios u WHERE u.tipoUsuario = 'usuario'";
            TypedQuery<Usuarios> query = entityManager.createQuery(jpql, Usuarios.class);
            usuarios = query.getResultList();
        } finally {
            entityManager.close();
        }
        return usuarios;
    }

    public void eliminarUsuario(int usuarioId) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Usuarios usuario = entityManager.find(Usuarios.class, usuarioId);
            if (usuario != null) {
                entityManager.remove(usuario);
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Usuarios obtenerUsuarioPorId(int usuarioId) {
        EntityManager entityManager = emf.createEntityManager();
        Usuarios usuario = null;
        try {
            usuario = entityManager.find(Usuarios.class, usuarioId);
        } finally {
            entityManager.close();
        }
        return usuario;
    }

    public BigDecimal obtenerSaldoHucha(String nombreUsuario) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<BigDecimal> query = em.createQuery(
                    "SELECT u.hucha FROM Usuarios u WHERE u.nombre = :nombreUsuario", BigDecimal.class);
            query.setParameter("nombreUsuario", nombreUsuario);
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return BigDecimal.ZERO;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void actualizarSaldoHucha(String nombreUsuario, BigDecimal nuevoSaldo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Usuarios> query = em.createQuery("SELECT u FROM Usuarios u WHERE u.nombre = :nombreUsuario", Usuarios.class);
            query.setParameter("nombreUsuario", nombreUsuario);
            Usuarios usuario = query.getSingleResult();
            if (usuario != null) {
                usuario.setHucha(nuevoSaldo);
                em.merge(usuario);
                em.getTransaction().commit();
            }
        } catch (PersistenceException pe) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            pe.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

}
