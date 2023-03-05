package com.li.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.covid.entity.Manage;

import java.util.List;

public interface IManageService extends IService<Manage> {

    void setRoleMenu(Integer roleId, List<Integer> menuIds);

    List<Integer> getRoleMenu(Integer roleId);
}
