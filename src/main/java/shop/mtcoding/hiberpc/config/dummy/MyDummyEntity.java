package shop.mtcoding.hiberpc.config.dummy;

import shop.mtcoding.hiberpc.model.user.User;

public class MyDummyEntity {

    protected User newUser(String name) {
        User user = User.builder().username(name).password("1234").email(name + "@mail").build();
        return user;
    }
}
