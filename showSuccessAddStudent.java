import javax.swing.*;
import java.awt.*; 

public class showSuccessAddStudent extends JFrame {

    public showSuccessAddStudent(JFrame parentFrame, String studentId, String name, String batch, String mode) {
        setTitle("Student Added Successfully");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parentFrame);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 450);
        mainPanel.setBackground(new Color(25, 35, 110));
        mainPanel.setLayout(null);

        JPanel whiteCardPanel = new JPanel();
        whiteCardPanel.setBounds(65, 120, 620, 170);
        whiteCardPanel.setBackground(Color.WHITE);
        whiteCardPanel.setLayout(null);

        JLabel lblMsg = new JLabel(name + " Successfully Added!", JLabel.CENTER);
        lblMsg.setBounds(20, 40, 580, 30);
        lblMsg.setForeground(new Color(25, 35, 110));
        lblMsg.setFont(new Font("Arial", Font.BOLD, 20));
        whiteCardPanel.add(lblMsg);

        JLabel lblRegNo = new JLabel("Registration No : " + studentId, JLabel.CENTER);
        lblRegNo.setBounds(20, 90, 580, 25);
        lblRegNo.setForeground(new Color(40, 40, 40));
        lblRegNo.setFont(new Font("Arial", Font.BOLD, 16));
        whiteCardPanel.add(lblRegNo);

        mainPanel.add(whiteCardPanel);

        JButton btnBackHome = new JButton("<   BACK TO HOME PAGE");
        btnBackHome.setBounds(40, 370, 240, 40);
        btnBackHome.setBackground(new Color(25, 35, 110));
        btnBackHome.setForeground(Color.WHITE);
        btnBackHome.setFocusPainted(false);
        btnBackHome.setBorder(BorderFactory.createLineBorder(new Color(60, 75, 150), 1));

        btnBackHome.addActionListener(e -> {
            new studentHomepage().setVisible(true);
            dispose();
        });
        mainPanel.add(btnBackHome);

        JButton btnAddAnother = new JButton("+   ADD NEW STUDENT");
        btnAddAnother.setBounds(470, 370, 240, 40);
        btnAddAnother.setBackground(new Color(25, 35, 110));
        btnAddAnother.setForeground(Color.WHITE);
        btnAddAnother.setFocusPainted(false);
        btnAddAnother.setBorder(BorderFactory.createLineBorder(new Color(60, 75, 150), 1));
        
        btnAddAnother.addActionListener(e -> {
            new AddStudent().setVisible(true);
            dispose();
        });
        mainPanel.add(btnAddAnother);

        add(mainPanel);        
    }
    
}
