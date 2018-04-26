package energysystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class cusGui extends JFrame implements ActionListener{

	JButton jb1,jb2,jb3 = null ; 
	JRadioButton jrb1,jrb2,jrb3,jrb4,jrb5,jrb6 = null;
	JTextField jtf = null;
	ButtonGroup bg = null;
	JPanel jp1,jp2,jp3,jp4 = null;
	JLabel jlb,jlb1,jlb2 = null;
	JPasswordField jpf = null;
	int type;
	int id;

	public void initcusGui(int type1, int line1){
		type = type1;
		id = line1;
		//Create buttons
		JButton jb1 = new JButton("Next");
		JButton jb2 = new JButton("Back");

		//Add listener
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//	jb3.addActionListener(this);

		jlb = new JLabel("Please select a business which you want:");

		if(type==1) {
			jrb1 = new JRadioButton("Check Budget");
			jrb2 = new JRadioButton("Check power consumption");
			jrb2.addActionListener(this);
			jrb3 = new JRadioButton("Check gas consumption");
			jrb3.addActionListener(this);
			jrb4 = new JRadioButton("View historical data");
			jrb5 = new JRadioButton("Check the tariff");
			jrb6 = new JRadioButton("Buy energy");
			ButtonGroup bgroup = new ButtonGroup();
			bgroup.add(jrb1);
			bgroup.add(jrb2);
			bgroup.add(jrb3);
			bgroup.add(jrb4);
			bgroup.add(jrb5);
			bgroup.add(jrb6);
		}
		else{
			jrb1 = new JRadioButton("Check monthly bills");
			jrb2 = new JRadioButton("Send bills to customers");
			jrb3 = new JRadioButton("View historical bills");
			jrb4 = new JRadioButton("Change the tariff of gas");
			jrb5 = new JRadioButton("Change the tariff of electric");
			jrb6 = new JRadioButton("Cut off energy of specific user");
			ButtonGroup bgroup = new ButtonGroup();
			bgroup.add(jrb1);
			bgroup.add(jrb2);
			bgroup.add(jrb3);
			bgroup.add(jrb4);
			bgroup.add(jrb5);
			bgroup.add(jrb6);
		}
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
	    jp4 = new JPanel();
     //   jp1.setLayout(new GridLayout(4,1));
		jp1.add(jlb);//add textfile

        jp4.setLayout(new GridLayout(3,1));
        jp4.add(jrb1);
        jp4.add(jrb2);
        jp4.add(jrb3);

		jp2.setLayout(new GridLayout(3,1));
		jp2.add(jrb4);
        jp2.add(jrb5);
        jp2.add(jrb6);

		//jp3.setLayout(new GridLayout(1,2));
		jp3.add(jb1);
		jp3.add(jb2);
	//	jp3.add(jb3);

		this.add(jp1);
        this.add(jp4);
		this.add(jp2);
		this.add(jp3);

		this.setLayout(new GridLayout(4,1));
		this.setTitle("Smart energy management and monitoring system");
		this.setSize(404,250);
		this.setLocation(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
	}

	/*Decide which identification is selected.*/
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()=="Next"){
			if(jrb1.isSelected()&&type==1){
				Check c=new Check();
				c.Checkbudget(id);
			}else if(jrb2.isSelected()&&type==1){
				/*If customer want to continue.*/
				// cuslogin();   //check
				Check c=new Check();
				c.CheckPower(id);

			}else if(jrb3.isSelected()&&type==1){
				Check c=new Check();
				c.CheckGas(id);
			}else if(jrb4.isSelected()&&type==1){
				//Check c=new Check();
				//
			}else if(jrb5.isSelected()&&type==1){
				Check c=new Check();
				c.Checktariff();
			}else if(jrb6.isSelected()&&type==1){
				//Check c=new Check();
				//
			}
		}else if(e.getActionCommand()=="Back"){
        	dispose();
            cusloginGui cusUI = new cusloginGui();
            if(type==1) {
				cusUI.initlogUI(1);
			}
			else{
				cusUI.initlogUI(2);
			}
        }
	}
}

    


