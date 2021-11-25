package com.gasbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.entity.Admin;
import com.gasbooking.exception.AdminNotFoundException;
import com.gasbooking.repository.IAdminRepository;
import com.gasbooking.repository.IGasBookingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminDao;

	@Autowired
	IGasBookingRepository gasBookingDao;
	
	Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);
	
	
	@Override
	public Admin insertAdmin(Admin admin) {
		logger.info("***********Inserting Admin Details*********************");
		
		return adminDao.save(admin);

	}

	
	@Override
	public Admin updateAdmin(int adminId,Admin admin) throws AdminNotFoundException,Exception {
		
		logger.info("***********Updating Admin Details*********************");
		
			Optional<Admin> daoAdmin = adminDao.findById(adminId);
			
			if (daoAdmin.isPresent()) {
				Admin adminSave=daoAdmin.get();
				adminSave.setUsername(admin.getUsername());
				adminSave.setPassword(admin.getPassword());
				adminSave.setAddress(admin.getAddress());
				adminSave.setMobileNumber(admin.getMobileNumber());
				adminSave.setEmail(admin.getEmail());
				return adminDao.save(adminSave);
			}
			else {
				throw new AdminNotFoundException("Admin Not Found");
			}

	}

	
	
	@Override
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException{
		logger.info("***********Deleting Admin Details*********************");
		
		Optional<Admin> optional=adminDao.findById(adminId);
		if(optional.isPresent()) {
			Admin gotAdmin=optional.get();
			adminDao.delete(gotAdmin);
			return gotAdmin;
			
		}
		else {
			throw new AdminNotFoundException("Please Give proper id to delete");
		}
		
//		try {
//			if (adminId <= 0) {
//				throw new AdminNotFoundException();
//			} else {
//
//				deletedAdmin = adminDao.deleteById(adminId);
//				if (deletedAdmin == null) {
//					throw new AdminNotFoundException();
//				}
//			}
//
//		} catch (AdminNotFoundException anfe) {
//			throw new AdminNotFoundException("No Admin Found To Update For Given Id::" + " " + adminId);
//		} catch (Exception e) {
//			throw new Exception("Some Problem Occured Try After SomeTime");
//		}

	//return deletedAdmin;

	}

	

//	@Override
//	public List<GasBooking> getAllBookings(int customerId) throws CustomerNotFoundException   {
//		logger.info("***********Fetching List Of GasBookings For Given CustomerId*********************");
//        
//		if (customerId == 0) {
//		throw new CustomerNotFoundException("Please Provide A valid customer Id");
//	} else {
//			return gasBookingDao.findAllByCustomerId(customerId);
//		}
//
//	}
	
	

//	@Override
//	public List<GasBooking> getAllBookingsForDays(int customerId, LocalDate fromDate, LocalDate toDate) {
//		logger.info("**********Fecting All Bookings Between Given Days For A Customer*********************");
//		return gasBookingDao.getAllBookingsForDays(customerId, fromDate, toDate);
//	}

}