package io.github.Miqueas;

import javax.swing.*;
import java.awt.*;

public class TaskItem extends JPanel {
  private final TasksProvider provider;
  private final TaskModel task;

  public TaskItem(TaskModel taskModel, TasksProvider tasksProvider) {
    task = taskModel;
    provider = tasksProvider;
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));

    JCheckBox checkbox = new JCheckBox(task.text(), task.done());
    checkbox.addActionListener(ev -> {});

    JButton deleteButton = new JButton("X");
    deleteButton.setFont(Fonts.bold);
    deleteButton.addActionListener(ev -> {
      provider.removeTask(task.id());
    });

    add(checkbox);
    add(Box.createHorizontalGlue());
    add(deleteButton);
  }
}