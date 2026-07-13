package com.palak.demo.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    //Field injection
//    @Autowired
//    PaymentService paymentService;

    //Constructor Injection
    PaymentService paymentService;
    OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    //Setter Injection
//    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
//
    public void placeOrder(){
        paymentService.payment();
        System.out.println("Order placed");
    }
}
