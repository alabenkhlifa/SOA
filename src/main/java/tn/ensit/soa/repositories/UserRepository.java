package tn.ensit.soa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ensit.soa.entities.User;


// We have only <bold>extended</bold> the JPARepository and Spring Data will automatically create the CRUD operations
// on its own (see the usage of the repository in the service

// This annotation is used to declare a Repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> { }