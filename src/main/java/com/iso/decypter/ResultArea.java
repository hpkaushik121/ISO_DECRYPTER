package com.iso.decypter;

import javax.swing.*;
import java.awt.*;

public class ResultArea extends Box {

    JTextArea resultTextArea;
    JTextArea resultTextArea2;
    private static final int GAP_INNER = 8;
    private static final int GAP_BORDER = 18;

    /**
     * Creates a <code>Box</code> that displays its components
     * along the specified axis.
     *
     * @throws AWTError if the <code>axis</code> is invalid
     * @see #createHorizontalBox
     */
    public ResultArea() {
        super(BoxLayout.X_AXIS);

        resultTextArea = new JTextArea(90, 300);
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(false);




        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);


        resultTextArea2 = new JTextArea(90, 300);
        resultTextArea2.setEditable(false);
        resultTextArea2.setLineWrap(false);




        JScrollPane resultScrollPane2 = new JScrollPane(resultTextArea2);
        Dimension gapInner = new Dimension(GAP_INNER, GAP_INNER);
        add(resultScrollPane);
        add(createRigidArea(gapInner));
        add(resultScrollPane2);
    }

    public JTextArea getResultTextArea() {
        return resultTextArea;
    }

    public JTextArea getTLVResultArea() {
        return resultTextArea2;
    }
}
