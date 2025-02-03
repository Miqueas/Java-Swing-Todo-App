package io.github.Miqueas.JavaSwingTodoApp;

import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.util.SystemInfo;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    // Integrates the app menu bar with the system menu bar on macOS
    if (SystemInfo.isMacOS) {
      System.setProperty("apple.laf.useScreenMenuBar", "true");
      System.setProperty("apple.awt.application.name", "Java Swing Todo App");
      System.setProperty("apple.awt.application.appearance", "system");
    }

    // Enable custom window decorations on Linux
    if (SystemInfo.isLinux) {
      JFrame.setDefaultLookAndFeelDecorated(true);
      JDialog.setDefaultLookAndFeelDecorated(true);
    }

    SwingUtilities.invokeLater(() -> {
      FlatMacDarkLaf.setup();
      FlatInterFont.installLazy();
      AppWindow window = new AppWindow();
      window.setVisible(true);
    });
  }
}