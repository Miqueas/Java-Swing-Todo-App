package io.github.Miqueas;

import javax.swing.*;
import java.awt.*;

public class TaskItem extends JPanel {
  private JCheckBox checkbox;
  private JButton deleteButton;
  private TasksProvider provider;
  private TaskModel task;


  public TaskItem(TaskModel taskModel, TasksProvider tasksProvider) {
    task = taskModel;
    provider = tasksProvider;
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));

    checkbox = new JCheckBox(task.text(), task.done());
    checkbox.addActionListener(ev -> {

    });

    deleteButton = new JButton("X");
    deleteButton.setFont(Fonts.bold);
    deleteButton.addActionListener(ev -> {
      provider.removeTask(task.id());
    });

    add(this.checkbox);
    add(Box.createHorizontalGlue());
    add(this.deleteButton);
  }
}
