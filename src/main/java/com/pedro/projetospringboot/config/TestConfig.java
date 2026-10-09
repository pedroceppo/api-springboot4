package com.pedro.projetospringboot.config;

import com.pedro.projetospringboot.entities.*;
import com.pedro.projetospringboot.entities.enums.OrderStatus;
import com.pedro.projetospringboot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

   @Autowired
   private ProductRepository productRepository;

   @Autowired
   private OrderItemRepository orderItemRepository;

   @Autowired
   private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null,"Eletronics");
        Category cat2 = new Category(null,"Books");
        Category cat3 = new Category(null,"Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        User u1 = new User(null,"Pedro","pedro@gmai.com","18988213514","123");
        User u2 = new User(null,"Camila","camila@gmail.com","18996951181","12345");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID ,u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT ,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));


        o1.setOrderStatus(OrderStatus.PAID);
        o2.setOrderStatus(OrderStatus.PAID);
        o3.setOrderStatus(OrderStatus.PAID);


        orderRepository.saveAll(Arrays.asList(o1, o2, o3));


        Payment pag1 = new Payment();
        pag1.setMoment(Instant.parse("2019-06-20T21:53:07Z"));
        pag1.setOrder(o1);

        Payment pag2 = new Payment();
        pag2.setMoment(Instant.parse("2019-07-21T05:42:10Z"));
        pag2.setOrder(o2);

        Payment pag3 = new Payment();
        pag3.setMoment(Instant.parse("2019-07-22T17:21:22Z"));
        pag3.setOrder(o3);


        paymentRepository.saveAll(Arrays.asList(pag1, pag2, pag3));


        o1.setPayment(pag1);
        o2.setPayment(pag2);
        o3.setPayment(pag3);


        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
