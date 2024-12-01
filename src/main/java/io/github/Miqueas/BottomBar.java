package io.github.Miqueas;

import static io.github.Miqueas.Fonts.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BottomBar extends JPanel {
  private final JCheckBox checkBox;
  private final JTextField input;
  private final TasksProvider provider;

  public BottomBar(TasksProvider tasksProvider) {
    provider = tasksProvider;
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    setBorder(new EmptyBorder(10, 10, 10, 10));

    checkBox = new JCheckBox("Done", false);
    checkBox.setFont(normal);
    checkBox.setFocusPainted(false);

    input = new JTextField(20);
    input.setFont(normal);
    input.addActionListener(ev -> addTask());

    JButton addButton = new JButton("Add");
    addButton.setFont(normal);
    addButton.setFocusPainted(false);
    addButton.addActionListener(ev -> addTask());

    add(checkBox);
    add(Box.createRigidArea(new Dimension(10, 0)));
    add(input);
    add(Box.createRigidArea(new Dimension(10, 0)));
    add(addButton);
  }

  private void addTask() {
    String text = input.getText();
    if (text.isEmpty()) return;
    provider.addTask(text, checkBox.isSelected());
    input.setText("");
  }
}