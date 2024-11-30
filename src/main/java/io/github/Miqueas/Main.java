package io.github.Miqueas;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      TasksProvider provider = new TasksProvider();
      AppWindow window = new AppWindow(provider);
      window.setVisible(true);
    });
  }
}