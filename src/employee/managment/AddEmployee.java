package employee.managment;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee  extends JFrame implements ActionListener {

    Random ran  = new Random();
    int number = ran.nextInt(999999);

    JTextField tname,fname,eaddress,ephone,eaadhar,eemail,esalary,edesignation;

    JLabel tempid;

     JDateChooser tdob;

     JButton add,back;

     JComboBox BoxEducation;

    AddEmployee() {


        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(heading);

        //Name
        JLabel name= new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(name);
        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        //Father Name
        JLabel fatherName= new JLabel("Father Name");
        fatherName.setBounds(400,150,150,30);
        fatherName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(fatherName);
        fname = new JTextField();
        fname.setBounds(600,150,150,30);
        fname.setBackground(new Color(177,252,197));
        add(fname);

        //Date of Birth
        JLabel dob= new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(dob);
        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        //Salary
        JLabel salary= new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(salary);
        esalary = new JTextField();
        esalary.setBounds(600,200,150,30);
        esalary.setBackground(new Color(177,252,197));
        add(esalary);


        //Address
        JLabel address= new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(address);
        eaddress = new JTextField();
        eaddress.setBounds(200,250,150,30);
        eaddress.setBackground(new Color(177,252,197));
        add(eaddress);

        //phone
        JLabel phone= new JLabel("Phone ");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(phone);
        ephone = new JTextField();
        ephone.setBounds(600,250,150,30);
        ephone.setBackground(new Color(177,252,197));
        add(ephone);

        //Email
        JLabel Email= new JLabel("Email Id ");
        Email.setBounds(50,300,150,30);
        Email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(Email);
        eemail = new JTextField();
        eemail.setBounds(200,300,150,30);
        eemail.setBackground(new Color(177,252,197));
        add(eemail);

        //eduction
        JLabel education= new JLabel("Higest Education ");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(education);
        String items[]={"BBA","MBA","BCA","MCA","B.COM","M.COM","DEPLO","B.TEC","PHD"};
        BoxEducation= new JComboBox(items);
        BoxEducation.setBackground(new Color(177,252,197));
        BoxEducation.setBounds(600,300,150,30);
        add(BoxEducation);

        //aadhr
        JLabel aadhar= new JLabel("Aadhar Number ");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(aadhar);
         eaadhar= new JTextField();
        eaadhar.setBounds(600,350,150,30);
        eaadhar.setBackground(new Color(177,252,197));
        add(eaadhar);

        //empid
        JLabel empid= new JLabel("Employee Id ");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(empid);
        tempid= new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
       tempid.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
       tempid.setForeground(Color.red);
        add(tempid);

        //designation
        JLabel designation= new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(designation);
        edesignation= new JTextField();
        edesignation.setBounds(200,350,150,30);
        edesignation.setBackground(new Color(177,252,197));
        add(edesignation);

        //add
        add = new JButton("Add");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        //back
        back = new JButton("Back");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name = tname.getText();
            String father= fname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary= esalary.getText();
            String address=eaddress.getText();
            String addhar=eaadhar.getText();
            String phone= ephone.getText();
            String email= eemail.getText();
            String education= (String) BoxEducation.getSelectedItem();
            String designation= edesignation.getText();
            String empId=tempid.getText();


            try{
                conn c=new conn();
                String query ="insert into employee values('"+name+"','"+father+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+addhar+"','"+empId+"')";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
