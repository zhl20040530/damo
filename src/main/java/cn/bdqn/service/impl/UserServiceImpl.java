package cn.bdqn.service.impl;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> list() {

        return userMapper.list();
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public PageBean<User> findLimit(Integer currPageNo, Integer pageSize) {
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrPageNo(currPageNo);
        int total = userMapper.findTotal();
        pageBean.setTotalCount(total);
        Integer tatalPageCount = total % 5 == 0?total/5:total/5+1;
        pageBean.setTotalPageCount(tatalPageCount);
        List<User> list = userMapper.findLimit((currPageNo-1)*1,1);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public Integer findTotal() {
        return userMapper.findTotal();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
