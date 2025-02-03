package io.github.Miqueas.JavaSwingTodoApp;

import javax.swing.*;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class Main {
  public static void main(String[] args) {
    FlatMacDarkLaf.setup();
    SwingUtilities.invokeLater(() -> {
      AppWindow window = new AppWindow();
      window.setVisible(true);
    });
  }
}