package io.github.Miqueas;

import static io.github.Miqueas.Fonts.*;
import javax.swing.*;
import java.awt.*;

public class BottomBar extends JPanel {
  private final JCheckBox doneCheckBox;
  private final JTextField input;
  private final TasksProvider provider;

  public BottomBar(TasksProvider tasksProvider) {
    provider = tasksProvider;
    setLayout(new FlowLayout(FlowLayout.CENTER));

    JLabel doneLabel = new JLabel("Done?");
    doneLabel.setFont(normal);

    doneCheckBox = new JCheckBox();

    input = new JTextField(20);
    input.setFont(normal);
    input.addActionListener(ev -> addTask());

    JButton addButton = new JButton("Add");
    addButton.setFont(normal);
    addButton.setFocusPainted(false);
    addButton.addActionListener(ev -> addTask());

    add(doneLabel);
    add(doneCheckBox);
    add(input);
    add(addButton);
  }

  private void addTask() {
    String text = input.getText();
    if (!text.isEmpty()) {
      provider.addTask(text, doneCheckBox.isSelected());
      input.setText("");
    }
  }
}