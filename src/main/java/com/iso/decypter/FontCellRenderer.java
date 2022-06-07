package com.iso.decypter;

import javax.swing.*;
import java.awt.*;

public class FontCellRenderer extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        JLabel label = (JLabel)super.getListCellRendererComponent(
                list,value,index,isSelected,cellHasFocus);
        Font font = new Font(value.toString(), Font.PLAIN, 20);
        label.setFont(font);
        return label;
    }
}
