package com.li.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.covid.common.Result;
import com.li.covid.entity.Manage;
import com.li.covid.service.IManageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Resource
    private IManageService manageService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Manage manage) {
        manageService.saveOrUpdate(manage);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        manageService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        manageService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(manageService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(manageService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam String name,
                           @RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {
        QueryWrapper<Manage> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        queryWrapper.orderByDesc("id");
        return Result.success(manageService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
    /**
     * 绑定角色和菜单的关系
     * @param roleId 角色id
     * @param menuIds 菜单id数组
     * @return
     */
    @PostMapping("/manageMenu/{roleId}")
    public Result ManageMenu(@PathVariable Integer roleId, @RequestBody List<Integer> menuIds) {
        manageService.setRoleMenu(roleId, menuIds);
        return Result.success();
    }
    @GetMapping("/manageMenu/{roleId}")
    public Result getManageMenu(@PathVariable Integer roleId) {
        return Result.success(manageService.getRoleMenu(roleId));
    }
}
