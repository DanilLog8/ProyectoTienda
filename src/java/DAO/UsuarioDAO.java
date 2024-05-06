package DAO;

import Tablas.Usuarios;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UsuarioDAO {

    private EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("tiendaOnline");
    }

    public boolean registrarUsuario(String usuario, String correo, String contrasena, String telefono, String direccion, String tipoUsuario) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Usuarios user = new Usuarios();
            user.setNombre(usuario);
            user.setEmail(correo);
            user.setContrasena(contrasena);
            user.setTelefono(telefono);
            user.setDireccion(direccion);
            user.setTipoUsuario(tipoUsuario); // Establecer el tipo de usuario

            entityManager.persist(user);

            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
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
        } catch (Exception ex) {
            ex.printStackTrace();
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
        } catch (Exception ex) {
            ex.printStackTrace();
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
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
}

    public boolean actualizarDatosUsuario(String usuario, String correo, String telefono, String direccion) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Usuarios user = entityManager.find(Usuarios.class, usuario);
            if (user != null) {
                user.setEmail(correo);
                user.setTelefono(telefono);
                user.setDireccion(direccion);
                entityManager.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }
}
