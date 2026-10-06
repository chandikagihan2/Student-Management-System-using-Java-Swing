import javax.swing.*;
import java.awt.*;

public class DeleteStudent extends JFrame {
    private JTextField txtSearchId;
    private JTextField txtNic;
    private JTextField txtName;
    private JTextField txtprfMarks;
    private JTextField txtdbmsMarks;
    private JTextField txtGpa;
    
    private JButton btnDelete;
    private JButton btnCancel;
    private Student currentStudent = null;

    public DeleteStudent() {
        setTitle("Delete Student");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 750, 500);
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 750, 50);
        topPanel.setBackground(new Color(25, 35, 110));
        topPanel.setLayout(null);

        JLabel lblTopTitle = new JLabel("Delete Student");
        lblTopTitle.setBounds(580, 12, 140, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(lblTopTitle);
        mainPanel.add(topPanel);

        txtSearchId = new JTextField();
        txtSearchId.setBounds(180, 75, 290, 30);
        mainPanel.add(txtSearchId);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(485, 75, 140, 30);
        btnSearch.setBackground(new Color(25, 35, 110));
        btnSearch.setForeground(Color.WHITE);
        mainPanel.add(btnSearch);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(80, 135, 100, 25);
        mainPanel.add(lblName);
        txtName = new JTextField();
        txtName.setBounds(180, 135, 445, 30);
        txtName.setEditable(false);
        mainPanel.add(txtName);

        JLabel lblNic = new JLabel("NIC");
        lblNic.setBounds(80, 185, 100, 25);
        mainPanel.add(lblNic);
        txtNic = new JTextField();
        txtNic.setBounds(180, 185, 240, 30);
        txtNic.setEditable(false);
        mainPanel.add(txtNic);

        JLabel lblPrfMarks = new JLabel("PRF Marks");
        lblPrfMarks.setBounds(80, 235, 100, 25);
        mainPanel.add(lblPrfMarks);
        txtprfMarks = new JTextField();
        txtprfMarks.setBounds(180, 235, 240, 30);
        txtprfMarks.setEditable(false);
        mainPanel.add(txtprfMarks);

        JLabel lblDbmsMarks = new JLabel("DBMS Marks");
        lblDbmsMarks.setBounds(80, 285, 100, 25);
        mainPanel.add(lblDbmsMarks);
        txtdbmsMarks = new JTextField();
        txtdbmsMarks.setBounds(180, 285, 240, 30);
        txtdbmsMarks.setEditable(false);
        mainPanel.add(txtdbmsMarks);

        JLabel lblGpa = new JLabel("GPA");
        lblGpa.setBounds(80, 335, 100, 25);
        mainPanel.add(lblGpa);
        txtGpa = new JTextField();
        txtGpa.setBounds(180, 335, 240, 30);
        txtGpa.setEditable(false);
        mainPanel.add(txtGpa);

        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(370, 400, 120, 35);
        btnCancel.setBackground(new Color(150, 160, 175));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(e -> {
            new StudentManagementSystem().setVisible(true);
            dispose();
        });
        mainPanel.add(btnCancel);

        btnDelete = new JButton("DELETE");
        btnDelete.setBounds(505, 400, 120, 35);
        btnDelete.setBackground(new Color(25, 35, 110));
        btnDelete.setForeground(Color.WHITE);
        mainPanel.add(btnDelete);

        btnSearch.addActionListener(e -> {
            String searchId = txtSearchId.getText().trim();
            currentStudent = null;

            if (searchId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Student ID!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (Student.getStudentArray() != null) {
                for (Student student : Student.getStudentArray()) {
                    if (student != null && student.getRegNo().equalsIgnoreCase(searchId)) {
                        currentStudent = student;
                        break;
                    }
                }
            }

            if (currentStudent != null) {
                txtName.setText(currentStudent.getName());
                txtNic.setText(currentStudent.getNic());

                int prf = currentStudent.getPrfMarks();
                int dbms = currentStudent.getDbmsMarks();

                if (prf == -1) {
                    txtprfMarks.setText("Absent");
                } else if (prf == -2) {
                    txtprfMarks.setText("Not Conducted");
                } else {
                    txtprfMarks.setText(String.valueOf(prf));
                }

                if (dbms == -1) {
                    txtdbmsMarks.setText("Absent");
                } else if (dbms == -2) {
                    txtdbmsMarks.setText("Not Conducted");
                } else {
                    txtdbmsMarks.setText(String.valueOf(dbms));
                }

                txtGpa.setText(String.format("%.2f", currentStudent.getGPA()));
            } else {
                JOptionPane.showMessageDialog(this, "This student does not exist in the system!", "Error", JOptionPane.ERROR_MESSAGE);
                txtName.setText("");
                txtNic.setText("");
                txtprfMarks.setText("");
                txtdbmsMarks.setText("");
                txtGpa.setText("");
            }
        });

        btnDelete.addActionListener(e -> {
            if (currentStudent != null) {
                new showSuccessDeleteStudent(this, currentStudent.getRegNo()).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please search and select a student first!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(mainPanel);
    }
}