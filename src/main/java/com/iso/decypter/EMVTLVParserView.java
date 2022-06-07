package com.iso.decypter;

import com.iso.decypter.ISOUtils.TLV;
import com.iso.decypter.ISOUtils.TLVParser;
import com.iso.decypter.ISOUtils.UnPackISOMessage;
import com.solab.iso8583.IsoMessage;
import org.jpos.iso.ISOMsg;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class EMVTLVParserView extends JPanel {
    private static final int GAP_INNER = 8;
    private static final int GAP_BORDER = 18;
    private static final String STARTING_DIRECTORY_LABEL = "Byte Array: ";
    private static final String FILE_MASK_LABEL = " ";

    private static final String DEFAULT_FILE_MASK = Const.EMPTY_STRING;

    public String getTitle(){
        return "EMV TLV Parser";
    }
    public EMVTLVParserView() {

        Dimension gapInner = new Dimension(GAP_INNER, GAP_INNER);

        // directory line
        JLabel directoryLabel = new JLabel(STARTING_DIRECTORY_LABEL, SwingConstants.LEFT);
        JLabel directoryLabelValue = new JLabel(Const.EMPTY_STRING);
        Border panelBorder = BorderFactory.createEmptyBorder(10, 0, GAP_BORDER, GAP_BORDER);
        setBorder(panelBorder);

        JLabel label=new JLabel();
        label.setText("<html><h4>EMV TLV Parser</h4></html>");
        label.setFont(new Font("Myriad Pro",Font.PLAIN,15));

       Container lable=Box.createHorizontalBox();
       lable.add(label);
       add(lable);
//
        JRadioButton isJ8583 = new JRadioButton("J8583");
        isJ8583.setMnemonic(KeyEvent.VK_S);
        isJ8583.setSelected(true);
        JRadioButton isISO8583 = new JRadioButton("ISO8583");
        isISO8583.setMnemonic(KeyEvent.VK_S);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(isJ8583);
        buttonGroup.add(isISO8583);
        Container radioGroup = Box.createHorizontalBox();
        radioGroup.add(Box.createRigidArea(gapInner));
        radioGroup.add(Box.createHorizontalGlue());
        radioGroup.add(isJ8583);
        radioGroup.add(isISO8583);




        Container directory = Box.createHorizontalBox();
        directory.add(directoryLabel);
        directory.add(directoryLabelValue);
        directory.add(Box.createHorizontalGlue());
//        directory.add(browseButton);
        directory.add(Box.createRigidArea(gapInner));
//        directory.add(setDirectoryButton);


        // file mask line
        JLabel fileMaskLabel = new JLabel(FILE_MASK_LABEL);
        JLabel fileMaskLabelValue = new JLabel(DEFAULT_FILE_MASK);

//        defaultButton = new JButton("Default");
//        defaultButton.setToolTipText(defaultFileMaskGetTitle());
//        defaultButton.setMnemonic(KeyEvent.VK_D);
//        defaultButton.setIcon(Icons.getResource("/ico/default.png"));
//        defaultButton.addActionListener(buttonsListener);





        // search button line
//        searchButton = new JButton("Search");
//        searchButton.setToolTipText(searchingGetTitle());
//        searchButton.setMnemonic(KeyEvent.VK_A);
//        searchButton.setIcon(Icons.getResource("/ico/search.png"));
//        searchButton.addActionListener(buttonsListener);

//        Container search = Box.createHorizontalBox();
//        search.add(Box.createHorizontalGlue());
//        search.add(searchButton);

        // result text area
//        JTextArea resultTextArea = new JTextArea(90, 300);
//        resultTextArea.setEditable(false);
//        resultTextArea.setLineWrap(false);
//
//
//
//
//        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);

        ResultArea resultArea=new ResultArea();

        JButton copyButton = new JButton("Copy");
        copyButton.setMnemonic(KeyEvent.VK_B);
        copyButton.setIcon(Icons.getResource("/ico/copy.png"));
        copyButton.addActionListener(e->{
            List<JTextArea> jTextAreas=new ArrayList<>();
            jTextAreas.add(resultArea.getResultTextArea());
            jTextAreas.add(resultArea.getTLVResultArea());
            copyingToClipboard(jTextAreas);
        });



        Container copyMap = Box.createHorizontalBox();
        copyMap.add(fileMaskLabel);
        copyMap.add(fileMaskLabelValue);
        copyMap.add(Box.createHorizontalGlue());
//      copyMap.add(defaultButton);
        copyMap.add(Box.createRigidArea(gapInner));
        copyMap.add(copyButton);




//        frame.getContentPane().add(BorderLayout.CENTER, panel);
//        loginFrame.pack();


        JTextArea inputByteArray = new JTextArea(90, 300);
        inputByteArray.setEditable(true);
        inputByteArray.setLineWrap(true);

        JScrollPane inputScrollPane = new JScrollPane(inputByteArray);


        BoxLayout mainPanelLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(mainPanelLayout);
        add(radioGroup);
        add(directory);
        add(Box.createRigidArea(gapInner));
        add(inputScrollPane);
        add(Box.createRigidArea(gapInner));
        JButton runBtn = new JButton("Run");
        runBtn.setMnemonic(KeyEvent.VK_E);
        runBtn.setIcon(Icons.getResource("/ico/run.png"));
        runBtn.addActionListener(e->{
            if(isISO8583.isSelected()){
                decode(inputByteArray,resultArea,DecodeType.ISO8583);
            }else{
                decode(inputByteArray,resultArea,DecodeType.J8583);
            }

        });
        Container fileMask = Box.createHorizontalBox();
        fileMask.add(fileMaskLabel);
        fileMask.add(fileMaskLabelValue);
        fileMask.add(Box.createHorizontalGlue());
//        fileMask.add(defaultButton);
        fileMask.add(Box.createRigidArea(gapInner));
        fileMask.add(runBtn);
        add(fileMask);



        add(Box.createRigidArea(gapInner));
        add(Box.createRigidArea(gapInner));
        add(Box.createRigidArea(gapInner));
        add(Box.createRigidArea(gapInner));
        add(resultArea);
        add(Box.createRigidArea(gapInner));
        add(copyMap);

    }

    private void copyingToClipboard(JTextArea textArea) {

        String resultString = textArea.getText();
        if (resultString.equals(Const.EMPTY_STRING)) {
            String message = "There is no result yet";
            JOptionPane.showMessageDialog(this, message, "Copying of the result", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringSelection stringSelection = new StringSelection(resultString);

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = defaultToolkit.getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        String message = "Result copied to the clipboard";
        JOptionPane.showMessageDialog(this, message, "Copying of the result", JOptionPane.INFORMATION_MESSAGE);
    }

    private void copyingToClipboard(List<JTextArea> textArea) {
        String resultString = "";
        for (JTextArea text:textArea ) {
            resultString +=text.getText();
            resultString +="\n \n ------------------------------------------------------------------- \n \n ";
        }

        if (resultString.equals(Const.EMPTY_STRING)) {
            String message = "There is no result yet";
            JOptionPane.showMessageDialog(this, message, "Copying of the result", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringSelection stringSelection = new StringSelection(resultString);

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = defaultToolkit.getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        String message = "Result copied to the clipboard";
        JOptionPane.showMessageDialog(this, message, "Copying of the result", JOptionPane.INFORMATION_MESSAGE);
    }

    private void decode(JTextArea inputArea,ResultArea resultArea,DecodeType type) {



        String[] rs=  inputArea.getText().replace("[","").replace("]","").replace(" ","").split(",");
        String decrypted="Unable to Decode";
        String TLV="TLV: N/A";
        UnPackISOMessage unPackISOMessage=new UnPackISOMessage();
        switch (type){
            case J8583 :
                try {
                    byte[] bytes=new byte[rs.length];

                    for (int i=0; i<rs.length;i++) {
                        bytes[i]= Byte.parseByte(rs[i]);
                    }

                    String byteArray = new String(bytes);
                     IsoMessage isoMessage = unPackISOMessage.unPackResponseJ8583(byteArray);
                     List<TLV> tlvList= TLVParser.parse(isoMessage.getField(55).toString());
                     TLV= com.iso.decypter.ISOUtils.TLV.toString(tlvList);
                     decrypted=unPackISOMessage.IsoToString(isoMessage);

                }catch (Throwable ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case ISO8583 :
                try{
                    byte[] bytes=new byte[rs.length];

                    for (int i=0; i<rs.length;i++) {
                        bytes[i]= Byte.parseByte(rs[i]);
                    }

                    String byteArray = new String(bytes);
                    ISOMsg isoMsg = unPackISOMessage.unPackResponseISO8583(bytes);
                    List<TLV> tlvList= TLVParser.parse(isoMsg.getString(55));
                    TLV= com.iso.decypter.ISOUtils.TLV.toString(tlvList);
                    decrypted=unPackISOMessage.IsoToString(isoMsg);
                }catch (Throwable ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        resultArea.getResultTextArea().setText(decrypted);
        resultArea.getResultTextArea().setCaretPosition(0);

        resultArea.getTLVResultArea().setText(TLV);
        resultArea.getTLVResultArea().setCaretPosition(0);
    }

}
