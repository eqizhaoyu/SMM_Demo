package lanway.common.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by zhangweiying on 2017/7/11.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
