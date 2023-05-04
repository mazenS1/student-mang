package firstPackage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;

public class updateStudent extends JPanel implements ActionListener {
    JLabel fname,lname,address,depar,i;
    JTextField firstname,lastname,addre,department,id;
    JButton send;
    public updateStudent(){
        this.setLayout(null);
        fname = new JLabel("first name");
        i = new JLabel("student id");
        lname = new JLabel("last name");
        address = new JLabel("address");
        depar= new JLabel("department");
        i.setBounds(50,20,80,25);
        fname.setBounds(50, 40, 80, 50);
        lname.setBounds(50, 70, 80, 50);
        address.setBounds(50, 100, 80, 50);
        depar.setBounds(50, 130, 80, 50);
        add(fname);
        add(lname);
        add(address);
        add(depar);
        add(i);
        firstname = new JTextField();
        id = new JTextField();
        lastname = new JTextField();
        addre = new JTextField();
        department = new JTextField();
        firstname.setBounds(150, 50, 120, 20); 
        id.setBounds(150, 20, 120, 20); 
        lastname.setBounds(150, 80, 120, 20); 
        addre.setBounds(150, 110, 120, 20);
        department.setBounds(150, 140, 120, 20); 
        add(firstname); 
        add(lastname);
        add(addre);
        add(department);
        add(id);

        send = new JButton("update student");
        send.setBounds(120,200,80,20);
        add(send);
        send.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        databas.studentDataBase.upDateStudentInfo(Integer.parseInt(id.getText()) ,firstname.getText() , lastname.getText(), addre.getText(), department.getText());
        JOptionPane.showMessageDialog(null, "updated student","data inserted",JOptionPane.INFORMATION_MESSAGE);
    }
}