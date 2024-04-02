package Manager;

import Domain.Epic;
import Domain.Meeting;
import Domain.SimpleTask;
import Domain.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindNone() {
        Todos todos = new Todos();
        Task[] expected = {};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }


// testing search method

    @Test
    public void shouldSearchMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Выкатка 3й версии приложения";


        Task[] expected = {meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Яйцо";


        Task[] expected = {epic};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Call to parents";


        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingAndSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Выкатка 3й версии приложения");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Выкатка 3й версии приложения";


        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTwoMeetingAndEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Выкатка 3й версии приложения");

        String[] subTasks = {"Приложение НетоБанка", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meetingMonday = new Meeting(
                556,
                "Important Встреча акционеров",
                "Приложение НетоБанка",
                "Monday 12:00"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(meetingMonday);

        String query = "Приложение НетоБанка";


        Task[] expected = {epic, meeting, meetingMonday};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTwoMeetingEpicSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Приложение НетоБанка");

        String[] subTasks = {"Приложение НетоБанка", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meetingMonday = new Meeting(
                556,
                "Important Встреча акционеров",
                "Приложение НетоБанка",
                "Monday 12:00"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(meetingMonday);

        String query = "Приложение НетоБанка";


        Task[] expected = {simpleTask, epic, meeting, meetingMonday};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchNone() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subTasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "What a wonderful day";


        Task[] expected = {};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }


}