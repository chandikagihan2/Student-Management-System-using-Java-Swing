import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class ViewBatches extends JFrame {

    public ViewBatches() {
        setTitle("View Batches");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 500);
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 750, 50);
        topPanel.setBackground(new Color(25, 35, 110));
        topPanel.setLayout(null);

        JLabel lblTopTitle = new JLabel("View Batches");
        lblTopTitle.setBounds(580, 12, 140, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(lblTopTitle);
        mainPanel.add(topPanel);

        // Create a table
        String[] columnNames = {"No", "Batch No", "Student Count", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 90, 650, 260);
        mainPanel.add(scrollPane);

        //add data to the table
        if (Batch.getBatchNameArray() != null) {
            int index = 1;
            for (Batch b : Batch.getBatchNameArray()) {
                if (b != null) {
                    String statusStr = (b.getStatus() == Batch.ENROLLMENT_OPEN) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
                    Object[] row = {index++, b.getBatchNo(), "25", statusStr};
                    model.addRow(row);
                }
            }
        }

        JButton btnBackHome = new JButton("BACK TO HOME PAGE");
        btnBackHome.setBounds(50, 400, 210, 35);
        btnBackHome.setBackground(new Color(25, 35, 110));
        btnBackHome.setForeground(Color.WHITE);
        btnBackHome.setFocusPainted(false);
        
        btnBackHome.addActionListener(e -> {
            new StudentManagementSystem().setVisible(true);
            dispose();
        });
        mainPanel.add(btnBackHome);

        add(mainPanel);
    }
}
