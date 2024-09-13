import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;
    // works like the main windows where component like the lables buttons textfields are added
    // create a GUI

    JTextArea textArea ;
    // Multi line area that displays plain text;

    JScrollPane scrollPane;
    // basically acts as a scrollBar ;

    JMenuBar menuBar;

    JMenu menuFile,menuEdit,menuFormat,menuColour;

    JMenuItem itemNew,itemOpen,itemSave,itemSaveAs,itemExit;

    Function_File file = new Function_File(this);

    public static void main(String[] args) {
        new GUI();
    }
    public GUI()
    {
       createWindow();
       // for creating the window that we are concerned with ;

       createTextArea();
        // calling this method
        // now we need a scrollBar ;

        createMenuBar();
        // for creating MenuBar which will be at top ;

        createFileMenu();


       window.setVisible(true);
       // this is for the visibility




    }

    public void createWindow()
    {

        window = new JFrame("NotePad");
        // this will be present as the window name ; ie
        // top part of the window
        window.setSize(800,600);
        // this is for the size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this is for the close the window ;
    }

    public void createTextArea()
    {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // according to the size of the text area the Horizontal Scrollbar will come
        // and in the case of vertical scrollbar it will come accordingly ;

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        // for no border we need to use this BorderFactory class ;
        window.add(scrollPane);
       // window.add(textArea);
        // we wont be needing this window.add(textArea); as we have already used it in the initialization of the scrollpane object ;


    }

    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);


        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColour = new JMenu("Colour");
        menuBar.add(menuColour);

    }

    public void createFileMenu()
    {
        itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        // we can set a string value to trigger the ActionListener on this item
        // here we are using the string "New"
        itemNew.setActionCommand("New");
        menuFile.add(itemNew);

        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");
        menuFile.add(itemOpen);

        itemSave = new JMenuItem("Save");
        menuFile.add(itemSave);

        itemSaveAs = new JMenuItem("Save As");
        menuFile.add(itemSaveAs);

        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command)
        {
            case "New" :
                // we need to call the newFile();
                file.newFile();
                break;

            case "Open":
                file.open();
                break;

        }
    }
}

