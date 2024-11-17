package org.study.sst2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.sst2.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

