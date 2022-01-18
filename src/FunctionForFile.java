import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionForFile {
    GUI gui;
    String fileName;
    String fileAddress;

    FunctionForFile(GUI gui){

        this.gui=gui;
    }

    public void newInFileMenu(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName=null;
        fileAddress=null;
    }

    public void openInFileMenu(){
        FileDialog fd=new FileDialog(gui.window,"Open",FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName=fd.getFile();
            fileAddress=fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            BufferedReader br=new BufferedReader(new FileReader(fileAddress+fileName));
            gui.textArea.setText("");

            String line=null;
            while((line= br.readLine())!=null){
                gui.textArea.append(line+'\n');
            }
            br.close();
        }
        catch (Exception e){
            System.out.print("Not oppened any file");
        }
    }

    public void save(){
        if(fileName==null){
            saveAs();
        }
        else{
            try {
                FileWriter fw=new FileWriter(fileAddress+fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            }
            catch (Exception e){
                System.out.println("Something went wrong");
            }
        }
    }

    public void saveAs(){
        FileDialog fd=new FileDialog(gui.window,"SaveAs",FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName=fd.getFile();
            fileAddress=fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try{
            FileWriter fw=new FileWriter(fileAddress+fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        }
        catch (Exception e){
            System.out.println("Something Went Wrong");
        }
    }
    public void exit(){
        System.exit(0);
    }
}
