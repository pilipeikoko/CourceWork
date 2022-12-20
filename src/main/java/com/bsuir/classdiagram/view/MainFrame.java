package com.bsuir.classdiagram.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private final JFrame frame;
    private final MainFrameComponents components;

    public MainFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame = new JFrame("Language translator");

        frame.setBackground(Color.white);
        components = new MainFrameComponents();
        setFrame();
    }

    private void setFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 300));
        frame.add(components.getPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
