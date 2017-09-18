package com.github.varunmehta.repos;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.github.varunmehta.model.ConcreteIdKey;
import com.github.varunmehta.model.ProjectionIdKey;
import com.github.varunmehta.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTests {

  @Autowired
  UserRepository userRepository;

  @Before
  public void setup() {
    userRepository
        .save(new User(1, "Clark", "Kent", "superman@dc.com", "SmallVille", "Village", "Smallville", "KS", "US"));
    userRepository.save(new User(2, "Bruce", "Wayne", "batman@dc.com", "Gotham", "City", "Chicago", "IL", "US"));
  }

  @Test
  public void testConcrete() {
    List<ConcreteIdKey> ids = userRepository.findsConcretesByProjectedColumns();
    Assert.notEmpty(ids, "No users found in concrete");
  }

  @Test
  public void testProjected() {
    List<ProjectionIdKey> ids = userRepository.findsProjectedByProjectedColumns();
    Assert.notEmpty(ids, "No users found in projection");
  }

  @Test
  public void testCachedConcrete() {
    List<ConcreteIdKey> ids = userRepository.findsCachedConcretesByProjectedColumns();
    Assert.notEmpty(ids, "No users found in concrete");
  }

  @Test
  public void testCachedProjected() {
    List<ProjectionIdKey> ids = userRepository.findsCachedProjectedByProjectedColumns();
    Assert.notEmpty(ids, "No users found in projection");
  }

}
