package io.github.Miqueas.JavaSwingTodoApp;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class TasksView extends JPanel {
  private final TasksProvider provider = TasksProvider.getInstance();
  private final JPanel list;

  public TasksView() {
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
    scroll.putClientProperty(FlatClientProperties.STYLE, "borderColor: #00000000");

    add(title);
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(scroll);

    build();
    provider.onChange(ev -> rebuild());
  }

  private void build() {
    for (TaskModel task : provider.getTasks()) {
      list.add(new TaskItem(task));
    }

    revalidate();
    repaint();
  }

  private void rebuild() {
    list.removeAll();
    build();
  }
}