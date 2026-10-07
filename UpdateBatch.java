import javax.swing.*;
import java.awt.*;

public class UpdateBatch extends JFrame {
    private JTextField txtSearchId;
    private JTextField txtStudentCount;
    private JCheckBox chkOpen;
    private JCheckBox chkClosed;
    private JButton btnUpdate;
    private JButton btnCancel;
    private Batch currentBatch = null;

    public UpdateBatch() {
        setTitle("Update Batch");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 500);
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 750, 50);
        topPanel.setBackground(new Color(25, 35, 110));
        topPanel.setLayout(null);

        JLabel lblTopTitle = new JLabel("Update Batch");
        lblTopTitle.setBounds(580, 12, 140, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(lblTopTitle);
        mainPanel.add(topPanel);

        txtSearchId = new JTextField();
        txtSearchId.setBounds(200, 75, 270, 30);
        mainPanel.add(txtSearchId);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(485, 75, 140, 30);
        btnSearch.setBackground(new Color(25, 35, 110));
        btnSearch.setForeground(Color.WHITE);
        mainPanel.add(btnSearch);

        JLabel lblStudentCount = new JLabel("Student Count");
        lblStudentCount.setBounds(80, 140, 110, 25);
        mainPanel.add(lblStudentCount);

        txtStudentCount = new JTextField();
        txtStudentCount.setBounds(200, 140, 270, 30);
        txtStudentCount.setEditable(false);
        mainPanel.add(txtStudentCount);

        JLabel lblStatus = new JLabel("Current Status");
        lblStatus.setBounds(80, 190, 110, 25);
        mainPanel.add(lblStatus);

        chkOpen = new JCheckBox("ENROLLMENT OPEN");
        chkOpen.setBounds(200, 190, 180, 25);
        chkOpen.setBackground(new Color(245, 247, 250));
        mainPanel.add(chkOpen);

        chkClosed = new JCheckBox("ENROLLMENT CLOSED");
        chkClosed.setBounds(400, 190, 200, 25);
        chkClosed.setBackground(new Color(245, 247, 250));
        mainPanel.add(chkClosed);

        ButtonGroup group = new ButtonGroup();
        group.add(chkOpen);
        group.add(chkClosed);

        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(370, 400, 120, 35);
        btnCancel.setBackground(new Color(150, 160, 175));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(e -> {
            new StudentManagementSystem().setVisible(true);
            dispose();
        });
        mainPanel.add(btnCancel);

        btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(505, 400, 120, 35);
        btnUpdate.setBackground(new Color(25, 35, 110));
        btnUpdate.setForeground(Color.WHITE);
        mainPanel.add(btnUpdate);

        btnSearch.addActionListener(e -> {
            String searchIdStr = txtSearchId.getText().trim();
            currentBatch = null;

            if (searchIdStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Batch ID!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int batchId;
            try {
                batchId = Integer.parseInt(searchIdStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric Batch ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Batch.getBatchNameArray() != null) {
                for (Batch b : Batch.getBatchNameArray()) {
                    if (b != null && b.getBatchNo() == batchId) {
                        currentBatch = b;
                        break;
                    }
                }
            }

            if (currentBatch != null) {
                txtStudentCount.setText("25"); 
                if (currentBatch.getStatus() == Batch.ENROLLMENT_OPEN) {
                    chkOpen.setSelected(true);
                } else {
                    chkClosed.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "This batch does not exist in the system.", "Error", JOptionPane.ERROR_MESSAGE);
                txtStudentCount.setText("");
                chkOpen.setSelected(false);
                chkClosed.setSelected(false);
            }
        });

        btnUpdate.addActionListener(e -> {
            if (currentBatch != null) {
                if (chkOpen.isSelected()) {
                    currentBatch.setStatus(Batch.ENROLLMENT_OPEN);
                } else if (chkClosed.isSelected()) {
                    currentBatch.setStatus(Batch.ENROLLMENT_CLOSED);
                }
                new showSuccessUpdateBatch(this, String.valueOf(currentBatch.getBatchNo())).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please search and select a batch first!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(mainPanel);
    }
}