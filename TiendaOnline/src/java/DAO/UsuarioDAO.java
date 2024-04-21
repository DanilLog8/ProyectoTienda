package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UsuarioDAO {

    private EntityManager entityManager;

    public UsuarioDAO() {
        entityManager = Persistence.createEntityManagerFactory("ProyectoTienda").createEntityManager();
    }

    public boolean registrarUsuario(Usuarios usuario) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(usuario);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }
}
