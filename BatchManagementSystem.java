import javax.swing.*;
import java.awt.*;

public class BatchManagementSystem extends JFrame {

    /**
     * 
     */
    public BatchManagementSystem() {
        setTitle("Batch Management System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 750, 500);
        panel.setBackground(new Color(25, 35, 110));
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Batch Management System", JLabel.CENTER);
        lblTitle.setBounds(50, 25, 350, 25);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("", 1, 22));
        panel.add(lblTitle); 

        JLabel lblSubTitle = new JLabel("Choose an option from the menu below to get started", JLabel.CENTER);
        lblSubTitle.setBounds(50, 90, 350, 20);
        lblSubTitle.setForeground(new Color(200, 215, 240));
        lblSubTitle.setFont(new Font("", Font.PLAIN, 12));
        panel.add(lblSubTitle);

        JButton addBatchButton = new JButton("Add Batch");
        addBatchButton.setBounds(75, 140, 300, 40);
        panel.add(addBatchButton);

        addBatchButton.addActionListener(e -> {
            new AddBatch().setVisible(true);
            dispose();
        });

        JButton viewBatchesButton = new JButton("View Batches");
        viewBatchesButton.setBounds(75, 200, 300, 40);
        panel.add(viewBatchesButton);

        viewBatchesButton.addActionListener(e -> {
            new ViewBatches().setVisible(true);
            dispose();
        });

        JButton updateBatchButton = new JButton("Update Batch");
        updateBatchButton.setBounds(75, 260, 300, 40);
        panel.add(updateBatchButton);

        updateBatchButton.addActionListener(e -> {
            new UpdateBatch().setVisible(true);
            dispose();
        });

        JButton btnBack = new JButton("GO to Homepage");
        btnBack.setBounds(15, 390, 130, 30);
        btnBack.setBackground(Color.GRAY);
        btnBack.setForeground(Color.BLACK);
        panel.add(btnBack);

        btnBack.addActionListener(e -> {
            new studentHomepage().setVisible(true); 
            dispose();
        });

        add(panel);
    }
}
