import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener
{
	String name;
	JButton start,back;

	Rules(String name)
	{
		this.name=name;
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel heading=new JLabel("welcome to " + name + " in simple minds");
		heading.setBounds(50,20,700,30);
		heading.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
		heading.setForeground(new Color(231,84,128));
		add(heading);

		JLabel rules=new JLabel();
		rules.setBounds(20,90,700,350);
		rules.setFont(new Font("Tahoma",Font.PLAIN,16));
		rules.setText(
				"<html>"+ 
                "1. Answer the questions by selecting one of the 4 answers choice." + "<br><br>" +
                "2. Answer the questions in less than 15 seconds." + "<br><br>" +
                "3. The answer appears after clicking on one of the choices." + "<br><br>" +
                "4. Scores are shown after submitting the all answers." + "<br><br>" +
                "5. A complete game consists of 10 questions." + "<br><br>" +
                "6. Click on Next button to move next question." + "<br><br>" +
                "7. Click play again button to restart the game." + "<br><br>" +
            "<html>"
			);
		add(rules);

		back=new JButton("Back");
		back.setBounds(250,500,100,30);
		back.setBackground(new Color(231,84,128));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		start=new JButton("start");
		start.setBounds(400,500,100,30);
		start.setBackground(new Color(231,84,128));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		add(start);

		setSize(800,650);
		setLocation(300,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==start)
		{
		setVisible(false);
		new Quiz(name);
		}
		else{
			setVisible(false);
			new Login();
		}
	}
	public static void main(String[] args) 
	{
		new Rules("user");
	}
}