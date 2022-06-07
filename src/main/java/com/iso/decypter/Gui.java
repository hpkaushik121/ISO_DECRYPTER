package com.iso.decypter;


import com.iso.decypter.interfaces.NavigationMenuClickListener;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    private void menu() {


        setJMenuBar(new MenuView(this).getMenuBar());
    }

    private void body() {


        // final container
        Container container = getContentPane();
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Container mainContainer=Box.createHorizontalBox();
        Container bodyContainer=Box.createHorizontalBox();

        NavigationMenu navigationMenu=new NavigationMenu(bodyContainer);
        mainContainer.add(navigationMenu);
        mainContainer.add(bodyContainer);

        container.add(mainContainer);
    }

    public Gui(String title) {
        super(title);

        // application icon
        ImageIcon imageIcon = Icons.getResource("/ico/filesfinder.png");
        Image image = imageIcon.getImage();
        this.setIconImage(image);

        menu();
        body();
    }
}
