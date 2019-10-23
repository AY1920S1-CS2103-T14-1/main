package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.assignment.Assignment;
import seedu.address.model.lesson.Lesson;
import seedu.address.model.student.Student;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Student> PREDICATE_SHOW_ALL_STUDENTS = unused -> true;
    Predicate<Assignment> PREDICATE_SHOW_ALL_ASSIGNMENTS = unused -> true;
    Predicate<Lesson> PREDICATE_SHOW_ALL_LESSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a student with the same identity as {@code student} exists in the address book.
     */
    boolean hasStudent(Student student);
    boolean hasAssignment(Assignment assignment);
    /**
     * Deletes the given student.
     * The student must exist in the address book.
     */
    void deleteStudent(Student target);
    void deleteAssignment(Assignment target);
    /**
     * Adds the given student.
     * {@code student} must not already exist in the address book.
     */
    void addStudent(Student student);
    void addAssignment(Assignment assignment);
    /**
     * Replaces the given student {@code target} with {@code editedStudent}.
     * {@code target} must exist in the address book.
     * The student identity of {@code editedStudent} must not be the same as another existing student in the address
     * book.
     */
    void setStudent(Student target, Student editedStudent);
    void setAssignment(Assignment target, Assignment editedAssignment);
    /** Returns an unmodifiable view of the filtered student list */
    ObservableList<Student> getFilteredStudentList();
    ObservableList<Assignment> getFilteredAssignmentList();
    ObservableList<Lesson> getFilteredLessonList();
    /**
     * Updates the filter of the filtered student list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStudentList(Predicate<Student> predicate);

    void updateFilteredAssignmentList(Predicate<Assignment> predicate);

    void updateFilteredLessonList(Predicate<Lesson> predicate);

    /**
     * Adds the given lesson.
     * @param lesson lesson object.
     */
    void addLesson(Lesson lesson);

    /**
     * Returns true if a lesson with the same identity exists in the addressbook.
     * @param lesson lesson object.
     */
    boolean hasLesson(Lesson lesson);

    /**
     * Deletes the given lesson.
     * The lesson must exist in the address book.
     */
    void deleteLesson(Lesson target);

    /**
     * Replaces the given lesson {@code target} with {@code editedLesson}.
     * {@code target} must exist in the address book.
     * The lesson identity of {@code editedLesson} must not be the same as another existing lesson in the address
     * book.
     */
    void setLesson(Lesson target, Lesson editedLesson);
}
