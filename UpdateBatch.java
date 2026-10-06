import javax.swing.*;
import java.awt.*;

public class UpdateBatch extends JFrame {

    public UpdateBatch() {
        setTitle("Update Batch");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel message = new JLabel("Update Batch", JLabel.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 20));
        add(message);
    }
}