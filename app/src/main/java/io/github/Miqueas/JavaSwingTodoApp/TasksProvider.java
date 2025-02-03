package io.github.Miqueas.JavaSwingTodoApp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TasksProvider {
  private static TasksProvider instance;

  private final PropertyChangeSupport notifier;
  private final List<TaskModel> tasks;

  public TasksProvider() {
    tasks = new ArrayList<TaskModel>();
    notifier = new PropertyChangeSupport(this);
  }

  public static TasksProvider getInstance() {
    if (instance == null) {
      instance = new TasksProvider();
    }

    return instance;
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
    notifier.firePropertyChange("add", null, tasks);
  }

  public void removeTask(int id) {
    tasks.removeIf(task -> task.id() == id);
    notifier.firePropertyChange("remove", null, tasks);
  }

  public void setDone(int id, boolean done) {
    tasks.replaceAll(task -> {
      if (task.id() == id) {
        return new TaskModel(task.id(), task.text(), done);
      }

      return task;
    });

    notifier.firePropertyChange("update", null, tasks);
  }
}