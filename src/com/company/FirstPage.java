package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class FirstPage extends JPanel {
    private final JTextField textField0;
    private final JTextField textField1;
    private final JTextField textField2;
    private final JTextField textField3;
    private final JComboBox facultyBox;
    ArrayList<Students> studentsList = new ArrayList<>();

    public ArrayList<Students> getStudentsList() {
        return studentsList;
    }

    public FirstPage(MainFrame parent) {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("ID:");
        label.setSize(300, 30);
        label.setLocation(100, 35);
        add(label);

        textField0 = new JTextField();
        textField0.setSize(200, 30);
        textField0.setLocation(170, 35);
        add(textField0);

        label = new JLabel("NAME:");
        label.setSize(300, 30);
        label.setLocation(100, 80);
        add(label);

        textField1 = new JTextField();
        textField1.setSize(200, 30);
        textField1.setLocation(170, 80);
        add(textField1);

        label = new JLabel("SURNAME:");
        label.setSize(300, 30);
        label.setLocation(100, 125);
        add(label);

        textField2 = new JTextField();
        textField2.setSize(200, 30);
        textField2.setLocation(170, 125);
        add(textField2);

        label = new JLabel("FACULTY:");
        label.setSize(300, 30);
        label.setLocation(100, 170);
        add(label);

        String[] faculties = {"Information", "Technologies", "Economics", "Mathematics"};
        facultyBox = new JComboBox(faculties);
        facultyBox.setSize(200, 30);
        facultyBox.setLocation(170, 170);
        add(facultyBox);

        label = new JLabel("GROUP:");
        label.setSize(300, 30);
        label.setLocation(100, 215);
        add(label);

        textField3 = new JTextField();
        textField3.setSize(200, 30);
        textField3.setLocation(170, 215);
        add(textField3);

        JButton back = new JButton("BACK");
        back.setSize(100, 30);
        back.setLocation(300, 300);
        add(back);
        back.addActionListener(actionEvent -> {
            parent.getFirstPage().setVisible(false);
            parent.getMainMenuPage().setVisible(true);
        });

        JButton add = new JButton("ADD");
        add.setSize(100, 30);
        add.setLocation(100, 300);
        add(add);

        add.addActionListener(e -> {
            String idText = textField0.getText();
            String text = textField1.getText();
            String text2 = textField2.getText();
            String faculty = (String) facultyBox.getSelectedItem();
            String text3 = textField3.getText();

            if (idText.isEmpty() || text.isEmpty() || text2.isEmpty() || text3.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE, FILL IN ALL FIELDS");
            } else {
                int id = Integer.parseInt(idText);
                studentsList.add(new Students(id, text, text2, faculty, text3));
                textField0.setText("");
                textField1.setText("");
                textField2.setText("");
                facultyBox.setSelectedIndex(0);
                textField3.setText("");
            }
        });
        add(add);
    }
}
