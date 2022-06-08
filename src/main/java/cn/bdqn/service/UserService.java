package cn.bdqn.service;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void add(User user);

    void update(User user);

    void delete(int id);

    public PageBean<User> findLimit(Integer currPageNo, Integer pageSize);
    public Integer findTotal();

    User getUserById(int id);
}
