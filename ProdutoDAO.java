package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Produto;
import util.JPAUtil;

import java.util.List;

public class ProdutoDAO {

    // Salvar ou atualizar produto
    public void salvar(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            if (produto.getId() == null) {
                em.persist(produto); // novo produto
            } else {
                em.merge(produto);   // atualiza se já existir
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Buscar por ID
    public Produto buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    // Listar todos
    public List<Produto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Remover por ID
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                em.getTransaction().begin();
                em.remove(produto);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }
}
