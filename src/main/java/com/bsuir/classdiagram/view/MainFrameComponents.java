package com.bsuir.classdiagram.view;

import com.bsuir.converter.JavaToCTranslator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.metal.MetalComboBoxUI;
import javax.swing.plaf.multi.MultiComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainFrameComponents {
    private final JPanel panel;
    private final JLabel selectSourceCodeLabel;
    private final JButton selectFolderButton;
    private final JTextField fileLocationTextField;
    private final JComboBox<String> sourceLanguageComboBox;
    private final JComboBox<String> targetLanguageComboBox;
    private final JLabel sourceLanguageLabel;
    private final JLabel targetLanguageLabel;
    private final JButton translateButton;

    private final String[] sourceLanguages = new String[]{"C#", "Java"};
    private final String[] targetLanguages = new String[]{"C#", "C"};

    public MainFrameComponents() {

        panel = new JPanel();
        panel.setBackground(Color.white);

        selectSourceCodeLabel = new JLabel("Select source code folder");

        selectFolderButton = new JButton("Choose folder");
        fileLocationTextField = new JTextField("Please, select a folder");
        fileLocationTextField.setMaximumSize(new Dimension(10000, 28));
        fileLocationTextField.setPreferredSize(new Dimension(10000, 28));
        selectFolderButton.setForeground(Color.BLACK);
        selectFolderButton.setBackground(Color.WHITE);
        selectFolderButton.setBorder(new RoundedBorder(5));
        selectFolderButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Open file or folder with code");
                fileChooser.setApproveButtonText("Open");
                fileChooser.showOpenDialog(null);
                fileLocationTextField.setText(fileChooser.getSelectedFile().getPath());
            }
        });

        sourceLanguageComboBox = new JComboBox<>(sourceLanguages);
        targetLanguageComboBox = new JComboBox<>(targetLanguages);
        sourceLanguageComboBox.setBorder(new RoundedBorder(5));
        targetLanguageComboBox.setBorder(new RoundedBorder(5));
        sourceLanguageComboBox.setForeground(Color.BLACK);
        sourceLanguageComboBox.setBackground(Color.WHITE);
        targetLanguageComboBox.setForeground(Color.BLACK);
        targetLanguageComboBox.setBackground(Color.WHITE);
        targetLanguageComboBox.setRenderer(createListRenderer());
        sourceLanguageComboBox.setRenderer(createListRenderer());
        sourceLanguageComboBox.setUI(new BasicComboBoxUI());
        targetLanguageComboBox.setUI(new BasicComboBoxUI());
        sourceLanguageComboBox.setMaximumSize(new Dimension(200, 28));
        sourceLanguageComboBox.setPreferredSize(new Dimension(100, 28));
        targetLanguageComboBox.setMaximumSize(new Dimension(200, 28));
        targetLanguageComboBox.setPreferredSize(new Dimension(100, 28));

        sourceLanguageLabel = new JLabel("Source language");
        targetLanguageLabel = new JLabel("Target language");

        translateButton = new JButton("Translate");

        translateButton.setBorder(new RoundedBorder(5));
        translateButton.setForeground(Color.BLACK);
        translateButton.setBackground(Color.WHITE);

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGap(10, 80, 1500)
                .addComponent(selectSourceCodeLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(selectFolderButton)
                                .addComponent(fileLocationTextField))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(sourceLanguageLabel)
                                .addComponent(sourceLanguageComboBox)
                                .addComponent(targetLanguageLabel)
                                .addComponent(targetLanguageComboBox)))
                .addComponent(translateButton)

        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(selectSourceCodeLabel)
                .addGap(10, 10, 30)
                .addGroup(layout.createParallelGroup()
                        .addComponent(selectFolderButton)
                        .addComponent(fileLocationTextField))
                .addGap(10, 10, 30)
                .addGroup(layout.createParallelGroup()
                        .addComponent(sourceLanguageLabel)
                        .addComponent(sourceLanguageComboBox)
                        .addComponent(targetLanguageLabel)
                        .addComponent(targetLanguageComboBox))
                .addGap(10, 80, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(translateButton)
                )
        );

        addTranslateButtonLogic();
    }

    private void addTranslateButtonLogic() {
        translateButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var sourceLanguage = sourceLanguageComboBox.getModel().getSelectedItem().toString();
                var targetLanguage = targetLanguageComboBox.getModel().getSelectedItem().toString();
                var path = fileLocationTextField.getText();
                if (sourceLanguage.equals("Java") && targetLanguage.equals("C")) {
                    try {
                        JavaToCTranslator.translate(path);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (sourceLanguage.equals("Java") && targetLanguage.equals("C#")) {

                } else if (sourceLanguage.equals("Java") && targetLanguage.equals("UML")) {

                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getSelectSourceCodeLabel() {
        return selectSourceCodeLabel;
    }

    public JButton getSelectFolderButton() {
        return selectFolderButton;
    }

    private static DefaultListCellRenderer createListRenderer() {
        return new DefaultListCellRenderer() {
            private Color background = new Color(80, 80, 80, 200);
            private Color defaultBackground = new Color(0, 100, 255, 15);


            @Override
            public boolean isOpaque() {
                return false;
            }


            @Override
            public Border getBorder() {
                return new RoundedBorder(5);
            }

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    label.setText((String) value);
                    label.setBackground(index % 2 == 0 ? background : defaultBackground);
                    if (!isSelected) {
                        label.setBackground(index % 2 == 0 ? background : defaultBackground);
                    }
                }
                return c;
            }
        };
    }
}
