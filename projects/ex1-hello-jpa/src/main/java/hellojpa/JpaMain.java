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
            // 비영속 상태
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // 영속 상태, 1차 캐시에 저장딤
            System.out.println("before");
            em.persist(member);
            System.out.println("after");    // 이 라인이 실행되기 전 DB에 쿼리가 날아가지 않음

            // 1차 캐시에서 조회
            Member findMember = em.find(Member.class, 100L);
            Member findMember2 = em.find(Member.class, 100L);   // 1차 캐시에서 조회된 데이터는 == 비교가 가능하다
            System.out.println("(findMember == findMember2) = " + (findMember == findMember2));

            // DB에 SELECT 쿼리가 날아가지 않음, 1차 캐시에서 조회된 것
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}
