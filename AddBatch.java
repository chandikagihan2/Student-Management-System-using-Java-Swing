import javax.swing.*;
import java.awt.*;

public class AddBatch extends JFrame {
    private JTextField txtBatchNo;
    private JButton btnAddBatch;
    private JButton btnCancel;


    public AddBatch() {
        setTitle("Add Batch");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setBounds(0, 0, 750, 500);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(25, 35, 110));
        topPanel.setBounds(0, 0, 750, 50);

        JLabel lblTopTitle = new JLabel("Add Batch");
        lblTopTitle.setBounds(600, 12, 120, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("", 1, 16));
        topPanel.add(lblTopTitle);
        mainPanel.add(topPanel);

        JLabel lblBatchNo = new JLabel("Batch Number");
        lblBatchNo.setBounds(80, 130, 120, 25);
        mainPanel.add(lblBatchNo);

        txtBatchNo = new JTextField();
        txtBatchNo.setBounds(220, 130, 280, 30);
        mainPanel.add(txtBatchNo);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(370, 400, 120, 35);
        btnCancel.setBackground(new Color(150, 160, 175));
        btnCancel.setForeground(Color.WHITE);
        mainPanel.add(btnCancel);

        btnCancel.addActionListener(e -> {
            new BatchManagementSystem().setVisible(true);
            dispose();
        });

        btnAddBatch = new JButton("Add Batch");
        btnAddBatch.setBounds(505, 400, 120, 35);
        btnAddBatch.setBackground(new Color(25, 35, 110));
        btnAddBatch.setForeground(Color.WHITE);
        mainPanel.add(btnAddBatch);

        btnAddBatch.addActionListener(e -> {
            String batchNo = txtBatchNo.getText().trim();

            if (batchNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a batch number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int BatchNo;
            try {
                BatchNo = Integer.parseInt(txtBatchNo.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Batch Number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isExists = false;
            Batch[] batches = Batch.getBatchNameArray();
            for (Batch b : batches) {
                if (b != null && b.getBatchNo() == BatchNo) {
                    isExists = true;
                    break;
                }
            }

            if (isExists) {
                JOptionPane.showMessageDialog(this, "This Batch is already added to the system!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Batch newBatch = new Batch(BatchNo, Batch.ENROLLMENT_OPEN);
                Batch.addBatch(newBatch);

                new showSuccessAddBatch(this, String.valueOf(BatchNo)).setVisible(true);
                dispose();
            }
        });
           
        add(mainPanel);
    }
}
