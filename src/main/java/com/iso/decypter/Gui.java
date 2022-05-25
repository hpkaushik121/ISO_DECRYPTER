package com.iso.decypter;


import com.iso.decypter.ISOUtils.UnPackISOMessage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.File;

public class Gui extends JFrame {
    private static final String APPLICATION_DATE = "May 2022 ";
    private static final String APPLICATION_VERSION = "2.0";

    private static final int GAP_INNER = 8;
    private static final int GAP_BORDER = 18;

    private static final String STARTING_DIRECTORY_LABEL = "Byte Array: ";
    private static final String FILE_MASK_LABEL = " ";

    private static final String DEFAULT_FILE_MASK = Const.EMPTY_STRING;

    private JMenuItem menuItemExit;
    private JMenuItem menuItemAdmin;
    private JMenuItem menuItemSetDirectory;
    private JMenuItem menuItemDefault;
    private JMenuItem menuItemSetFileMask;
    private JMenuItem menuItemSearch;
    private JMenuItem menuItemCopyToClipboard;
    private JMenuItem menuItemAbout;

    private JLabel directoryLabelValue;
    private JLabel fileMaskLabelValue;
    private JRadioButton isJ8583,isISO8583;
    private JButton copyButton;
    private JButton setDirectoryButton;
    private JButton defaultButton;
    private JButton setFileMaskButton;
    private JButton searchButton;

    private JTextArea resultTextArea;
    private JTextArea inputByteArray;

    private JLabel password1, label;
    private JTextField username;
    private JButton button;
    private JPasswordField Password;
    private JPanel loginPanel=new JPanel();
    private JFrame loginFrame=new JFrame();

    private class MenuItemsButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();

            if (source == menuItemExit) {
                System.exit(0);
            }

            if (source == menuItemAbout) {
                aboutApplication();
            }

            if ( (source == menuItemAdmin)) {
                browseDirectories();
            }
            if(source == copyButton){
                copyingToClipboard();
            }

                if ((source == setDirectoryButton) || (source == menuItemSetDirectory)) {
                settingDirectory();
            }

            if ((source == defaultButton) || (source == menuItemDefault)) {
                defaultFileMask();
            }

            if ((source == setFileMaskButton) || (source == menuItemSetFileMask)) {
                decode();
            }

            if (source == menuItemCopyToClipboard) {
                copyingToClipboard();
            }
        }
    }

    private class TextsMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent event) {
            Object source = event.getSource();

            if (source == resultTextArea) {
                copyingToClipboard();
            }
        }

        @Override
        public void mousePressed(MouseEvent event) {
        }

        @Override
        public void mouseReleased(MouseEvent event) {
        }

        @Override
        public void mouseEntered(MouseEvent event) {
        }

        @Override
        public void mouseExited(MouseEvent event) {
        }
    }

    private String aboutApplicationGetTitle() {
        String title = "About the " + this.getTitle();
        return title;
    }

    private void aboutApplication() {
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

        JOptionPane.showMessageDialog(this, message, aboutApplicationGetTitle(), JOptionPane.INFORMATION_MESSAGE);
    }

    private String browseDirectoriesGetTitle() {
        String title = "Browsing of the starting directory";
        return title;
    }

    private void browseDirectories() {


//        frame.setLocationByPlatform(true);
        loginFrame.setVisible(true);
        loginFrame.setResizable(true);
        username.requestFocus();



//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDialogTitle(browseDirectoriesGetTitle());
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        fileChooser.setAcceptAllFileFilterUsed(false);
//
//        String directoryName = directoryLabelValue.getText();
//        File directory = new File(directoryName);
//        fileChooser.setCurrentDirectory(directory);
//
//        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            directory = fileChooser.getSelectedFile();
//            directoryName = directory.getPath();
//            directoryLabelValue.setText(directoryName);
//        }
    }

    private String settingDirectoryGetTitle() {
        String title = "Manual setting of the starting directory";
        return title;
    }

    private void settingDirectory() {
        String message = STARTING_DIRECTORY_LABEL;
        String title = settingDirectoryGetTitle();
        String directoryName = directoryLabelValue.getText();
        directoryName = (String)JOptionPane.showInputDialog(this, message, title, JOptionPane.PLAIN_MESSAGE, null, null, directoryName);

        if (directoryName != null) {
            directoryLabelValue.setText(directoryName);
        }
    }

    private String defaultFileMaskGetTitle() {
        String title = "Default file mask setting";
        return title;
    }

    private void defaultFileMask() {
        String question = "Really set the default file mask '" + DEFAULT_FILE_MASK + "' ?";
        String title = defaultFileMaskGetTitle();
        int n = JOptionPane.showConfirmDialog(this, question, title, JOptionPane.YES_NO_OPTION);

        if (n == 0) {
            fileMaskLabelValue.setText(DEFAULT_FILE_MASK);
        }
    }

    private String settingFileMaskGetTitle() {
        String title = "Manual setting of the file mask";
        return title;
    }

    private void settingFileMask() {
        String message = FILE_MASK_LABEL;
        String title = settingFileMaskGetTitle();
        String fileMaskName = fileMaskLabelValue.getText();
        fileMaskName = (String)JOptionPane.showInputDialog(this, message, title, JOptionPane.PLAIN_MESSAGE, null, null, fileMaskName);

        if (fileMaskName != null) {
            fileMaskLabelValue.setText(fileMaskName);
        }
    }

