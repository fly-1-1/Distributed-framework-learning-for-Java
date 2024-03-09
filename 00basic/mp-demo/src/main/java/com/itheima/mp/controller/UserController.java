package com.itheima.mp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.dto.UserFormDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户管理接口")
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final IUserService iUserService;

    @ApiOperation("新增用户接口")
    @PostMapping
    public void saveUser(@RequestBody UserFormDTO userFormDTO) {

        User user = BeanUtil.copyProperties(userFormDTO, User.class);
        iUserService.save(user);
    }

    @ApiOperation("删除用户接口")
    @DeleteMapping("{id}")
    public void deleteUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
        iUserService.removeById(id);
    }

    @ApiOperation("查询用户接口")
    @GetMapping("{id}")
    public UserVO QueryUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
       return iUserService.queryUserAndAddressesById(id);
    }



    @ApiOperation("批量查询用户接口")
    @GetMapping
    public List<UserVO> QueryUserByIds(@ApiParam("用户id集合") @RequestParam("ids") List<Long> ids) {
        return iUserService.queryUserAndAddressesByIds(ids);
    }

    @ApiOperation("扣减用户余额接口")
    @PutMapping("/{id}/deduction/{money}")
    public void deleteUserById(@ApiParam("用户id") @PathVariable("id") Long id,
                               @ApiParam("扣减金额") @PathVariable("money") Integer money) {

        iUserService.deductBalance(id,money);
    }

    @ApiOperation("复杂条件批量查询用户接口")
    @GetMapping("/list")
    public List<UserVO> QueryUsers(UserQuery query) {
        List<User> users = iUserService.queryUsers(query.getName(),query.getStatus(),query.getMinBalance(),query.getMaxBalance());
        return BeanUtil.copyToList(users,UserVO.class);
    }

    @ApiOperation("复杂条件分页查询用户接口")
    @GetMapping("/page")
    public PageDTO<UserVO> QueryUsersPage(UserQuery query) {
        return iUserService.queryUsersPage(query);
    }


}
