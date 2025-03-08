package com.example.Spring_boot.Task2.Repository;

import com.example.Spring_boot.Task2.Entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    // İş yerini növünə görə tapır
    @Query("SELECT w FROM Workspace w WHERE w.type = :type")
    List<Workspace> findWorkspacesByType(@Param("type") String type);


    // İş yerini yerləşdiyi yerə görə tapır
    @Query("SELECT w FROM Workspace w WHERE w.location = :location")
    List<Workspace> findWorkspacesByLocation(@Param("location") String location);
}
