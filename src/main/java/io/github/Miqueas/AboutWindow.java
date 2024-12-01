package io.github.Miqueas;

import static io.github.Miqueas.Fonts.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class AboutWindow extends JFrame {
  public AboutWindow(Component parent) {
    int closeOperation;

    if (parent == null) { closeOperation = JFrame.EXIT_ON_CLOSE; }
    else { closeOperation = JFrame.DISPOSE_ON_CLOSE; }

    setDefaultCloseOperation(closeOperation);
    setResizable(false);
    setTitle("About");

    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    content.setBorder(new EmptyBorder(10, 10, 10, 10));

    JLabel title = new JLabel("Todo");
    title.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel description = new JLabel("A simple todo app in Java");
    description.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel author = new JLabel("Author: Josué Martínez");
    author.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel version = new JLabel("Version: 0.3.0");
    version.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton closeButton = new JButton("Close");
    closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    title.setFont(display);
    description.setFont(normal);
    author.setFont(normal);
    version.setFont(normal);
    closeButton.setFont(normal);
    closeButton.setFocusPainted(false);
    closeButton.addActionListener(e -> this.dispose());

    content.add(title);
    content.add(description);
    content.add(Box.createRigidArea(new Dimension(0, 10)));
    content.add(author);
    content.add(version);
    content.add(Box.createRigidArea(new Dimension(0, 10)));
    content.add(closeButton, Component.CENTER_ALIGNMENT);

    setContentPane(content);
    pack();
    setLocationRelativeTo(parent);
    setVisible(true);
  }
}