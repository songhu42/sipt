import javax.swing.*;
import java.awt.*;

public class MembershipRegistration extends JFrame{

    public MembershipRegistration()
    {
        setTitle("Membership registration");
        setSize(400, 600);

        // 맨 아래쪽 패널에 패널 3개를 추가한다. 
        JPanel panel = new JPanel();
        // panel.setLayout(new GridLayout(3, 1, 5, 5));
        panel.setLayout(new BorderLayout()); 
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1, 5, 5));
        panel1.setSize(400, 60);
        JLabel title = new JLabel("회원 등록하기"); 
        title.setHorizontalAlignment(JLabel.CENTER); 
        panel1.add(title);
        panel.add(panel1, BorderLayout.NORTH);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 2, 5, 5));
        panel2.setSize(400, 280);

        panel2.add(new JLabel("이름"));
        panel2.add(new JTextField(15));
        panel2.add(new JLabel("패스워드"));
        panel2.add(new JPasswordField(15));
        panel2.add(new JLabel("이메일 주소"));
        panel2.add(new JTextField(15));
        panel2.add(new JLabel("전화번호"));
        panel2.add(new JTextField(15));

        panel.add(panel2, BorderLayout.CENTER);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2, 5, 5));
        panel2.setSize(400, 60);

        JButton login = new JButton("등록하기");
        panel3.add(login);
        JButton cancel = new JButton("취소");
        panel3.add(cancel);
        
        panel.add(panel3, BorderLayout.SOUTH);

        pack(); 
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	public static void main(String args[]) {
		MembershipRegistration s = new MembershipRegistration();
	}
}
