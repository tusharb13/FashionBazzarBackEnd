package com.niit.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;
	String username;
	Date orderDate;
	String pmode;
	int totalShippingAmount;
	public int getOrderID() {
		return orderId;
	}
	public void setOrderID(int orderID) {
		this.orderId = orderID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	public int getTotalShippingAmount() {
		return totalShippingAmount;
	}
	public void setTotalShippingAmount(int totalShippingAmount) {
		this.totalShippingAmount = totalShippingAmount;
	}
	
}
