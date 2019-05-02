package com.sasmitha.gproject.repositories;

import com.sasmitha.gproject.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RequestRepository extends JpaRepository<Request,Integer> {
    @Transactional
    @Query(value = "UPDATE Request_Table SET Request_status=2  WHERE Request_Id=:request_id",nativeQuery = true)
    void acceptRequest(@Param("request_id") Integer  request_id);

}
