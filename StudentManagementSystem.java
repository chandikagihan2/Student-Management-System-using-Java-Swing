import javax.swing.*;
import java.awt.*;

public class StudentManagementSystem extends JFrame {

    /**
     * 
     */
    public StudentManagementSystem() {
        setTitle("Student Management System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 450, 500);
        panel.setBackground(new Color(25, 35, 110));
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Student Management System", JLabel.CENTER);
        lblTitle.setBounds(50, 25, 350, 25);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("", 1, 22));
        panel.add(lblTitle); 

        JLabel lblSubTitle = new JLabel("Choose an option from the menu below to get started", JLabel.CENTER);
        lblSubTitle.setBounds(50, 90, 350, 20);
        lblSubTitle.setForeground(new Color(200, 215, 240));
        lblSubTitle.setFont(new Font("", Font.PLAIN, 12));
        panel.add(lblSubTitle);

        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.setBounds(75, 140, 300, 40);
        panel.add(addStudentButton);

        addStudentButton.addActionListener(e -> {
            new AddStudent().setVisible(true);
            dispose();
        });

        JButton viewStudentsButton = new JButton("View Students");
        viewStudentsButton.setBounds(75, 200, 300, 40);
        panel.add(viewStudentsButton);

        JButton updateStudentButton = new JButton("Update Student");
        updateStudentButton.setBounds(75, 260, 300, 40);
        panel.add(updateStudentButton);

        updateStudentButton.addActionListener(e -> {
            new UpdateStudent().setVisible(true);
            dispose();
        });

        JButton deleteStudentButton = new JButton("Delete Student");
        deleteStudentButton.setBounds(75, 320, 300, 40);
        panel.add(deleteStudentButton);

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
