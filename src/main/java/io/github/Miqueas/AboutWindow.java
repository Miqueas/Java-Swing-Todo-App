package io.github.Miqueas;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class AboutWindow extends JFrame {
  private JPanel content = new JPanel();
  private JLabel title = new JLabel("Todo");
  private JLabel description = new JLabel("A simple todo app in Java");
  private JLabel author = new JLabel("Author: Josué Martínez");
  private JLabel version = new JLabel("Version: 0.1.0");
  private JButton closeButton = new JButton("Close");

  public AboutWindow(Component parent) {
    int closeOperation;

    if (parent == null) {
      closeOperation = JFrame.EXIT_ON_CLOSE;
    } else {
      closeOperation = JFrame.DISPOSE_ON_CLOSE;
    }

    setDefaultCloseOperation(closeOperation);
    setResizable(false);
    setTitle("About");

    content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
    content.setBorder(new EmptyBorder(10, 10, 10, 10));

    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    description.setAlignmentX(Component.CENTER_ALIGNMENT);
    author.setAlignmentX(Component.CENTER_ALIGNMENT);
    version.setAlignmentX(Component.CENTER_ALIGNMENT);
    closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    title.setFont(Fonts.display);
    description.setFont(Fonts.normal);
    author.setFont(Fonts.normal);
    version.setFont(Fonts.normal);
    closeButton.setFont(Fonts.normal);
    closeButton.setFocusPainted(false);
    closeButton.addActionListener(e -> this.dispose());

    content.add(this.title);
    content.add(this.description);
    content.add(Box.createRigidArea(new Dimension(0, 10)));
    content.add(this.author);
    content.add(this.version);
    content.add(Box.createRigidArea(new Dimension(0, 10)));
    content.add(this.closeButton, Component.CENTER_ALIGNMENT);

    setContentPane(this.content);
    pack();
    setLocationRelativeTo(parent);
    setVisible(true);
  }
}