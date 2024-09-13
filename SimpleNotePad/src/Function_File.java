import java.awt.*;

public class Function_File {

    GUI gui;
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
    }
}
