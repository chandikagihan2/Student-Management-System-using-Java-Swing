import javax.swing.*;
import java.awt.*;

public class ViewStudentProfile extends JFrame {
    private JTextField txtSearchId;
    private JTextField txtNic;
    private JTextField txtName;
    private JTextField txtprfMarks;
    private JTextField txtdbmsMarks;
    private JTextField txtGpa;

    public ViewStudentProfile() {
        setTitle("View Student Profile");
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

        JLabel lblTopTitle = new JLabel("View Student Profile");
        lblTopTitle.setBounds(550, 12, 180, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(lblTopTitle);
        mainPanel.add(topPanel);

        txtSearchId = new JTextField();
        txtSearchId.setBounds(230, 85, 240, 30);
        mainPanel.add(txtSearchId);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(485, 85, 140, 30);
        btnSearch.setBackground(new Color(25, 35, 110));
        btnSearch.setForeground(Color.WHITE);
        mainPanel.add(btnSearch);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(100, 145, 100, 25);
        mainPanel.add(lblName);
        txtName = new JTextField();
        txtName.setBounds(230, 145, 395, 30);
        txtName.setEditable(false);
        mainPanel.add(txtName);

        JLabel lblNic = new JLabel("NIC");
        lblNic.setBounds(100, 195, 100, 25);
        mainPanel.add(lblNic);
        txtNic = new JTextField();
        txtNic.setBounds(230, 195, 240, 30);
        txtNic.setEditable(false);
        mainPanel.add(txtNic);

        JLabel lblPrfMarks = new JLabel("PRF Marks");
        lblPrfMarks.setBounds(100, 245, 100, 25);
        mainPanel.add(lblPrfMarks);
        txtprfMarks = new JTextField();
        txtprfMarks.setBounds(230, 245, 240, 30);
        txtprfMarks.setEditable(false);
        mainPanel.add(txtprfMarks);

        JLabel lblDbmsMarks = new JLabel("DBMS Marks");
        lblDbmsMarks.setBounds(100, 295, 100, 25);
        mainPanel.add(lblDbmsMarks);
        txtdbmsMarks = new JTextField();
        txtdbmsMarks.setBounds(230, 295, 240, 30);
        txtdbmsMarks.setEditable(false);
        mainPanel.add(txtdbmsMarks);

        JLabel lblGpa = new JLabel("GPA");
        lblGpa.setBounds(100, 345, 100, 25);
        mainPanel.add(lblGpa);
        txtGpa = new JTextField();
        txtGpa.setBounds(230, 345, 240, 30);
        txtGpa.setEditable(false);
        mainPanel.add(txtGpa);

        JButton btnBackHome = new JButton("BACK TO HOME PAGE");
        btnBackHome.setBounds(100, 400, 200, 35);
        btnBackHome.setBackground(new Color(25, 35, 110));
        btnBackHome.setForeground(Color.WHITE);
        btnBackHome.addActionListener(e -> {
            new StudentManagementSystem().setVisible(true);
            dispose();
        });
        mainPanel.add(btnBackHome);

        btnSearch.addActionListener(e -> {
            String searchId = txtSearchId.getText().trim();
            Student foundStudent = null;

            if (searchId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Student ID!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (Student.getStudentArray() != null) {
                for (Student student : Student.getStudentArray()) {
                    if (student != null && student.getRegNo().equalsIgnoreCase(searchId)) {
                        foundStudent = student;
                        break;
                    }
                }
            }

            if (foundStudent != null) {
                txtName.setText(foundStudent.getName());
                txtNic.setText(foundStudent.getNic());

                int prf = foundStudent.getPrfMarks();
                int dbms = foundStudent.getDbmsMarks();

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

                double gpa = foundStudent.getGPA();
                txtGpa.setText(String.format("%.2f", gpa));
            } else {
                JOptionPane.showMessageDialog(this, "This student does not exist in the system", "Error", JOptionPane.ERROR_MESSAGE);
                txtName.setText("");
                txtNic.setText("");
                txtprfMarks.setText("");
                txtdbmsMarks.setText("");
                txtGpa.setText("");
            }
        });

        add(mainPanel);
    }
}