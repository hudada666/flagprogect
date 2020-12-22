package abc.httpposttool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DomeTestService {

    Logger logger = LoggerFactory.getLogger("DomeTestService");

    public String  checkResult() {
        
        logger.info("checkResult旗子开始执行");
        char grade = 'C';

        switch (grade) {
            case 'A':

                break;
            case 'B':
            case 'C':

                break;
            case 'D':

                break;
            case 'F':

                break;
            default:

        }


    }

}
