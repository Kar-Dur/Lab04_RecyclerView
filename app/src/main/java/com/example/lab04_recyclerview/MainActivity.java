package com.example.lab04_recyclerview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private EditText groupInput;

    private final List<Task> taskList = new ArrayList<>();
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        groupInput = findViewById(R.id.groupInput);

        Button saveButton = findViewById(R.id.saveButton);
        RecyclerView taskListView = findViewById(R.id.taskListView);

        taskList.add(new Task("Nauka na sprawdzian", "Szkoła"));
        taskList.add(new Task("Nakarmić psa", "Pies"));

        taskAdapter = new TaskAdapter(taskList);

        taskListView.setLayoutManager(new LinearLayoutManager(this));
        taskListView.setAdapter(taskAdapter);

        saveButton.setOnClickListener(view -> saveTask());
    }

    private void saveTask() {
        String name = nameInput.getText().toString().trim();
        String group = groupInput.getText().toString().trim();

        if (name.isEmpty()) {
            nameInput.setError("Wpisz nazwę zadania");
            nameInput.requestFocus();
            return;
        }

        if (group.isEmpty()) {
            group = "Pozostałe";
        }

        Task newTask = new Task(name, group);
        int newPosition = taskList.size();

        taskList.add(newTask);
        taskAdapter.notifyItemInserted(newPosition);

        nameInput.setText("");
        groupInput.setText("");
        nameInput.requestFocus();

        Toast.makeText(
                this,
                "Zadanie dodane do listy",
                Toast.LENGTH_SHORT
        ).show();
    }
}