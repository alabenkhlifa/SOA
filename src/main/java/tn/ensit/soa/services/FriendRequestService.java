package tn.ensit.soa.services;

import tn.ensit.soa.entities.FriendRequest;
import tn.ensit.soa.repositories.FriendRequestRepository;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestService {

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private UserRepository userRepository;

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
