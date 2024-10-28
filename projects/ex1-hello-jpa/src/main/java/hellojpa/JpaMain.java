package hellojpa;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("Yushin");
            member.setAddress(new Address("city", "street", "244"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("마라탕");
            member.getFavoriteFoods().add("맥주");

            member.getAddressHistory().add(new AddressEntity("광주", "우산동", "?"));
            member.getAddressHistory().add(new AddressEntity("서울", "어딘가", "?"));

            em.persist(member);

            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
