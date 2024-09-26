package employee.managment;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class  extends JFrame {


    Main_class(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120, 350, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        img.add(heading);

        JButton add= new JButton("Add Employee");
        add.setBounds(355,270,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton View= new JButton("View Employee");
        View.setBounds(565,270,150,40);
        View.setForeground(Color.white);
        View.setBackground(Color.black);
        View.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(View);

        JButton Remove= new JButton("Remove Employee");
        Remove.setBounds(440,370,150,40);
        Remove.setForeground(Color.white);
        Remove.setBackground(Color.black);
        Remove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new RemoveEmployee();
            }
        });
        img.add(Remove);

        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
