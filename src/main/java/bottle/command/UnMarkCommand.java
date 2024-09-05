package bottle.command;

import bottle.Storage;
import bottle.Ui;
import bottle.task.TaskList;

/**
 * The type Un mark command.
 */
public class UnMarkCommand extends Command {
    /**
     * The Task index.
     */
    private final int taskIndex;

    /**
     * Instantiates a new Un mark command.
     *
     * @param taskIndex the task index
     */
    public UnMarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.getTask(taskIndex).unMark();
        storage.saveTasks(taskList.getTaskList());
        return ui.printUnMark(taskList.getTask(taskIndex));
    }
}
