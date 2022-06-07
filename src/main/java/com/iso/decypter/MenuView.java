package com.iso.decypter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuView extends JMenuBar {
    JMenuBar menuBar = new JMenuBar();

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public MenuView(JFrame jFrame) {

        // File menu items
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.setToolTipText("Exit the application");
        menuItemExit.setMnemonic(KeyEvent.VK_X);
        menuItemExit.setIcon(Icons.getResource("/ico/exit.png"));
        menuItemExit.addActionListener(e -> {
            System.exit(0);
        });



        // Run menu items
        JMenuItem menuItemAdmin = new JMenuItem("Admin Login");
        menuItemAdmin.setMnemonic(KeyEvent.VK_B);
        menuItemAdmin.setIcon(Icons.getResource("/ico/about.png"));
        menuItemAdmin.addActionListener(e -> {
            new AdminView();
        });

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuFile.setIcon(Icons.getResource("/ico/file.png"));
        menuFile.add(menuItemAdmin);
        menuFile.add(menuItemExit);


        // horizontal menu glue
        Component horizontalGlue = Box.createHorizontalGlue();

        // Info menu items
        JMenuItem menuItemAbout = new JMenuItem("About");
        menuItemAbout.setMnemonic(KeyEvent.VK_A);
        menuItemAbout.setIcon(Icons.getResource("/ico/about.png"));
        menuItemAbout.addActionListener(e -> {
            new AboutView(jFrame);
        });

        JMenu menuInfo = new JMenu("Info");
        menuInfo.setMnemonic(KeyEvent.VK_I);
        menuInfo.setIcon(Icons.getResource("/ico/info.png"));
        menuInfo.add(menuItemAbout);

        // final menu bar

        menuBar.add(menuFile);
//        menuBar.add(menuRun);
        menuBar.add(horizontalGlue);
        menuBar.add(menuInfo);
    }

//    private class MenuItemsButtonsListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent event) {
//            Object source = event.getSource();
//
//            if (source == menuItemExit) {
//
//            }
//
//            if (source == menuItemAbout) {
//
//            }
//
//            if ( (source == menuItemAdmin)) {
//                browseDirectories();
//            }
//            if(source == copyButton){
//                copyingToClipboard();
//            }
//
//            if ((source == setDirectoryButton) || (source == menuItemSetDirectory)) {
//                settingDirectory();
//            }
//
//            if ((source == defaultButton) || (source == menuItemDefault)) {
//                defaultFileMask();
//            }
//
//            if ((source == setFileMaskButton) || (source == menuItemSetFileMask)) {
//                decode();
//            }
//
//            if (source == menuItemCopyToClipboard) {
//                copyingToClipboard();
//            }
//        }
//    }

}
