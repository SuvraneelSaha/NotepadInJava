import java.awt.*;


public class Function_Format {
    GUI gui;

    Font arial,comicSansMs,timeNewRoman ;

    //String selectedFont;

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

//    public void createFont(int fontSize)
//    {
//        // this method is for changing the font and also the size of that of the font
//
//        //arial = new Font("Arial",Font.PLAIN , fontSize);
//        //comicSansMs = new Font("Comic Sans MS",Font.PLAIN,fontSize);
//        //timeNewRoman = new Font("Times New Roman",Font.PLAIN,fontSize);
//
//        //setFont(selectedFont);
//        // khotka place
//    }

//    public void setFont(String font)
//    {
//        selectedFont = font;
//
//        switch (selectedFont) {
//            case "Arial":
//                gui.textArea.setFont(arial);
//                break;
//            case "Comic Sans MS" :
//                gui.textArea.setFont(comicSansMs);
//                break;
//            case "Times New Roman" :
//                gui.textArea.setFont(timeNewRoman);
//                break;
//        }
//
//    }

    public void changeFontSize(int newFontSize)
    {
        Font currentFont =  gui.textArea.getFont();

        Font newFont = new Font(currentFont.getName(),currentFont.getStyle(),newFontSize);

        gui.textArea.setFont(newFont);
    }

    public void changeFontType(String newFontType)
    {
        // get the current font from the text area
        Font currentFont = gui.textArea.getFont();

        // Create a new Font object with the new font type, same style, and same size
        Font newFont = new Font(newFontType, currentFont.getStyle(), currentFont.getSize());

        gui.textArea.setFont(newFont);

    }
}
