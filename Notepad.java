import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Create a class named Notepad that extends JFrame and implements the ActionListener interface
public class Notepad extends JFrame implements ActionListener {
    JTextArea textArea; // Declare a JTextArea for text editing
    JScrollPane scrollPane; // Declare a JScrollPane for scrolling
    JMenuBar menuBar; // Declare a menu bar
    JMenu fileMenu, editMenu, helpMenu; // Declare three menus

    // Declare menu items for the File menu
    JMenuItem newMenuItem, openMenuItem, saveMenuItem, saveAsMenuItem, exitMenuItem;

    // Declare menu items for the Edit menu
    JMenuItem cutMenuItem, copyMenuItem, pasteMenuItem;

    // Declare a menu item for the Help menu
    JMenuItem aboutMenuItem;

    // Constructor for the Notepad class
    public Notepad() {
        setTitle("Notepad"); // Set the title of the JFrame
        setSize(500, 500); // Set the initial size of the JFrame
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Exit the application when the window is closed

        textArea = new JTextArea(); // Create a new JTextArea for text input
        scrollPane = new JScrollPane(textArea); // Add a scroll pane for the text area
        add(scrollPane); // Add the scroll pane to the JFrame

        menuBar = new JMenuBar(); // Create a menu bar
        fileMenu = new JMenu("File"); // Create a "File" menu
        editMenu = new JMenu("Edit"); // Create an "Edit" menu
        helpMenu = new JMenu("Help"); // Create a "Help" menu

        // Create menu items for the File menu
        newMenuItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        saveAsMenuItem = new JMenuItem("Save As");
        exitMenuItem = new JMenuItem("Exit");

        // Create menu items for the Edit menu
        cutMenuItem = new JMenuItem("Cut");
        copyMenuItem = new JMenuItem("Copy");
        pasteMenuItem = new JMenuItem("Paste");

        // Create a menu item for the Help menu
        aboutMenuItem = new JMenuItem("About");

        // Add action listeners for menu items
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        saveAsMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        cutMenuItem.addActionListener(this);
        copyMenuItem.addActionListener(this);
        pasteMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);

        // Add menu items to the File menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator(); // Add a separator line
        fileMenu.add(exitMenuItem);

        // Add menu items to the Edit menu
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        // Add the About menu item to the Help menu
        helpMenu.add(aboutMenuItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar); // Set the menu bar for the JFrame
    }

    // ActionPerformed method to handle menu item actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newMenuItem) {
            // Handle the "New" menu item - clear the text area
            textArea.setText("");
        } else if (e.getSource() == openMenuItem) {
            // Handle the "Open" menu item - open a file
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == saveMenuItem) {
            // Handle the "Save" menu item - save the content to a file
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(textArea.getText());
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == saveAsMenuItem) {
            // Handle the "Save As" menu item - save the content to a file
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(textArea.getText());
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == exitMenuItem) {
            // Handle the "Exit" menu item - exit the application
            System.exit(0);
        } else if (e.getSource() == cutMenuItem) {
            // Handle the "Cut" menu item - cut selected text
            textArea.cut();
        } else if (e.getSource() == copyMenuItem) {
            // Handle the "Copy" menu item - copy selected text
            textArea.copy();
        } else if (e.getSource() == pasteMenuItem) {
            // Handle the "Paste" menu item - paste text from clipboard
            textArea.paste();
        } else if (e.getSource() == aboutMenuItem) {
            // Handle the "About" menu item - show an about dialog
            JOptionPane.showMessageDialog(this, "Notepad Clone\n By Lead: Mrugank Worlikar \n Aryan Figer \n Adwait Chavan \n Vivian Ludrick", "About", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // The main method to start the application
    public static void main(String[] args) {
        Notepad notepad = new Notepad(); // Create an instance of the Notepad class
        notepad.setVisible(true); // Make the JFrame visible
    }
}
