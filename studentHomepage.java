import javax.swing.*;
import java.awt.*;

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
        panel.setBounds(0, 0, 450, 500);
        panel.setBackground(new Color(25, 35, 110));
        panel.setLayout(null);

        JLabel lblTitle1 = new JLabel("iCET", JLabel.CENTER);
        lblTitle1.setBounds(50, 25, 350, 25);
        lblTitle1.setForeground(Color.WHITE);
        lblTitle1.setFont(new Font("", 1, 22));
        panel.add(lblTitle1); 

        JLabel lblTitle2 = new JLabel("Learning Management System", JLabel.CENTER);
        lblTitle2.setBounds(50, 55, 350, 25);
        lblTitle2.setForeground(Color.WHITE);
        lblTitle2.setFont(new Font("", Font.BOLD, 20));
        panel.add(lblTitle2);

        JLabel lblSubTitle = new JLabel("Choose an option from the menu below to get started", JLabel.CENTER);
        lblSubTitle.setBounds(50, 90, 350, 20);
        lblSubTitle.setForeground(new Color(200, 215, 240));
        lblSubTitle.setFont(new Font("", Font.PLAIN, 12));
        panel.add(lblSubTitle);

        JButton btn1 = new JButton("Student Management");
        btn1.setBounds(75, 140, 300, 40);
        panel.add(btn1);

        btn1.addActionListener(e -> {
            new StudentManagementSystem().setVisible(true);
              dispose();
        });

        JButton btn2 = new JButton("Batch Management");
        btn2.setBounds(75, 200, 300, 40);
        panel.add(btn2);

      /* btn2.addActionListener(e -> {
            new BatchManagementSystem().setVisible(true);
            dispose();
        });*/

        JButton btn3 = new JButton("Grade Management");
        btn3.setBounds(75, 260, 300, 40);
        panel.add(btn3);

        JButton btn4 = new JButton("Report Generator");
        btn4.setBounds(75, 320, 300, 40);
        panel.add(btn4);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(175, 390, 100, 30);
        btnExit.setBackground(Color.GRAY);
        btnExit.setForeground(Color.BLACK);
        panel.add(btnExit);

        btnExit.addActionListener(e -> System.exit(0));

        add(panel);
    }    
}