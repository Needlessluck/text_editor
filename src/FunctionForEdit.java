import java.awt.*;

public class FunctionForEdit {
    GUI gui;

    FunctionForEdit(GUI gui){
        this.gui=gui;
    }

    public void redoEdit(){
         gui.um.redo();
    }

    public void undoEdit(){
         gui.um.undo();
    }
}
