package com.example.back.ecommerce.services;

import com.example.back.ecommerce.entities.User;
import com.example.back.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){return repository.findAll();}

   /* public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }*/
    public List<User> findByEmail(String email){
        return repository.findByEmail(email);
    }
    public User insert(User obj){return repository.save(obj);}
    public void delete(String id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException | DataIntegrityViolationException ex){
            ex.printStackTrace();
        }
    }
    public User update(String id, User obj){
        try{
            User entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setPassword(obj.getPassword());
        obj.setCep(obj.getCep());
    }



}
