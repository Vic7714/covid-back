package com.li.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.covid.entity.Role;

public interface IRoleService extends IService<Role> {

    Role login(Role role);
    Role register(Role role);
}
