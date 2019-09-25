package matc89.exercicio3;

import java.util.List;

public class TaskBusiness {
    private TaskRepository repository;

    public TaskBusiness(){
        this.repository = TaskRepository.getInstance();
    }

    public void insert (Tarefa task){
        this.repository.getListaTarefas().add(task);
    }

    public void remove (Tarefa task){
        this.repository.getListaTarefas().remove(task);
    }

    public void remove (){
        if (!this.repository.getListaTarefas().isEmpty()) {
            this.repository.getListaTarefas().remove(0);
        }
    }

    public List<Tarefa> getListTasks() {
        return (List<Tarefa>) repository.getListaTarefas();
    }
}
