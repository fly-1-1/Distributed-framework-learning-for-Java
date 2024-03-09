package com.itheima.mp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.Address;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.AddressVO;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.enums.UserStatus;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Transactional
    @Override
    public void deductBalance(Long id, Integer money) {
        //查询用户状态
        User user = getById(id);
        if (user == null || user.getStatus() == UserStatus.FROZEN) {
            throw new RuntimeException("用户状态异常");
        }
        if (user.getBalance() < money) {
            throw new RuntimeException("用户余额不足");
        }
        //baseMapper.deductBalance(id, money);
        int remainBalance = user.getBalance() - money;
        lambdaUpdate()
                .set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, 2)
                .eq(User::getId, id)
                .eq(User::getBalance, user.getBalance())
                .update();
    }

    @Override
    public List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance) {
        return lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .gt(minBalance != null, User::getBalance, minBalance)
                .ge(maxBalance != null, User::getBalance, maxBalance).list();
    }

    @Override
    public UserVO queryUserAndAddressesById(Long id) {
        User user = getById(id);
        if (user == null || user.getStatus() == UserStatus.FROZEN) {
            throw new RuntimeException("用户状态异常");
        }
        //查询地址
        List<Address> addresses = Db.lambdaQuery(Address.class).eq(Address::getUserId, id).list();
        //封装Vo
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);

        if (CollUtil.isNotEmpty(addresses)) {
            userVO.setAddresses(BeanUtil.copyToList(addresses, AddressVO.class));
        }

        return userVO;
    }

    @Override
    public List<UserVO> queryUserAndAddressesByIds(List<Long> ids) {
        //查询用户
        List<User> users = listByIds(ids);
        if (CollUtil.isEmpty(users)) {
            return Collections.emptyList();
        }
        //查询地址
        //获取用户id集合
        List<Long> userIds = users.stream().map(User::getId).collect(Collectors.toList());
        List<Address> addresses = Db.lambdaQuery(Address.class).in(Address::getUserId, userIds).list();
        List<AddressVO> addressVOList = BeanUtil.copyToList(addresses, AddressVO.class);
        Map<Long, List<AddressVO>> addressMap = new HashMap<>(0);
        //梳理地址集合 相同用户的放入集合中
        if (CollUtil.isNotEmpty(addressVOList)) {
            addressMap = addressVOList.stream().collect(Collectors.groupingBy(AddressVO::getUserId));
        }
        //转vo
        List<UserVO> list = new ArrayList<>(users.size());
        for (User user : users) {
            UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
            list.add(userVO);
            userVO.setAddresses(addressMap.get(user.getId()));
        }
        return list;
    }

//    @Override
//    public PageDTO<UserVO> queryUsersPage1(UserQuery query) {
//        String name = query.getName();
//        Integer status = query.getStatus();
//        //构建查询条件
//        Page<User> page = Page.of(query.getPageNo(), query.getPageSize());
//        if (StrUtil.isNotBlank(query.getSortBy())) {
//            page.addOrder(new OrderItem(query.getSortBy(), query.getIsAsc()));
//        } else {
//            page.addOrder(new OrderItem("update_time", false));
//        }
//        //分页查询
//        Page<User> p = lambdaQuery().like(name != null, User::getUsername, name)
//                .eq(status != null, User::getStatus, status)
//                .page(page);
//        PageDTO<UserVO> dto = new PageDTO<>();
//        dto.setTotal(p.getTotal());
//        dto.setPages(p.getPages());
//        List<User> records = p.getRecords();
//
//        if (CollUtil.isEmpty(records)) {
//            dto.setList(Collections.emptyList());
//            return dto;
//        }
//        List<UserVO> vos = BeanUtil.copyToList(records, UserVO.class);
//        dto.setList(vos);
//        return dto;
//    }


    @Override
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {

        Page<User> page = Page.of(query.getPageNo(), query.getPageSize());
        Page<User> p = lambdaQuery().page(page);
        PageDTO<UserVO> userVOPageDTO = new PageDTO<>();
        userVOPageDTO.setTotal(p.getTotal());
        userVOPageDTO.setPages(p.getPages());
        List<User> records = p.getRecords();
        List<UserVO> vos = BeanUtil.copyToList(records, UserVO.class);
        userVOPageDTO.setList(vos);
        return userVOPageDTO;
    }

    @Override
    public PageDTO<UserVO> queryUsersPage1(UserQuery query) {
        String name = query.getName();
        Integer status = query.getStatus();
        //构建查询条件
        Page<User> page = query.toMpPageDefaultSortByUpdateTime();
        //分页查询
        Page<User> p = lambdaQuery().like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .page(page);
        //封装vo
        //return PageDTO.of(p,user -> BeanUtil.copyProperties(user,UserVO.class));

        return PageDTO.of(p, user -> {
            UserVO vo = BeanUtil.copyProperties(user, UserVO.class);
            vo.setUsername(vo.getUsername().substring(0, vo.getUsername().length() - 2) + "**");
            return vo;
        });
    }
}
