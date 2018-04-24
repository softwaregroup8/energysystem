package energysystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class systemGui extends JFrame implements ActionListener{

	JButton jb1,jb2,jb3 = null ; 
	JRadioButton jrb1,jrb2,jrb3,jrb4 = null;
	JTextField jtf = null;
	ButtonGroup bg = null;
	JPanel jp1,jp2,jp3,jp4 = null;
	JLabel jlb,jlb1 = null;
	public int typenum=3;
	public static void main(String[] args){
			systemGui sGUI = new systemGui();
			sGUI.initGui();
	}

	public void initGui(){

		//Create buttons
		JButton jb1 = new JButton("Enter");

		//Add listener
		jb1.addActionListener(this);


		jrb1 = new JRadioButton("Customer");
		jrb2 = new JRadioButton("Provider");

		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		jrb1.setSelected(true);//default value is customer

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jlb = new JLabel("Welcome!",JLabel.CENTER);
		jlb1 = new JLabel("Please choose your identification first:",JLabel.CENTER);
		jp1.setLayout(new GridLayout(2,1));
		jp1.add(jlb);//add textfile
		jp1.add(jlb1);

		jp2.setLayout(new GridLayout(2,1));
		jp2.add(jrb1);
		jp2.add(jrb2);

		jp3.add(jb1);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setLayout(new GridLayout(3,1));
		this.setTitle("Smart energy management and monitoring system");
		this.setSize(404,250);
		this.setLocation(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
	}

	/*Decide which identification is selected.*/
	public void actionPerformed(ActionEvent e){
		if(jrb1.isSelected()){
			//this.setResizable(false);
			dispose();
			typenum=1;
			cusloginGui cusUI = new cusloginGui();
			cusUI.initlogUI(typenum);
		}else if(jrb2.isSelected()){
			//banloginGui();
			dispose();
			typenum=2;
			cusloginGui cusUI = new cusloginGui();
			cusUI.initlogUI(typenum);

		}
	}


}