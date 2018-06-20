package dao;

import java.util.Collection;

import com.project.coupon.entities.Company;
import com.project.coupon.entities.Coupon;
import com.project.coupon.entities.Customer;

public interface CustomerDAO {
	void createCustomer(Customer customer);
    void removeCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getCustomer(Long id);
    Collection<Company> getAllCustomers();
    Collection<Coupon> getCoupons();
    boolean login(String custName, String password);

}
