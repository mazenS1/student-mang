package firstPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class secondeScreen extends JFrame implements ActionListener {
    image ii = new image();
    JLabel user,pass,depart,note;
    JTextField user_name=new JTextField();
    JTextField password=new JTextField();
    JTextField department=new JTextField();
    JButton back= new JButton("back");
    JButton send=new JButton("send data");
    public secondeScreen(){
        showSecondeScreeen();
    }
    public void showSecondeScreeen() {
        // insliz user and password department labels
        user= new JLabel("user name ");
        pass=new JLabel("password");
        note= new JLabel("enter department (cs,is or it) only");
        depart=new JLabel("department");
        user.setBounds(10, 50, 80, 25);
        pass.setBounds(10, 80, 80, 25);
        depart.setBounds(10, 110, 80, 25);
        note.setBounds(220, 110, 220, 25);
        note.setForeground(Color.BLUE);
        // ..in.. text fields
        
        user_name.setBounds(100,50,100,20);
        password.setBounds(100,80,100,20);
        department.setBounds(100,110,100,20);
        ii.add(user_name);ii.add(password);ii.add(department);
        //..in.. send data and back button
        
        send.setBounds(100,150,110,20);
        back.setBounds(0,0,110,20);
        back.setForeground(Color.RED);
        back.setBackground(Color.red);
        ii.add(send);ii.add(back);
        send.addActionListener(this);
        back.addActionListener(this);
        //..in.. main form
        ii.add(user);ii.add(pass);ii.add(depart);ii.add(note);
        setTitle("uni staff");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600,400);
        setVisible(true);
        add(ii);
    }
    @Override
    public void actionPerformed(ActionEvent r) {
       if (r.getSource()==back) {
            this.dispose();
            new firstScreen().showFirstScreen();
       }
       if (r.getSource()==send) {
            try {
                System.out.println("here");
                String t1 = department.getText();
                if (t1.equalsIgnoreCase("cs")||t1.equalsIgnoreCase("is")||t1.equalsIgnoreCase("it")) {
                    databas.userDataBase.insertUser(user_name.getText(), password.getText(), department.getText());
                    JOptionPane.showMessageDialog(null, "succses","data inserted",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new firstScreen().showFirstScreen();
                }
                else{
                    JOptionPane.showMessageDialog(null, "department not exists","error department",JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            }
       }
    }
}
