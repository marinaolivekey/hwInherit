package Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    //  Meeting

    @Test
    public void matchesInMeetingIfNone() {
        Meeting meeting = new Meeting(
                556,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Выкатка 1й версии приложения";
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(false, actual);
    }

    @Test
    public void matchesInMeetingIfTopic() {
        Meeting meeting = new Meeting(
                556,
                "Выкатка 1й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Выкатка 1й версии приложения";
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(true, actual);
    }

    @Test
    public void matchesInMeetingIfProject() {
        Meeting meeting = new Meeting(
                556,
                "Выкатка 1й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String query = "Приложение НетоБанка";
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(true, actual);
    }


    //  Epic

    @Test
    public void matchesInEpicIfNone() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(56, subtasks);

        String query = "Приложение НетоБанка";
        boolean actual = epic.matches(query);
        Assertions.assertEquals(false, actual);
    }

    @Test
    public void matchesInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(56, subtasks);

        String query = "Молоко";
        boolean actual = epic.matches(query);
        Assertions.assertEquals(true, actual);
    }

    //  SimpleTask

    @Test
    public void matchesInSimpleTaskIfNone() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String query = "Молоко";
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(false, actual);
    }

    @Test
    public void matchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String query = "Call to parents";
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(true, actual);
    }


}