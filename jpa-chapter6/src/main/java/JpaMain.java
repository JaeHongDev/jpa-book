import domain.Member;
import domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            save(em);
            find(em);
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
        }finally {
            em.close();
        }
    }

    private static void save(EntityManager em) {
        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA);
        em.persist(member1);
    }
    public static void find(EntityManager em){
        Member member = em.find(Member.class,"member1");
        List<Product> products = member.getProducts();
        for(Product product : products){
            System.out.println("product.name= "+ product.getName());
        }
    }
}
