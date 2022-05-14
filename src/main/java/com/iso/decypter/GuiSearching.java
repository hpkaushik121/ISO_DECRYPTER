package com.iso.decypter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GuiSearching extends JDialog {
    private static final int GAP_INNER = 8;
    private static final int GAP_BORDER = 18;

    private JButton cancelButton;

    private Search search = null;

    private class ButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();

            if (source == cancelButton) {
                if (search != null) {
                    search.cancel();
                }
            }
        }
    }

    private void work() {
        search.run();

        Runnable runnableUI = new Runnable() {
            public void run() {
                setVisible(false);
                dispose();
            }
        };

        // add to the UI thread
        SwingUtilities.invokeLater(runnableUI);
    }

    public void startWork(Search search) {
        this.search = search;

        Thread workingThread = new Thread() {
            public void run(){
                work();
            }
        };

        // start in the working thread
        workingThread.start();
    }

    private String cancelingGetTitle() {
        String title = "Canceling of the files searching";
        return title;
    }

    private void body() {
        Dimension gapInner = new Dimension(GAP_INNER, GAP_INNER);

        ButtonsListener buttonsListener = new ButtonsListener();

        // cancel button line
        cancelButton = new JButton("Cancel");
        cancelButton.setToolTipText(cancelingGetTitle());
        cancelButton.setMnemonic(KeyEvent.VK_C);
        cancelButton.setIcon(Icons.getResource("/ico/cancel.png"));
        cancelButton.addActionListener(buttonsListener);

        Container cancel = Box.createHorizontalBox();
        cancel.add(cancelButton);

        // final panel
        JPanel panel = new JPanel();

        Border panelBorder = BorderFactory.createEmptyBorder(GAP_BORDER, GAP_BORDER, GAP_BORDER, GAP_BORDER);
        panel.setBorder(panelBorder);

        BoxLayout panelLayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(panelLayout);

        panel.add(Box.createRigidArea(gapInner));
        panel.add(cancel);

        // final container
        Container container = getContentPane();
        container.add(panel);
    }

    public GuiSearching(Frame parent, String title) {
        super(parent, title, true);

        // application icon
        ImageIcon imageIcon = Icons.getResource("/ico/filesfinder.png");
        Image image = imageIcon.getImage();
        this.setIconImage(image);

        body();
    }
}
