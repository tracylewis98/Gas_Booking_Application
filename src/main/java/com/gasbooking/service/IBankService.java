package com.gasbooking.service;

import com.gasbooking.entity.Bank;
import com.gasbooking.exception.BankNotFoundException;

public interface IBankService {
	public Bank insertBank(Bank bank);
	public Bank updateBank(Bank bank) throws BankNotFoundException;
	public Bank deleteBank(Bank bank,int bankId) throws BankNotFoundException;

}
