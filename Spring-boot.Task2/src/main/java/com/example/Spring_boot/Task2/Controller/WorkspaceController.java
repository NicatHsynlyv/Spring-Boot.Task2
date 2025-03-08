package com.example.Spring_boot.Task2.Controller;

import com.example.Spring_boot.Task2.Entity.Workspace;
import com.example.Spring_boot.Task2.Enum.WorkspaceType;
import com.example.Spring_boot.Task2.Service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Workspace>> getWorkspacesByType(@PathVariable String type) {
        return ResponseEntity.ok(workspaceService.getWorkspacesByType(type));
    }

    @GetMapping("/location/{location}")
    public List<Workspace> getWorkspacesByLocation(@PathVariable String location) {
        return workspaceService.getWorkspacesByLocation(location);
    }
//task2
    @GetMapping("/type/{type}")
    public List<Workspace> getworkspacesByType(@PathVariable WorkspaceType workspaceType) {
        return workspaceService.getWorkspacesByType(String.valueOf(workspaceType));
    }
}
