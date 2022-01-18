import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    boolean wordWrap=false;
    //text area
    JTextArea textArea;
    JScrollPane scrollPane;
    //main menu
    JMenuBar menuBar;
    JMenu File,Edit,Color,Format;
    //file menu
    JMenuItem fNew,fOpen,fSave,fSaveAs,fExit;
    //format menu
    JMenuItem formatWordWrap,fontTNR,fontCaliber,fontArial,fontSize8,fontSize12,fontSize16,fontSize20,fontSize24;
    JMenu formatFont,formatFontSize;
    //color menu
    JMenuItem color1,color2,color3;
    //edit menu
    JMenuItem editUndo,editRedo;

    UndoManager um=new UndoManager();

    FunctionForFile newFile=new FunctionForFile(this);
    FunctionForFormat newFormat=new FunctionForFormat(this);
    FunctionForColor newColor=new FunctionForColor(this);
    FunctionForEdit newEdit=new FunctionForEdit(this);
    public static void main(String[] args) {
        new GUI();
    }

    public GUI(){

        createWindow();
        createtextArea();
        createMenuBar();
        createFileMenu();
        createFomatMenu();

        newFormat.selectedStyle="Arial";
        newFormat.wordSize(12);

        createColorMenu();

        newColor.setColor("White");

        createEditMenu();

        window.setVisible(true);


    }

    public void createWindow(){

        window = new JFrame("Text-Editor");
        window.setSize(600,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createtextArea(){
        textArea=new JTextArea();

                textArea.getDocument().addUndoableEditListener(
                        new UndoableEditListener() {
                            @Override
                            public void undoableEditHappened(UndoableEditEvent e) {
                                um.addEdit(e.getEdit());
                            }
                        }
                );
        scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){
        menuBar=new JMenuBar();
        window.setJMenuBar(menuBar);


        File=new JMenu("File");
        menuBar.add(File);


        Edit=new JMenu("Edit");
        menuBar.add(Edit);


        Format=new JMenu("Format");
        menuBar.add(Format);

        Color=new JMenu("Color");
        menuBar.add(Color);
    }

    public void createFileMenu(){
        fNew=new JMenuItem("New");
        fNew.addActionListener(this);
        fNew.setActionCommand("New");
        File.add(fNew);


        fOpen=new JMenuItem("Open");
        fOpen.addActionListener(this);
        fOpen.setActionCommand("Open");
        File.add(fOpen);


        fSave=new JMenuItem("Save");
        fSave.addActionListener(this);
        fSave.setActionCommand("Save");
        File.add(fSave);

        fSaveAs=new JMenuItem("SaveAs");
        fSaveAs.addActionListener(this);
        fSaveAs.setActionCommand("SaveAs");
        File.add(fSaveAs);

        fExit=new JMenuItem("Exit");
        fExit.addActionListener(this);
        fExit.setActionCommand("Exit");
        File.add(fExit);
    }

    public void createFomatMenu(){
        formatWordWrap=new JMenuItem("Word-Wrap:off");
        formatWordWrap.addActionListener(this);
        formatWordWrap.setActionCommand("Word-Wrap-Toggle");
        Format.add(formatWordWrap);

        formatFont=new JMenu("Font");

        fontArial=new JMenuItem("Arial");
        fontArial.addActionListener(this);
        fontArial.setActionCommand("Arial");
        formatFont.add(fontArial);

        fontTNR=new JMenuItem("Times New Roman");
        fontTNR.addActionListener(this);
        fontTNR.setActionCommand("Times New Roman");
        formatFont.add(fontTNR);

        fontCaliber=new JMenuItem("Caliber");
        fontCaliber.addActionListener(this);
        fontCaliber.setActionCommand("Caliber");
        formatFont.add(fontCaliber);

        Format.add(formatFont);

        formatFontSize=new JMenu("Font-Size");

        fontSize8=new JMenuItem("8");
        fontSize8.addActionListener(this);
        fontSize8.setActionCommand("8");
        formatFontSize.add(fontSize8);

        fontSize12=new JMenuItem("12");
        fontSize12.addActionListener(this);
        fontSize12.setActionCommand("12");
        formatFontSize.add(fontSize12);

        fontSize16=new JMenuItem("16");
        fontSize16.addActionListener(this);
        fontSize16.setActionCommand("16");
        formatFontSize.add(fontSize16);

        fontSize20=new JMenuItem("20");
        fontSize20.addActionListener(this);
        fontSize20.setActionCommand("20");
        formatFontSize.add(fontSize20);

        fontSize24=new JMenuItem("24");
        fontSize24.addActionListener(this);
        fontSize24.setActionCommand("24");
        formatFontSize.add(fontSize24);

        Format.add(formatFontSize);

    }

    public void createColorMenu(){

        color1=new JMenuItem("Black");
        color1.addActionListener(this);
        color1.setActionCommand("Black");
        Color.add(color1);

        color2=new JMenuItem("White");
        color2.addActionListener(this);
        color2.setActionCommand("White");
        Color.add(color2);

        color3=new JMenuItem("Blue");
        color3.addActionListener(this);
        color3.setActionCommand("Blue");
        Color.add(color3);
    }

    public void createEditMenu(){
        editUndo=new JMenuItem("Undo");
        editUndo.addActionListener(this);
        editUndo.setActionCommand("Undo");
        Edit.add(editUndo);

        editRedo=new JMenuItem("Redo");
        editRedo.addActionListener(this);
        editRedo.setActionCommand("Redo");
        Edit.add(editRedo);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
           String command=e.getActionCommand();
           switch (command){
               case "New":newFile.newInFileMenu();break;
               case "Open":newFile.openInFileMenu();break;
               case "SaveAs":newFile.saveAs();break;
               case "Save":newFile.save();break;
               case "Exit":newFile.exit();break;
               case "Word-Wrap-Toggle":newFormat.wordWraping();break;
               case "Arial": newFormat.wordStyle("Arial");break;
               case "Caliber": newFormat.wordStyle("Caliber");break;
               case "Times New Roman": newFormat.wordStyle("Times New Roman");break;
               case "8":newFormat.wordSize(8);break;
               case "12":newFormat.wordSize(12);break;
               case "16":newFormat.wordSize(16);break;
               case "20":newFormat.wordSize(20);break;
               case "24":newFormat.wordSize(24);break;
               case "Black":newColor.setColor("Black");break;
               case "White":newColor.setColor("White");break;
               case "Blue":newColor.setColor("Blue");break;
               case "Redo":newEdit.redoEdit();break;
               case "Undo":newEdit.undoEdit();break;
           }
    }
}
