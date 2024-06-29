/*Author: Kendall Ferebee
* CS320: Software Test, Automation QA
* 4-1 Milestone: Task Service
*/


package Task;

public class Task {
    // Task ID is final and cannot be changed after initialization
    private final String taskId;
    private String name;
    private String description;

    // Constructor for initializing a Task object with taskId, name, and description
    public Task(String taskId, String name, String description) {
        // Validate task ID: it should not be null and must be 10 characters or less
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        // Validate name: it should not be null and must be 20 characters or less
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        // Validate description: it should not be null and must be 50 characters or less
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getter for taskId
    public String getTaskId() {
        return taskId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name with validation
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description with validation
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
