import com.groupone.taskmanagementsystem.TaskManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    private TaskManager taskManager;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAddTask() {
        // Capture output from addTask
        taskManager.addTask("Test Task");
        String addOutput = outputStream.toString().trim();
        assertTrue(addOutput.contains("Task added."), "Should print 'Task added.'");

        // Reset output stream and capture output from listTasks
        outputStream.reset();
        taskManager.listTasks();
        String listOutput = outputStream.toString().trim();
        assertEquals("Task 1: Test Task", listOutput, "Should list the added task");
    }

    @Test
    public void testRemoveTask() {
        taskManager.addTask("Task to Remove");
        outputStream.reset();
        taskManager.removeTask(1);
        assertTrue(outputStream.toString().contains("Task removed."));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}