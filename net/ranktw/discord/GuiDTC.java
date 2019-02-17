package net.ranktw.discord;

import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;

public class GuiDTC extends JFrame {
    private boolean checking=false;
    GuiDTC() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        TotalInput = new JLabel();
        InputTokensButton = new JButton();
        panel = new JPanel();
        panel.setBackground(new Color(0x5E5E5B));
        WorkedCheckBox = new JCheckBox();
        WorkedTextField = new JTextField();
        WorkedBrowse = new JButton();
        InvalidCheckBox = new JCheckBox();
        InvalidBrowse = new JButton();
        InvalidTextField = new JTextField();
        scrollPane = new JScrollPane();
        textArea = new JTextArea();
        CheckButton = new JButton();

        UnverifiedCheckBox = new JCheckBox();
        UnverifiedTextField = new JTextField();
        UnverifiedBrowse = new JButton();

        UnverifiedCheckBox.setFont(new Font("Arial Black", 0, 10)); // NOI18N
        UnverifiedCheckBox.setForeground(new Color(255, 255, 255));
        UnverifiedCheckBox.setText("Unverified");
        UnverifiedCheckBox.setMargin(new Insets(2, 0, 2, 0));
        UnverifiedCheckBox.setBackground(new Color(0x5E5E5B));
        UnverifiedCheckBox.addActionListener(this::UnverifiedCheckBoxActionPerformed);

        UnverifiedBrowse.setFont(UnverifiedBrowse.getFont());
        UnverifiedBrowse.setText("Browse");
        UnverifiedBrowse.addActionListener(this::UnverifiedFileButtonActionPerformed);

