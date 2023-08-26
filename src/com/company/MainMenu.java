package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class MainMenu extends JPanel {
    public MainMenu(MainFrame parent) {
        setSize(500, 500);
        setLayout(null);

        JButton firstPageButton = new JButton("ADD STUDENT");
        firstPageButton.setSize(300, 30);
        firstPageButton.setLocation(100, 100);
        add(firstPageButton);
        firstPageButton.addActionListener(actionEvent -> {
            parent.getMainMenuPage().setVisible(false);
            parent.getFirstPage().setVisible(true);
        });

        JButton secondPageButton = getSecondPageButton(parent);
        add(secondPageButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setSize(300, 30);
        exitButton.setLocation(100, 200);
        add(exitButton);
        exitButton.addActionListener(actionEvent -> System.exit(0));
    }

    private static JButton getSecondPageButton(MainFrame parent) {
        JButton secondPageButton = new JButton("LIST STUDENTS");
        secondPageButton.setSize(300, 30);
        secondPageButton.setLocation(100, 150);
        secondPageButton.addActionListener(actionEvent -> {
            ArrayList<Students> studentsList = parent.getStudents();
            boolean isDataEmpty = studentsList.isEmpty();
            if (isDataEmpty) {
                JOptionPane.showMessageDialog(null, "THE LIST OF STUDENTS IS EMPTY");
            } else {
                parent.getSecondPage().generateTable(studentsList);
                parent.getMainMenuPage().setVisible(false);
                parent.getSecondPage().setVisible(true);
            }
        });
        return secondPageButton;
    }
}
