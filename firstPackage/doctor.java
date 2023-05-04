package firstPackage;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class doctor extends JFrame {
    String depart;
    JTabbedPane tab;
    add a1;
    degree d1;
    updateDegree d4;
    updateStudent d3;
    printDegree d2;
    public doctor(String depart){
       this.depart=depart;
    }
    public void showDoctorScreen() {
        a1 = new add();
        d2 = new printDegree();
        d3=new updateStudent();
        d4 = new updateDegree();
        d1 = new degree(this.depart);
        setTitle("doc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600,400);
        setVisible(true);
        tab = new JTabbedPane();
        tab.addTab("student", a1);
        tab.addTab("degreee", d1);
        tab.addTab("pritn", d2);
        tab.addTab("update student", d3);
        tab.addTab("update degree", d4);
        add(tab);
    }
}
