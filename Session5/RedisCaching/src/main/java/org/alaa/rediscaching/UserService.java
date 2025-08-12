package org.alaa.rediscaching;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CacheManager cacheManager;
    private final UserRepository userRepository;

    @Cacheable(cacheNames = "usersList")
    public List<Users> findAll() {
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
       return userRepository.findAll();
    }

    @CacheEvict(cacheNames = "usersList",allEntries = true)
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Cacheable(cacheNames = "userDetailsById",key = "#id")
    public Users findById(Long id) {
        return userRepository.findById(id).get();
    }

    @CacheEvict(cacheNames = "usersList",allEntries = true)
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

//    @CachePut(cacheNames = "userDetailsById",key = "#id")
//    @CacheEvict(cacheNames = "usersList",allEntries = true)
    @Caching(
           put =  @CachePut(cacheNames = "userDetailsById",key = "#id"),
            evict = @CacheEvict(cacheNames = "usersList",allEntries = true)
    )
    public Users updateUser(Long id,Users user) {
        Users u = userRepository.findById(id).get();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        return userRepository.save(u);
    }


}
