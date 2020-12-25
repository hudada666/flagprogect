package abc.httpposttool.service;

import abc.httpposttool.dao.ComponentDao;
import abc.httpposttool.dao.FlagDao;
import abc.httpposttool.dao.TransactionDao;
import abc.httpposttool.poiUtil.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ExcelService {
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    ComponentDao componentDao;
    @Autowired
    FlagDao flagDao;
    @Autowired
    ExportExcel exportExcel;

    public Map<String,List> selectData(){

        String filePath = "/Users/hudada/Downloads/returns.xlsx";
        //获取excel数据
        Map<String,List> getExcelDate = exportExcel.getExcelData(filePath) ;
        return getExcelDate;
    }
}
