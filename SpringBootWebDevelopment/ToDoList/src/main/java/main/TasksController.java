package main;
import main.model.TaskRepository;
import main.model.TypeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TasksController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping(value = "/tasks/",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity add(@RequestBody Task taskBody) {
        Task task = new Task();
        task.setCreationTime(LocalDateTime.now().withNano(0));
        task.setIsDone(TypeStatus.NOT_COMPLETED);
        task.setTitle(taskBody.getTitle());
        task.setDescription(taskBody.getDescription());
        taskRepository.save(task);
        Optional <Task> optionalTask = taskRepository.findById(task.getId());
        if(!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return new ResponseEntity<>(optionalTask.get(),HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional <Task> optionalTask = taskRepository.findById(id);
        if(!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optionalTask.get(),HttpStatus.OK);
    }


    @GetMapping("/tasks/")
    public List<Task> getToDoList() {
        Iterable<Task> toDoIterable = taskRepository.findAll();
        ArrayList <Task> tasks = new ArrayList<>();
        for(Task task : toDoIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @PatchMapping("/tasks/{id}")
    public ResponseEntity edit(@PathVariable int id, @RequestBody Task taskBody) {
        Optional <Task> optionalTask = taskRepository.findById(id);
        if(!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if(taskBody.getIsDone() != null) {
            optionalTask.get().setIsDone(taskBody.getIsDone());
        }
        if(taskBody.getTitle() != null) {
            optionalTask.get().setTitle(taskBody.getTitle());
        }
        if (taskBody.getDescription() != null) {
            optionalTask.get().setDescription(taskBody.getDescription());
        }
        taskRepository.save(optionalTask.get());
        return new ResponseEntity<>(optionalTask.get(),HttpStatus.OK);
    }


    @DeleteMapping("/tasks/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        taskRepository.deleteById(id);
        Optional <Task> optionalTask = taskRepository.findById(id);
        if(!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return new ResponseEntity<>(optionalTask.get(),HttpStatus.BAD_REQUEST);
    }
}
