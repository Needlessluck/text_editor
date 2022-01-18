import java.awt.*;

public class FunctionForColor {
    GUI gui;
    String selectedColor;

    public FunctionForColor(GUI gui){
        this.gui=gui;
    }

    public void setColor(String colorToChange){
           selectedColor=colorToChange;
           switch(selectedColor){
               case "Black":gui.window.getContentPane().setBackground(Color.black);
                            gui.textArea.setBackground(Color.black);
                            gui.textArea.setForeground(Color.white);
                            break;
               case "White":gui.window.getContentPane().setBackground(Color.white);
                           gui.textArea.setBackground(Color.white);
                           gui.textArea.setForeground(Color.black);
                           break;
               case "Blue":gui.window.getContentPane().setBackground(Color.blue);
                           gui.textArea.setBackground(Color.blue);
                           gui.textArea.setForeground(Color.black);
                           break;
           }
    }
}
