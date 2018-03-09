package lanway.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lanway.common.service.impl.BaseService;
import lanway.test.dao.CountryMapper;
import lanway.test.entity.Country;
import lanway.test.service.TestCountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by jh on 2017/7/10.
 */
@Service
public class TestCountryServiceImpl extends BaseService<Country> implements TestCountryService {
    private static Logger log = LoggerFactory.getLogger(TestCountryServiceImpl.class);

    @Autowired
    private CountryMapper countryMapper;
    @Override
    public List<Country> selectByPage(Country country,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Country> countries = countryMapper.selectByPage(country);
        return countries;
    }
}
