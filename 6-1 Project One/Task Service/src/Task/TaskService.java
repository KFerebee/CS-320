/*Author: Kendall Ferebee
* CS320: Software Test, Automation QA
* 4-1 Milestone: Task Service
*/


package Task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // HashMap to store tasks with their taskId as the key
    private final Map<String, Task> tasks;

    // Constructor initializing the tasks map
    public TaskService() {
        tasks = new HashMap<>();
    }

    // Method to add a task if the taskId is unique
    public boolean addTask(Task task) {
        // Check if taskId already exists
        if (tasks.containsKey(task.getTaskId())) {
            return false;
        }
        // Add task to the map
        tasks.put(task.getTaskId(), task);
        return true;
    }

    // Method to delete a task by taskId
    public boolean deleteTask(String taskId) {
        // Check if taskId exists
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
            return true;
        }
        return false;
    }

    // Method to update the name of a task by taskId
    public boolean updateTaskName(String taskId, String name) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setName(name);
            return true;
        }
        return false;
    }

    // Method to update the description of a task by taskId
    public boolean updateTaskDescription(String taskId, String description) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setDescription(description);
            return true;
        }
        return false;
    }

    // Method to retrieve a task by taskId
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
