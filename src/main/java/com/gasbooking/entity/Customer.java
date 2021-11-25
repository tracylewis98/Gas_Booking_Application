package com.gasbooking.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import com.gasbooking.entity.Bank;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.CascadeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gasbooking.entity.Customer;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.repository.ICustomerRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends AbstractUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 195158816166559020L;

	// data members

	@NotNull
	@Column(name = "account_no")
	private int accountNo;

	@Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}$", message = "Given IFSC No. is not valid.")
	@Column(name = "ifsc_no")
	private String ifscNo;

	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Given PAN No. is not valid.")
	@Column(name = "pan")
	private String pan;

	@JsonManagedReference(value = "1")
	@OneToOne(targetEntity = Cylinder.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cylinder_id")
	private Cylinder cylinder;

	@JsonManagedReference(value = "2")
	@OneToOne(targetEntity = Bank.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;
	
	@JsonManagedReference("4")
	@OneToMany(targetEntity = GasBooking.class, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<GasBooking> gasBooking = new ArrayList<>();

	// constructors
	public Customer() {
		super();
	}

	// getters and setters
	
	public Customer(@NotNull int accountNo,
			@Pattern(regexp = "^[A-Z]{4}0[0-9]{6,7}$", message = "Given IFSC No. is not valid.") String ifscNo,
			@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Given PAN No. is not valid.") String pan,
			Cylinder cylinder, Bank bank) {
		super();
		this.accountNo = accountNo;
		this.ifscNo = ifscNo;
		this.pan = pan;
		this.cylinder = cylinder;
		this.bank = bank;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfscNo() {
		return ifscNo;
	}

	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Cylinder getCylinder() {
		return cylinder;
	}

	public void setCylinder(Cylinder cylinder) {
		this.cylinder = cylinder;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<GasBooking> getGasBooking() {
		return gasBooking;
	}

	public void setGasBooking(List<GasBooking> gasBooking) {
		this.gasBooking = gasBooking;
	}

	// toString
	
	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", ifscNo=" + ifscNo + ", pan=" + pan + ", cylinder=" + cylinder
				+ ", bank=" + bank + "]";
	}
	
}