package ru.netology.javaqa.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить");
        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean expected = true;
        boolean actual = simpleTask.matches("звон");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesSimpleTaskNegative() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить");
        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean expected = false;
        boolean actual = simpleTask.matches("купить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Todos todos = new Todos();
        Epic epic = new Epic(55, subtasks);
        todos.add(epic);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesEpicNegative() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Todos todos = new Todos();
        Epic epic = new Epic(55, subtasks);
        todos.add(epic);

        boolean expected = false;
        boolean actual = epic.matches("Булка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesMeetingToTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesMeetingToProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesMeetingNegative() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = false;
        boolean actual = meeting.matches("нетслов");

        Assertions.assertEquals(expected, actual);
    }
}