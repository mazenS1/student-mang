package firstPackage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.table.DefaultTableCellRenderer;

public class degree extends JPanel implements ActionListener {
    int x;
    String s;
    JTable table;
    JScrollPane sc;
    String data[][];
    JLabel m1,m2,m3,m4,m5,m6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton addDgree;
    String header[] = {"id","fname","lname"};
    ArrayList<domain.Student> arr;
    public degree(String s){
        this.s=s;
        this.setLayout(null);
        showTable();
    }

    public void showTable() {
        //initialize table 
        arr =  databas.studentDataBase.getStudent(s);
        data = new String[arr.size()][3];
        for (int i = 0; i < data.length; i++) {
            data[i][0]=""+arr.get(i).getId();
            data[i][1]=arr.get(i).getFname();
            data[i][2]=arr.get(i).getLname();
        }
        table = new JTable(data,header);
        sc=new JScrollPane(table);
        sc.setBounds(0,0,250,300);
        add(sc);
        // initialize degree label button an textfeild
        m1 = new JLabel("IS");
        m2 = new JLabel("IA");
        m3 = new JLabel("SA");
        m4 = new JLabel("SC");
        m5 = new JLabel("IT");
        m6 = new JLabel("OP");
        m1.setBounds(290,20,50,25);
        m2.setBounds(290,50,50,25);
        m3.setBounds(290,80,50,25);
        m4.setBounds(290,110,50,25);
        m5.setBounds(290,140,50,25);
        m6.setBounds(290,170,50,25);
        add(m1);add(m2);add(m3);add(m4);add(m5);add(m6);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t1.setBounds(320,20,50,25);
        t2.setBounds(320,50,50,25);
        t3.setBounds(320,80,50,25);
        t4.setBounds(320,110,50,25);
        t5.setBounds(320,140,50,25);
        t6.setBounds(320,170,50,25);
        add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);
        addDgree = new JButton("add Dgree");
        addDgree.setBounds(300,220,100,20);
        addDgree.setBackground(Color.DARK_GRAY);
        add(addDgree);
        addDgree.addActionListener(this);
        //config table:
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        // initialize event table
        table.addMouseListener(new java.awt.event.MouseAdapter(){
            
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tmouseClicked(evt);
                }
        });
    }
    private void tmouseClicked(java.awt.event.MouseEvent evt){
        x = table.getSelectedRow();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int id = arr.get(x).getId();
            databas.degreeDataBase.insertDegree(id, Integer.parseInt(t1.getText()) , Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
            JOptionPane.showMessageDialog(null, "dgree add to student: ","insetred degree",JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException | SQLException e1) {
            System.out.println(e1.getMessage());
            System.out.println(e1.getLocalizedMessage());
        }
    }
}
