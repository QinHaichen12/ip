package bottle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bottle.task.Task;
import bottle.task.TaskList;
import bottle.task.Todo;

/**
 * The type Ui test.
 */
public class UiTest {
    /**
     * The Ui.
     */
    private Ui ui;
    /**
     * The Output stream.
     */
    private ByteArrayOutputStream outputStream;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        ui = new Ui();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Tear down.
     */
    @AfterEach
    public void tearDown() {
        System.setIn(System.in); // Reset System.in after the test
        System.setOut(System.out); // Reset System.out after the test (if you modify it)
    }

    /**
     * Test print task list.
     */
    @Test
    public void testPrintTaskList() {
        TaskList taskList = new TaskList();
        taskList.addTask(new Todo("Task 1"));
        taskList.addTask(new Todo("Task 2"));
        ui = new Ui();
        ui.printTaskList(taskList);
        String expectedOutput =
                "\n____________________________________________________________\n"
                        + "1. [T][ ] Task 1\n" + "2. [T][ ] Task 2\n"
                        + "\n____________________________________________________________\n\r" + "\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    /**
     * Test print mark.
     */
    @Test
    public void testPrintMark() {
        Task task = new Todo("Sample Task");
        task.mark();
        ui.printMark(task);
        String expectedOutput = "\n____________________________________________________________\n"
                + "Nice! I've marked this task as done:\n"
                + "[T][X] Sample Task"
                + "\n____________________________________________________________\n\r" + "\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

}