        scrollPane.getVerticalScrollBar().addAdjustmentListener(e -> {
            if (checking)e.getAdjustable().setValue(e.getAdjustable().getMaximum());
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(51, 51, 51));

        TotalInput.setBackground(new Color(51, 51, 51));
        TotalInput.setFont(new Font("Arial Black", 1, 12)); // NOI18N
        TotalInput.setForeground(new Color(255, 255, 255));
        TotalInput.setHorizontalAlignment(SwingConstants.CENTER);
        TotalInput.setText("Total Input - 0");
        TotalInput.setToolTipText("");

        InputTokensButton.setFont(InputTokensButton.getFont());
        InputTokensButton.setText("Input Tokens");
        InputTokensButton.addActionListener(this::InputTokensActionPerformed);
//        InputTokensButton.getModel().addChangeListener(e -> {
//            ButtonModel model = (ButtonModel) e.getSource();
//
//            if (model.isRollover()) {
//                InputTokensButton.setBackground(new Color(31, 90, 40).brighter());
//            } else if (model.isPressed()) {
//                InputTokensButton.setBackground(Color.BLACK);
//            } else {
//                InputTokensButton.setBackground(new Color(25, 90, 43));
//            }
//        });
//        InputTokensButton.addMouseListener(new MouseAdapter() {
//            public void mouseEntered(MouseEvent evt) {
//                InputTokensButton.setBackground(Color.GREEN);
//            }
//
//            public void mouseExited(MouseEvent evt) {
//                InputTokensButton.setBackground(UIManager.getColor("control"));
//            }
//        });

        panel.setBorder(BorderFactory.createTitledBorder(null, "Output", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial Black", 0, 12), new Color(255, 255, 255))); // NOI18N

        WorkedCheckBox.setFont(new Font("Arial Black", 0, 12)); // NOI18N
        WorkedCheckBox.setForeground(new Color(255, 255, 255));
        WorkedCheckBox.setText("Worked");
        WorkedCheckBox.setMargin(new Insets(2, 0, 2, 0));
        WorkedCheckBox.setBackground(new Color(0x5E5E5B));
        WorkedCheckBox.addActionListener(this::WorkedCheckBoxActionPerformed);

        WorkedBrowse.setFont(WorkedBrowse.getFont());
        WorkedBrowse.setText("Browse");
        WorkedBrowse.addActionListener(this::WorkedFileButtonActionPerformed);

        InvalidCheckBox.setFont(new Font("Arial Black", 0, 12)); // NOI18N
        InvalidCheckBox.setForeground(new Color(255, 255, 255));
        InvalidCheckBox.setText("Invalid");
        InvalidCheckBox.setMargin(new Insets(2, 0, 2, 0));
        InvalidCheckBox.setBackground(new Color(0x5E5E5B));
        InvalidCheckBox.addActionListener(this::InvalidCheckBoxActionPerformed);

        InvalidBrowse.setFont(InvalidBrowse.getFont());
        InvalidBrowse.setText("Browse");
        InvalidBrowse.addActionListener(this::InvalidFileButtonActionPerformed);

        textArea.setEditable(false);
        textArea.setBackground(new Color(51, 51, 51));
        textArea.setColumns(20);
        textArea.setFont(textArea.getFont());
        textArea.setRows(5);
        textArea.setForeground(new Color(255, 255, 255));
        textArea.setSelectionColor(new Color(0x5D9F6E));
        scrollPane.setViewportView(textArea);

        CheckButton.setText("Check");
        CheckButton.addActionListener(this::CheckButtonActionPerformed);

        // <editor-fold defaultstate="collapsed" desc="Layout Code">
        GroupLayout jPanel1Layout = new GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(WorkedCheckBox, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(WorkedTextField, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(WorkedBrowse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(UnverifiedCheckBox, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(UnverifiedTextField, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(UnverifiedBrowse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(InvalidCheckBox, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(InvalidTextField, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(InvalidBrowse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(WorkedCheckBox)
                                        .addComponent(WorkedTextField)
                                        .addComponent(WorkedBrowse))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(UnverifiedCheckBox)
                                        .addComponent(UnverifiedTextField)
                                        .addComponent(UnverifiedBrowse))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(InvalidCheckBox)
                                        .addComponent(InvalidTextField)
                                        .addComponent(InvalidBrowse)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(TotalInput, GroupLayout.PREFERRED_SIZE, 239, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(InputTokensButton, -1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane)
                        .addComponent(CheckButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TotalInput, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(InputTokensButton))
                                .addGap(1, 1, 1)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(CheckButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        );

        pack();
        // </editor-fold>

    }// </editor-fold>

    private void InputTokensActionPerformed(ActionEvent evt) {
        Main.guiInput.setVisible(true);
        Main.guiInput.setAlwaysOnTop(true);
    }

    private void WorkedCheckBoxActionPerformed(ActionEvent evt) {
        this.WorkedTextField.setEnabled(WorkedCheckBox.isSelected());
        this.WorkedBrowse.setEnabled(WorkedCheckBox.isSelected());
    }
    private void InvalidCheckBoxActionPerformed(ActionEvent evt) {
        this.InvalidTextField.setEnabled(InvalidCheckBox.isSelected());
        this.InvalidBrowse.setEnabled(InvalidCheckBox.isSelected());
    }
    private void UnverifiedCheckBoxActionPerformed(ActionEvent evt) {
        this.UnverifiedTextField.setEnabled(UnverifiedCheckBox.isSelected());
        this.UnverifiedBrowse.setEnabled(UnverifiedCheckBox.isSelected());
    }

    String Workedpath="Token Worked.txt";
    String Invalidpath="Token Invalid.txt";
    String Unverifiedpath="Token Unverified.txt";
    private void WorkedFileButtonActionPerformed(ActionEvent evt) {
        Workedpath = FileUtil.chooseFile(Main.currFolder, this, new FileUtil.TxtFileFilter());
        if (Workedpath != null) {
            this.WorkedTextField.setText(Workedpath);
            Main.currFolder=new File(Workedpath);
        }
    }
    private void InvalidFileButtonActionPerformed(ActionEvent evt) {
        Invalidpath = FileUtil.chooseFile(Main.currFolder, this, new FileUtil.TxtFileFilter());
        if (Invalidpath != null) {
            this.InvalidTextField.setText(Invalidpath);
            Main.currFolder=new File(Invalidpath);
        }
    }
    private void UnverifiedFileButtonActionPerformed(ActionEvent evt) {
        Unverifiedpath = FileUtil.chooseFile(Main.currFolder, this, new FileUtil.TxtFileFilter());
        if (Unverifiedpath != null) {
            this.UnverifiedTextField.setText(Unverifiedpath);
            Main.currFolder=new File(Unverifiedpath);
        }
    }

    private void CheckButtonActionPerformed(ActionEvent evt) {
        if (Main.tokens.size()==0)return;

        if (WorkedCheckBox.isSelected())if (!FileUtil.checkFileExistOrCreate(new File(Workedpath))){
            JOptionPane.showMessageDialog(this, "Worked output isn't a valid File path", "ERROR", JOptionPane.ERROR_MESSAGE );
            return;
        }
        if (InvalidCheckBox.isSelected())if (!FileUtil.checkFileExistOrCreate(new File(Invalidpath))){
            JOptionPane.showMessageDialog(this, "Invalid output isn't a valid File path", "ERROR", JOptionPane.ERROR_MESSAGE );
            return;
        }
        if (UnverifiedCheckBox.isSelected())if (!FileUtil.checkFileExistOrCreate(new File(Unverifiedpath))){
            JOptionPane.showMessageDialog(this, "Unverified output isn't a valid File path", "ERROR", JOptionPane.ERROR_MESSAGE );
            return;
        }
        if (checking)return;
        checking=true;
        CheckButton.setEnabled(false);
        check();
    }
    private void check(){
        new Thread(() -> {
            WorkedWriter = null;
            InvalidWriter = null;
            UnverifiedWriter = null;
            try {
                if (WorkedCheckBox.isSelected()) WorkedWriter = new BufferedWriter(new FileWriter(Workedpath));
                if (InvalidCheckBox.isSelected()) InvalidWriter = new BufferedWriter(new FileWriter(Invalidpath));
                if (UnverifiedCheckBox.isSelected())
                    UnverifiedWriter = new BufferedWriter(new FileWriter(Unverifiedpath));

                int i = 0;
                for (String token : Main.tokens) {
                    CheckButton.setText("(" + i + "/" + Main.tokens.size() + ")");
                    i++;
                    write(Main.InfoToken(token, i), token);
                }
                this.w = 0;
                this.u = 0;
                this.i = 0;
                CheckButton.setText("Check");
                checking = false;
                CheckButton.setEnabled(true);

            }catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (WorkedWriter != null) {
                    try {
                        WorkedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (InvalidWriter != null) {
                    try {
                        InvalidWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (UnverifiedWriter != null) {
                    try {
                        UnverifiedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    BufferedWriter WorkedWriter = null;
    BufferedWriter InvalidWriter = null;
    BufferedWriter UnverifiedWriter = null;

    private int w, i, u;
    private void write(Status status,String token) throws IOException {
        switch (status) {
            case Worked:w++;
                if (WorkedCheckBox.isSelected()) {
                    WorkedWriter.write((w==1?"":"\n")+token);
                }
                break;
            case Unverified:u++;
                if (UnverifiedCheckBox.isSelected()) {
                    UnverifiedWriter.write((u==1?"":"\n")+token);
                }
                break;
            case Invalid:i++;
                if (InvalidCheckBox.isSelected()) {
                    InvalidWriter.write((i==1?"":"\n")+token);
                }
                break;
        }
        TotalInput.setText("Worked: "+w+" Unverified: "+u+" Invalid: "+i);
    }

    public void addLine(String s){
        textArea.append(s+"\n");
    }

    public static void main(String args[]) {
        onGUI();
    }
    private static void onUIManager(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { e.printStackTrace(); }
    }
    static void start(){
        onGUI();
    }
    private static void onGUI() {
        SwingUtilities.invokeLater(() -> {
            onUIManager();
            GuiDTC main = new GuiDTC();
            main.setVisible(true);
            main.getContentPane().setBackground(new Color(0x5E5E5B));
            main.setLocationRelativeTo(null);
            main.setTitle("Discord Token Checker - ᵇʸ ᴿᴬᴺᴷᵀᵂ");

            URL url = GuiDTC.class.getResource("/Head.png");
            main.setIconImage(Toolkit.getDefaultToolkit().getImage(url));
            main.WorkedCheckBox.setSelected(true);
            main.InvalidTextField.setEnabled(false);
            main.InvalidBrowse.setEnabled(false);
            main.UnverifiedTextField.setEnabled(false);
            main.UnverifiedBrowse.setEnabled(false);

            main.WorkedTextField.setText("Token Worked.txt");
            main.InvalidTextField.setText("Token Invalid.txt");
            main.UnverifiedTextField.setText("Token Unverified.txt");
            Main.guiMain=main;
        });
    }

    // Variables declaration - do not modify
    private JButton InputTokensButton;
    private JButton WorkedBrowse;
    private JButton InvalidBrowse;
    private JButton CheckButton;
    private JButton UnverifiedBrowse;
    private JCheckBox WorkedCheckBox;
    private JCheckBox InvalidCheckBox;
    private JCheckBox UnverifiedCheckBox;
    JLabel TotalInput;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    JTextField WorkedTextField;
    JTextField InvalidTextField;
    JTextField UnverifiedTextField;

    // End of variables declaration

    public enum Status{
        Worked,
        Invalid,
        Unverified
    }
}
