package main.java.text_editor.gui;
import main.java.text_editor.functions.FileCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class MainPage extends JFrame{
    public JMenuBar menuBar;
    public JMenu fileMenu;
    public JMenuItem createFileItem;
    public JTextField filenameField;

    public MainPage(){
        setSize(1920,1080);
        setResizable(true);
        setTitle("Main Page");
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon(
                Objects.requireNonNull(MainPage.class.getResource("../resources/icon.png"))).getImage()
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPageGUI();
        setVisible(true);
    }

    public void MainPageGUI(){
        createMenuBar();
    }

    // TOP MENU
    private void createMenuBar() {

        // TOP BAR THAT WILL CONTAIN ALL THE JMENU AND THEIR ITEMS
        menuBar = new JMenuBar();

        // A JMENU IS LIKE A DROPDOWN MENU
        fileMenu = new JMenu("File");

        // ON JMenuItem THE PARAMETERS ARE THESE -> TEXT - IMG
        createFileItem = new JMenuItem("Create File");
        createFileItem.setToolTipText("Create a new file");
        createFileItem.addActionListener(this::createFile);

        // ADD ITEM TO JMENU
        fileMenu.add(createFileItem);
        // ADD JMENU TO TOP BAR
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    public void createFile(ActionEvent e){
        /*
            THIS FUNCTION WILL MAKE A POPUP APPEAR ON THE SCREEN
            AND WILL ASK THE USER TO INPUT THE FILE NAME, IF IT ALREADY EXISTS, IT WILL POPUP AN ERROR
            ELSE IT WILL CREATE THE FILE AND ALSO OPEN IT
         */
        filenameField = new JTextField();

        try{
            Object[] message = {
                    "File name:", filenameField
            };

            int option = JOptionPane.showConfirmDialog(
                    this,
                    message,
                    "Introduce the file name:",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (option == JOptionPane.OK_OPTION) {
                String filename = filenameField.getText();
                FileCreator.createFileCreator(filename);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }



    }

}
