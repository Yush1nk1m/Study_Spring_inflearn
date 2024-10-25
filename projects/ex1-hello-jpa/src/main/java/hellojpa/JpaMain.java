package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            // 비영속
//            Member member1 = new Member(1L, "A");
//            Member member2 = new Member(2L, "B");

            // 영속
//            em.persist(member1);
//            em.persist(member2);

            Member member = em.find(Member.class, 1L);
            member.setName("yushin");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}
