package com.piyas.controller;


import com.piyas.Service.OrderService;
import com.piyas.Service.PaymentService;
import com.piyas.Service.UserService;
import com.piyas.model.CartItem;
import com.piyas.model.Order;
import com.piyas.model.User;
import com.piyas.request.AddCartItemRequest;
import com.piyas.request.OrderRequest;
import com.piyas.request.UpdateCartItemRequest;
import com.piyas.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;


    @PostMapping("/order")
    public ResponseEntity<PaymentResponse> createOrder(@RequestBody OrderRequest req,
                                                       @RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwtToken(jwt);
        Order order=orderService.createOrder(req,user);
        PaymentResponse res=paymentService.createPaymentLink(order);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                             @RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwtToken(jwt);
        List <Order> orders=orderService.getUsersOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }



}
