package matc89.exercicio3;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private static TaskRepository uniqueInstance;

    private static List<Tarefa> listaTarefas;

    private TaskRepository(){
        this.listaTarefas = new ArrayList<>();
    }

    public static synchronized TaskRepository getInstance(){

        if(uniqueInstance == null){
            uniqueInstance = new TaskRepository();
        }
        return uniqueInstance;
    }

    public List<Tarefa> getListaTarefas(){
        return listaTarefas;
    }

}
