import java.awt.*;

public class Function_Color {
    GUI gui;

    public Function_Color(GUI gui)
    {
        this.gui = gui;
    }
    public void changeColour(String colour)
    {
        switch (colour)
        {
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
                // setForeground means that the color of the font will be black ;
                // whenever the color of the background will be white
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(Color.blue);
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(new Color(222, 181, 69));
                // rgb color is also allowed in this
                break;

                /*
                Java Ex 31 place a color palette 
                 */
        }
    }
}
