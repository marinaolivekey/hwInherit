package Manager;

import Domain.Task;

public class Todos {

    private Task[] tasks = new Task[0];

    // Вспомогательный метод добавления задачи в массив задач
    private Task[] addToArray(Task[] current, Task task) {

        Task[] tmp = new Task[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    // Метод добавления задачи в список дел

    public void add(Task task) {
        tasks = addToArray(tasks, task);
    }

    public Task[] findAll() {
        return tasks;
    }

    // Метод поиска задач, которые подходят под поисковый запрос

    public Task[] search(String query) {
        Task[] result = new Task[0];
        for (Task task : tasks) {
            if (task.matches(query)) {
                result = addToArray(result, task);
            }
        }
        return result;
    }

}
