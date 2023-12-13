package com.ourProperty.service.serviceImpl;

import com.ourProperty.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${stripe.secret.key}")
    private String seckretKey;

    @Override
    public String createPaymentIntent(double amount) {
        Stripe.apiKey = seckretKey;

//        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
//                .setAmount((long) amount * 100)).setCurrency("usd").build();

        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setAmount((long) (amount * 100))
                .setCurrency("usd")
                .build();

        try {
           PaymentIntent paymentIntent = PaymentIntent.create(createParams);
           return paymentIntent.getId();
        }catch(StripeException e){
            throw new RuntimeException("Error creating payment intent", e);
        }
    }
}
