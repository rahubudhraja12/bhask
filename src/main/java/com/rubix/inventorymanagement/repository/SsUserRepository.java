package com.rubix.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.inventorymanagement.domain.SsUser;

@Repository
public interface SsUserRepository extends JpaRepository<SsUser, Long> {

	SsUser findByUserId(long userId);
	
	@Query(value = "SELECT * from ss_user  WHERE  User_id=:userId and group_id=:groupId", nativeQuery = true)
	SsUser findByGroupIdAndUserId(@Param("userId")long groupId,@Param("groupId") long userId);

}
