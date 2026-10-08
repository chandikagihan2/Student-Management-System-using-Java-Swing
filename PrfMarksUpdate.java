import javax.swing.*;
public class PrfMarksUpdate extends JFrame {
    private JTextField txtSearchId;
    private JTextField txtName;
    private JTextField txtNic;
    private JTextField txtCurrentMarks;
    private JTextField txtNewMarks;
    
    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnCancel;

    public PrfMarksUpdate() {
        setTitle("PRF Marks Update");
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

        JLabel lblTopTitle = new JLabel("PRF Marks Update");
        lblTopTitle.setBounds(550, 12, 170, 25);
        lblTopTitle.setForeground(Color.WHITE);
        lblTopTitle.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(lblTopTitle);
        mainPanel.add(topPanel);

        txtSearchId = new JTextField();
        txtSearchId.setBounds(230, 75, 250, 30);
        mainPanel.add(txtSearchId);

        btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(495, 75, 130, 30);
        btnSearch.setBackground(new Color(25, 35, 110));
        btnSearch.setForeground(Color.WHITE);
        mainPanel.add(btnSearch);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(80, 130, 120, 25);
        mainPanel.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(230, 130, 395, 30);
        txtName.setEditable(false);
        mainPanel.add(txtName);

        JLabel lblNic = new JLabel("NIC");
        lblNic.setBounds(80, 180, 120, 25);
        mainPanel.add(lblNic);

        txtNic = new JTextField();
        txtNic.setBounds(230, 180, 260, 30);
        txtNic.setEditable(false);
        mainPanel.add(txtNic);

        JLabel lblCurrentMarks = new JLabel("PRF Marks");
        lblCurrentMarks.setBounds(80, 230, 120, 25);
        mainPanel.add(lblCurrentMarks);

        txtCurrentMarks = new JTextField();
        txtCurrentMarks.setBounds(230, 230, 260, 30);
        txtCurrentMarks.setEditable(false);
        mainPanel.add(txtCurrentMarks);

        JLabel lblNewMarks = new JLabel("Enter New PRF Marks");
        lblNewMarks.setBounds(80, 280, 140, 25);
        mainPanel.add(lblNewMarks);

        txtNewMarks = new JTextField();
        txtNewMarks.setBounds(230, 280, 260, 30);
        mainPanel.add(txtNewMarks);

        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(370, 400, 120, 35);
        btnCancel.setBackground(new Color(150, 160, 175));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(e -> {
            new GradeManagement().setVisible(true);
            dispose();
        });
        mainPanel.add(btnCancel);

        btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(505, 400, 120, 35);
        btnUpdate.setBackground(new Color(25, 35, 110));
        btnUpdate.setForeground(Color.WHITE);
        mainPanel.add(btnUpdate);

        btnSearch.addActionListener(e -> {
            String studentId = txtSearchId.getText().trim();
            if (studentId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Student ID!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (studentId.equals("PR24105003")) {
                txtName.setText("Silva Kumara");
                txtNic.setText("199501012345");
                txtCurrentMarks.setText("85");
            } else if (studentId.equals("PR24100020")) {
                txtName.setText("Silva Rajapaksha");
                txtNic.setText("199501012345");
                txtCurrentMarks.setText("ABSENT");
            } else {
                JOptionPane.showMessageDialog(this, "This student does not exist in the system.", "Error", JOptionPane.ERROR_MESSAGE);
                txtName.setText("");
                txtNic.setText("");
                txtCurrentMarks.setText("");
            }
        });

        btnUpdate.addActionListener(e -> {
            String studentId = txtSearchId.getText().trim();
            String newMarksStr = txtNewMarks.getText().trim();

            if (studentId.isEmpty() || txtName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please search and select a student first!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (newMarksStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter new marks!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int newMarks;
            try {
                newMarks = Integer.parseInt(newMarksStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric mark (-1 or 0-100)!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (newMarks != -1 && (newMarks < 0 || newMarks > 100)) {
                JOptionPane.showMessageDialog(this, "Marks must be -1 (absent) or within the range of 0 to 100!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new ShowSuccessPrfUpdate(this, studentId).setVisible(true);
            dispose();
        });

        add(mainPanel);
    }
}
