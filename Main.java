import jakarta.persistence.EntityManager;
import model.*;
import util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        ProdutoFisico pf = new ProdutoFisico("Livro", 50.0, "Livro de Java", 1.2, 3);
        ProdutoDigital pd = new ProdutoDigital("E-book", 20.0, "E-book de Java", "http://download.com/ebook");

        Categoria cat1 = new Categoria("Tecnologia");

        // Persistindo
        em.getTransaction().begin();
        em.persist(cat1);
        em.persist(pf);
        em.persist(pd);
        em.getTransaction().commit();

        em.close();
    }
}
