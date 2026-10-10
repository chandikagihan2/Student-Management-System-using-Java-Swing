import java.awt.*;
import javax.swing.*;

public class ReportGenerator extends JFrame {

    public ReportGenerator() {
        setTitle("Report Management");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 500);
        mainPanel.setBackground(new Color(25, 35, 110));
        mainPanel.setLayout(null);

        JLabel lblTitle = new JLabel("Report Management", JLabel.CENTER);
        lblTitle.setBounds(0, 50, 750, 40);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        mainPanel.add(lblTitle);

        JLabel lblSubTitle = new JLabel("Choose an option from the menu below to get started", JLabel.CENTER);
        lblSubTitle.setBounds(0, 100, 750, 25);
        lblSubTitle.setForeground(new Color(200, 210, 230));
        lblSubTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(lblSubTitle);

        JButton btnStudentRegReport = new JButton("Student Registration Report");
        btnStudentRegReport.setBounds(175, 165, 400, 50);
        btnStudentRegReport.setBackground(new Color(215, 225, 250));
        btnStudentRegReport.setForeground(new Color(25, 35, 110));
        btnStudentRegReport.setFont(new Font("Arial", Font.BOLD, 18));
        btnStudentRegReport.setFocusPainted(false);
        
        btnStudentRegReport.addActionListener(e -> {
            new StudentRegistrationReport().setVisible(true);
            dispose();    
        });
        mainPanel.add(btnStudentRegReport);

        JButton btnBatchWiseReport = new JButton("Batch-wise Student Report");
        btnBatchWiseReport.setBounds(175, 235, 400, 50);
        btnBatchWiseReport.setBackground(new Color(215, 225, 250));
        btnBatchWiseReport.setForeground(new Color(25, 35, 110));
        btnBatchWiseReport.setFont(new Font("Arial", Font.BOLD, 18));
        btnBatchWiseReport.setFocusPainted(false);
       
        btnBatchWiseReport.addActionListener(e -> {
            new BatchWiseReport().setVisible(true);
            dispose();    
        });
        mainPanel.add(btnBatchWiseReport);

        JButton btnTrainingReport = new JButton("Industry Training Eligibility Report");
        btnTrainingReport.setBounds(175, 305, 400, 50);
        btnTrainingReport.setBackground(new Color(215, 225, 250));
        btnTrainingReport.setForeground(new Color(25, 35, 110));
        btnTrainingReport.setFont(new Font("Arial", Font.BOLD, 18));
        btnTrainingReport.setFocusPainted(false);
        
        btnTrainingReport.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Opening Industry Training Eligibility Report...");
        });
        mainPanel.add(btnTrainingReport);

        JButton btnBack = new JButton("← Back to Main Menu");
        btnBack.setBounds(40, 420, 180, 25);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Arial", Font.BOLD, 13));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnBack.addActionListener(e -> {
            new studentHomepage().setVisible(true);
            dispose();
        });
        mainPanel.add(btnBack);

        add(mainPanel);
    }
}