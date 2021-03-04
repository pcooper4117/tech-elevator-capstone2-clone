package com.techelevator.tenmo.models;

public class Transfer {

private long transfer_id;
private long transfer_type_id;
private long transfer_status_id;
private long transfer_to;
private long transfer_from;
private double amount;


public long getTransfer_id() {
	return transfer_id;
}
public void setTransfer_id(long transfer_id) {
	this.transfer_id = transfer_id;
}
public long getTransfer_type_id() {
	return transfer_type_id;
}
public void setTransfer_type_id(long transfer_type_id) {
	this.transfer_type_id = transfer_type_id;
}
public long getTransfer_status_id() {
	return transfer_status_id;
}
public void setTransfer_status_id(long transfer_status_id) {
	this.transfer_status_id = transfer_status_id;
}
public long getTransfer_to() {
	return transfer_to;
}
public void setTransfer_to(long transfer_to) {
	this.transfer_to = transfer_to;
}
public long getTransfer_from() {
	return transfer_from;
}
public void setTransfer_from(long transfer_from) {
	this.transfer_from = transfer_from;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

	
	
	
	
}
