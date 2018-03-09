package lanway.test.service;

import lanway.common.service.IService;
import lanway.test.entity.Country;
import lanway.test.entity.TestUser;

import java.util.List;

/**
 * Created by jh on 2017/7/10.
 */
public interface TestCountryService extends IService<Country>{

    public List<Country> selectByPage(Country country,int page,int pageSize);
}
