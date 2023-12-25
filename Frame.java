import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
JButton a, b, c, d, e1, f, g, h, i;
Font font = new Font("Ink Free", Font.BOLD, 90);

//This are variables for the reasoning/logic behind the game
int position = 0;
int wiggle = 0;

//This constructor houses the Frame, Panels, and Buttons
	public Frame() {
		a = new JButton(); b = new JButton(); c = new JButton(); 
		d = new JButton(); e1 = new JButton(); f = new JButton();
		g = new JButton(); h = new JButton(); i = new JButton();
		JButton [] list = {a, b, c, d, e1, f, g, h, i};
		
		for(JButton i : list) {
			i.setBackground(Color.WHITE);
			i.setFocusable(false);
			i.addActionListener(this);
			i.setFont(font);
			panel.add(i);
		}
		panel.setLayout(new GridLayout(3,3,4,4));
		panel.setBounds(30,40,420,400);
		frame.setBounds(500,100,500,500);
		panel.setBackground(Color.black);
		frame.add(panel);
		frame.add(label);
		frame.setVisible(true);

	}
// This declares the constructor
	public static void main(String[] args) {
	Frame f = new Frame();
	}
	
// Logic plus ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		String x = "X";
		String o = "O";
		for (JButton comp : Arrays.asList(a, b, c, d, e1, f, g, h, i)) {
		    if (e.getSource() == comp) {
		        switch (position) {
		            case 0:
		                if (comp.getText().isEmpty()) {
		                    comp.setText(x);
		                    position = 1;
		                    logic(a.getText(), b.getText(), c.getText(), d.getText(), e1.getText(), f.getText(), g.getText(), h.getText(), i.getText());
		                }
	                    if(wiggle>=9) {
		            		JOptionPane.showMessageDialog(null, "Draw!");
		            		frame.dispose();
		            		Frame aas = new Frame();
	                    }
		                break;
		                
		             case 1:
		            	if (comp.getText().isEmpty()) {
		            		comp.setText(o);
		            		position = 0;
		            		logic(a.getText(), b.getText(), c.getText(), d.getText(), e1.getText(), f.getText(), g.getText(), h.getText(), i.getText());
		            		}
		            	if(wiggle>=9) {
		            		JOptionPane.showMessageDialog(null, "Draw!");
		            		Frame aas = new Frame();
		            	}
		                break;
		        }
		    }
		}
	}
	
// 0_0 Really long TicTacToe logic XD
		 void logic(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
			 
			if(((a == "X")&&(a==b)&&(b==c))||((d == "X")&&(d == e)&&(e==f))||((g == "X")&&(g == h)&&(h==i))||((e == "X")&&(a == e)&&(e==i))||((g == "X")&&(c == e)&&(e==g))||((d == "X")&&(a == d)&&(d==g))||((h == "X")&&(b == e)&&(e==h))||((i == "X")&&(c == f)&&(f==i))){
				JOptionPane.showMessageDialog(null, "X wins!");
				wiggle =0;
				frame.dispose();
				Frame abs = new Frame();
		}
			if(((a == "O")&&(a==b)&&(b==c))||((d == "O")&&(d == e)&&(e==f))||((g == "O")&&(g == h)&&(h==i))||((e == "O")&&(a == e)&&(e==i))||((g == "O")&&(c == e)&&(e==g))||((d == "O")&&(a == d)&&(d==g))||((h == "0")&&(b == e)&&(e==h))||((i == "O")&&(c == f)&&(f==i))){
				JOptionPane.showMessageDialog(null, "O wins!");
				wiggle =0;
				frame.dispose();
				Frame abs = new Frame();
			}
			else {
				wiggle =wiggle + 1;
			}
	}
		 
}
