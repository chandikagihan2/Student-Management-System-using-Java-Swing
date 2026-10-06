import javax.swing.*;
import java.awt.*;

public class ViewBatches extends JFrame {

    public ViewBatches() {
        setTitle("View Batches");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel message = new JLabel("View Batches", JLabel.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 20));
        add(message);
    }
}
