package io.github.Miqueas.JavaSwingTodoApp;

import static io.github.Miqueas.JavaSwingTodoApp.Fonts.*;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;
import java.awt.*;

public class TaskItem extends JPanel {
  private final TasksProvider provider = TasksProvider.getInstance();
  private final TaskModel task;

  public TaskItem(TaskModel taskModel) {
    task = taskModel;
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));

    JCheckBox checkbox = new JCheckBox(task.text(), task.done());
    checkbox.setFont(normal.deriveFont(Map.of(
      TextAttribute.STRIKETHROUGH, task.done()
    )));
    checkbox.setFocusPainted(false);
    checkbox.addActionListener(ev -> {
      provider.setDone(task.id(), checkbox.isSelected());
    });

    JButton deleteButton = new JButton("X");
    deleteButton.setFont(bold);
    deleteButton.setFocusPainted(false);
    deleteButton.addActionListener(ev -> {
      provider.removeTask(task.id());
    });

    add(checkbox);
    add(Box.createHorizontalGlue());
    add(deleteButton);
  }
}