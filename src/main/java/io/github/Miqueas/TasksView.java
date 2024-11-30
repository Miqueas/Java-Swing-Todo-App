package io.github.Miqueas;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class TasksView extends JPanel {
  private final TasksProvider provider;
  private final JPanel list;

  public TasksView(TasksProvider tasksProvider) {
    provider = tasksProvider;
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(new EmptyBorder(10, 10, 10, 10));
    JLabel title = new JLabel("Todo");
    title.setFont(Fonts.title);
    title.setAlignmentX(Component.LEFT_ALIGNMENT);

    list = new JPanel();
    list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));

    JScrollPane scroll = new JScrollPane(list);
    scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
    scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

    add(title);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(scroll);

    provider.onChange(ev -> buildList());
  }

  private void buildList() {
    list.removeAll();

    for (TaskModel task : provider.getTasks()) {
      list.add(new TaskItem(task, provider));
    }

    revalidate();
    repaint();
  }
}