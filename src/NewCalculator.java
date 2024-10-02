import javax.swing.*;
import java.awt.*;

public class NewCalculator extends JFrame {

    private JPanel panel;
    private JTextField outputField;
    private JButton[] buttons;
    private String[] labels = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", "back", "=", "+"
    };

    public NewCalculator() {
    	setTitle("New Calculator");
        setSize(400, 300);
        

        // 맨 아래쪽 패널에 패널 3개를 추가한다. 
        JPanel panel = new JPanel();
        // panel.setLayout(new GridLayout(3, 1, 5, 5));
        panel.setLayout(new BorderLayout());
        add(panel);

        // 첫번째 결과 표시 패널 
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1, 5, 5));
        panel1.setSize(400, 40);

        outputField = new JTextField(35); 
        outputField.setText("0.");
        outputField.setEnabled(false);
        outputField.setHorizontalAlignment(JLabel.CENTER); 
        panel1.add(outputField); 
                
        panel.add(panel1, BorderLayout.NORTH);
        
        // 두번째 Clear 버튼 
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 4, 5, 5));
        panel2.setSize(400, 40);

        panel2.add(new JButton("C")); 
        panel2.add(new JLabel("")); 
        panel2.add(new JLabel("")); 
        panel2.add(new JLabel("")); 
        
        panel.add(panel2, BorderLayout.CENTER);

        // 세번째 4x4 버튼 구성 

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(4, 4, 5, 5));
        panel3.setSize(400, 200);
        
        // 여기에 panel의 배치관리자를 GridLayout으로 설정하는 코드를 추가해보자.
        buttons = new JButton[16];
        int index = 0;
        for (int rows = 0; rows < 4; rows++) {
            for (int cols = 0; cols < 4; cols++) {
                buttons[index] = new JButton(labels[index]);
                panel3.add(buttons[index]);
                index++;
            }
        }

        panel.add(panel3, BorderLayout.SOUTH);

        pack(); 
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        



    }

    public static void main(String args[]) {
    	NewCalculator s = new NewCalculator();
    }
}
