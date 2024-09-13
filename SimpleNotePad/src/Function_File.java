import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

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




}
