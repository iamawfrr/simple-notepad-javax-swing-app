package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class SecondPage extends JPanel {
    private final String[] header = {"Id", "Name", "Surname", "Faculty", "Group"};
    private final JTable table;

    public SecondPage(MainFrame parent) {
        setSize(500, 500);
        setLayout(null);

        JButton back = new JButton("BACK");
        back.setSize(300, 30);
        back.setLocation(100, 400);
        add(back);
        back.addActionListener(actionEvent -> {
            parent.getSecondPage().setVisible(false);
            parent.getMainMenuPage().setVisible(true);
        });

        table = new JTable();
        table.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(450, 300);
        scrollPane.setLocation(20, 50);
        add(scrollPane);
    }

    public void generateTable(ArrayList<Students> studentsList) {
        Object[][] data = new Object[10][5];

        for (int i = 0; i < studentsList.toArray().length; i++) {
            data[i][0] = studentsList.get(i).getId();
            data[i][1] = studentsList.get(i).getName();
            data[i][2] = studentsList.get(i).getSurname();
            data[i][3] = studentsList.get(i).getFaculty();
            data[i][4] = studentsList.get(i).getGroup();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}
