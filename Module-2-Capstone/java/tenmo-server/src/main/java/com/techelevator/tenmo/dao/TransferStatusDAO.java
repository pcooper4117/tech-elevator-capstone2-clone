package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer_Status;

public interface TransferStatusDAO {

	Transfer_Status getTransfer_Status(Transfer_Status transfer_Status);

	Transfer_Status updtateTransfer_Status(Transfer_Status transfer_Status, long id);
	

}
