package energysystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Check extends JFrame implements ActionListener {
    double Gasconsumption;
    double Powconsumption;
    JFrame frame=new JFrame();
    JButton Gasback=new JButton("Back");
    JButton Powback=new JButton("Back");
    JTextField Gas =new JTextField();
    JTextField Pow =new JTextField();
    int id;

    public void CheckGas(int line){
        id = line;
        frame.setTitle("Smart energy system "); //Set the name of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //when the frame closed the java can be operated by user
        frame.setLayout(new BorderLayout());  //set the whole frame layout which is BorderLayout
        frame.setVisible(true);
        frame.setSize(404,250);
        frame.setLocation(400,200);
        JPanel pan1=new JPanel();
        pan1.add(Gasback);
        frame.add(pan1,BorderLayout.SOUTH);
        Gasconsumption=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("customer.txt"));
            String tempString = null;
            for (int j=0; j<= id; j++) {
                tempString = reader.readLine();
            }
            String[] content = tempString.split(" ");
            Gasconsumption = Float.parseFloat(content[2]);
            reader.close();
            //
        }catch(IOException err){
            err.printStackTrace();
        }

        //String printgas = );
        Gas.setText("Your gas consumption: "+ String.format("%.2f",Gasconsumption)+ " KW·H");
        frame.add(Gas,BorderLayout.CENTER);

        Gasback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cusGui c=new cusGui();
                c.initcusGui(1, id);
            }
        });
    }
    public void CheckPower(int line2){
        id = line2;
        //System.out.println(id);
        frame.setTitle("Smart energy system"); //Set the name of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //when the frame closed the java can be operated by user
        frame.setLayout(new BorderLayout());  //set the whole frame layout which is BorderLayout
        frame.setVisible(true);
        frame.setSize(404,250);
        frame.setLocation(400,200);
        JPanel pan1=new JPanel();
        pan1.add(Powback);
        frame.add(pan1,BorderLayout.SOUTH);
        Powconsumption=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("customer.txt"));
            String tempString = null;
            for (int j=0; j<= id; j++) {
                tempString = reader.readLine();
            }
            String[] content = tempString.split(" ");
            Powconsumption = Float.parseFloat(content[3]);
            reader.close();
            //
        }catch(IOException err){
            err.printStackTrace();
        }


        Pow.setText("Your power consumption: "+ String.format("%.2f",Powconsumption)+ " KW·H");
        frame.add(Pow,BorderLayout.CENTER);

        Powback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cusGui c=new cusGui();
                c.initcusGui(1, id);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

