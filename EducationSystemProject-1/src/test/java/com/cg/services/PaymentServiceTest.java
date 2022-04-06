package com.cg.services;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.entities.Payment;
import com.cg.exception.PaymentException;
import com.cg.repositories.PaymentRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)

@SpringBootTest
public class PaymentServiceTest {
	@InjectMocks
	private PaymentService payService;
	
	@MockBean 
	private PaymentRepository payRepo;
	
	@Test
	public void testAddPayment() 
	{
		Payment pay=new Payment();
		
		pay.setAmount(30000);
		pay.setDescription("good");
		pay.setPaymentDate("29/07/2020");
		Mockito.when(payRepo.save(pay)).thenReturn(pay);
		assertThat(payService.addPayment(pay)).isEqualTo(pay);
	}
	
	@Test
	public void testViewPayment() throws PaymentException {
		Payment pay1 = new Payment();
		
		pay1.setAmount(20000);
		pay1.setDescription("complete");
		pay1.setPaymentDate("29/07/1999");
		
		Payment pay2 = new Payment();
	
		pay2.setAmount(21000);
		pay2.setDescription("complete");
		pay2.setPaymentDate("21/07/1999");
		
		List<Payment> payList=new ArrayList<>();
		payList.add(pay1);
		payList.add(pay2);
		
		Mockito.when(payRepo.findAll()).thenReturn(payList);
		assertThat(payService.viewPayment()).isEqualTo(payList);
	}
	

}
