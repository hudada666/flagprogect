package abc.httpposttool.service;

import abc.httpposttool.dao.FlagDao;
import abc.httpposttool.entity.FlagDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

@Service
public class FlagService {

    @Autowired
    FlagDao flagDao;

    @Transactional
    public boolean tx() {
        FlagDetails flagDetails = new FlagDetails();
        flagDetails.setComponentCode();
        flagDetails.setFlagCode();
        flagDetails.setFlagStuts();
        flagDetails.setFlagMsg();
        flagDetails.setFlag_order();
        flagDetails.setFlagUseTime();
        flagDetails.setTransactionCode();
        flagDao.insert(flagDetails);

        return true;

    }
}
