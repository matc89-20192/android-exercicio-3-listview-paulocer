package matc89.exercicio3;

import android.content.Context;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class TaskBusiness {
    private TaskRepository repository;
    private Context mContext;

    public TaskBusiness(Context context){
        this.repository = TaskRepository.getInstance();
        this.mContext = context;
    }

    public void insert (Tarefa task){
        for (Tarefa taskAux : this.getListTasks()){
            if(taskAux.getDescricao().equalsIgnoreCase(task.getDescricao())){
                Toast.makeText(this.mContext,"Tarefa já cadastrada.", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        if(task.getPrioridade() < 1 || task.getPrioridade() > 10){
            Toast.makeText(this.mContext,"A prioridade deve estar entre 1 e 10.", Toast.LENGTH_SHORT).show();
            return;
        }

        this.repository.getListaTarefas().add(task);
        //Ordenar
        Collections.sort(this.getListTasks());

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
