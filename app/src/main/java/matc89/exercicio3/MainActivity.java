package matc89.exercicio3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ViewHolder mViewHolder;
private List<Tarefa> mListTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obter ListView
        this.mViewHolder = new ViewHolder(this);
        this.mListTarefa = new ArrayList<>();
        this.mListTarefa.add(new Tarefa("Tarefa 1",3));
        this.mListTarefa.add(new Tarefa("Tarefa 2",1));
        this.mListTarefa.add(new Tarefa("Tarefa 3",5));
        this.mListTarefa.add(new Tarefa("Tarefa 1",3));
        this.mListTarefa.add(new Tarefa("Tarefa 2",1));
        this.mListTarefa.add(new Tarefa("Tarefa 3",5));
        this.mListTarefa.add(new Tarefa("Tarefa 1",3));
        this.mListTarefa.add(new Tarefa("Tarefa 2",1));
        this.mListTarefa.add(new Tarefa("Tarefa 3",5));
        this.mListTarefa.add(new Tarefa("Tarefa 1",3));
        this.mListTarefa.add(new Tarefa("Tarefa 2",1));
        this.mListTarefa.add(new Tarefa("Tarefa 3",5));
        this.mListTarefa.add(new Tarefa("Tarefa 1",3));
        this.mListTarefa.add(new Tarefa("Tarefa 2",1));
        this.mListTarefa.add(new Tarefa("Tarefa 3",5));
        this.mListTarefa.add(new Tarefa("Tarefa 1",3));
        this.mListTarefa.add(new Tarefa("Tarefa 2",1));
        this.mListTarefa.add(new Tarefa("Tarefa 3",5));
        this.mListTarefa.add(new Tarefa("Tarefa 1",3));
        this.mListTarefa.add(new Tarefa("Tarefa 2",1));
        this.mListTarefa.add(new Tarefa("Tarefa 3",5));

        //Obter Adapter
        TaskAdapter taskAdapter;
        taskAdapter = new TaskAdapter(mListTarefa, this);
        this.mViewHolder.mListView.setAdapter(taskAdapter);
    }

    private class ViewHolder{
        public ListView mListView;

        public ViewHolder(Activity activity){
            this.mListView = activity.findViewById(R.id.listView);
        }

    }
}
