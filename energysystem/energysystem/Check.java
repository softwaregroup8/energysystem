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
    double budget;
    double tariffgas;
    double tariffpow;

    JFrame frame=new JFrame();
    JButton Gasback=new JButton("Back");
    JButton Powback=new JButton("Back");
    JButton budback=new JButton("Back");
    JButton tarback=new JButton("Back");

    JLabel Gas =new JLabel();
    JLabel Pow =new JLabel();
    JLabel Bud =new JLabel();
    JLabel Tariffg =new JLabel();
    JLabel Tariffp =new JLabel();
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

    public void Checkbudget(int line2){
        id = line2;
        //System.out.println(id);
        frame.setTitle("Smart energy system"); //Set the name of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //when the frame closed the java can be operated by user
        frame.setLayout(new BorderLayout());  //set the whole frame layout which is BorderLayout
        frame.setVisible(true);
        frame.setSize(404,250);
        frame.setLocation(400,200);
        JPanel pan1=new JPanel();
        pan1.add(budback);
        frame.add(pan1,BorderLayout.SOUTH);
        budget=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("customer.txt"));
            String tempString = null;
            for (int j=0; j<= id; j++) {
                tempString = reader.readLine();
            }
            String[] content = tempString.split(" ");
            budget = Float.parseFloat(content[4]);
            reader.close();
            //
        }catch(IOException err){
            err.printStackTrace();
        }


        Bud.setText("Your power consumption: "+ String.format("%.2f",budget)+ " $");
        frame.add(Bud,BorderLayout.CENTER);

        budback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cusGui c=new cusGui();
                c.initcusGui(1, id);
            }
        });
    }

    public void Checktariff(){

        //System.out.println(id);
        JPanel tariffpanel = new JPanel();
        frame.setTitle("Smart energy system"); //Set the name of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //when the frame closed the java can be operated by user
        frame.setLayout(new BorderLayout());  //set the whole frame layout which is BorderLayout
        frame.setVisible(true);
        frame.setSize(404,250);
        frame.setLocation(400,200);
        JPanel pan1=new JPanel();
        pan1.add(tarback);
        frame.add(pan1,BorderLayout.SOUTH);
        tariffgas=0;
        tariffpow=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("tariff.txt"));
            String tempString = reader.readLine();
            String[] content = tempString.split(" ");
            tariffgas = Float.parseFloat(content[0]);
            tariffpow = Float.parseFloat(content[1]);
            reader.close();
            //
        }catch(IOException err){
            err.printStackTrace();
        }


        Tariffg.setText("The tariff of gas is : "+ String.format("%.2f",tariffgas)+ " $/M^3");
        Tariffp.setText("The tariff of electricity is: "+ String.format("%.2f",tariffpow)+ " $/KW·H");
        tariffpanel.add(Tariffg);
        tariffpanel.add(Tariffp);
        tariffpanel.setLayout(new GridLayout(2,1));
        frame.add(tariffpanel,BorderLayout.CENTER);

        tarback.addActionListener(new ActionListener() {
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

