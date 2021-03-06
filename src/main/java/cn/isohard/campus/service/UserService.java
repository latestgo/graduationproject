package cn.isohard.campus.service;

import cn.isohard.campus.entities.User;
import cn.isohard.campus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean isLogin(String username, String password) {
        User user = userMapper.selectUser(username, password);
        if(user == null)
            return false;
        return true;
    }

    public Integer getUseriddByUsername(String username) {
        return userMapper.selectUseridByUsername(username);
    }

    public boolean isValidUsername(String username) {
        Integer userid = userMapper.selectUseridByUsername(username);
        if(userid == null) {
            return true;
        }
        else
            return false;
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    /**
     * update user by userid
     * @param user
     */
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    /**
     * get User By userid
     * @param userid
     * @return
     */
    public User getUserByUserid(Integer userid) {
        return userMapper.getUserByUserid(userid);
    }
}
