import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();

        var tx = em.getTransaction();
        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static void logic(EntityManager em) {
        var findMember1= em.find(Member.class,"id5");
        var findMember2 = em.find(Member.class,"id5");

        System.out.println(findMember1 == findMember2);

        var findMember3 = em.find(Member.class,"id5");
        em.flush();
        var findMember4 = em.find(Member.class,"id5");

        findMember4.setName("member6");
        var          query   = em.createQuery("select m from Member m",Member.class);
        List<Member> members = query.getResultList();
    }
}
