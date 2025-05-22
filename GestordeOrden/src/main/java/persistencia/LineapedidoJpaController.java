/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.mycompany.gestordeorden.exceptions.NonexistentEntityException;
import com.mycompany.gestordeorden.logica.LineaPedido;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USUARIO
 */
public class LineapedidoJpaController implements Serializable {

    public LineapedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
        public LineapedidoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_gestororden_jar_1.0-SNAPSHOTPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LineaPedido lineapedido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lineapedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LineaPedido lineapedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lineapedido = em.merge(lineapedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = lineapedido.getIdentificador();
                if (findLineapedido(id) == null) {
                    throw new NonexistentEntityException("The lineapedido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LineaPedido lineapedido;
            try {
                lineapedido = em.getReference(LineaPedido.class, id);
                lineapedido.getIdentificador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lineapedido with id " + id + " no longer exists.", enfe);
            }
            em.remove(lineapedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LineaPedido> findLineapedidoEntities() {
        return findLineapedidoEntities(true, -1, -1);
    }

    public List<LineaPedido> findLineapedidoEntities(int maxResults, int firstResult) {
        return findLineapedidoEntities(false, maxResults, firstResult);
    }

    private List<LineaPedido> findLineapedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LineaPedido.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public LineaPedido findLineapedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LineaPedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getLineapedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LineaPedido> rt = cq.from(LineaPedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
