package energysystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class cusloginGui extends JFrame implements ActionListener{

	JButton jb1,jb2,jb3 = null ; 
	JRadioButton jrb1,jrb2,jrb3,jrb4 = null;
	JTextField jtf = null;
	ButtonGroup bg = null;
	JPanel jp1,jp2,jp3,jp4 = null;
	JLabel jlb,jlb1,jlb2 = null;
	JPasswordField jpf = null;
	int type;
	int line=0;
	String fileName;

	public void initlogUI(int type1){

		type = type1;
		//cusloginGui cusUI = new cusloginGui();
		//Create buttons
		JButton jb1 = new JButton("Next");
		JButton jb2 = new JButton("Back");
	//	JButton jb3 = new JButton("Exit");

		//Add listener
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	//	jb3.addActionListener(this);
		if(type==1){
			jlb = new JLabel("Please enter your information as a customer:");

		}else{
			jlb = new JLabel("Please enter your information as a provider:");

		}

		jlb1 = new JLabel("UserName");
		jtf = new JTextField(10);
		jlb2 = new JLabel("Password");
		jpf = new JPasswordField(10);

		

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jp1.add(jlb);//add textfile

		jp2.setLayout(new GridLayout(4,1));
		jp2.add(jlb1);
		jp2.add(jtf);
		jp2.add(jlb2);
		jp2.add(jpf);

		//jp3.setLayout(new GridLayout(1,2));
		jp3.add(jb1);
		jp3.add(jb2);
	//	jp3.add(jb3);

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
		if(e.getActionCommand() =="Next"){  
        	/*If customer want to continue.*/  
            cuslogin(type);   //check
        }else if(e.getActionCommand()=="Back"){
        	dispose();
            systemGui bUI = new systemGui();
            bUI.initGui();
        }  
	}



    public  void clear(){  
        jtf.setText("");  
        jpf.setText("");  
    }  

    public void cuslogin(int typetxt){
		if(typetxt==1) {
			fileName = "customer.txt";
		}
		else{
			fileName = "provider.txt";
		}
    	BufferedReader reader = null;

    	String name = jtf.getText();
    //	System.out.println(name);
    	char[] c = jpf.getPassword();
    	//String code = String.charAt(c);
    	String code = String.valueOf(c);
    //	System.out.println(code);
    	boolean a = false;
    	boolean b = false;

    	try{
    		reader = new BufferedReader(new FileReader(fileName));
    		String tempString = null;
    		//int line = 0;

    		while((tempString = reader.readLine())!=null){
				//System.out.println(tempString+"\n");

				//System.out.println(reader.readLine()+"\n");
    			String[] content = tempString.split(" ");
    			//System.out.println(content[0]);
    			//System.out.println(content[1]);
    			if(content[0].equals(name)){
    				a = true;
    				//System.out.printf("1");
    			}
    			if(content[1].equals(code)){
    				b = true;
    				//System.out.printf("2");
    			}
    			if(a&&b){
    				break;
    			}else{
    				a = false;
    				b = false;
    			}
    			line++;
    		}
    		reader.close();
			//System.out.println("line"+line+"\n");

		}catch(IOException e){
    		e.printStackTrace();
    	}finally{
    		if(reader!=null){
    			try{
    				reader.close();
    			}catch(IOException e1){
    				System.out.printf("No content in file!");
    			}
    		}
    	}

    	if(a&&b){            
            JOptionPane.showMessageDialog(null,"Login successful!","WARNING",JOptionPane.WARNING_MESSAGE);           
            dispose();        
            clear();
            if(typetxt==1){
            	cusGui ui=new cusGui();
            	ui.initcusGui(1,line);
            }else{
				cusGui ui=new cusGui();
				ui.initcusGui(2,line);
			}
        }else if(name.isEmpty()&&code.isEmpty()){  

            JOptionPane.showMessageDialog(null,"Please enter your ID and Password!","WARNING",JOptionPane.WARNING_MESSAGE);  
        }else if(name.isEmpty()){

            JOptionPane.showMessageDialog(null,"Please enter your ID!","WARNING",JOptionPane.WARNING_MESSAGE);  
        }else if(code.isEmpty()){  

            JOptionPane.showMessageDialog(null,"Please enter your Password!","WARNING",JOptionPane.WARNING_MESSAGE);  
        }else{  

            JOptionPane.showMessageDialog(null,"You enter a wrong ID and Password\nPlease enter again!","WARNING",JOptionPane.ERROR_MESSAGE);  
            //Clear all the input
            clear();  
        }  
        
    }


}