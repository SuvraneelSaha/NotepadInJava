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

        arial = new Font("Arial" , Font.PLAIN , fontSize);
        comicSansMS = new Font("Comic Sans MS" , Font.PLAIN , fontSize);
        timesNewRoman = new Font("Times New Roman" , Font.PLAIN , fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font){
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
    }
}
