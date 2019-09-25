package matc89.exercicio3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private ViewHolder mViewHolder;
private TaskBusiness mTaskBusiness;
private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder = new ViewHolder(this);
        this.mTaskBusiness = new TaskBusiness();
        this.setListeners();

        //Obter ListView

        this.mTaskBusiness.insert(new Tarefa("Tarefa 1", 1));
        this.mTaskBusiness.insert(new Tarefa("Tarefa 2", 2));

        //Obter Adapter

        taskAdapter = new TaskAdapter(mTaskBusiness.getListTasks(), this);
        this.mViewHolder.mListView.setAdapter(taskAdapter);
        this.setupActivity();
    }

    private void setupActivity() {
        if (mTaskBusiness.getListTasks().isEmpty()){
            this.mViewHolder.mButtonRemover.setEnabled(false);
        } else {
            this.mViewHolder.mButtonRemover.setEnabled(true);
        }
    }

    private void setListeners() {
        this.mViewHolder.mButtonRemover.setOnClickListener(this);
        this.mViewHolder.mButtonAdicionar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id  = view.getId();
        switch (id){
            case R.id.buttonRemover :
                this.mTaskBusiness.remove();
                taskAdapter.notifyDataSetChanged();
                if (mTaskBusiness.getListTasks().isEmpty()){
                    this.mViewHolder.mButtonRemover.setEnabled(false);
                    }
                break;
            case R.id.buttonAdicionar :
                String descricao = "Tarefa x";
                int prioridade = 1;
                this.mTaskBusiness.insert(new Tarefa(descricao, prioridade));
                taskAdapter.notifyDataSetChanged();
                this.mViewHolder.mButtonRemover.setEnabled(true);
                break;
        }
    }

    private class ViewHolder{
        public ListView mListView;
        public Button mButtonRemover;
        public Button mButtonAdicionar;

        public ViewHolder(Activity activity){
            this.mListView = activity.findViewById(R.id.listView);
            this.mButtonRemover = (Button)activity.findViewById(R.id.buttonRemover);
            this.mButtonAdicionar = (Button)activity.findViewById(R.id.buttonAdicionar);
        }

    }
}
