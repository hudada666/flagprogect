package abc.httpposttool.service;

import abc.httpposttool.dao.ComponentDao;
import abc.httpposttool.dao.TransactionDao;
import abc.httpposttool.entity.ComponentDetails;
import abc.httpposttool.entity.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComponentService {

    @Autowired
    ComponentDao componentDao;

    @Transactional
    public boolean tx() {
        ComponentDetails componentDetails = new ComponentDetails();
        componentDetails.setTransactionCode();
        componentDetails.setComponentCode();
        componentDetails.setComponentOrder();
        componentDetails.setComponentStuts();
        componentDetails.setComponentUseTime();
        componentDao.insert(componentDetails);

        return true;

    }
}
