package abc.httpposttool.service;


import abc.httpposttool.dao.TransactionDao;
import abc.httpposttool.entity.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TranService {

    @Autowired
    TransactionDao transactionDao;

    @Transactional
    public boolean tx(TransactionDetails transactionDetails) {
        transactionDao.insert(transactionDetails);

        return true;

    }
}
