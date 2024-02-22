package com.example.doitv2.ToDoAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doitv2.AddNewTask;
import com.example.doitv2.MainActivity;
import com.example.doitv2.Model.ToDoModel;
import com.example.doitv2.R;
import com.example.doitv2.Utils.DatabaseHandler;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>{

  private List<ToDoModel> todoList;
  private MainActivity activity;

  public ToDoAdapter(MainActivity activity){
      this.activity=activity;
  }

    @NonNull
    @Override
    public ToDoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout,parent,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ToDoModel item = todoList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
    }

    @Override
    public int getItemCount() {return todoList.size();}

    private boolean toBoolean(int n){return n!=0;}

    public void setTask(List<ToDoModel> todoList){
      this.todoList = todoList;
      notifyDataSetChanged();
    }

    public Context getContext(){
      return activity;
    }

    public void setTasks(List<ToDoModel> todoList){
      this.todoList = todoList;
    }

    public void deleteItem(int position) {
        ToDoModel item = todoList.get(position);
        todoList.remove(position);
        notifyItemRemoved(position);
    }

    public void editItem(int position) {
        ToDoModel item = todoList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("task", item.getTask());
        AddNewTask fragment = new AddNewTask();
        fragment.setArguments(bundle);
        fragment.show(activity.getSupportFragmentManager(), AddNewTask.TAG);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
      CheckBox task;

      ViewHolder(View view){
          super(view);
          task = view.findViewById(R.id.todoCheckBox);
      }
    }
}
