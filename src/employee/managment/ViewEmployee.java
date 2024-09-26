package employee.managment;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.naming.spi.DirStateFactory;
import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee  extends JFrame implements ActionListener {

    JTable table;
    Choice  choiceemp;
    JButton searchbtn, print,update,back;

    ViewEmployee(){

        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20,20,150,20);
        add(search);


        choiceemp = new Choice();
        choiceemp.setBounds(180,20,150,20);
        add(choiceemp);

        try{
            conn c=new conn();
            ResultSet resultset  =c.stmt.executeQuery("select  * from employee");
            while(resultset.next()){
                choiceemp.add(resultset.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c=new conn();
            ResultSet resultset =c.stmt.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);



                 setSize(900,700);
                 setLayout(null);
                 setLocation(300,100);
                 setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchbtn){
            String query = "select * from employee where empId='"+choiceemp.getSelectedItem()+"'";
            try{
                conn c=new conn();
                ResultSet resultset =c.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultset));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==print){
            try{
                table.print();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if(e.getSource()==update){
                setVisible(false);
                new UpdateEmployee(choiceemp.getSelectedItem());

        }else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
