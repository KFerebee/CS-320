/*Author: Kendall Ferebee
* CS320: Software Test, Automation QA
* 4-1 Milestone: Task Service
*/


package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService service;
    private Task task;
    private String id;
    private String name;
    private String description;
    private String tooLongName;
    private String tooLongDescription;

    @BeforeEach
    void setUp() {
        service = new TaskService();
        id = "1234567890";
        name = "Valid Task Name";
        description = "Valid description for task.";
        tooLongName = "This name is way too long to be valid";
        tooLongDescription = "This description is way too long to be valid and should throw an exception when trying to create a task with it.";
        task = new Task(id, name, description);
    }

    // Test adding a task
    @Test
    public void testAddTask() {
        assertTrue(service.addTask(task)); // Task should be added successfully
    }

    // Test adding a duplicate task
    @Test
    public void testAddDuplicateTask() {
        service.addTask(task);
        assertFalse(service.addTask(task)); // Duplicate ID should not be allowed
    }

    // Test deleting a task
    @Test
    public void testDeleteTask() {
        service.addTask(task);
        assertTrue(service.deleteTask(id)); // Task should be deleted successfully
    }

    // Test deleting a non-existent task
    @Test
    public void testDeleteNonExistentTask() {
        assertFalse(service.deleteTask("nonexistent")); // Deleting non-existent task should return false
    }

    // Test updating a task's name
    @Test
    public void testUpdateTaskName() {
        service.addTask(task);
        assertTrue(service.updateTaskName(id, "NewTaskName")); // Name should be updated
        assertEquals("NewTaskName", service.getTask(id).getName()); // Verify new name
    }

    // Test updating a non-existent task's name
    @Test
    public void testUpdateNameForNonExistentTask() {
        assertFalse(service.updateTaskName("nonexistent", "NewTaskName")); // Updating non-existent task should return false
    }

    // Test updating a task's description
    @Test
    public void testUpdateTaskDescription() {
        service.addTask(task);
        assertTrue(service.updateTaskDescription(id, "NewDescription")); // Description should be updated
        assertEquals("NewDescription", service.getTask(id).getDescription()); // Verify new description
    }

    // Test updating a non-existent task's description
    @Test
    public void testUpdateDescriptionForNonExistentTask() {
        assertFalse(service.updateTaskDescription("nonexistent", "NewDescription")); // Updating non-existent task should return false
    }

    // Test getting a task
    @Test
    public void testGetTask() {
        service.addTask(task);
        Task retrievedTask = service.getTask(id);
        assertNotNull(retrievedTask); // Task should be retrieved successfully
        assertEquals(id, retrievedTask.getTaskId());
        assertEquals(name, retrievedTask.getName());
        assertEquals(description, retrievedTask.getDescription());
    }

    // Test adding a task with a non-unique ID
    @Test
    public void testAddTaskWithNonUniqueID() {
        Task task2 = new Task(id, "Task2", "Description2");
        assertTrue(service.addTask(task)); // First task should be added successfully
        assertFalse(service.addTask(task2)); // Second task with same ID should not be added
    }

    // Test creating a Task with invalid name (null or too long)
    @Test
    public void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, name, null); // Null description
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, name,  tooLongDescription); // description too long
        });
    }

    // Test creating a Task with invalid name (null or too long)
    @Test
    public void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, null, description); // Null name
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, tooLongName, description); // Name too long
        });
    }
}
