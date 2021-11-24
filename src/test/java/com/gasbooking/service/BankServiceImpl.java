package com.gasbooking.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;

import java.util.Optional;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gasbooking.entity.Bank;
import com.gasbooking.exception.BankNotFoundException;
import com.gasbooking.repository.IBankRepository;
@SpringBootTest
public class BankServiceImpl {
	@Autowired
	IBankService bankService;
	
	@MockBean
	IBankRepository bankRepository;
	@Test
	void testInsertBank() {
		
		Bank b1=new Bank();
		b1.setBankId(1323);
		b1.setBankName("ICICI");
		b1.setAddress("msg");
	
	Mockito.when(bankRepository.save(b1)).thenReturn(b1);
	assertThat(bankService.insertBank(b1)).isEqualTo(b1);
	}
	@Test
	void testUpdateBank() throws BankNotFoundException{
		Bank b1=new Bank();
		b1.setBankId(1323);
		b1.setBankName("ICICI");
		b1.setAddress("msg");
		Optional<Bank> b2=Optional.of(b1);
		Mockito.when(bankRepository.findById(1323)).thenReturn(b2);
		Mockito.when(bankRepository.save(b1)).thenReturn(b1);
		b1.setBankId(1424);
		b1.setBankName("AXIS");
		b1.setAddress("Udupi");
		assertThat(bankService.updateBank(b1)).isEqualTo(b1);
	}
	@Test
	void testDeleteBank() throws BankNotFoundException{
		Bank b1=new Bank();
		b1.setBankId(1424);
		b1.setBankName("AXIS");
		b1.setAddress("Udupi");
		Optional<Bank> b2=Optional.of(b1);
		Mockito.when(bankRepository.findById(1424)).thenReturn(b2);
		assertThat(bankService.deleteBank(1424)).isEqualTo(b1);
	}
		
		
		

}
