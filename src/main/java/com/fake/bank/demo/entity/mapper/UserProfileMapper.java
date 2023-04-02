package com.fake.bank.demo.entity.mapper;

import org.springframework.beans.BeanUtils;

import com.fake.bank.demo.dto.UserProfileDTO;
import com.fake.bank.demo.model.UserProfile;

/**
 * 
 * @author USER
 * Copying Data from DTO to Entity class and vice versa
 */
public class UserProfileMapper extends BaseMapper<UserProfile, UserProfileDTO>{

	@Override
	public UserProfile convertToEntity(UserProfileDTO dto, Object... args) {
		// TODO Auto-generated method stub
		UserProfile userprofile = new UserProfile();
		 if (dto != null) {
	            BeanUtils.copyProperties(dto, userprofile);
	        }
		return userprofile;
	}

	@Override
	public UserProfileDTO convertToDto(UserProfile entity, Object... args) {
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		if (entity != null) {
            BeanUtils.copyProperties(entity, userProfileDTO);
        }
        return userProfileDTO;
	}

}
