package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPage extends JPanel {

    FirstPage firstPage;

    private MainFrame parent;

    private JButton back;

    private String header[] = {"Name", "Surname", "Faculty", "Group"};
    private JTable table;
    private JScrollPane scrollPane;


    public SecondPage(MainFrame parent) {

        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        back = new JButton("BACK");
        back.setSize(300, 30);
        back.setLocation(100, 400);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getSecondPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });

        table = new JTable();
        table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(450, 300);
        scrollPane.setLocation(20, 50);
        add(scrollPane);

    }

    public SecondPage() {
    }

    public void generateTable(Students[] students) {

        Object data[][] = new Object[10][4];

        for (int i = 0; i < students.length; i++) {
            data[i][0] = students[i].getName();
            data[i][1] = students[i].getSurname();
            data[i][2] = students[i].getFaculty();
            data[i][3] = students[i].getGroup();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}