package com.iso.decypter;

import java.awt.*;

public class FilesFinder {
    private static Point getLeftUpperCorner() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();

        int leftUpperCornerX = (int)((screenSize.getWidth() - Const.APP_WINDOW_WIDTH) / 2);
        int leftUpperCornerY = (int)((screenSize.getHeight() - Const.APP_WINDOW_HEIGHT) / 2);

        Point leftUpperCorner = new Point(leftUpperCornerX, leftUpperCornerY);

        return leftUpperCorner;
    }

    public static void main(String[] args) {
        Point leftUpperCorner = getLeftUpperCorner();
        Dimension preferredSize = new Dimension(Const.APP_WINDOW_WIDTH, Const.APP_WINDOW_HEIGHT);

        Gui window = new Gui("NowNow POS Iso Decrypter");
        window.setLocation(leftUpperCorner); // place to the middle of the screen
        window.setPreferredSize(preferredSize);
        window.pack();
        window.setDefaultCloseOperation(Gui.EXIT_ON_CLOSE);

        window.setVisible(true);
    }
}
