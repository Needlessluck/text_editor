import java.awt.*;

public class FunctionForFormat {
    GUI gui;
    Font arial,caliber,TMS;
    String selectedStyle;


    public FunctionForFormat(GUI gui){
        this.gui=gui;
    }

    public void wordWraping(){
        if(!gui.wordWrap){
           gui.wordWrap=true;
           gui.textArea.setLineWrap(true);
           gui.textArea.setWrapStyleWord(true);
           gui.formatWordWrap.setText("Word-Wrap:ON");
        }
        else{
            gui.wordWrap=false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.formatWordWrap.setText("Word-Wrap:OFF");
        }
    }

    public void wordSize(int size){
        arial=new Font("Arial",Font.PLAIN,size);
        caliber=new Font("caliber",Font.PLAIN,size);
        TMS=new Font("Times New Roman",Font.PLAIN,size);

        wordStyle(selectedStyle);
    }

    public void wordStyle(String style){
        selectedStyle=style;
        switch (selectedStyle){
            case "Arial":gui.textArea.setFont(arial);break;
            case "Times New Roman":gui.textArea.setFont(TMS);break;
            case "Caliber":gui.textArea.setFont(caliber);break;
        }
    }
}
