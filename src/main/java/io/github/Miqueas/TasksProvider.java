package io.github.Miqueas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TasksProvider {
  private final PropertyChangeSupport notifier;
  private final List<TaskModel> tasks;

  public TasksProvider() {
    notifier = new PropertyChangeSupport(this);
    tasks = new ArrayList<TaskModel>();
  }

  public List<TaskModel> getTasks() {
    return tasks;
  }

  public void onChange(PropertyChangeListener listener) {
    notifier.addPropertyChangeListener(listener);
  }

  public void addTask(String text, boolean done) {
    TaskModel task = new TaskModel(tasks.size(), text, done);
    tasks.add(task);
    notifier.firePropertyChange("tasks", null, tasks);
  }

  public void removeTask(int id) {
    tasks.removeIf(task -> task.id() == id);
    notifier.firePropertyChange("tasks", null, tasks);
  }

  public void setDone(int id, boolean done) {
    tasks.replaceAll(task -> {
      if (task.id() == id) {
        return new TaskModel(task.id(), task.text(), done);
      }

      return task;
    });

    notifier.firePropertyChange("tasks", null, tasks);
  }
}