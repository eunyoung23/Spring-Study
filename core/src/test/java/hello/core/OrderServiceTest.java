package hello.core.order;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        long memberId = 1L;
        
    }
}

