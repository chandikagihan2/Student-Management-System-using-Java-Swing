import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BatchStudentReportView extends JFrame {

    public BatchStudentReportView(String batchName) {
        setTitle(batchName + " Student Report");
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

        JLabel lblTopTitle = new JLabel(batchName + " Student Report");
        lblTopTitle.setBounds(450, 12, 270, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(lblTopTitle);
        mainPanel.add(topPanel);

        String[] columnNames = {"No", "Registration No", "Student Name", "NIC", "PRF Marks", "DBMS Marks", "GPA"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 80, 670, 280);
        mainPanel.add(scrollPane);

        String batchNumberOnly = batchName.replace(" Batch", "").trim();

        if (Student.getStudentArray() != null) {
            int index = 1;
            for (Student s : Student.getStudentArray()) {
                if (s != null && s.getRegNo() != null && s.getRegNo().contains(batchNumberOnly)) {
                   String prf = "";
                    if (s.getPrfMarks() == -1) {
                        prf = "ABSENT";
                    } else if (s.getPrfMarks() == -2) {
                        prf = "NOT CONDUCTED";
                    } else {
                        prf = String.valueOf(s.getPrfMarks());
                    }

                    String dbms = "";
                    if (s.getDbmsMarks() == -1) {
                        dbms = "ABSENT";
                    } else if (s.getDbmsMarks() == -2) {
                        dbms = "NOT CONDUCTED";
                    } else {
                        dbms = String.valueOf(s.getDbmsMarks());
                    }

                    String gpa = String.format("%.2f", calculateGpa(s.getPrfMarks(), s.getDbmsMarks()));

                    Object[] row = {index++, s.getRegNo(), s.getName(), s.getNic(), prf, dbms, gpa};
                    model.addRow(row);
                }
            }
        }

        JButton btnBackHome = new JButton("BACK TO HOME PAGE");
        btnBackHome.setBounds(40, 400, 210, 35);
        btnBackHome.setBackground(new Color(25, 35, 110));
        btnBackHome.setForeground(Color.WHITE);
        btnBackHome.setFocusPainted(false);
        btnBackHome.addActionListener(e -> {
            new BatchWiseReport().setVisible(true);
            dispose();
        });
        mainPanel.add(btnBackHome);

        add(mainPanel);
    }

    private double calculateGpa(int prf, int dbms) {
        if (prf < 0 || dbms < 0) return 0.00;
        int avg = (prf + dbms) / 2;
        if (avg >= 75) return 4.00;
        if (avg >= 65) return 3.00;
        if (avg >= 50) return 2.00;
        if (avg >= 35) return 1.00;
        return 0.00;
    }
}