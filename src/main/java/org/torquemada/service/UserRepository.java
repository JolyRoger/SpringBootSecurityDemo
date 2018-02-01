package org.torquemada.service;

import org.springframework.data.repository.CrudRepository;
import org.torquemada.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
