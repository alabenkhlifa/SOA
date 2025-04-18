package tn.ensit.soa.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.entities.FriendRequest;
import tn.ensit.soa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    List<FriendRequest> findByReceiverAndAccepted(User receiver, boolean accepted);
}
