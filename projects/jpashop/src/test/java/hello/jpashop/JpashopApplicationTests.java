package hello.jpashop;

import hello.jpashop.domain.Member;
import hello.jpashop.domain.Order;
import hello.jpashop.domain.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class JpashopApplicationTests {

	@Autowired
	private EntityManager em;

	@Test
	@Transactional
	@Commit
	void run() {
		Order order = new Order();
		em.persist(order);

		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(order);

		em.persist(orderItem);
	}

}
