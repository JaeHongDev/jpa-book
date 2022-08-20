import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin(); // 트랜잭션 - 시작
            logic(em); // 비즈니스 로직 실행
            tx.commit(); // 트랜잭션 - 커밋
        } catch (Exception e) {
            tx.rollback(); // 트랜잭션 - 롤백
        } finally {
            em.close(); // 엔티티 매니저 종료
        }
        emf.close(); // 앤티티 매니저 팩토리 종료
    }
    public static void logic(EntityManager em){

        String id = "id2";
        var member = Member.builder()
                .id("id2")
                .age(12)
                .username("username").build();
        em.persist(member);

        member.setAge(20);

        var findMember = em.find(Member.class ,id);
        System.out.println(findMember.toString());


        em.remove(member);
    }
}
