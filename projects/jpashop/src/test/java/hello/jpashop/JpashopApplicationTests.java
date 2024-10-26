package hello.jpashop;

import hello.jpashop.domain.Member;
import hello.jpashop.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class JpashopApplicationTests {

	@Autowired
	private EntityManager em;

	@Test
	@Transactional
	void run() {
		// RDB 중심적인 개발의 문제점
		Order order = em.find(Order.class, 1L);
		Long memberId = order.getMemberId();

		Member member = em.find(Member.class, memberId);
		member.setName("Yushin");
	}

}
