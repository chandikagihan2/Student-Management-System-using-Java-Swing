import java.awt.*;
import javax.swing.*;

public class GradeManagement extends JFrame {

    public GradeManagement() {
        setTitle("Grade Management");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 500);
        mainPanel.setBackground(new Color(25, 35, 110));
        mainPanel.setLayout(null);

        JLabel lblTitle = new JLabel("Grade Management", JLabel.CENTER);
        lblTitle.setBounds(0, 60, 750, 40);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        mainPanel.add(lblTitle);

        JLabel lblSubTitle = new JLabel("Choose an option from the menu below to get started", JLabel.CENTER);
        lblSubTitle.setBounds(0, 110, 750, 25);
        lblSubTitle.setForeground(new Color(200, 210, 230));
        lblSubTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(lblSubTitle);

        JButton btnPrfMarks = new JButton("PRF Marks Update");
        btnPrfMarks.setBounds(175, 190, 400, 50);
        btnPrfMarks.setBackground(new Color(215, 225, 250));
        btnPrfMarks.setForeground(new Color(25, 35, 110));
        btnPrfMarks.setFont(new Font("Arial", Font.BOLD, 18));
        btnPrfMarks.setFocusPainted(false);
        
        
        btnPrfMarks.addActionListener(e -> {
            new PrfMarksUpdate().setVisible(true);
            dispose();
        });
        mainPanel.add(btnPrfMarks);

        JButton btnDbmsMarks = new JButton("DBMS Marks Update");
        btnDbmsMarks.setBounds(175, 270, 400, 50);
        btnDbmsMarks.setBackground(new Color(215, 225, 250));
        btnDbmsMarks.setForeground(new Color(25, 35, 110));
        btnDbmsMarks.setFont(new Font("Arial", Font.BOLD, 18));
        btnDbmsMarks.setFocusPainted(false);
        
        btnDbmsMarks.addActionListener(e -> {
            new DbmsMarksUpdate().setVisible(true);
            dispose();
        });
        mainPanel.add(btnDbmsMarks);

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