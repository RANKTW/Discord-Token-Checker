package net.ranktw.discord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author RANKTW
 */
public class GuiInput extends javax.swing.JFrame {
    GuiInput() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        FromFileButton = new JRadioButton();
        FileTextField = new JTextField();
        fileInputButton = new JButton();
        FromTextButton = new JRadioButton();
        scrollPane = new JScrollPane();
        TextTextArea = new JTextArea();
        AddButton = new JButton();

        FileTextField.setBackground(new Color(0x5E5E5B));
        TextTextArea.setBackground(new Color(0x5E5E5B));

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setBackground(new Color(0x333333));

        FromFileButton.setText("From File");
        FromFileButton.setBackground(Color.DARK_GRAY);
        FromFileButton.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        FromFileButton.setForeground(new Color(255, 255, 255));
        FromFileButton.addActionListener(this::FromFileButtonActionPerformed);

        fileInputButton.setText("...");
        fileInputButton.addActionListener(this::FileInputButtonActionPerformed);

        FromTextButton.setText("From Text");
        FromTextButton.setBackground(Color.DARK_GRAY);
        FromTextButton.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        FromTextButton.setForeground(new Color(255, 255, 255));
        FromTextButton.addActionListener(this::FromTextButtonActionPerformed);

        TextTextArea.setColumns(20);
        TextTextArea.setRows(5);
        TextTextArea.setForeground(Color.white);
        scrollPane.setViewportView(TextTextArea);

        AddButton.setText("Add");
        AddButton.addActionListener(this::AddButtonActionPerformed);

        // <editor-fold defaultstate="collapsed" desc="Layout Code">
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(FromTextButton)
                                                        .addComponent(FromFileButton)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(FileTextField, GroupLayout.PREFERRED_SIZE, 241, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(fileInputButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(65, 65, 65)
                                                                .addComponent(AddButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FromFileButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(FileTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fileInputButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FromTextButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddButton))
        );

        pack();
        // </editor-fold>

    }// </editor-fold>

    private String path;
    private void FileInputButtonActionPerformed(ActionEvent evt) {
        path = FileUtil.chooseFile(Main.currFolder, this, new FileUtil.TxtFileFilter());
        if (path != null) {
            this.FileTextField.setText(path);
            Main.currFolder=new File(path);
            String s = path;
            String[] ss = s.split("\\.");
            String w = s.replace("."+ss[ss.length-1]," Worked."+ss[ss.length-1]);
            String i = s.replace("."+ss[ss.length-1]," Invalid."+ss[ss.length-1]);
            String u = s.replace("."+ss[ss.length-1]," Unverified."+ss[ss.length-1]);
            Main.guiMain.Workedpath = w;
            Main.guiMain.WorkedTextField.setText(w);
            Main.guiMain.Invalidpath = i;
            Main.guiMain.InvalidTextField.setText(i);
            Main.guiMain.Unverifiedpath = u;
            Main.guiMain.UnverifiedTextField.setText(u);
        }
    }
    private void FromFileButtonActionPerformed(ActionEvent evt) {
        this.FromFileButton.setSelected(true);
        this.FileTextField.setEnabled(true);
        this.fileInputButton.setEnabled(true);

        this.FromTextButton.setSelected(false);
        this.TextTextArea.setEnabled(false);

        this.FromFileButton.setForeground(new Color(255, 255, 255));
        this.FromTextButton.setForeground(new Color(168, 168, 168));
    }
    private void FromTextButtonActionPerformed(ActionEvent evt) {
        this.FromFileButton.setSelected(false);
        this.FileTextField.setEnabled(false);
        this.fileInputButton.setEnabled(false);

        this.FromTextButton.setSelected(true);
        this.TextTextArea.setEnabled(true);

        this.FromTextButton.setForeground(new Color(255, 255, 255));
        this.FromFileButton.setForeground(new Color(168, 168, 168));
    }

    private void AddButtonActionPerformed(ActionEvent evt) {
        if (FromFileButton.isSelected()) {
            if (!FileUtil.checkFileExist(path)) {
                JOptionPane.showMessageDialog(this, "Input File doesn't exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Main.tokens.clear();
            loadFile();
        }else {
            Main.tokens.clear();
            if (!TextTextArea.getText().equals("")){
                Main.tokens.addAll(Arrays.asList(TextTextArea.getText().split("\n")));
            }
        }
        this.setVisible(false);
        Main.guiMain.TotalInput.setText("Total Input - "+Main.tokens.size());
    }
    private void loadFile() {
        try {
            File file = new File(path);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                reader.lines().forEach(line -> Main.tokens.add(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            onUIManager();
            GuiInput input = new GuiInput();
            input.setVisible(true);
            input.getContentPane().setBackground(Color.darkGray);
            input.setLocationRelativeTo(null);
            input.setTitle("Input Tokens");
        });
    }
    static void start() {
        SwingUtilities.invokeLater(() -> {
            onUIManager();
            GuiInput input = new GuiInput();
            input.setVisible(false);
            input.getContentPane().setBackground(Color.darkGray);
            input.setLocationRelativeTo(null);
            input.setTitle("Input Tokens");

            input.FromFileButton.setSelected(true);
            input.FileTextField.setEnabled(true);
            input.fileInputButton.setEnabled(true);

            input.FromTextButton.setSelected(false);
            input.TextTextArea.setEnabled(false);

            input.FromFileButton.setForeground(new Color(255, 255, 255));
            input.FromTextButton.setForeground(new Color(168, 168, 168));

            Main.guiInput=input;
        });
    }
    private static void onUIManager(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { e.printStackTrace(); }
    }

    // Variables declaration - do not modify
    private JButton fileInputButton;
    private JButton AddButton;
    private JRadioButton FromFileButton;
    private JRadioButton FromTextButton;
    private JScrollPane scrollPane;
    private JTextArea TextTextArea;
    private JTextField FileTextField;
    // End of variables declaration
}
