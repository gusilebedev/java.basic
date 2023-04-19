package practice;

import java.util.ArrayList;

public class TodoList {
    ArrayList<String> todoList = new ArrayList<>();
    public void add(String todo) {
        todoList.add(todo);
        // TODO: добавьте переданное дело в конец списка
    }
    public void add(int index, String todo) {
        if (index < todoList.size()) {
            todoList.add(index, todo);
        } else {
            todoList.add(todo);
            // TODO: добавьте дело на указаный индекс,
            //  проверьте возможность добавления
        }
    }
    public void edit(int index, String todo) {
        if(index < todoList.size()) {
            todoList.set(index, todo);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }
    public void delete(int index) {
        if(index < todoList.size()) {
            todoList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }
    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return todoList;
    }
}
