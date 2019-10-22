package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.scheduler.Reminder;
import seedu.address.model.student.Student;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the students list.
     * This list will not contain any duplicate students.
     */
    ObservableList<Student> getStudentList();
    /**
     * Returns unmodifiable view of reminders list
     * will not contain duplicate reminders
     */
    ObservableList<Reminder> getReminderList();

}
