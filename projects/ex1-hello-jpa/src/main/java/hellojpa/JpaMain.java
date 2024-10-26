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
            Member member = new Member();
            member.setUsername("Yushin");
            member.setRoleType(RoleType.USER);

            Member member2 = new Member();
            member2.setUsername("Yeonwoo");

            System.out.println("=====");
            em.persist(member);
            em.persist(member2);
            System.out.println("member.getId() = " + member.getId());
            System.out.println("=====");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}
