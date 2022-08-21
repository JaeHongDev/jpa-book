import domain.Member;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String [] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            teamSave(em);
            queryLogicJoin(em);
            updateRelation(em);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    public static void teamSave(EntityManager em){

        Team team1 = new Team("team1","팀1");
        em.persist(team1);

        Member member1=  new Member("member1", "회원");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member("member2","회원");
        member2.setTeam(team1);
        em.persist(member2);

        Member member = em.find(Member.class , "member1");
        Team team = member.getTeam();
        System.out.println(team.toString());
    }

    private static void queryLogicJoin(EntityManager em){
        String jpql = "select m from Member m join m.team t where t.name=:teamName";

        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName","팀1")
                .getResultList();
        for (Member member : resultList){
            System.out.println("[query] member.username=" + member.getUsername());
        }
    }

    private static void updateRelation(EntityManager em){
        Team team = new Team("team2" , "팀2");
        em.persist(team);

        Member member = em.find(Member.class,"member1");
        member.setTeam(team);
    }

    private static void deleteRelation(EntityManager em){
        Member member1 = em.find(Member.class,"member1");
        member1.setTeam(null);
    }
    private void testSaveNonOwner(EntityManager em){
        Member member1 = new Member("member1","회원1");
        em.persist(member1);

        Member member2 = new Member("member2","회원2");
        em.persist(member2);

        Team team1 = new Team("team1", "팀2");

        team1.getMembers().add(member1);
        team1.getMembers().add(member2);
        em.persist(team1);
    }
}
