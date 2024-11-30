package io.github.Miqueas;

import javax.swing.*;
import java.awt.*;

public class BottomBar extends JPanel {
  private JLabel doneLabel;
  private JCheckBox doneCheckBox;
  private JTextField input;
  private JButton addButton;
  private TasksProvider provider;

  public BottomBar(TasksProvider tasksProvider) {
    provider = tasksProvider;
    setLayout(new FlowLayout(FlowLayout.CENTER));

    doneLabel = new JLabel("Done?");
    doneLabel.setFont(Fonts.normal);

    doneCheckBox = new JCheckBox();

    input = new JTextField(20);
    input.setFont(Fonts.normal);
    input.addActionListener(ev -> addTask());

    addButton = new JButton("Add");
    addButton.setFont(Fonts.normal);
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