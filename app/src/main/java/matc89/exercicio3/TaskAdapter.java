package matc89.exercicio3;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends BaseAdapter {
    private List<Tarefa> mListTarefa;
    private Activity mActivity;

    public TaskAdapter (List<Tarefa> listTarefa, Activity activity){
        this.mListTarefa = listTarefa;
        this.mActivity = activity;
    }

    @Override
    public int getCount() {
        return mListTarefa.size();
    }

    @Override
    public Object getItem(int i) {
        return mListTarefa.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //View viewTask = mActivity.getLayoutInflater().inflate(R.layout.list_tarefa_layout,viewGroup,false);
        View viewTask = mActivity.getLayoutInflater().inflate(android.R.layout.simple_list_item_2,viewGroup,false);
        Tarefa tarefa = mListTarefa.get(i);
        TextView txtTarefa = (TextView) viewTask.findViewById(android.R.id.text1);
        TextView txtPrioridade = (TextView) viewTask.findViewById(android.R.id.text2);
        txtTarefa.setText(tarefa.getDescricao());
        txtPrioridade.setText("Prioridade: " + tarefa.getPrioridade());
        return viewTask;
    }
}
