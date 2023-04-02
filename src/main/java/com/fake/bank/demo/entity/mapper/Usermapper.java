package com.fake.bank.demo.entity.mapper;

import org.springframework.beans.BeanUtils;

import com.fake.bank.demo.dto.UserDTO;
import com.fake.bank.demo.user.Users;

/**
 * 
 * @author USER
 *	Copying Data from DTO to Entity class and vice versa
 */
public class Usermapper extends BaseMapper<Users, UserDTO>{

	@Override
	public Users convertToEntity(UserDTO dto, Object... args) {
		// TODO Auto-generated method stub
		Users users = new Users();
		 if (dto != null) {
	            BeanUtils.copyProperties(dto, users);
	        }
	        return users;
	}

	@Override
	public UserDTO convertToDto(Users entity, Object... args) {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		if (entity != null) {
            BeanUtils.copyProperties(entity, userDTO);
        }
        return userDTO;
	}
}
