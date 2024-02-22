package com.example.doitv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.doitv2.Model.ToDoModel;
import com.example.doitv2.ToDoAdapter.ToDoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogCloseListener{

    private RecyclerView tasksReycleview;
    private ToDoAdapter tasksAdapter;
    private FloatingActionButton fab;

    private List<ToDoModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        taskList = new ArrayList<>();

        tasksReycleview = findViewById(R.id.tasksRecyclerView);
        tasksReycleview.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdapter(this);
        tasksReycleview.setAdapter(tasksAdapter);

        fab = findViewById(R.id.fab);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelper(tasksAdapter));
        itemTouchHelper.attachToRecyclerView(tasksReycleview);

        Collections.reverse(taskList);
        tasksAdapter.setTask(taskList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });

        ToDoModel task = new ToDoModel();
        ToDoModel task1 = new ToDoModel();
        ToDoModel task2 = new ToDoModel();
        ToDoModel task3 = new ToDoModel();
        ToDoModel task4 = new ToDoModel();

        task.setTask("Clean the Bedroom");
        task1.setTask("IOT Homework");
        task2.setTask("Go to Gym");
        task3.setTask("Learn German Words");
        task4.setTask("Sleep Well at 10");

        task.setStatus(0);
        task1.setStatus(0);
        task2.setStatus(0);
        task3.setStatus(0);
        task4.setStatus(0);

        task.setId(1);
        task1.setId(1);
        task2.setId(1);
        task3.setId(1);
        task4.setId(1);

        taskList.add(task);
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);

        tasksAdapter.setTask(taskList);
    }
    @Override
    public void handleDialogClose(DialogInterface dialog){
        Collections.reverse(taskList);
        tasksAdapter.setTask(taskList);
        tasksAdapter.notifyDataSetChanged();
    }
}