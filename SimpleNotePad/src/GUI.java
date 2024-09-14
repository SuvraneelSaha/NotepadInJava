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

    boolean wordWrapOn = false;

    JMenuBar menuBar;
    // menubar is the top menubar
    JMenu menuFile,menuEdit,menuFormat,menuColour;
    // this are all for the menu items

    JMenuItem itemNew,itemOpen,itemSave,itemSaveAs,itemExit;
    // thi are all inside the File item -- ie subitems
    // File
    Function_File file = new Function_File(this);

    Function_Format format = new Function_Format(this);
    // thi is for the format

    JMenuItem formatWordWrap;
    JMenu formatFont , formatFontSize;
    // these items will be inside the format section

    JMenuItem fontArial,fontCSMS,fontTNRoman, fontSize8,fontSize12,fontSize16,fontSize20,fontSize24,fontSize28;

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

        createFormatMenu();
        // for the format

        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();

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
        // this argument is just the name given for the menu item
        itemNew.addActionListener(this);
        // we can set a string value to trigger the ActionListener on this item
        // here we are using the string "New"
        itemNew.setActionCommand("New");
        // basically setter function
        menuFile.add(itemNew);

        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");
        menuFile.add(itemOpen);

        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("Save");
        menuFile.add(itemSave);

        itemSaveAs = new JMenuItem("Save As"); //this text will be the menu item name
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("Save As");
        menuFile.add(itemSaveAs);

        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("Exit");
        menuFile.add(itemExit);

    }

    public void createFormatMenu(){
        // Word Wrap inside the Format Section START
        formatWordWrap = new JMenuItem("Word Wrap: OFF");
        formatWordWrap.addActionListener(this);
        formatWordWrap.setActionCommand("Word Wrap");
        menuFormat.add(formatWordWrap);
        // Word Wrap inside the Format section END

        formatFont = new JMenu("Font");
        // we dont need to add action Listner as it is just a menu ;
        // not a clickable item
        menuFormat.add(formatFont);

        // font types sub items START
        fontArial = new JMenuItem("Arial");
        fontArial.addActionListener(this);
        fontArial.setActionCommand("Arial");
        // adding it to the formatFont menu
        formatFont.add(fontArial);

        fontCSMS = new JMenuItem("Comic Sans MS");
        fontCSMS.addActionListener(this);
        fontCSMS.setActionCommand("Comic Sans MS");
        //adding it to the formatFont menu
        formatFont.add(fontCSMS);

        fontTNRoman = new JMenuItem("Times New Roman");
        fontTNRoman.addActionListener(this);
        fontTNRoman.setActionCommand("Times New Roman");
        // adding it to the format Font Menu
        formatFont.add(fontTNRoman);
        // font types sub items END

        // Format Size START

        formatFontSize = new JMenu("Font Size");
        menuFormat.add(formatFontSize);

        fontSize8 = new JMenuItem("8");
        fontSize8.addActionListener(this);
        fontSize8.setActionCommand("size8");
        // adding it to the parent of this item - formatFontSize ;
        formatFontSize.add(fontSize8);

        fontSize12 = new JMenuItem("12");
        fontSize12.addActionListener(this);
        fontSize12.setActionCommand("size12");
        // adding it to the parent of this item - formatFontSize ;
        formatFontSize.add(fontSize12);

        fontSize16 = new JMenuItem("16");
        fontSize16.addActionListener(this);
        fontSize16.setActionCommand("size16");
        // adding it to the parent of this item - formatFontSize ;
        formatFontSize.add(fontSize16);

        fontSize20 = new JMenuItem("20");
        fontSize20.addActionListener(this);
        fontSize20.setActionCommand("size20");
        // adding it to the parent of this item - formatFontSize ;
        formatFontSize.add(fontSize20);

        fontSize24 = new JMenuItem("24");
        fontSize24.addActionListener(this);
        fontSize24.setActionCommand("size24");
        // adding it to the parent of this item - formatFontSize ;
        formatFontSize.add(fontSize24);

        fontSize28 = new JMenuItem("28");
        fontSize28.addActionListener(this);
        fontSize28.setActionCommand("size28");
        // adding it to the parent of this item - formatFontSize ;
        formatFontSize.add(fontSize28);

        // Format Size END




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
            case "Save":
                file.save();
                break;
            case "Save As":
                file.saveAs();
                break;
            case "Exit":
                file.exit();
                break;
            case "Word Wrap" :
                format.wordWrap();
                break;
            case "Arial":
                format.setFont("Arial");
                break;
            case "Comic Sans MS":
                format.setFont("Comic Sans MS");
                break;
                // both the one above and this one are the same
            case "Times New Roman":
                format.setFont("Times New Roman");
                break;
            case "size8":
                format.createFont(8);
                break;
            case "size12":
                format.createFont(12);
                break;
            case "size16":
                format.createFont(16);
                break;
            case "size20":
                format.createFont(20);
                break;
            case "size24":
                format.createFont(24);
                break;
            case "size28":
                format.createFont(28);
                break;

        }
    }
}


