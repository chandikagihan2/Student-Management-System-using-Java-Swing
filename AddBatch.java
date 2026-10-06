import javax.swing.*;
import java.awt.*;

public class AddBatch extends JFrame {

    public AddBatch() {
        setTitle("Add Batch");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel message = new JLabel("Add Batch", JLabel.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 20));
        add(message);
    }
}