//    private String searchingGetTitle() {
//        String title = "Files searching";
//        return title;
//    }

    private Point searchingWindowGetLeftUpperCorner() {
        Point leftUpperCorner = getLocation();

        int dx = (int)((getWidth() - Const.APP_WINDOW_SEARCH_WIDTH) / 2);
        int dy = (int)((getHeight() - Const.APP_WINDOW_SEARCH_HEIGHT) / 2);
        leftUpperCorner.translate(dx, dy);

        return leftUpperCorner;
    }


    private void decode() {



        String[] rs=  inputByteArray.getText().replace("[","").replace("]","").split(",");


        if(isISO8583.isSelected()) {
            try {
                byte[] bytes=new byte[rs.length-2];

                for (int i=2; i<rs.length;i++) {
                    bytes[i-2]= Byte.parseByte(rs[i]);
                }

                String byteArray = new String(bytes);
                String decrypted= new UnPackISOMessage().unPackResponseISO8583(bytes);
                resultTextArea.setText(decrypted);
                resultTextArea.setCaretPosition(0);
            }catch (Throwable ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!!!", JOptionPane.ERROR_MESSAGE);
        }

        } else  {
            try{
                byte[] bytes=new byte[rs.length];

                for (int i=0; i<rs.length;i++) {
                    bytes[i]= Byte.parseByte(rs[i]);
                }

                String byteArray = new String(bytes);
                String decrypted= new UnPackISOMessage().unPackResponseISO8583(bytes);
                resultTextArea.setText(decrypted);
                resultTextArea.setCaretPosition(0);
            }catch (Throwable ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!!!", JOptionPane.ERROR_MESSAGE);
            }


        }




//
    }

    private String copyingToClipboardGetTitle() {
        String title = "Copying of the result";
        return title;
    }

    private void copyingToClipboard() {
//        String question = "Really copy the result to the clipboard ?";
//        String title = copyingToClipboardGetTitle();
//        int n = JOptionPane.showConfirmDialog(this, question, title, JOptionPane.YES_NO_OPTION);
//
//        if (n != 0) {
//            return;
//        }

        String resultString = resultTextArea.getText();
        if (resultString.equals(Const.EMPTY_STRING)) {
            String message = "There is no result yet";
            JOptionPane.showMessageDialog(this, message, copyingToClipboardGetTitle(), JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringSelection stringSelection = new StringSelection(resultString);

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = defaultToolkit.getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        String message = "Result copied to the clipboard";
        JOptionPane.showMessageDialog(this, message, copyingToClipboardGetTitle(), JOptionPane.INFORMATION_MESSAGE);
    }

    private void menu() {
        MenuItemsButtonsListener menuItemsListener = new MenuItemsButtonsListener();

        // File menu items
        menuItemExit = new JMenuItem("Exit");
        menuItemExit.setToolTipText("Exit the application");
        menuItemExit.setMnemonic(KeyEvent.VK_X);
        menuItemExit.setIcon(Icons.getResource("/ico/exit.png"));
        menuItemExit.addActionListener(menuItemsListener);



        // Run menu items
        menuItemAdmin = new JMenuItem("Admin Login");
        menuItemAdmin.setToolTipText(browseDirectoriesGetTitle());
        menuItemAdmin.setMnemonic(KeyEvent.VK_B);
        menuItemAdmin.setIcon(Icons.getResource("/ico/about.png"));
        menuItemAdmin.addActionListener(menuItemsListener);

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuFile.setIcon(Icons.getResource("/ico/file.png"));
        menuFile.add(menuItemAdmin);
        menuFile.add(menuItemExit);

//
//        menuItemSetDirectory = new JMenuItem("Set directory");
//        menuItemSetDirectory.setToolTipText(settingDirectoryGetTitle());
//        menuItemSetDirectory.setMnemonic(KeyEvent.VK_S);
//        menuItemSetDirectory.setIcon(Icons.getResource("/ico/set.png"));
//        menuItemSetDirectory.addActionListener(menuItemsListener);
//
//        menuItemDefault = new JMenuItem("Default file mask");
//        menuItemDefault.setToolTipText(defaultFileMaskGetTitle());
//        menuItemDefault.setMnemonic(KeyEvent.VK_D);
//        menuItemDefault.setIcon(Icons.getResource("/ico/default.png"));
//        menuItemDefault.addActionListener(menuItemsListener);
//
//        menuItemSetFileMask = new JMenuItem("Set file mask");
//        menuItemSetFileMask.setToolTipText(settingFileMaskGetTitle());
//        menuItemSetFileMask.setMnemonic(KeyEvent.VK_E);
//        menuItemSetFileMask.setIcon(Icons.getResource("/ico/set.png"));
//        menuItemSetFileMask.addActionListener(menuItemsListener);
//
//        menuItemSearch = new JMenuItem("Search");
//        menuItemSearch.setToolTipText(searchingGetTitle());
//        menuItemSearch.setMnemonic(KeyEvent.VK_A);
//        menuItemSearch.setIcon(Icons.getResource("/ico/search.png"));
//        menuItemSearch.addActionListener(menuItemsListener);
//
//        menuItemCopyToClipboard = new JMenuItem("Copy to clipboard");
//        menuItemCopyToClipboard.setToolTipText(copyingToClipboardGetTitle());
//        menuItemCopyToClipboard.setMnemonic(KeyEvent.VK_C);
//        menuItemCopyToClipboard.setIcon(Icons.getResource("/ico/copy.png"));
//        menuItemCopyToClipboard.addActionListener(menuItemsListener);

//        JMenu menuRun = new JMenu("Run");
//        menuRun.setMnemonic(KeyEvent.VK_R);
//        menuRun.setIcon(Icons.getResource("/ico/run.png"));
//        menuRun.add(menuItemBrowse);
//        menuRun.add(menuItemSetDirectory);
//        menuRun.add(new JSeparator());
//        menuRun.add(menuItemDefault);
//        menuRun.add(menuItemSetFileMask);
//        menuRun.add(new JSeparator());
//        menuRun.add(menuItemSearch);
//        menuRun.add(new JSeparator());
//        menuRun.add(menuItemCopyToClipboard);

        // horizontal menu glue
        Component horizontalGlue = Box.createHorizontalGlue();

        // Info menu items
        menuItemAbout = new JMenuItem("About");
        menuItemAbout.setToolTipText(aboutApplicationGetTitle());
        menuItemAbout.setMnemonic(KeyEvent.VK_A);
        menuItemAbout.setIcon(Icons.getResource("/ico/about.png"));
        menuItemAbout.addActionListener(menuItemsListener);

        JMenu menuInfo = new JMenu("Info");
        menuInfo.setMnemonic(KeyEvent.VK_I);
        menuInfo.setIcon(Icons.getResource("/ico/info.png"));
        menuInfo.add(menuItemAbout);

        // final menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuFile);
//        menuBar.add(menuRun);
        menuBar.add(horizontalGlue);
        menuBar.add(menuInfo);

        this.setJMenuBar(menuBar);
    }

    private void body() {
        Dimension gapInner = new Dimension(GAP_INNER, GAP_INNER);

        MenuItemsButtonsListener buttonsListener = new MenuItemsButtonsListener();
        TextsMouseListener textsMouseListener = new TextsMouseListener();

        // directory line
        JLabel directoryLabel = new JLabel(STARTING_DIRECTORY_LABEL, SwingConstants.LEFT);
        directoryLabelValue = new JLabel(Const.EMPTY_STRING);

        copyButton = new JButton("Copy");
        copyButton.setToolTipText(browseDirectoriesGetTitle());
        copyButton.setMnemonic(KeyEvent.VK_B);
        copyButton.setIcon(Icons.getResource("/ico/copy.png"));
        copyButton.addActionListener(buttonsListener);
//
         isJ8583 = new JRadioButton("J8583");
        isJ8583.setToolTipText(settingDirectoryGetTitle());
        isJ8583.setMnemonic(KeyEvent.VK_S);
        isJ8583.setSelected(true);
         isISO8583 = new JRadioButton("ISO8583");
        isISO8583.setToolTipText(settingDirectoryGetTitle());
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
        fileMaskLabelValue = new JLabel(DEFAULT_FILE_MASK);

//        defaultButton = new JButton("Default");
//        defaultButton.setToolTipText(defaultFileMaskGetTitle());
//        defaultButton.setMnemonic(KeyEvent.VK_D);
//        defaultButton.setIcon(Icons.getResource("/ico/default.png"));
//        defaultButton.addActionListener(buttonsListener);

        setFileMaskButton = new JButton("Run");
        setFileMaskButton.setToolTipText(settingFileMaskGetTitle());
        setFileMaskButton.setMnemonic(KeyEvent.VK_E);
        setFileMaskButton.setIcon(Icons.getResource("/ico/run.png"));
        setFileMaskButton.addActionListener(buttonsListener);

        Container fileMask = Box.createHorizontalBox();
        fileMask.add(fileMaskLabel);
        fileMask.add(fileMaskLabelValue);
        fileMask.add(Box.createHorizontalGlue());
//        fileMask.add(defaultButton);
        fileMask.add(Box.createRigidArea(gapInner));
        fileMask.add(setFileMaskButton);

        Container copyMap = Box.createHorizontalBox();
        copyMap.add(fileMaskLabel);
        copyMap.add(fileMaskLabelValue);
        copyMap.add(Box.createHorizontalGlue());
//      copyMap.add(defaultButton);
        copyMap.add(Box.createRigidArea(gapInner));
        copyMap.add(copyButton);

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
        resultTextArea = new JTextArea(90, 300);
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(false);
        resultTextArea.addMouseListener(textsMouseListener);

        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);







        loginPanel.setLayout(null);
        loginPanel.setOpaque(true);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginFrame.setTitle("Admin Login");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - loginFrame.getWidth()) / 2.6);
        int y = (int) ((dimension.getHeight() - loginFrame.getHeight()) / 2.6);
        loginFrame.setLocation(new Point(x, y));
        loginFrame.add(loginPanel);
        loginFrame.setSize(new Dimension(400, 200));

        // Username label constructor
        label = new JLabel("Username");
        label.setBounds(100, 8, 70, 20);
        loginPanel.add(label);


        // Username TextField constructor
        username = new JTextField();
        username.setBounds(100, 27, 198, 20);
        loginPanel.add(username);


        // Password Label constructor
        password1 = new JLabel("Password");
        password1.setBounds(100, 55, 70, 20);
        loginPanel.add(password1);



        // Password TextField
        Password = new JPasswordField();
        Password.setBounds(100, 75, 198, 20);
        loginPanel.add(Password);


        // Button constructor
        button = new JButton("Login");
        button.setBounds(100, 110, 198, 25);
