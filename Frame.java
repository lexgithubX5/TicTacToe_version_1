import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame implements ActionListener {
// Code for Graphical Interface

JFrame frame = new JFrame("TicTacToe  by  Jordan ");
JLabel label = new JLabel();
JPanel panel = new JPanel();
JButton a= new JButton(); JButton b = new JButton();JButton c= new JButton();
JButton d = new JButton(); JButton e1= new JButton(); JButton f= new JButton();
JButton g= new JButton(); JButton h= new JButton(); JButton i= new JButton();
Font font = new Font("Ink Free", Font.BOLD, 90);

//This are variables for the reasoning/logic behind the game
int position = 0;
int wiggle = 0;

//This constructor houses the Frame, Panels, and Buttons
	public Frame() {
		panel.setLayout(new GridLayout(3,3,4,4));
		panel.setBounds(30,40,420,400);
		frame.setBounds(500,100,500,500);
		panel.setBackground(Color.black);
		frame.setBackground(Color.green);
		frame.add(panel);
		frame.add(label);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton [] list = {a, b, c, d, e1, f, g, h, i};
		for(JButton i : list) {
			i.setBackground(Color.WHITE);
			i.setFocusable(false);
			i.addActionListener(this);
			i.setFont(font);
			panel.add(i);
		}

	}
// This declares the constructor
	public static void main(String[] args) {
	Frame f = new Frame();
	}
	
// Logic plus ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame game;
		String x = "X";
		String o = "O";
		for (JButton comp : Arrays.asList(a, b, c, d, e1, f, g, h, i)) {
		    if (e.getSource() == comp) {
		        switch (position) {
		            case 0:
		                if (comp.getText().isEmpty()) {
		                    comp.setText(x);
		                    comp.setForeground(Color.blue);
		                    position = 1;
		                    logic(a.getText(), b.getText(), c.getText(), d.getText(), e1.getText(), f.getText(), g.getText(), h.getText(), i.getText());
		                }
	                    if(wiggle>=9) {
		            		JOptionPane.showMessageDialog(null, "Draw!");
		            		frame.dispose();
		            		game = new Frame();
	                    }
		                break;
		                
		             case 1:
		            	if (comp.getText().isEmpty()) {
		            		comp.setText(o);
		            		comp.setForeground(Color.orange);
		            		position = 0;
		            		logic(a.getText(), b.getText(), c.getText(), d.getText(), e1.getText(), f.getText(), g.getText(), h.getText(), i.getText());
		            		}
		            	if(wiggle>=9) {
		            		JOptionPane.showMessageDialog(null, "Draw!");
		            		game = new Frame();
		            	}
		                break;
		        }
		    }
		}
		
	}
	
// 0_0 Really long TicTacToe logic XD
		 void logic(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
			 Frame game1;
			 boolean q1; boolean q2; boolean q3; boolean q4; boolean q5; boolean q6; boolean q7; boolean q8;
			 boolean w1; boolean w2; boolean w3; boolean w4; boolean w5; boolean w6; boolean w7; boolean w8;
			 q1 = (a == "X")&&(a==b)&&(b==c); q2 =(d == "X")&&(d == e)&&(e==f); q3=(g == "X")&&(g == h)&&(h==i); q4=(e == "X")&&(a == e)&&(e==i);
			 q5=(g == "X")&&(c == e)&&(e==g); q6=(d == "X")&&(a == d)&&(d==g); q7 =(h == "X")&&(b == e)&&(e==h); q8=(i == "X")&&(c == f)&&(f==i); 
			 	 
			if(q1||q2||q3||q4||q5||q6||q7||q8){		
				JOptionPane.showMessageDialog(null, "X wins!");
				wiggle =0;
				frame.dispose();
				game1 = new Frame();
		}
			w1=(a == "O")&&(a==b)&&(b==c); w2=(d == "O")&&(d == e)&&(e==f); w3=(g == "O")&&(g == h)&&(h==i); w4=(e == "O")&&(a == e)&&(e==i);
			w5=(g == "O")&&(c == e)&&(e==g); w6=(d == "O")&&(a == d)&&(d==g); w7=(h == "0")&&(b == e)&&(e==h); w8=(i == "O")&&(c == f)&&(f==i);
			if(w1||w2||w3||w4||w5||w6||w7||w8){
				JOptionPane.showMessageDialog(null, "O wins!");
				wiggle =0;
				frame.dispose();
				game1 = new Frame();
			}
			else {
				wiggle =wiggle + 1;
			}
			
	}

}

