package br.com.duty.services;

import br.com.duty.models.Addres;
import br.com.duty.models.User;
import br.com.duty.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getUser(Optional<Integer> id){
        List<User> users = new ArrayList<User>();
        if(id.isPresent())
            users.add(userRepository.findById(id.get()).get());
        else
            users = userRepository.findAll();

        return users;
    }

    public User createUser(String name, String email, String passWord){
        User user = new User(name, email, passWord);
        userRepository.save(user);
        return user;
    }

    public User updateUserPassword(Integer userId, String passWord){
       return this.updateUser(userId,Optional.ofNullable(null),Optional.ofNullable(null),Optional.of(passWord), Optional.ofNullable(null));
    }

    public User updateUserEmail(Integer userId, String email){
        return this.updateUser(userId,Optional.ofNullable(null),Optional.of(email), Optional.of(null), Optional.ofNullable(null));
    }

    public User addAddress(Integer userId, Addres add) {
        return this.updateUser(userId,Optional.ofNullable(null),Optional.ofNullable(null), Optional.of(null), Optional.of(add));
    }


    private User updateUser(Integer id, Optional<String> name, Optional<String> email, Optional<String> passWord, Optional<Addres> addres){
        User user = userRepository.getById(id);

        if(name.isPresent())
            user.setName(name.get());
        if(email.isPresent())
            user.setEmail(email.get());
        if(passWord.isPresent())
            user.setPassword(passWord.get());
        if(addres.isPresent())
            user.setAddres(addres.get());

        userRepository.save(user);

        return user;
    }


}
