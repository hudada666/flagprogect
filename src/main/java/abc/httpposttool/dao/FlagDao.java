package abc.httpposttool.dao;

import abc.httpposttool.entity.FlagDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("flagDao")
public interface FlagDao {

    @Insert("insert into flag_details(flag_code,\n" +
            "flag_stuts,\n" +
            "flag_msg,\n" +
            "flag_time,\n" +
            "transaction_code,\n" +
            "component_code) values(#{flagCode},#{flagStuts},#{flagMsg},\n" +
            "#{flagUseTime},#{transactionCode},#{componentCode})")
    void insert(FlagDetails flagDetails);
}
