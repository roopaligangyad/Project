package com.cg.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Payment;
import com.cg.exception.PaymentException;
import com.cg.repositories.PaymentRepository;






@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	
	@Override
	public Payment addPayment( Payment payment) {
		
		paymentRepository.save(payment);
		
		return payment;
	}

	

	@Override
	public Payment getPaymentById( int id) throws PaymentException {
		
		 Payment payment = paymentRepository.findById(id).orElse(null);
		if (payment == null) {
		
			throw new PaymentException("Payment details not found");
		} else {
			
			return payment;
		}

	}

	

	@Override
	public List<Payment> viewPayment() throws PaymentException {
		
		final List<Payment> paymentList = paymentRepository.findAll();
		if (paymentList.size() > 0) {
		
			return paymentList;
		} else {
			
			throw new PaymentException("Payment details not found");
		}

	}




}