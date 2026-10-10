import java.awt.*;
import javax.swing.*;

public class BatchWiseReport extends JFrame {

    public BatchWiseReport() {
        setTitle("Batch-wise Student Report");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 500);
        mainPanel.setBackground(new Color(25, 35, 110));
        mainPanel.setLayout(null);

        JLabel lblTitle = new JLabel("Batch-wise Student Report", JLabel.CENTER);
        lblTitle.setBounds(0, 40, 750, 40);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        mainPanel.add(lblTitle);

        JLabel lblSubTitle = new JLabel("Choose an option from the menu below to get started", JLabel.CENTER);
        lblSubTitle.setBounds(0, 90, 750, 20);
        lblSubTitle.setForeground(new Color(200, 210, 230));
        lblSubTitle.setFont(new Font("Arial", Font.PLAIN, 13));
        mainPanel.add(lblSubTitle);

        String[] batches = {"105 Batch", "106 Batch", "107 Batch", "108 Batch", "109 Batch", "110 Batch"};
        int y = 135;

        for (String batch : batches) {
            JButton btnBatch = new JButton(batch);
            btnBatch.setBounds(175, y, 400, 40);
            btnBatch.setBackground(new Color(215, 225, 250));
            btnBatch.setForeground(new Color(25, 35, 110));
            btnBatch.setFont(new Font("Arial", Font.BOLD, 16));
            btnBatch.setFocusPainted(false);
            btnBatch.addActionListener(e -> {
                new BatchStudentReportView(batch).setVisible(true);
                dispose();
            });
            mainPanel.add(btnBatch);
            y += 48;
        }

        JButton btnBack = new JButton("← Back to Home Page");
        btnBack.setBounds(40, 425, 180, 25);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Arial", Font.BOLD, 13));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(e -> {
            new ReportGenerator().setVisible(true);
            dispose();
        });
        mainPanel.add(btnBack);

        add(mainPanel);
    }
}