//        button.setForeground(Color.WHITE);
//        button.setBackground(Color.BLACK);
        button.addActionListener(v->{
            if(username.getText().equals("admin") && Password.getText().equals("admin@123")){
                Const.isAdmin=true;
                JOptionPane.showMessageDialog(loginFrame, "Admin mode enabled","Admin", JOptionPane.INFORMATION_MESSAGE);
                loginFrame.dispose();
            }else{
                JOptionPane.showMessageDialog(loginFrame, "Invalid Username or password","Error!!", JOptionPane.ERROR_MESSAGE);
            }

        });
        loginPanel.add(button);

//        frame.getContentPane().add(BorderLayout.CENTER, panel);
//        loginFrame.pack();


        inputByteArray = new JTextArea(90, 300);
        inputByteArray.setEditable(true);
        inputByteArray.setLineWrap(true);

        JScrollPane inputScrollPane = new JScrollPane(inputByteArray);

        // final panel
        JPanel panel = new JPanel();

        Border mainPanelBorder = BorderFactory.createEmptyBorder(GAP_BORDER, GAP_BORDER, GAP_BORDER, GAP_BORDER);
        panel.setBorder(mainPanelBorder);


        BoxLayout mainPanelLayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(mainPanelLayout);
        panel.add(radioGroup);
        panel.add(directory);
        panel.add(Box.createRigidArea(gapInner));
        panel.add(inputScrollPane);
        panel.add(Box.createRigidArea(gapInner));
        panel.add(fileMask);
        panel.add(Box.createRigidArea(gapInner));
        panel.add(Box.createRigidArea(gapInner));
//        panel.add(search);
        panel.add(Box.createRigidArea(gapInner));
        panel.add(Box.createRigidArea(gapInner));
        panel.add(resultScrollPane);
        panel.add(Box.createRigidArea(gapInner));
        panel.add(copyMap);

        // final container
        Container container = getContentPane();
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        container.add(panel);
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
