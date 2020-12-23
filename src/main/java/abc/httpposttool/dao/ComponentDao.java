package abc.httpposttool.dao;

import abc.httpposttool.entity.ComponentDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("componentDao")
public interface ComponentDao {

    @Insert("insert into component_details(component_code,\n" +
            "component_stuts,\n" +
            "component_use_time,\n" +
            "component_time,\n" +
            "transaction_code) values(#{componentCode},#{componentStuts},#{componentUseTime},\n" +
            "#{componentTime},#{transactionCode})")
    void insert(ComponentDetails componentDetails);
}
