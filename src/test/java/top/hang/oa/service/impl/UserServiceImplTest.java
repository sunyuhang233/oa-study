package top.hang.oa.service.impl;

import org.junit.jupiter.api.Test;
import top.hang.oa.entity.User;
import top.hang.oa.service.UserService;

class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    void login() {
        User user = userService.login("m8", "test");
        System.out.println(user);
    }
}