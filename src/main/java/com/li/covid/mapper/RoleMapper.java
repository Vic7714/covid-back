package com.li.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.covid.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper extends BaseMapper<Role> {
    @Select("select id from manage where flag=#{flag}")
    Integer selectByFlag(@Param("flag") String flag);
}
