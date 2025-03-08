package com.example.Spring_boot.Task2.Service;

import com.example.Spring_boot.Task2.Entity.Workspace;
import com.example.Spring_boot.Task2.Repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public List<Workspace> getWorkspacesByType(String type) {
        return workspaceRepository.findWorkspacesByType(type);
    }

    public List<Workspace> getWorkspacesByLocation(String location) {
        return workspaceRepository.findWorkspacesByLocation(location);
    }
}
