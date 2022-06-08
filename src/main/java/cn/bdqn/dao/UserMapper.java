package cn.bdqn.dao;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> list();

    void add(User user);

    void update(User user);

    void delete(int id);
    public List<User> findLimit(@Param("currPageNo") Integer currPageNo, @Param("pageSize") Integer pageSize);
    public Integer findTotal();

    User getUserById(int id);
}
