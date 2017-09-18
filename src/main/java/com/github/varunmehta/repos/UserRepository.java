package com.github.varunmehta.repos;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.varunmehta.model.ConcreteIdKey;
import com.github.varunmehta.model.ProjectionIdKey;
import com.github.varunmehta.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT new com.github.varunmehta.model.ConcreteIdKey(u.id as id, concat (u.firstname, ' ', u.lastname) as value) FROM User u")
  List<ConcreteIdKey> findsConcretesByProjectedColumns();

  @Query("SELECT u.id as id, concat (u.firstname, ' ', u.lastname) as value FROM User u")
  List<ProjectionIdKey> findsProjectedByProjectedColumns();

  @Query("SELECT new com.github.varunmehta.model.ConcreteIdKey(u.id as id, concat (u.firstname, ' ', u.lastname) as value) FROM User u")
  @Cacheable("concrete")
  List<ConcreteIdKey> findsCachedConcretesByProjectedColumns();

  @Query("SELECT u.id as id, concat (u.firstname, ' ', u.lastname) as value FROM User u")
  @Cacheable("projected")
  List<ProjectionIdKey> findsCachedProjectedByProjectedColumns();

}
