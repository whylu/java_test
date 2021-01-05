package com.ming01.houseRenting.mapper;

import com.ming01.houseRenting.model.BadRent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper // if enable this @Mapper, @MapperScan in MybatisConfig can be removed
public interface BadRentMapper {

    @Select("SELECT address, rent_price, message, longitude, latitude, submit_time FROM bad_rent")
    List<BadRent> selectAllBadRent();

    // define in mapper/BadRentMapper.xml
    int insertBadRent(@Param("badRent") BadRent badRent);

}
