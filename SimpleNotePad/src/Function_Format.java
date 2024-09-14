import java.awt.*;


public class Function_Format {
    GUI gui;

    Font arial,comicSansMS,timesNewRoman ;

    String selectedFont;

    public Function_Format(GUI gui)
    {
        this.gui = gui;
    }

    public void wordWrap()
    {
        if(gui.wordWrapOn == false)
        {
            gui.wordWrapOn = true;
            // word wrap happnes ;
            gui.textArea.setLineWrap(true);
            // this is how you make line breaking in the text area
            gui.textArea.setWrapStyleWord(true);
            // this method setWrapStyleWord is called so that line wrap does not happens
            // by breaking at middle of a word
            gui.formatWordWrap.setText("Word Wrap : ON");
        }
        else if(gui.wordWrapOn == true)
        {
            gui.wordWrapOn = false;

            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.formatWordWrap.setText("Word Wrap : OFF");
        }
    }

    public void createFont(int fontSize){
        System.out.println("createFont  method ");
        arial = new Font("FreeSans" , Font.PLAIN , fontSize);
        comicSansMS = new Font("Monospaced" , Font.PLAIN , fontSize);
        timesNewRoman = new Font("Noto Serif Georgian" , Font.PLAIN , fontSize);
        /*
        the problem lies in the font family ;
        Ariel , comic Sans ,
        Time New Roman does not exist as a font family these are like the placeholder in the
        object initialization ;

        so better to use other font families that are currently present in the java awt ;

        also the Java Awt library gets updated from time to time so for which this kinds
        of redundancy comes ;

         */



        setFont(selectedFont);
    }

    public void setFont(String font){
        System.out.println("setFont method");
        selectedFont = font;

        switch (selectedFont) {
            case "Arial":   gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS" : gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman" : gui.textArea.setFont(timesNewRoman);
                break;
            default:
                break;
        }

        System.out.println("type of font "+gui.textArea.getFont());

    }

    public void changeFontType(String newFontType)
    {

    }
}
