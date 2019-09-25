package matc89.exercicio3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        this.mTaskBusiness = new TaskBusiness(this);
        this.setListeners();

        //Obter ListView

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
                if(this.mViewHolder.mDescricao.getText().toString() != null && !this.mViewHolder.mDescricao.getText().toString().isEmpty()){
                    if(this.mViewHolder.mPrioridade.getText().toString() != null && !this.mViewHolder.mPrioridade.getText().toString().isEmpty()){
                        if(Integer.parseInt(this.mViewHolder.mPrioridade.getText().toString()) >= 1 && Integer.parseInt(this.mViewHolder.mPrioridade.getText().toString()) <= 10){
                            Tarefa task = new Tarefa(this.mViewHolder.mDescricao.getText().toString(), Integer.parseInt(this.mViewHolder.mPrioridade.getText().toString()));
                            this.mTaskBusiness.insert(task);
                            this.mViewHolder.mDescricao.setText("");
                            this.mViewHolder.mPrioridade.setText("");
                            this.mViewHolder.mDescricao.requestFocus();

                            taskAdapter.notifyDataSetChanged();
                            if (!mTaskBusiness.getListTasks().isEmpty()){
                                this.mViewHolder.mButtonRemover.setEnabled(true);
                            }
                        } else {
                            Toast.makeText(this,"A prioridade deve estar entre 1 e 10.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else {
                       // Toast.makeText(this,"Campo prioridade é obrigatório",Toast.LENGTH_SHORT).show();
                        this.mViewHolder.mPrioridade.setError("Campo prioridade é obrigatório");
                }
                } else {
                    //Toast.makeText(this,"Campo descrição é obrigatório",Toast.LENGTH_SHORT).show();
                    this.mViewHolder.mDescricao.setError("Campo descrição é obrigatório");
                }


                break;
        }
    }

    private class ViewHolder{
        public ListView mListView;
        public Button mButtonRemover;
        public Button mButtonAdicionar;
        public EditText mDescricao;
        public EditText mPrioridade;

        public ViewHolder(Activity activity){
            this.mListView = activity.findViewById(R.id.listView);
            this.mButtonRemover = (Button)activity.findViewById(R.id.buttonRemover);
            this.mButtonAdicionar = (Button)activity.findViewById(R.id.buttonAdicionar);
            this.mDescricao = (EditText) findViewById(R.id.editDescricao);
            this.mPrioridade = (EditText) findViewById(R.id.editPrioridade);
        }

    }
}
