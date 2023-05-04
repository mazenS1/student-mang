package firstPackage;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class doctor extends JFrame {
    String depart;
    JTabbedPane tab;
    add a1;
    degree d1;
    public doctor(String depart){
       this.depart=depart;
    }
    public void showDoctorScreen() {
        a1 = new add();
        d1 = new degree(this.depart);
        setTitle("doc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600,400);
        setVisible(true);
        tab = new JTabbedPane();
        tab.addTab("student", a1);
        tab.addTab("degree", d1);
        add(tab);
    }
}
