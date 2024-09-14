import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    GUI gui;

    String fileName;
    String fileAddress;
    public Function_File(GUI gui){
        this.gui = gui;

    }
    public void newFile()
    {
        // it will start a new text file ;
        gui.textArea.setText("");
        // empty ie erase the current text
        gui.window.setTitle("New");

        // when we start the application ; the filename and the file address will have no name

        fileName = null;
        fileAddress = null ;


    }

    public void open()
    {
        FileDialog fd = new FileDialog(gui.window,"Open" ,FileDialog.LOAD );
        // if we want to open a file we need to use this FileDialog.LOAD ;
        // FileDialog.LOAD is the main point of opening any file ;
        // in this case opening text file

        fd.setVisible(true);
        // otherwise it wont show up ;

        // the content of the file is still not loaded ;

        if(fd.getFile() != null)
        {
           fileName = fd.getFile();
           // we will get the file Name
            fileAddress = fd.getDirectory();
            // this is how we get the file address of the file ;

            gui.window.setTitle(fileName);
            // we will give the title as the File Name that we have selected ;

        }
        System.out.println("File address and file name "+fileAddress + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            // take t
            // whenever we read a file it needs the address of the file

                    // a class which reads text finds a character from the  input stream ; -- BufferReader ;
            gui.textArea.setText("");
            // clearing the Text area ;

            String line = null;

            while ((line=br.readLine()) != null)
            {
                // readLine() reads a line of text ;
                // as long as line are present -- in teext format - it will go on in the loop ;
                // each line of text is read

                gui.textArea.append(line+"\n");
            }
            br.close();

        }
        catch (Exception e)
        {
            System.out.println("File not opened!!");
        }
    }

    public void save()
    {
        // it is basically overrides the current text ;
        // acts as the save function

        if(fileName==null)
        {
            // it means it is a new file ; it has not been saved yet ;
            saveAs();
        }
        else
        {
            try
            {
                FileWriter fw = new FileWriter(fileAddress+fileName);
                fw.write(gui.textArea.getText());
                // it will take the text which is present in the text Area ;
                gui.window.setTitle(fileName);
                // we will be setting the fileName as this will be a new file
                fw.close();
            }
            catch (Exception e)
            {
                System.out.println("Problem in Save method !!");
            }
        }

    }

    public void saveAs()
    {
        FileDialog fd = new FileDialog(gui.window,"Save As",FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!= null)
        {
            fileName = fd.getFile();
            fileAddress=fd.getDirectory();
            gui.window.setTitle(fileName);

        }

        try
        {
            // we will be using file writer ;
            FileWriter fw = new FileWriter(fileAddress+fileName);
            fw.write(gui.textArea.getText());
            // it will get text from what is written in the text area and
            // it will write it to the new file ;
            // using the help of the FileWriter ;

            fw.close();

        }
        catch (Exception e)
        {
            System.out.println("Something Wrong from this Save As  ");
        }
    }

    public void exit()
    {
        System.exit(0);
    }




}
