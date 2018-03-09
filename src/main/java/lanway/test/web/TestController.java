package lanway.test.web;

import com.github.pagehelper.PageInfo;
import lanway.common.util.Token;
import lanway.test.entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import lanway.test.service.TestCountryService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by jh on 2017/7/10.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static Logger log = LoggerFactory.getLogger(TestCountryService.class);
    @Autowired
    private TestCountryService testCountryService;

    @RequestMapping(value = "/init")
    @Token(save = true)//获取token令牌
    public String init(HttpServletRequest request, HttpServletResponse response, ModelMap ma){
        Country country = new Country();
        country.setId(100l);
        int page = 2;
        int pageSize = 10;
        List<Country> list = testCountryService.selectByPage(country,page,pageSize);
        PageInfo<Country> pageInfo = new PageInfo<Country>(list);
        System.out.println(pageInfo.getTotal());
        ma.put("name",list.get(0).getCountryname());
        return "test/test";
    }

    @RequestMapping(value = "/saveData",method = RequestMethod.POST)
    @ResponseBody
    @Token(remove=true)//保存时通过页面提交的token值，和session中的比较，token一致提交保存，token不一致提示重复提交
    public void saveData(HttpServletRequest request,HttpServletResponse response,
                         String tablename,String trowkey,String columns,
                         String indextablename,String irowkey,String icolumns,
                         String task_id,String savetype,String memoryCodes){
        System.out.println(task_id);
    }

}
