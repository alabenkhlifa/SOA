package tn.ensit.soa.User.services;

import org.springframework.stereotype.Service;
import tn.ensit.soa.User.entities.FriendRequest;
import tn.ensit.soa.User.entities.User;
import tn.ensit.soa.User.repositories.FriendRequestRepository;
import tn.ensit.soa.User.repositories.UserRepository;

import java.util.List;

@Service
public class FriendRequestService {

    private final FriendRequestRepository friendRequestRepository;

    private final UserRepository userRepository;

    public FriendRequestService(FriendRequestRepository friendRequestRepository, UserRepository userRepository) {
        this.friendRequestRepository = friendRequestRepository;
        this.userRepository = userRepository;
    }

    public FriendRequest sendFriendRequest(Long requesterId, Long receiverId) {
        User requester = userRepository.findById(requesterId).orElseThrow();
        User receiver = userRepository.findById(receiverId).orElseThrow();
        FriendRequest friendRequest = new FriendRequest(requester, receiver);
        return friendRequestRepository.save(friendRequest);
    }

    public List<FriendRequest> getPendingRequests(Long receiverId) {
        User receiver = userRepository.findById(receiverId).orElseThrow();
        return friendRequestRepository.findByReceiverAndAccepted(receiver, false);
    }

    public FriendRequest acceptRequest(Long requestId) {
        FriendRequest request = friendRequestRepository.findById(requestId).orElseThrow();
        request.setAccepted(true);
        return friendRequestRepository.save(request);
    }
}
