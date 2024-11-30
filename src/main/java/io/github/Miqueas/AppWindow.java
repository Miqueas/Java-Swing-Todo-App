package io.github.Miqueas;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {
  private JMenuBar menuBar;
  private JMenu fileMenu;
  private JMenuItem aboutButton;
  private JMenuItem exitButton;
  private TasksView tasksView;
  private BottomBar bottomBar;
  private TasksProvider provider;

  public AppWindow(TasksProvider tasksProvider) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 600);
    setLocationRelativeTo(null);
    setTitle("Todo");

    provider = tasksProvider;
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    aboutButton = new JMenuItem("About");
    exitButton = new JMenuItem("Exit");
    tasksView = new TasksView(provider);
    bottomBar = new BottomBar(provider);

    aboutButton.setFont(Fonts.normal);
    aboutButton.addActionListener(e -> new AboutWindow(this));
    exitButton.setFont(Fonts.normal);
    exitButton.addActionListener(e -> System.exit(0));
    fileMenu.add(this.aboutButton);
    fileMenu.add(this.exitButton);
    menuBar.add(this.fileMenu);

    setJMenuBar(this.menuBar);

    Container content = this.getContentPane();
    content.add(BorderLayout.CENTER, tasksView);
    content.add(BorderLayout.PAGE_END, bottomBar);
  }
}