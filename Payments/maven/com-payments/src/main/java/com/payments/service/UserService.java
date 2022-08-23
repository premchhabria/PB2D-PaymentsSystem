package com.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.model.User;
import com.payments.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

//	public User loginUser(User user) {
//		Optional<User> respUser = userRepository.findByUserIdAndPassword(user.getLogin_id(), user.getPassword());
//        if(respUser.isEmpty())
//            return new User(false,"authentication error");
//        return new User(true,"authentication successful");
//	}

}
