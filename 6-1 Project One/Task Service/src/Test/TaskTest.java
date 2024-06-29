/*Author: Kendall Ferebee
* CS320: Software Test, Automation QA
* 4-1 Milestone: Task Service
*/

package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Task.Task;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private String id;
    private String name;
    private String description;
    private String tooLongId;
    private String tooLongName;
    private String tooLongDescription;
    private Task validTask;

    @BeforeEach
    void setUp() {
        id = "1234567890";
        name = "Valid Task Name";
        description = "Valid description for task.";
        tooLongId = "12345678901"; // 11 characters
        tooLongName = "This name is way too long to be valid";
        tooLongDescription = "This description is way too long to be valid and should throw an exception when trying to create a task with it.";
        validTask = new Task(id, name, description);
    }

    // Test creating a valid Task
    @Test
    public void testValidTaskCreation() {
        assertEquals(id, validTask.getTaskId());
        assertEquals(name, validTask.getName());
        assertEquals(description, validTask.getDescription());
    }

    // Test creating a Task with invalid taskId (null or too long)
    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, name, description); // Null taskId
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(tooLongId, name, description); // taskId too long
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

    // Test creating a Task with invalid description (null or too long)
    @Test
    public void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, name, null); // Null description
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, name, tooLongDescription); // Description too long
        });
    }

    // Test updating the name of a Task with valid and invalid values
    @Test
    public void testUpdateName() {
        validTask.setName("NewTaskName");
        assertEquals("NewTaskName", validTask.getName());

        // Test setting name to null or too long
        assertThrows(IllegalArgumentException.class, () -> {
            validTask.setName(null); // Null name
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validTask.setName("ThisNameIsWayTooLongToBeValid"); // Name too long
        });
    }

    // Test updating the description of a Task with valid and invalid values
    @Test
    public void testUpdateDescription() {
        validTask.setDescription("NewTaskDescription");
        assertEquals("NewTaskDescription", validTask.getDescription());

        // Test setting description to null or too long
        assertThrows(IllegalArgumentException.class, () -> {
            validTask.setDescription(null); // Null description
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validTask.setDescription("ThisDescriptionIsWayTooLongToBeValidAndShouldThrowAnException"); // Description too long
        });
    }

    // Boundary value tests for task ID
    @Test
    public void testBoundaryTaskId() {
        // 10 characters (valid)
        Task taskWithBoundaryId = new Task("1234567890", name, description);
        assertNotNull(taskWithBoundaryId);

        // 11 characters (invalid)
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", name, description);
        });
    }

    // Boundary value tests for task name
    @Test
    public void testBoundaryTaskName() {
        // 20 characters (valid)
        Task taskWithBoundaryName = new Task(id, "12345678901234567890", description);
        assertNotNull(taskWithBoundaryName);

        // 21 characters (invalid)
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, "123456789012345678901", description);
        });
    }

    // Boundary value tests for task description
    @Test
    public void testBoundaryTaskDescription() {
        // 50 characters (valid)
        Task taskWithBoundaryDescription = new Task(id, name, "12345678901234567890123456789012345678901234567890");
        assertNotNull(taskWithBoundaryDescription);

        // 51 characters (invalid)
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, name, "123456789012345678901234567890123456789012345678901");
        });
    }
}
