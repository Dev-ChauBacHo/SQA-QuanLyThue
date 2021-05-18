package model;

import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 */
public class Employee implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String mst;
    private String password;
    private String email;
    private String address;
    private String phone;
    private String pin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMst() {
		return mst;
	}
	public void setMst(String mst) {
		this.mst = mst;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
    
    
}
