package firstPackage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
public class printDegree extends JPanel implements ActionListener{
    JTable table;
    JScrollPane sc;
    String data[][];
    JButton print;
    String header[] = {"id","fname","lname","degree"};
    ArrayList<domain.Student> arr; 
    public printDegree(){
        this.setLayout(null);
        showTable();
    }
    public void showTable() {
        //initialize table 
        arr =  databas.studentDataBase.getStudentAndDegree();
        data = new String[arr.size()][4];
        for (int i = 0; i < data.length; i++) {
            data[i][0]=""+arr.get(i).getId();
            data[i][1]=arr.get(i).getFname();
            data[i][2]=arr.get(i).getLname();
            data[i][3]=arr.get(i).getAddress();
        }
        table = new JTable(data,header);
        sc=new JScrollPane(table);
        sc.setBounds(0,0,300,300);
        add(sc);
        // initialize degree label button an textfeild
        print = new JButton("print Dgree");
        print.setBounds(300,220,100,20);
        add(print);
        print.setBounds(180,300,100,20);
        print.addActionListener(this);
        //config table:
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MessageFormat h = new MessageFormat("student degree");
        MessageFormat f = new MessageFormat("page (1)");
        try {
            table.print(JTable.PrintMode.NORMAL,h,f);
        } catch (Exception e1) {
                System.out.println(e1.getMessage());
        }
    }
    
}
