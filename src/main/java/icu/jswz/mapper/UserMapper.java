package icu.jswz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.jswz.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
