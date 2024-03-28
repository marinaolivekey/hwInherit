package Manager;
import Domain.Epic;
import Domain.Meeting;
import Domain.Task;

import Domain.SimpleTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic (55, subTasks);

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
        Epic epic = new Epic (55, subTasks);

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


        Task[] expected ={meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic (55, subTasks);

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


        Task[] expected ={epic};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Call to parents");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic (55, subTasks);

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


        Task[] expected ={simpleTask};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingAndSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Выкатка 3й версии приложения");

        String[] subTasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic (55, subTasks);

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


        Task[] expected ={simpleTask, meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }



}