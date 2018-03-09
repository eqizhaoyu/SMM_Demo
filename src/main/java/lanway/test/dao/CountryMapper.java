package lanway.test.dao;

import lanway.common.dao.MyMapper;
import lanway.test.entity.Country;

import java.util.List;

public interface CountryMapper extends MyMapper<Country> {

    public List<Country> selectByPage(Country country);
}