import domain.Child;
import domain.Member;
import domain.Parent;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String [] args){
        var emf = Persistence.createEntityManagerFactory("jpabook");
        var em = emf.createEntityManager();
        var tx = em.getTransaction();

        try{
           tx.begin();
           logic(em);
           tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }

    private static void logic(EntityManager em) {

    }
    private void printUserAndTeam(EntityManager em, String memberId){
        Member member = em.find(Member.class,memberId);
        Team team = member.getTeam();
        System.out.println("회원이름:"+ member.getUsername());
        System.out.println("소속팀:"+ team.getName());
    }
    private static void printUser(EntityManager em, String memberId){
        Member member =em.find(Member.class,memberId);
        System.out.println("회원이름:"+ member.getUsername());
    }
    private static void proxyPrintUserAndTeam(EntityManager em, String memberId){
        var member = em.getReference(Member.class,"member1");
    }

    private static void saveNoCascade(EntityManager em){

        Parent parent = new Parent();
        em.persist(parent);

        Child child1 = new Child();
        child1.setParent(parent);


    }
}
