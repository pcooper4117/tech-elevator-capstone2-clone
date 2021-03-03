package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer_Type;

public interface TransferTypeDAO {
	Transfer_Type getTransfer_Type(Transfer_Type transfer_Type);

	Transfer_Type updtateTransfer_Type(Transfer_Type transfer_Type, long id);

}
