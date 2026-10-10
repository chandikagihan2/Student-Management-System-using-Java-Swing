import java.awt.*;
import javax.swing.*;

class studentHomepage extends JFrame{

     /**
     * 
     */
    studentHomepage() {
        
        setTitle("iCET Learning Management System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 750, 500);
        panel.setBackground(new Color(25, 35, 110));
        panel.setLayout(null);

        JLabel lblTitle1 = new JLabel("iCET", JLabel.CENTER);
        lblTitle1.setBounds(0, 20, 750, 25);
        lblTitle1.setForeground(Color.WHITE);
        lblTitle1.setFont(new Font("", 1, 22));
        panel.add(lblTitle1); 

        JLabel lblTitle2 = new JLabel("Learning Management System", JLabel.CENTER);
        lblTitle2.setBounds(0, 70, 750, 25);
        lblTitle2.setForeground(Color.WHITE);
        lblTitle2.setFont(new Font("", Font.BOLD, 20));
        panel.add(lblTitle2);

        JLabel lblSubTitle = new JLabel("Choose an option from the menu below to get started", JLabel.CENTER);
        lblSubTitle.setBounds(0, 110, 750, 25);
        lblSubTitle.setForeground(new Color(200, 215, 240));
        lblSubTitle.setFont(new Font("", Font.PLAIN, 12));
        panel.add(lblSubTitle);

        JButton btn1 = new JButton("Student Management");
        btn1.setBounds(175, 190, 400,40);
        panel.add(btn1);

        btn1.addActionListener(e -> {
            new StudentManagementSystem().setVisible(true);
              dispose();
        });

        JButton btn2 = new JButton("Batch Management");
        btn2.setBounds(175, 240, 400, 40);
        panel.add(btn2);

         btn2.addActionListener(e -> {
            new BatchManagementSystem().setVisible(true);
            dispose();
        });

        JButton btn3 = new JButton("Grade Management");
        btn3.setBounds(175, 290, 400, 40);
        panel.add(btn3);

        btn3.addActionListener(e -> {
            new GradeManagement().setVisible(true);
            dispose();
        });

        JButton btn4 = new JButton("Report Generator");
        btn4.setBounds(175, 340, 400, 40);
        panel.add(btn4);

        btn4.addActionListener(e -> {
            new ReportGenerator().setVisible(true);
            dispose();
        });

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(175, 390, 100, 30);
        btnExit.setBackground(Color.GRAY);
        btnExit.setForeground(Color.BLACK);
        panel.add(btnExit);

        btnExit.addActionListener(e -> System.exit(0));

        add(panel);
    }    
}