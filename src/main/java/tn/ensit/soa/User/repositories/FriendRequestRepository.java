package tn.ensit.soa.User.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ensit.soa.User.entities.FriendRequest;
import tn.ensit.soa.User.entities.User;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    List<FriendRequest> findByReceiverAndAccepted(User receiver, boolean accepted);
}
