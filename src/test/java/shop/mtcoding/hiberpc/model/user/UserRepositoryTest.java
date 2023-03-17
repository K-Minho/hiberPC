package shop.mtcoding.hiberpc.model.user;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import shop.mtcoding.hiberpc.config.dummy.MyDummyEntity;

@Import(UserRepository.class)
@DataJpaTest
public class UserRepositoryTest extends MyDummyEntity {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    @BeforeEach
    public void setup() {
        em.createNativeQuery("alter table user_tb alter column id restart with 1").executeUpdate();
    }

    @Test
    public void save_test() {
        // given
        User user = newUser("ssar");
        // when
        User userPS = userRepository.save(user);
        // then
        Assertions.assertThat(userPS.getId()).isEqualTo(1);
    }

    @Test
    public void update_test() {
        // given
        User user = newUser("ssar");
        User userPS = userRepository.save(user);
        // given
        String password = "12345";
        String email = "email@email";

        // when
        userPS.update(password, email);
        User userUpdatePS = userRepository.save(userPS);
        // then
        Assertions.assertThat(userUpdatePS.getPassword()).isEqualTo("12345");
    }

    @Test
    public void update_dutty_check_test() {
        // given
        User user = newUser("ssar");
        User userPS = userRepository.save(user);
        // given
        String password = "12345";
        String email = "email@email";

        // when
        userPS.update(password, email);
        em.flush();
        // then
        User updatedUserPS = userRepository.findById(1);
        Assertions.assertThat(updatedUserPS.getPassword()).isEqualTo("12345");
    }

    @Test
    public void delete_test() {
        // given
        User user = newUser("ssar");
        User userPS = userRepository.save(user);

        int id = 1;
        User finduserPS = userRepository.findById(id);
        // when
        userRepository.delete(finduserPS);

        // then
        User deletedUserPS = userRepository.findById(1);
        assertThat(deletedUserPS).isNull();
    }
}
