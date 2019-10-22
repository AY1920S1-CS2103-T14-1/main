package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ASSIGNMENTS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_STUDENTS;

public class RedoCommand extends Command {

    public static final String COMMAND_WORD = "redo";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Redo the previous undone command ";

    public static final String MESSAGE_REDO_SUCCESS = "Redo success!";
    public static final String MESSAGE_REDO_FAILURE = "There is no action to redo!";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (!model.canRedo()) {
            throw new CommandException(MESSAGE_REDO_FAILURE);
        }
        model.redo();
        model.updateFilteredStudentList(PREDICATE_SHOW_ALL_STUDENTS);
        model.updateFilteredAssignmentList(PREDICATE_SHOW_ALL_ASSIGNMENTS);
        return new CommandResult(MESSAGE_REDO_SUCCESS);
    }
}
