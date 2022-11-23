package sample;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class patientHealth extends JFrame implements ActionListener{
	JLabel lbl_patid,lbl_name,lbl_date,lbl_time,lbl_pulserate,lbl_oxylvl,lbl_temp,lbl_othersymptoms;
	JTextField txt_patid,txt_name,txt_date,txt_time,txt_pulserate,txt_oxylvl,txt_temp,txt_othersymptoms;
	JButton jbtn_submit,jbtn_Back;
	Container co;
	public patientHealth() {
		co=getContentPane();
		co.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lbl_patid=new JLabel("Patient ID Number : ");
		lbl_name=new JLabel("Name : ");
		lbl_date=new JLabel("Date (dd/mm/year) : ");
		lbl_time=new JLabel("Time (hh:mm:ss): ");
		lbl_pulserate=new JLabel("Pulse Rate (BPM): ");
		lbl_oxylvl=new JLabel("Oxygen level (mm Hg): ");
		lbl_temp=new JLabel("Temperature(F) : ");
		lbl_othersymptoms=new JLabel("Other Symptoms : ");
		
		txt_patid= new JTextField();
		txt_name=new JTextField();
		txt_date=new JTextField();
		txt_time=new JTextField();
		txt_pulserate=new JTextField();
		txt_oxylvl=new JTextField();
		txt_temp=new JTextField();
		txt_othersymptoms=new JTextField();
		jbtn_submit=new JButton("Update");
		jbtn_Back=new JButton("Back");
        jbtn_Back.addActionListener(new ActionListener(){  
       public void actionPerformed(ActionEvent e){
           setVisible(false);
 }
        });
        jbtn_submit.addActionListener(this); 
       jbtn_submit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
            	
          	JFrame f=new JFrame("VIEW UPDATED DETAILS"); 
         	   f.setBounds(20, 20, 1000, 500);
         	   f.setVisible(true);
         	   f.setBackground(Color.red);
         	   DefaultTableModel table = new DefaultTableModel();
                JTable jt = new JTable(table);
                jt.setAutoscrolls(true);
                table.addColumn("PAT ID");
                table.addColumn("NAME");
                table.addColumn("DATE");
                table.addColumn("TIME");
                table.addColumn("PULSE RATE");
                table.addColumn("OXYGEN LEVEL");
                table.addColumn("TEMPERATURE");
                table.addColumn("OTHER SYMPTOMS");
                
               JPanel jp = new JPanel();
                JScrollPane jsp;
                jsp = new JScrollPane(jt,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               jsp.setPreferredSize(new Dimension(900,900));
                jp.add(jsp);
                jp.setBackground(Color.WHITE);
                jp.setBounds(200,550,900,400);
                f.add(jp,BorderLayout.CENTER);
                DefaultTableModel table1 = (DefaultTableModel)jt.getModel();
                table1.addRow(new Object[]
                        {
                           
                           txt_patid.getText(),
                          txt_name.getText(),
                           txt_date.getText(),
                           txt_time.getText(),
                           txt_pulserate.getText(),
                           txt_oxylvl.getText(),
                          txt_temp.getText(),
                           txt_othersymptoms.getText()
                          
                       });
      }
             });	
		lbl_patid.setBounds(100, 50, 120, 25);
		 lbl_name.setBounds(100, 100, 120, 25);
		 lbl_date.setBounds(100,150,120,25);
		 lbl_time.setBounds(100,200,120,25);
		 lbl_pulserate.setBounds(100, 250, 120, 25);
		 lbl_oxylvl.setBounds(100,300,200,25);

		 lbl_temp.setBounds(100, 350, 120, 25);
		 lbl_othersymptoms.setBounds(100, 400, 120, 25);
		 
		 jbtn_submit.setBounds(100, 450, 80, 25);
		 jbtn_Back.setBounds(200, 450, 80, 25);
		 
		 txt_patid.setBounds(250, 50, 120, 25);
		 txt_name.setBounds(250, 100, 120, 25);
		 txt_date.setBounds(250, 150, 120, 25);
		 txt_time.setBounds(250, 200, 120, 25);
		 txt_pulserate.setBounds(250, 250, 120, 25);
		 txt_oxylvl.setBounds(250, 300, 120, 25);
		 txt_temp.setBounds(250, 350, 120, 25);
		 txt_othersymptoms.setBounds(250,400,120,25);

		 co.add(lbl_patid);
		 co.add(lbl_name);
		 co.add(lbl_date);
		 co.add(lbl_time);
		 co.add(lbl_pulserate);
		 co.add(lbl_oxylvl);
		 co.add(lbl_temp);
		 co.add(lbl_othersymptoms);
		 co.add(jbtn_submit);;
		 co.add(jbtn_Back);
		 co.add(txt_patid);
		 co.add(txt_name);
		 co.add(txt_date);
		 co.add(txt_time);
		 co.add(txt_pulserate);
		 co.add(txt_oxylvl);
		 co.add(txt_temp);
		 co.add(txt_othersymptoms);

		 setSize(800, 800);
		 setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
Object obj_source=ae.getSource();
if(obj_source==jbtn_submit)
{try
{
int int_patid=Integer.parseInt(txt_patid.getText());
String str_name=txt_name.getText();
String str_date=txt_date.getText();
String str_time=txt_time.getText();
String str_pulserate=txt_pulserate.getText();
String str_oxylvl=txt_oxylvl.getText();
String str_temp=txt_temp.getText();
String str_othersymptoms=txt_othersymptoms.getText();
Connection con=null;
Class.forName("com.mysql.cj.jdbc.Driver"); 
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Khaash@123");
 Statement stmt=con.createStatement();
 String query="insert into patienthealthdetails values('"+int_patid+"','"+str_name+"','"+str_date+"','"+str_time+"','"+str_pulserate+"','"+str_oxylvl+"','"+str_temp+"','"+str_othersymptoms+"')";
 stmt.executeUpdate(query);
 con.setAutoCommit(true);
 JOptionPane.showMessageDialog(this,"Details Added Successfully!");
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(this, ex.toString());
}}
}
public static void main(String args[])
{
patientHealth Demo1=new patientHealth();
}
}
