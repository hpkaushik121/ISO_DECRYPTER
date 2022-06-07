package com.iso.decypter;

import javax.swing.*;

public class AboutView {
    private static final String APPLICATION_DATE = "May 2022 ";
    private static final String APPLICATION_VERSION = "2.0";
    public AboutView(JFrame jFrame) {
        String message = "Author: Sourabh Kaushik © " + APPLICATION_DATE;
        message += System.lineSeparator();
        message += "Version: " + APPLICATION_VERSION;
        message += System.lineSeparator();
        message += System.lineSeparator();

        message += "Java version: " + System.getProperty("java.specification.version");
        message += " (" + System.getProperty("java.version") + ")";
        message += System.lineSeparator();
        message += "Operating system: " + System.getProperty("os.name");
        message += System.lineSeparator();

        message += " ";
        String title = "About the " + jFrame.getTitle();


        JOptionPane.showMessageDialog(jFrame, message,title, JOptionPane.INFORMATION_MESSAGE);
    }
}
