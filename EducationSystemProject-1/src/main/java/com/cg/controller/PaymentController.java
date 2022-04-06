package com.cg.controller;


import java.util.List;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Payment;
import com.cg.exception.DateException;
import com.cg.exception.ErrorMessages;
import com.cg.exception.InvalidPaymentException;
import com.cg.exception.PaymentException;
import com.cg.services.PaymentService;





@RestController
@RequestMapping("/api/edu")
public class PaymentController {
	
	
	
	@Autowired
	transient private PaymentService paymentService;

	@PostMapping("/add-Payment")
	public Payment addPayment(@RequestBody  Payment payment) throws InvalidPaymentException,DateException {
	

	String datePattern = "^(1[0-2]|0[1-9])/(3[01]"
               + "|[12][0-9]|0[1-9])/[0-9]{4}$";
	
       if (payment.getAmount() == 0 || payment.getDescription() == null) {
			throw new InvalidPaymentException("Amount and Description cannot contain null values");
        }
			else if (!(Pattern.matches(datePattern, payment.getPaymentDate()))) {
			
			throw new DateException("Please enter in the format dd/mm/yyyy");
		}

		else {
		 Payment addPayment = paymentService.addPayment(payment);
			
			return addPayment;

		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPaymentException.class)
	public ErrorMessages exceptionHandler( InvalidPaymentException invalidPayEx) {
		return new ErrorMessages("400", invalidPayEx.str);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PaymentException.class)
	public ErrorMessages exceptionHandler(PaymentException paymentEx) {
		return new ErrorMessages("404", paymentEx.str);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DateException.class)
	public ErrorMessages exceptionHandler(DateException dateEx) {
		return new ErrorMessages("400", dateEx.str);
	}

	

	@GetMapping("/get-Payment/{transactionId}")
	public Payment getPaymentById(@PathVariable("transactionId")  int transactionId) throws PaymentException {
	
		 Payment getPayment = paymentService.getPaymentById(transactionId);
		
		return getPayment;
	}

	

	@GetMapping("/view-Payment")
	public List<Payment> viewPayment() throws PaymentException {
		
		List<Payment> getPaymentList = paymentService.viewPayment();
		
		return getPaymentList;
	}



}
