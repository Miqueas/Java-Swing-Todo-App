package io.github.Miqueas.JavaSwingTodoApp;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {
  public AppWindow() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 600);
    setLocationRelativeTo(null);
    setTitle("Todo");

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem aboutButton = new JMenuItem("About");
    JMenuItem exitButton = new JMenuItem("Exit");
    TasksView tasksView = new TasksView();
    BottomBar bottomBar = new BottomBar();

    aboutButton.setFont(Fonts.normal);
    aboutButton.addActionListener(e -> new AboutWindow(this));
    exitButton.setFont(Fonts.normal);
    exitButton.addActionListener(e -> System.exit(0));
    fileMenu.add(aboutButton);
    fileMenu.add(exitButton);
    menuBar.add(fileMenu);

    setJMenuBar(menuBar);

    Container content = this.getContentPane();
    content.add(BorderLayout.CENTER, tasksView);
    content.add(BorderLayout.PAGE_END, bottomBar);
  }
}