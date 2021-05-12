package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JPanel {

    private MainFrame parent;

    private JLabel label;
    private JButton back;
    private JButton add;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox facultyBox;
    private String[] faculties = {"Information", "Technologies", "Economics", "Mathematics"};
    private Students[] students = new Students[5];

    public Students[] getStudents() {
        return students;
    }

    public FirstPage(MainFrame parent) {


        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        label = new JLabel("NAME:");
        label.setSize(300, 30);
        label.setLocation(100, 75);
        add(label);

        textField = new JTextField();
        textField.setSize(200, 30);
        textField.setLocation(170, 75);
        add(textField);

        label = new JLabel("SURNAME:");
        label.setSize(300, 30);
        label.setLocation(100, 120);
        add(label);

        textField2 = new JTextField();
        textField2.setSize(200, 30);
        textField2.setLocation(170, 120);
        add(textField2);

        label = new JLabel("FACULTY:");
        label.setSize(300, 30);
        label.setLocation(100, 175);
        add(label);

        facultyBox = new JComboBox(faculties);
        facultyBox.setSize(200, 30);
        facultyBox.setLocation(170, 175);
        add(facultyBox);

        label = new JLabel("GROUP:");
        label.setSize(300, 30);
        label.setLocation(100, 230);
        add(label);

        textField3 = new JTextField();
        textField3.setSize(200, 30);
        textField3.setLocation(170, 230);
        add(textField3);

        back = new JButton("BACK");
        back.setSize(100, 30);
        back.setLocation(300, 350);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFirstPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });

        add = new JButton("ADD");
        add.setSize(100, 30);
        add.setLocation(100, 350);
        add(add);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String text2 = textField2.getText();
                String faculty = (String) facultyBox.getSelectedItem();
                String text3 = textField3.getText();
                students = new Students[]{
                        new Students(text, text2, faculty, text3),
                };
                textField.setText("");
                textField2.setText("");
                facultyBox.setSelectedIndex(0);
                textField3.setText("");
            }
        });
        add(add);
    }
}