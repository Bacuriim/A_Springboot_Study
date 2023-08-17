package com.br.einstein.files.api;

import com.br.einstein.files.facade.FacadeTasks;
import com.br.einstein.files.dto.TaskDTO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(
        value = {"/tasks"},
        produces = {"application/json"}
)
public class TasksAPI {
    @Autowired
    private FacadeTasks facadeTasks;

    public TasksAPI() {
    }

    @PostMapping
    @ResponseBody
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        return this.facadeTasks.createTask(taskDTO);
    }

    @PutMapping({"/{taskId}"})
    @ResponseBody
    public TaskDTO updateTask(@PathVariable("taskId") Long taskId, @RequestBody TaskDTO taskDTO) {
        return this.facadeTasks.updateTask(taskDTO, taskId);
    }

    @DeleteMapping({"/{taskId}"})
    @ResponseBody
    public String deleteTask(@PathVariable("taskId") Long taskId, @RequestBody TaskDTO taskDTO) {
        return this.facadeTasks.deleteTask(taskDTO, taskId);
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getAll() {
        return this.facadeTasks.getAll();
    }
}
