package uz.utkirbek.jpaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.utkirbek.jpaproject.dto.UserDto;
import uz.utkirbek.jpaproject.entity.User;
import uz.utkirbek.jpaproject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Muallif: Utkirbek
 * Soat: 08:32:08
 * Kun: July 10, 2023, Monday
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getOne(Integer id){
        Optional<User> optionalUser=userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public String save(UserDto userDto){
        User user=new User();
        user.setAddress(userDto.getAddress());
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        userRepository.save(user);
        return "User saqlandi";
    }

    public String delete(Integer id){
        if(!userRepository.existsById(id)){
            return "User topilmadi";
        }else {
            userRepository.deleteById(id);
            return "User o'chirildi!";
        }
    }

    public String update(UserDto userDto){
        if (userDto.getId()==null)
            return "User topilmadi!";


        Optional<User> optionalUser=userRepository.findById(userDto.getId());
        if (!optionalUser.isPresent())
            return "User topilmadi!";

        if (userRepository.existsByPhoneNumberAndIdNot(userDto.getPhoneNumber(), userDto.getId()))
                return "Bunday foydalanuvchi mavjud!";

        User user=new User();
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setFullName(userDto.getFullName());
        user.setAddress(user.getAddress());
        user.setId(userDto.getId());

        userRepository.save(user);

        return "User tahrirlandi!";

    }
}
