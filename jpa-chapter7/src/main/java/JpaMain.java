import domain.EmbeddedParentId;
import domain.Parent;
import domain.ParentId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        entityTransaction.begin();
        Parent parent = new Parent();
        parent.setId1("myId1");
        parent.setId2("myId2");
        parent.setName("parentName");
        em.persist(parent);

        ParentId parentId = new ParentId("myId1","myId2");
        Parent findParent = em.find(Parent.class,parentId);

        System.out.println(findParent);


        entityTransaction.commit();

    }
}
