import javax.swing.*;
import java.awt.*;

public class showSuccessDeleteStudent extends JFrame {

    public showSuccessDeleteStudent(JFrame parentFrame, String studentId) {
        setTitle("Student Deleted Successfully");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parentFrame);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 500);
        mainPanel.setBackground(new Color(25, 35, 110));
        mainPanel.setLayout(null);

        JPanel whiteCardPanel = new JPanel();
        whiteCardPanel.setBounds(65, 120, 620, 170);
        whiteCardPanel.setBackground(Color.WHITE);
        whiteCardPanel.setLayout(null);

        JLabel lblMsg = new JLabel(studentId + " Successfully Deleted!", JLabel.CENTER);
        lblMsg.setBounds(20, 70, 580, 30);
        lblMsg.setForeground(new Color(25, 35, 110));
        lblMsg.setFont(new Font("Arial", Font.BOLD, 20));
        whiteCardPanel.add(lblMsg);

        mainPanel.add(whiteCardPanel);

        JButton btnBackHome = new JButton("<   BACK TO HOME PAGE");
        btnBackHome.setBounds(40, 370, 240, 40);
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