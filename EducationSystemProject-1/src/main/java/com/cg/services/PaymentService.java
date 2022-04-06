package com.cg.services;

import java.util.List;

import com.cg.entities.Payment;
import com.cg.exception.PaymentException;





public interface PaymentService {
	Payment addPayment(Payment payment);

	Payment getPaymentById(int paymentId) throws PaymentException;

	List<Payment> viewPayment() throws PaymentException;



}
