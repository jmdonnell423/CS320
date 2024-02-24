package TaskTest;
import org.junit.jupiter.api.Test;

import TaskService.Task;
import TaskService.TaskService;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Test Task", "This is a test task");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("1"));
        assertThrows(IllegalStateException.class, () -> taskService.addTask(task));
    }

    @Test
    void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Test Task", "This is a test task");
        taskService.addTask(task);
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
        taskService.deleteTask("1"); // Deleting a non-existing task should not throw an exception
    }

    @Test
    void testUpdateTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Test Task", "This is a test task");
        taskService.addTask(task);
        taskService.updateTask("1", "Updated Task", "Updated Description");
        assertEquals("Updated Task", taskService.getTask("1").getName());
        assertEquals("Updated Description", taskService.getTask("1").getDescription());
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask("2", "No Task", "No Description"));
    }

    @Test
    void testGetTask() {
        TaskService taskService = new TaskService();
        assertNull(taskService.getTask("1"));
    }
}


