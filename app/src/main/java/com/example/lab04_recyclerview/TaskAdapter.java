package com.example.lab04_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private final List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);

        return new TaskHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        Task currentTask = taskList.get(position);

        holder.nameLabel.setText(currentTask.getName());
        holder.groupLabel.setText(currentTask.getGroupName());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskHolder extends RecyclerView.ViewHolder {

        TextView nameLabel;
        TextView groupLabel;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            nameLabel = itemView.findViewById(R.id.nameLabel);
            groupLabel = itemView.findViewById(R.id.groupLabel);
        }
    }
}