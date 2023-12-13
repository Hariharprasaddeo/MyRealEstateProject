package com.ourProperty.Controller;

import com.ourProperty.entity.Product;
import com.ourProperty.exception.EntityNotFoundException;
import com.ourProperty.repository.ProductRepository;
import com.ourProperty.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Value("${stripe.secret.key}")
    private String seckretKey;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PaymentService paymentService;

//  http://localhost:8080/api/payments/initiate?productid=1
    @PostMapping("/initiate")
    public ResponseEntity<String> initiatePayment(@RequestParam Long productid){
         Product product = productRepository.findById(productid).orElseThrow(
                () -> new EntityNotFoundException("Product Not found"));

        String payIntentId = paymentService.createPaymentIntent(product.getPrice());
        return new ResponseEntity<>(payIntentId, HttpStatus.CREATED);

    }

}
