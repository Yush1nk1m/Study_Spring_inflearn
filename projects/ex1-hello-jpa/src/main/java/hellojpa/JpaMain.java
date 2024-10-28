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

            Address address = new Address("Gunpo", "Surisan", "244");

            Member member = new Member();
            member.setUsername("Yushin");
            member.setAddress(address);
            em.persist(member);

            Address newAddress = new Address("new City", address.getStreet(), address.getZipcode());
            member.setAddress(newAddress);

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
