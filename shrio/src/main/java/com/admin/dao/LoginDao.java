package com.admin.dao;

import com.admin.pojo.UserCommen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zhl on 2021/8/18.
 */
@Mapper
@Component
public interface LoginDao {
    UserCommen getUserByName(@Param("name") String name);
}
