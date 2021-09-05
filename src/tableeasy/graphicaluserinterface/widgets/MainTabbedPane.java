
package tableeasy.graphicaluserinterface.widgets;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import tableeasy.MainActivity;
import tableeasy.OracleDatabaseConnection;
import static tableeasy.OracleDatabaseConnection.connect;
import tableeasy.TheStaticClass;
import tableeasy.graphicaluserinterface.widgets.maintabbedpane.QueryTableModel;
import tableeasy.graphicaluserinterface.widgets.maintabbedpane.TableDetails;
public class MainTabbedPane extends JTabbedPane
{   public JTabbedPane _maintabbed_pane;
    public static JPanel _startpage_panel;
    private JPanel _sqledit_panel;
    private JTextField _sqledit_textarea;
    private javax.swing.JCheckBox[] jCheckboxArray;
    private JTextField _select_tablename;
    private JButton _execute_button;
    private JButton _other_button;
    private JButton _show_colomn;
    public static JButton _create_database;
    private JButton _select_button;
    private JButton _select_databases=new JButton("Select Database");
    public static String q;
    public static int rwcnt=0;
    QueryTableModel qtm;
    public static javax.swing.JComboBox databases = new javax.swing.JComboBox();
    public static String smine[]=new String[100];
 
 ImageIcon icon;
 ImageIcon icon2;
    public  MainTabbedPane()
    {
        setUpComponents();
          
    }
    public void setUpComponents()
   {
        tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database=new JButton("DATABASE");
        _maintabbed_pane = new JTabbedPane();
        _startpage_panel = new JPanel()
                {			
			protected void paintComponent(Graphics g)
			{
				//  Dispaly image at full size
				g.drawImage(icon.getImage(), 0, 0, null); 	
				super.paintComponent(g);
			}
		};
   
   
    _startpage_panel.setOpaque(false);
        _startpage_panel.setLayout(null);
       icon = new ImageIcon("F:/back.jpg");
  
		
  
        _select_button=new JButton("Select Table");
        _show_colomn=new JButton("Show Coloumns");
        _sqledit_panel = new JPanel();
        _sqledit_panel.setLayout(null);
        _sqledit_textarea = new JTextField("Enter Query");
        _select_tablename=new JTextField();
        _execute_button = new JButton("Execute");
        _other_button = new JButton("Queries");
   
      _other_button.setBackground(new Color(59, 89, 182));
        _other_button.setForeground(Color.WHITE);
       _other_button.setFocusPainted(false);
        _other_button.setFont(new Font("Tahoma", Font.BOLD, 12));//http://answers.yahoo.com/question/index?qid=20070906133202AAOvnIP
        
    _other_button.setBounds(10, 285, 300, 30);
         _startpage_panel.add(_other_button);
         Dimension sized=databases.getPreferredSize();
         databases.setBounds(400, 100, 300, sized.height);
         _startpage_panel.add(databases);
         tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database.setBounds(900,100,300,30);
         tableeasy.graphicaluserinterface.widgets.MainTabbedPane._startpage_panel.add(tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database);
         tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database.setVisible(false);
         _sqledit_textarea.setBounds(15, 10, 900, 50);
         _sqledit_panel.add(_sqledit_textarea);
         _sqledit_panel.setPreferredSize(new Dimension(1000,500));
         _sqledit_textarea.setPreferredSize(new Dimension(1000,40));
         _select_tablename.setPreferredSize(new Dimension(1040,40));
         final Helper1 h1=new Helper1();
         Dimension sizer=h1.getPreferredSize();
         h1.setBounds(40, 317, sizer.width, sizer.height);
         h1.setVisible(false);
         _startpage_panel.add(h1);
         _select_databases.setBounds(400,140,300,30);
         _startpage_panel.add(_select_databases);
       
        // _select_button.setVisible(false);
         icon2=new ImageIcon("F:/userdet.jpg");
             Table _table=new Table(MainActivity.usernames)
                {			

			protected void paintComponent(Graphics g)
			{
				//  Dispaly image at full size
				g.drawImage(icon2.getImage(), 0, 0, null); 	
				super.paintComponent(g);
			}
		};
     
     
  
     _execute_button.setBounds(15,80,300,30);
             _sqledit_panel.add(_execute_button);
     
     ///DEMO CODE
          
      ExtendedMenuBar._search_textfield.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
            	
           Connection connector=OracleDatabaseConnection.connect;
           
           
               
                        String search_text=new String();
                        String search_query;
                        try
                        {
                              if(OracleDatabaseConnection.connect!=null)
            {
                        Statement st=connector.createStatement();
                        search_text = ExtendedMenuBar._search_textfield.getText().trim();
                      //  System.out.print("dfsfhlshldfsd");
                        
                        search_query = "select * from keywordsr where keywordname like '%"+search_text+"%'";
                         if(!(ExtendedMenuBar._search_textfield.getText().equals("")))
   
       
   {
                        try{
                        ResultSet rs = st.executeQuery(search_query);                        
                        System.out.println("commands\n--------\n");
                        System.out.println("name---description\n");
                       
                        while(rs.next()) 
                        {
				System.out.print(rs.getString("keywordname")+"\t");
				//System.out.print(rs.getString("example")+"\t");
                                System.out.print(rs.getString("descriptions")+"\n");
                               h1.setValue(rs.getString("keywordname"),rs.getString("descriptions"),rs.getString("example"));
                               h1.setVisible(true);
                              
                        }
                                 
                        }
                        catch(SQLException er)
                        {System.out.println("po");
                            er.printStackTrace();
                        }
   }
                          else
   {
       h1.setVisible(false);
   }
            }
   }
            catch(SQLException sqle)
            {
                sqle.getMessage();
                        //"jdbc:oracle:thin:@Prinz:1521:",
            }
          
            }  
        });  
             
             
   _select_databases.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement st=OracleDatabaseConnection.connect.createStatement();
                    String queries="select * from databaser where dbname='"+databases.getSelectedItem().toString()+"'";
                    for(int i=1;i<=MainActivity.noofdata;i++)
                    {
                        if(databases.getSelectedItem().toString().equalsIgnoreCase(MainActivity.databases[i]))
                        {
                            MainActivity.selecteddata=i;
                        }
                    }
                   
                } catch (SQLException ex) {
                    Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //tableeasy.MainActivity.selecteddata=Integer.parseInt(databases.getSelectedItem().toString());
            }
   });
             ///DEMOCODES
    
        _execute_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(tableeasy.MainActivity.usernames==0)
                {
                     UserCreation  _loginbox   = new UserCreation(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
                }
                 else
                 {
              //System.out.println(getUsername()+getPassword()+getPort()+getHostname()+getDatabase());
                              OracleDatabaseConnection conn=new OracleDatabaseConnection();
              Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
           
              q= _sqledit_textarea.getText().trim();
                          q=q.substring(0,q.length()-1);
                  TableDetails screen = new TableDetails();
		
		screen.display();
		
		screen.setVisible(true);
              
                
                
               
         
               if(connector==null)
                    System.out.print("null");
               
               else
               {
                    try {
                        System.out.print("not null");
                          String query = _sqledit_textarea.getText().trim();
                          query=query.substring(0,query.length()-1);
                           System.out.print(query);
               Statement stmt;              
                                
             stmt = connector.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             while (rs.next()) {
                 
                 System.out.println(rs.getString("EMPID") + "\t" );
             }      } catch (SQLException ex) {
                        Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                    }
    
    }
                } }
               
        });
      
     
     _select_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                       
             
                    
                    System.out.println("kko");
                  //System.out.println(getUsername()+getPassword()+getPort()+getHostname()+getDatabase());
                                  OracleDatabaseConnection conn=new OracleDatabaseConnection();
                  Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
               
                 String[] s = new String[100];
                    String s2=_select_tablename.getText().trim();
                   String s1="select ";
                    
                  for(int i=1;i<=rwcnt;i++)
                  {
                      
                      if( jCheckboxArray[i].isSelected() )
                      {
                          s[i]=jCheckboxArray[i].getText();
                          s1=s1.concat(s[i]);
                          s1=s1.concat(",");
                          System.out.println(s[i]);
                      }
                      
                  }
                      
                  
                 s1=s1.substring(0,s1.length()-1);
                   s1=s1.concat(" from ");
                  s1=s1.concat(s2);
                  System.out.println(s2);
                    q=s1;
                   if(connector==null)
                        System.out.print("null");
                   
                   else
                   {
                       
                            System.out.print("not null");
                               System.out.print(q);
                        
                              
                                       
                                       
                                       TableDetails screen = new TableDetails();
                   
                    screen.display();
                    screen.setLocationRelativeTo(null);
                    screen.setTitle(_select_tablename.getText());
                    screen.setVisible(true);
                   }
              
              
}
               
        });
         
       
              _show_colomn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                 if(tableeasy.MainActivity.usernames==0)
                {
                     UserCreation  _loginbox   = new UserCreation(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
                }
                else
                {
                  
                System.out.println(tableeasy.MainActivity.usernames);
               
                                 
                  Connection connector=OracleDatabaseConnection.connect;
                   String s2=_select_tablename.getText().trim();
                   String s1="select * from ";
                   s2=s1.concat(s2);
                  
                  System.out.println(s2);
                    
                   if(connector==null)
                        JOptionPane.showMessageDialog(null,"NOT YET CONNECTED");
                   
                   else
                   {
                                      try {
                                           if(tableeasy.MainActivity.noofdata==0)
                {
                     Databases d=new Databases();
                    d.setLocationRelativeTo(null);
          
           d.setVisible(true);
                }
                                           else
                                           {
                                       for(int i = 1; i<=rwcnt;i++)
                           {
                               jCheckboxArray[i].setVisible(false);
   
                        
                           }
                                          Statement stmt;              
                                                   
                                stmt = connector.createStatement();
                                String squery="select * from tablesr where dbname='"+tableeasy.MainActivity.databases[tableeasy.MainActivity.selecteddata]+"'";
                                            ResultSet rs = stmt.executeQuery(squery); 
                                            ResultSetMetaData metaData1 = rs.getMetaData();
                                             int f=0;
                                             int count=1;
                                            while(rs.next())
                                            {
                                                if(_select_tablename.getText().equals(rs.getString(metaData1.getColumnName(1))))
                                                        f=1;
                                                count++;
                                            }
                                            if(f==0)
                                            {
                                                
                                                JOptionPane.showMessageDialog(null,"NO SUCH TABLE");
                                            }
                                            else{
                                                 rs = stmt.executeQuery(s2);
                           ResultSetMetaData metaData = rs.getMetaData();
                          rwcnt=metaData.getColumnCount();
                           jCheckboxArray = new javax.swing.JCheckBox[100];
                           System.out.println(rwcnt);
                           
                           for(int i = 1; i<=metaData.getColumnCount();i++)
                           {
                               System.out.println("johan");
                               jCheckboxArray[i] = new javax.swing.JCheckBox();
    jCheckboxArray[i].setText(metaData.getColumnName(i));
    jCheckboxArray[i].setBounds(15,((i-1)*20+150), 100, 20);
     jCheckboxArray[i].setVisible(true);
    _startpage_panel.add(jCheckboxArray[i]);
                           }
                        //  _select_button.setVisible(true);
                           }}
                        
                                      } catch (SQLException ex) {
                                           JOptionPane.showMessageDialog(null,"NO SUCH TABLE");
                                          Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                                      }

                   }
                        
}
            }
                          
        });
                  JScrollPane pane = new JScrollPane(_startpage_panel); 
                   _maintabbed_pane.add(pane,"Start Page");    
                   pane.setVisible(true);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                _maintabbed_pane.add(_sqledit_panel,"Sql Edit");
      _maintabbed_pane.add(_table,"Table Details");
               _other_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(tableeasy.MainActivity.usernames==0)
                 {                  UserCreation  _loginbox   = new UserCreation(tableeasy.GraphicalUserInterface._mainframe);
          _loginbox.setVisible(true);
               
                }
                else
                {
                    if(MainActivity.selecteddata==0)
                    {
                         JOptionPane.showMessageDialog(null,"Select a database");
                    }
                    else{
                System.out.println(tableeasy.MainActivity.usernames);
           OtherQueries oq=new OtherQueries();
           oq.setLocationRelativeTo(null);
          
           oq.setVisible(true);
          //  oq.setTitle("MORE QUERIES");
            }}}
        });
               
             
   }
       
   public String returnSqlEditText()
   {
       return _sqledit_textarea.getText();
   }
 
 }
