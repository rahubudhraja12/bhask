package com.rubix.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubix.inventorymanagement.domain.SsGroup;

@Repository
public interface SsGroupRepository extends JpaRepository<SsGroup, Long> {

	SsGroup findByGroupId(long groupId);

	@Query(value = "SELECT * from ss_group  WHERE  role_id=:roleId and group_id=:groupId", nativeQuery = true)
	SsGroup findByRoleIdAndGroupId(@Param("roleId")long roleId,@Param("groupId")long groupId);
	

}
