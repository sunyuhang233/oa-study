package top.hang.oa.service.impl;

import top.hang.oa.entity.User;
import top.hang.oa.mapper.UserMapper;
import top.hang.oa.service.UserService;
import top.hang.oa.service.exception.LoginException;
import top.hang.oa.utils.Md5Utils;

/**
 * @author : Flobby
 * @program : my-oa
 * @description :
 * @create : 2023-02-27 14:51
 **/

public class UserServiceImpl implements UserService {
    UserMapper userMapper = new UserMapper();

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new LoginException("用户名不存在");
        }
        // 对密码进行 加盐加密 进行比较
        String md5Password = Md5Utils.md5Digest(password, user.getSalt());

        System.out.println("加盐密文：" + md5Password);

        if (!md5Password.equals(user.getPassword())) {
            throw new LoginException("密码错误");
        }
        return user;
    }
}
