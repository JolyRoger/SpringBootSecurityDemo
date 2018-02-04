package org.torquemada.SpringBootSecurityDemo;

import static org.junit.Assert.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.hibernate.annotations.common.util.impl.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.torquemada.SpringBootSecurityDemoApplication;
import org.torquemada.WebSecurityConfig;
import org.torquemada.domain.Role;
import org.torquemada.domain.User;
import org.torquemada.service.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootSecurityDemoApplication.class, WebSecurityConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootSecurityDemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

	@Test
	public void myTest() {
        assertTrue(true);
	}

	@Test
	public void databaseUsers() {
        System.out.println("databaseUsers starts");
        Iterable<User> users = userRepository.findAll();
        System.out.println("databaseUsers::COUNT=" + userRepository.count());
        users.forEach(System.out::println);
        System.out.println("databaseUsers finishes");
    }

	@Test
	public void databaseUsersCount() {
        System.out.println("databaseUsersCount starts");
        long count = userRepository.count();
        System.out.println("Users in database = " + count);
        System.out.println("databaseUsersCount finishes");
    }
}
