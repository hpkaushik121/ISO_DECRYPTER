package com.iso.decypter;

import com.iso.decypter.interfaces.NavigationMenuClickListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NavigationMenu extends JPanel {
    private static final int GAP_INNER = 8;
    private static final int GAP_BORDER = 18;
    private JList jList;
    public NavigationMenu(Container body) {
        Border mainPanelBorder = BorderFactory.createEmptyBorder(GAP_BORDER, GAP_BORDER, GAP_BORDER, GAP_BORDER);
        setBorder(mainPanelBorder);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(640, 480));



        //create a new label
        JLabel l= new JLabel("select the day of the week");

        //String array to store weekdays
        String week[]= {
                "EMV TLV Parser",
                "Crypto Calculator",
                "Card Security Values",
                "PIN Block calculator",
                "PIN Verification",
                "PIN Extract",
                "Luhn Algorithm",
                "ISO8583 Bitmap",
                "EMV tag Decoders",
                "ARQR Caculator",
                "Converters",
                "mpe2sql",
        };

        //create list
        jList= new JList(week);
        Font font = new Font("Default", Font.PLAIN, 14);
        jList.setFont(font);
        //set a selected index
        jList.setSelectedIndex(0);
        EMVTLVParserView mainView=new EMVTLVParserView();
        jList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                body.removeAll();
                switch (index){
                    case 0:


                        body.add(mainView);
                        break;
                    default:
                        body.removeAll();
                }
                body.revalidate();
            }
        });
        body.add(mainView);
        body.revalidate();

        //add list to panel
        add(jList, BorderLayout.CENTER);



    }
}
