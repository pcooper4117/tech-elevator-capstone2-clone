package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;

public interface TransferDAO {

	void createTransfer(Transfer transfer, long account_to, long ac);

	Transfer getTransfer(Transfer transfer);

	Transfer updateTransfer(Transfer transfer, long id);

	void deleteTranfer (long id);
}
