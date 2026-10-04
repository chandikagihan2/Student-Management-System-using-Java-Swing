import javax.swing.*;
import java.awt.*;

class AddStudent extends JFrame {

     /**
     * 
     */
    public AddStudent() {
        setTitle("Add Student");
        setSize(450, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 450, 480);
        panel.setBackground(new Color(245, 247, 250));
        panel.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 450, 50);
        topPanel.setBackground(new Color(25, 35, 110));
        topPanel.setLayout(null);

        JLabel lblTopTitle = new JLabel("Add Student");
        lblTopTitle.setBounds(310, 12, 120, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(lblTopTitle);
        panel.add(topPanel);

        JLabel lblBatch = new JLabel("Batch Number");
        lblBatch.setBounds(30, 80, 120, 25);
        lblBatch.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(lblBatch);

        String[] batches = {"Select Batch", "105 Batch CLOSED", "106 Batch CLOSED", "107 Batch CLOSED", "108 Batch CLOSED", "109 Batch ", "110 Batch"};
        JComboBox<String> cmbBatch = new JComboBox<>(batches);
        cmbBatch.setBounds(150, 80, 250, 30);
        panel.add(cmbBatch);

        JLabel lblNic = new JLabel("NIC");
        lblNic.setBounds(30, 130, 120, 25);
        lblNic.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(lblNic);

        JTextField txtNic = new JTextField();
        txtNic.setBounds(150, 130, 250, 30);
        panel.add(txtNic);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 180, 120, 25);
        lblName.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(150, 180, 250, 30);
        panel.add(txtName);

        JLabel lblMode = new JLabel("Lecturer Mode");
        lblMode.setBounds(30, 230, 120, 25);
        lblMode.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(lblMode);

        String[] modes = {"Select Mode", "Physical", "Online"};
        JComboBox<String> cmbMode = new JComboBox<>(modes);
        cmbMode.setBounds(150, 230, 250, 30);
        panel.add(cmbMode);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(170, 350, 100, 35);
        btnCancel.setBackground(new Color(150, 155, 170));
        btnCancel.setForeground(Color.WHITE);
        panel.add(btnCancel);

        JButton btnAdd = new JButton("ADD STUDENT");
        btnAdd.setBounds(280, 350, 120, 35);
        btnAdd.setBackground(new Color(25, 35, 110));
        btnAdd.setForeground(Color.WHITE);
        panel.add(btnAdd);

        btnAdd.addActionListener(e -> {
            String selectedBatch = (String) cmbBatch.getSelectedItem();
            String nic = txtNic.getText().trim();
            String name = txtName.getText().trim();
            String mode = (String) cmbMode.getSelectedItem();

            if (selectedBatch.equals("Select Batch") || nic.isEmpty() || name.isEmpty() || mode.equals("Select Mode")) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int selectedBatchNo = Integer.parseInt(selectedBatch.split(" ")[0]);
                boolean isClosed = false;

                for (Batch batch : Batch.batchNameArray) {
                    if (batch.getBatchNo() == selectedBatchNo) {
                        if(batch.getStatus() == Batch.ENROLLMENT_CLOSED) {
                            isClosed = true;
                        }
                        break;
                    }
                }
                if(isClosed) {
                    JOptionPane.showMessageDialog(this, "Student can not be added to this batch because enrollment is closed!", "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    int StudentCount=0;

                    if(Student.getStudentArray() != null) {
                        for (Student student : Student.getStudentArray()) {
                            if (student != null && student.getBatchNo() == selectedBatchNo) {
                                StudentCount++;
                            }
                        }
                    }
                    int nextStudentId = StudentCount + 1;
                    String prefix = "Online".equals(mode) ? "OR" : "PR";
                    String generatedStudentID = String.format("%s24%d%03d", prefix, selectedBatchNo, nextStudentId);

                    String selectedBatchStr = (String) cmbBatch.getSelectedItem();
                    String Mode = (String) cmbMode.getSelectedItem();
                    new showSuccessAddStudent(this, generatedStudentID, name, selectedBatchStr, Mode).setVisible(true);
                    dispose();
                }
            }
        });
        btnCancel.addActionListener(e -> {
            dispose();
        });

        add(panel);
    }
}



    

