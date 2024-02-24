package TaskTest;

import TaskService.Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void constructor_ValidInput_TaskCreatedSuccessfully() {
        // Arrange
        String taskId = "123";
        String name = "TaskName";
        String description = "TaskDescription";

        // Act
        Task task = new Task(taskId, name, description);

        // Assert
        assertEquals(taskId, task.getTaskId());
        assertEquals(name, task.getName());
        assertEquals(description, task.getDescription());
    }

    @Test
    void constructor_InvalidInput_ThrowsIllegalArgumentException() {
        // Arrange
        String invalidTaskId = "12345678901";
        String validName = "TaskName";
        String validDescription = "TaskDescription";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Task(invalidTaskId, validName, validDescription));
    }

    @Test
    void setName_ValidName_NameSetSuccessfully() {
        // Arrange
        Task task = new Task("123", "TaskName", "TaskDescription");
        String newName = "NewTaskName";

        // Act
        task.setName(newName);

        // Assert
        assertEquals(newName, task.getName());
    }

    @Test
    void setName_InvalidName_ThrowsIllegalArgumentException() {
        // Arrange
        Task task = new Task("123", "TaskName", "TaskDescription");
        String invalidName = "InvalidTaskNameWithLengthGreaterThan20Characters";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> task.setName(invalidName));
    }

    @Test
    void setDescription_ValidDescription_DescriptionSetSuccessfully() {
        // Arrange
        Task task = new Task("123", "TaskName", "TaskDescription");
        String newDescription = "NewTaskDescription";

        // Act
        task.setDescription(newDescription);

        // Assert
        assertEquals(newDescription, task.getDescription());
    }

    @Test
    void setDescription_InvalidDescription_ThrowsIllegalArgumentException() {
        // Arrange
        Task task = new Task("123", "TaskName", "TaskDescription");
        String invalidDescription = "InvalidTaskDescriptionWithLengthGreaterThan50Characters";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(invalidDescription));
    }
}
