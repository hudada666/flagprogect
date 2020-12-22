package abc.httpposttool.dao;

import abc.httpposttool.entity.TransactionDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("transactionDao")
public interface TransactionDao {

    @Insert("insert into transaction_details(transaction_code,\n" +
            "transaction_stuts,\n" +
            "transaction_time \n) " +
            "values(#{transactionCode},#{transactionStuts},#{transactionTime})")
    void insert(TransactionDetails transactionDetails);
}
