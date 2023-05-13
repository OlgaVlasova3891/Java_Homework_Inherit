package ru.netology.javaqa.javamvninherit.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testTrueMatchesForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("родителям");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFalseMatchesForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("другу");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTrueMatchesForEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Молоко");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFalseMatchesForEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Творог");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTrueMatchesForMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("НетоБанк");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTrueMatchesForMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("версии");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFalseMatchesForMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Версия");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testFalseMatchesForMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Сбербанк");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTaskId() {
        Task task = new Task(4);
        int expected = 4;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTitle() {
        SimpleTask newTask = new SimpleTask(5, "Позвонить другу");
        String expected = "Позвонить другу";
        String actual = newTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasks() {
        Epic epic = new Epic(8, new String[]{"Молоко", "Яйца", "Хлеб"});
        String[] expected = new String[]{"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTopic() {
        Meeting meeting = new Meeting(5, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetProject() {

        Meeting meeting = new Meeting(5, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStart() {

        Meeting meeting = new Meeting(5, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

}
