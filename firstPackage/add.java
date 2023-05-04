package firstPackage;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class add extends JPanel implements ActionListener{
    JLabel fname,lname,address,depar;
    JTextField firstname,lastname,addre,department;
    JButton send;
    public add(){
        this.setLayout(null);
        fname = new JLabel("first name");
        lname = new JLabel("last name");
        address = new JLabel("address");
        depar= new JLabel("department");
        fname.setBounds(50, 40, 80, 50);
        lname.setBounds(50, 70, 80, 50);
        address.setBounds(50, 100, 80, 50);
        depar.setBounds(50, 130, 80, 50);
        add(fname);
        add(lname);
        add(address);
        add(depar);

        firstname = new JTextField();
        lastname = new JTextField();
        addre = new JTextField();
        department = new JTextField();
        firstname.setBounds(150, 50, 120, 20); 
        lastname.setBounds(150, 80, 120, 20); 
        addre.setBounds(150, 110, 120, 20);
        department.setBounds(150, 140, 120, 20); 
        add(firstname); 
        add(lastname);
        add(addre);
        add(department);

        send = new JButton("send");
        send.setBounds(120,200,80,20);
        add(send);
        send.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==send) {
            try {
                databas.studentDataBase.insertStudent(firstname.getText(), lastname.getText(), addre.getText(), department.getText());
                JOptionPane.showMessageDialog(null, "inserted student: "+firstname.getText(),"data inserted",JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            }
       }
    }

}
