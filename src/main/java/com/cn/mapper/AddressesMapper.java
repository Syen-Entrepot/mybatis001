package com.cn.mapper;

import com.cn.pojo.Addresses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Syen
 * @date 2019/7/21 0021-下午 14:50
 */
public interface AddressesMapper {
    Addresses queryById(Integer id);

    List<Addresses> queryByCountryCity(@Param("country") String country,@Param("city") String city);

    int updata(Addresses addresses);

    List<Addresses> query(Addresses addresses);

    List<Addresses> queryTrim(Addresses addresses);

    List<Addresses> queryFor(List<Integer> list);

    List<Addresses> querylik(@Param("city") String city);

    List<Addresses> listAll();
}
