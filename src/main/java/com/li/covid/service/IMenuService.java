package com.li.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.covid.entity.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {

    List<Menu> findMenus(String name);
}
