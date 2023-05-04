package firstPackage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import databas.userDataBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class firstScreen extends JFrame implements ActionListener {
    JLabel user,pass;
    JTextField user_name;
    JPasswordField password;
    JButton signin,signup;
    image ii = new image();
    public firstScreen(){
        
    }
    public void showFirstScreen(){
        // insliz user and password labels
        user=new JLabel("user name");
        pass = new JLabel("password");
        user.setBounds(100, 70, 80, 25);
        pass.setBounds(100, 100, 80, 25);
        ii.add(user);ii.add(pass);
        // insliz user ans password text fileds
        user_name=new JTextField();
        password = new JPasswordField();
        user_name.setBounds(190, 70, 150, 25);
        password.setBounds(190, 100, 150, 25);
        ii.add(user_name);ii.add(password);
        // ..in.. sign in and sign up button
        signin= new JButton("sign in");
        signup= new JButton("sign up");
        signin.setBounds(120, 140, 80, 20);
        signup.setBounds(210, 140, 80, 20);
        ii.add(signin); ii.add(signup);
        signin.addActionListener(this);
        signup.addActionListener(this);
        // ..in.. main form for pro
        setTitle("uni staff");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600,400);
        setVisible(true);
        add(ii);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            
       
        if (e.getSource()==signin) 
        {
            System.out.println("si");
            int i = databas.userDataBase.checkUser(user_name.getText(), password.getText());
            if (i==1) {
                JOptionPane.showMessageDialog(null, "loged in "+user_name.getText(),"welcom",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new doctor(userDataBase.getDepartment(user_name.getText())).showDoctorScreen();
            }
            if (i==2) {
                JOptionPane.showMessageDialog(null, "password not exists","error password not wrong",JOptionPane.WARNING_MESSAGE);
            }
            if (i==0) {
                JOptionPane.showMessageDialog(null, "user not exists","error user",JOptionPane.WARNING_MESSAGE);
        
            }
            System.out.println(i);
        }

        if (e.getSource()==signup) 
        {
            this.dispose();
            new secondeScreen().showSecondeScreeen();;    
        }
        
    }
}
