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
            // C
            Member member = new Member();
            member.setId(1L);
            member.setName("Yushin");
            em.persist(member);

            Member member2 = new Member();
            member2.setId(2L);
            member2.setName("Yeonwoo");
            em.persist(member2);

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)  // skip 5: Pagination
                    .setMaxResults(8)   // take 8: Pagination
                    .getResultList();

            for (Member m : result) {
                System.out.println("id = " + m.getId() + ", name = " + m.getName());
            }

            // R
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            // U
//            findMember.setId(2L);
//            findMember.setName("Yeonwoo");

//            em.remove(member);    // D


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
