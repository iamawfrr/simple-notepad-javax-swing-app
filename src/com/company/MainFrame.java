package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private final MainMenu mainMenuPage;
    private final FirstPage firstPage;
    private final SecondPage secondPage;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Simple notebook application");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        mainMenuPage = new MainMenu(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        firstPage = new FirstPage(this);
        firstPage.setVisible(false);
        add(firstPage);

        secondPage = new SecondPage(this);
        secondPage.setVisible(false);
        add(secondPage);
    }

    public MainMenu getMainMenuPage() {
        return mainMenuPage;
    }

    public FirstPage getFirstPage() {
        return firstPage;
    }

    public SecondPage getSecondPage() {
        return secondPage;
    }

    public ArrayList<Students> getStudents() {
        return firstPage.getStudentsList();
    }
}
