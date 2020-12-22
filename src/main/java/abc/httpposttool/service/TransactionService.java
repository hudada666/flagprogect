package abc.httpposttool.service;


import abc.httpposttool.dao.TransactionDao;
import abc.httpposttool.entity.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    TransactionDao transactionDao;

    @Transactional
    public boolean tx() {
        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setTransactionCode();
        transactionDetails.setTransactionStuts();
        transactionDetails.setTransactionTime();
        transactionDao.insert(transactionDetails);

        return true;

    }
}
