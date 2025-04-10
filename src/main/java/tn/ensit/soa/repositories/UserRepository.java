package tn.ensit.soa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ensit.soa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
