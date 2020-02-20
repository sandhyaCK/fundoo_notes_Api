package com.bridgelabz.fundoonotes.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.ProfilePic;
@Repository
public interface ProfilePicRepoImple extends JpaRepository<ProfilePic,Long>{

	@Query(value = "select * from profile_pic where user_id=? ", nativeQuery = true)
	Profile findUserById(Long userId);

	

}
