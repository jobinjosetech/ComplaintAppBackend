package com.nest.ComplaintAppBackend.dao;

import com.nest.ComplaintAppBackend.controller.ComplaintController;
import com.nest.ComplaintAppBackend.model.ComplaintsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<ComplaintsModel, Integer> {
    @Query(value = "SELECT c.`complaint`, c.`userid`, u.`name`, u.`email`, u.`phone`, c.`date` FROM `complaint` AS c JOIN `user` AS u ON c.userid = u.id", nativeQuery = true)
    List<Map<String, String>> GetComplaints();

    @Query(value = "SELECT c.`complaint`, c.`date` FROM `complaint` AS c JOIN `user` AS u ON c.userid = u.id WHERE c.userid = :id", nativeQuery = true)
    List<Map<String, String>> GetUserComplaint(@Param("id") Integer id);
}
