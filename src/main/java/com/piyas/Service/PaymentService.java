package com.piyas.Service;

import com.piyas.model.Order;
import com.piyas.response.PaymentResponse;
import com.stripe.exception.StripeException;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentService {
    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}
