package com.ming01.houseRenting.mapper;

import com.ming01.houseRenting.model.BadRent;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BadRentMapperTest extends AbstTestMapper<BadRentMapper> {


    public BadRentMapperTest() {
        super(BadRentMapper.class, "/h2/init.sql", "/h2/badRent/add_bad_rent.sql");
    }

    @Test
    void selectAllBadRent() {
        List<BadRent> badRents = getMapper().selectAllBadRent();
        assertThat(badRents).isNotEmpty();
    }

    @Test
    void testInsertBadRent() {
        BadRent badRent = new BadRent();
        badRent.setAddress("addressssssad ad asfsdf sdfasd");
        badRent.setLatitude(new BigDecimal("0.1234567"));
        badRent.setLongitude(new BigDecimal("0.1223344"));
        badRent.setMessage("this is meessage");
        badRent.setRentPrice(0.123456);

        int result = getMapper().insertBadRent(badRent);
        assertThat(result).isEqualTo(1);
    }

}