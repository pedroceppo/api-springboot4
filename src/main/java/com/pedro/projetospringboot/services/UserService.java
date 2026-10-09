package com.pedro.projetospringboot.services;

import com.pedro.projetospringboot.entities.User;
import com.pedro.projetospringboot.repositories.UserRepository;
import com.pedro.projetospringboot.services.exceptions.DatabaseException;
import com.pedro.projetospringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        if(obj.isPresent()) {
            return obj.get();
        }
        throw new ResourceNotFoundException(id);
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        try {
            userRepository.deleteById(id);
            userRepository.flush();
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não é possível excluir um usuário que possui registros vinculados.");
        }
    }

    public User update(Long id, User user){


        User existingUser = findById(id);


        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());

        return userRepository.save(existingUser);
    }
}
