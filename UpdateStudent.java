import javax.swing.*;
import java.awt.*;

public class UpdateStudent extends JFrame {
    private JTextField txtSearchId;
    private JTextField txtNic;
    private JTextField txtName;

    private int foundIndex = -1;

    public UpdateStudent() {
        setTitle("Update Student");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 450);
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 750, 50);
        topPanel.setBackground(new Color(25, 35, 110));
        topPanel.setLayout(null);

        JLabel lblTopTitle = new JLabel("Update Student");
        lblTopTitle.setBounds(580, 12, 140, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("",1 , 16));
        topPanel.add(lblTopTitle);
        mainPanel.add(topPanel);
       
        txtSearchId = new JTextField();
        txtSearchId.setBounds(220, 95, 250, 30);
        mainPanel.add(txtSearchId);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(485, 95, 140, 30);
        btnSearch.setBackground(new Color(25, 35, 110));
        btnSearch.setForeground(Color.WHITE);
        mainPanel.add(btnSearch);

        JLabel lblNic = new JLabel("NIC");
        lblNic.setBounds(100, 170, 80, 25);
        lblNic.setFont(new Font("Arial", Font.BOLD, 12));
        mainPanel.add(lblNic);

        txtNic = new JTextField();
        txtNic.setBounds(220, 170, 405, 30);
        mainPanel.add(txtNic);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(100, 220, 80, 25);
        lblName.setFont(new Font("Arial", Font.BOLD, 12));
        mainPanel.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(220, 220, 405, 30);
        mainPanel.add(txtName);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(390, 345, 110, 35);
        btnCancel.setBackground(new Color(150, 155, 170));
        btnCancel.setForeground(Color.WHITE);
        mainPanel.add(btnCancel);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(515, 345, 110, 35);
        btnUpdate.setBackground(new Color(25, 35, 110));
        btnUpdate.setForeground(Color.WHITE);
        mainPanel.add(btnUpdate);

        btnSearch.addActionListener(e -> {
        String searchId = txtSearchId.getText().trim();
        foundIndex = -1;

        if (searchId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter Student ID!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
        }

                if (Student.getStudentArray() != null) {
                for (int i = 0; i < Student.getStudentArray().length; i++) {
                    Student student = Student.getStudentArray()[i];
                    if (student != null && student.getRegNo().equalsIgnoreCase(searchId)) {
                        foundIndex = i;
                        break;
                    }
                }
            }
        if (foundIndex != -1) {
            Student foundStudent = Student.getStudentArray()[foundIndex];
            txtNic.setText(foundStudent.getNic());
            txtName.setText(foundStudent.getName());
        } else {
            JOptionPane.showMessageDialog(this, "This student not exist in the system", "Error", JOptionPane.ERROR_MESSAGE);
            txtNic.setText("");
            txtName.setText("");
            }
        });
    
    btnUpdate.addActionListener(e -> {
    if (foundIndex == -1) {
        JOptionPane.showMessageDialog(this, "Please search and select a student first!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Student foundStudent = Student.getStudentArray()[foundIndex];
    
    String newNic = txtNic.getText().trim();
    String newName = txtName.getText().trim();

    if (newNic.isEmpty() || newName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Fields cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    if (!newNic.equals(foundStudent.getNic())) {
        boolean nicExists = false;
        for (Student student : Student.getStudentArray()) {
            if (student != null && student.getNic().equals(newNic)) {
                nicExists = true;
                break;
            }
        }
        if (nicExists) {
            JOptionPane.showMessageDialog(this, "The NIC already exists in the system!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    foundStudent.setNic(newNic);
    foundStudent.setName(newName);

    new showSuccessUpdateStudent(this, foundStudent.getRegNo()).setVisible(true);
    dispose();
    });

        btnCancel.addActionListener(e -> {
            new StudentManagementSystem(){}.setVisible(true);
            dispose();
        });

        add(mainPanel);
    }
}