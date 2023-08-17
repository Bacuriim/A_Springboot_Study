package com.br.einstein.files.facade;

import com.br.einstein.files.dto.TaskDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class FacadeTasks {
    private static final Map<Long, TaskDTO> tasks = new HashMap();

    public FacadeTasks() {
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        Long nextId = (long)tasks.keySet().size() + 1L;
        taskDTO.setId(nextId);
        tasks.put(nextId, taskDTO);
        return taskDTO;
    }

    public TaskDTO updateTask(TaskDTO taskDTO, Long taskId) {
        tasks.put(taskId, taskDTO);
        return taskDTO;
    }

    public String deleteTask(TaskDTO taskDTO, Long taskId) {
        tasks.remove(taskId);
        return "Task has been removed!";
    }

    public TaskDTO getById(Long taskId) {
        return (TaskDTO)tasks.get(taskId);
    }

    public List<TaskDTO> getAll() {
        return new ArrayList(tasks.values());
    }
}
