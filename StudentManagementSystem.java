import java.awt.*;
import javax.swing.*;

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
        panel.setBounds(0, 0, 750, 500);
        panel.setBackground(new Color(25, 35, 110));
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Student Management System", JLabel.CENTER);
        lblTitle.setBounds(0, 60, 750, 40);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("", 1, 22));
        panel.add(lblTitle); 

        JLabel lblSubTitle = new JLabel("Choose an option from the menu below to get started", JLabel.CENTER);
        lblSubTitle.setBounds(0, 110, 750, 25);
        lblSubTitle.setForeground(new Color(200, 215, 240));
        lblSubTitle.setFont(new Font("", Font.PLAIN, 12));
        panel.add(lblSubTitle);

        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.setBounds(175, 170, 400, 40);
        panel.add(addStudentButton);

        addStudentButton.addActionListener(e -> {
            new AddStudent().setVisible(true);
            dispose();
        });

        JButton viewStudentsButton = new JButton("View Students");
        viewStudentsButton.setBounds(175, 220, 400, 40);
        panel.add(viewStudentsButton);

        viewStudentsButton.addActionListener(e -> {
            new ViewStudentProfile().setVisible(true);
            dispose();
        });

        JButton updateStudentButton = new JButton("Update Student");
        updateStudentButton.setBounds(175, 270, 400, 40);
        panel.add(updateStudentButton);

        updateStudentButton.addActionListener(e -> {
            new UpdateStudent().setVisible(true);
            dispose();
        });

        JButton deleteStudentButton = new JButton("Delete Student");
        deleteStudentButton.setBounds(175, 320, 400, 40);
        panel.add(deleteStudentButton);

        deleteStudentButton.addActionListener(e -> {
            new DeleteStudent().setVisible(true);
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
