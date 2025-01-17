package employee.managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee  extends JFrame implements ActionListener {

    Choice choiceEMPID;
    JButton delete,back;

    RemoveEmployee() {

        JLabel label = new JLabel("Employee Id");
        label.setBounds(50, 50, 100, 30);
        label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(label);
        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200, 50, 150, 30);
        add(choiceEMPID);

        try{
            conn c = new conn();
            ResultSet resultSet = c.stmt.executeQuery("select * from employee");
            while(resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        labelname.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(labelname);

        JLabel textName = new JLabel();
        textName.setBounds(200, 100, 100, 30);
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 150, 100, 30);
        labelPhone.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200, 150, 100, 30);
        add(textPhone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        labelemail.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(labelemail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200, 200, 100, 30);
        add(textEmail);

        try{
            conn c = new conn();
            ResultSet resultSet = c.stmt.executeQuery("select * from employee where empId='"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));

            }
            while(resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.stmt.executeQuery("select * from employee where empId='"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/rback.png"));
        Image i21 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i21);
        JLabel imges = new JLabel(i33);
        imges.setBounds(0,0,1120,630);
        add(imges);





        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete) {
            try{
                conn c = new conn();
                String query = "delete from employee where empId='"+choiceEMPID.getSelectedItem()+"'";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
                setVisible(false);
                new Main_class();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
