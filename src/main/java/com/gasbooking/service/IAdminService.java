package com.gasbooking.service;

import com.gasbooking.entity.Admin;
import com.gasbooking.exception.AdminNotFoundException;

public interface IAdminService {

	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(int adminId,Admin admin)throws AdminNotFoundException,Exception;
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException ,Exception;
//    public List<GasBooking>getAllBookings(int customerId)throws CustomerNotFoundException;
//    public List<GasBooking>getAllBookingsForDays(int customerId, LocalDate fromDate, LocalDate toDate);
}