/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableeasy.graphicaluserinterface.widgets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tableeasy.OracleDatabaseConnection;

/**
 *
 * @author Rohan
 */
public class DatabaseSelector extends javax.swing.JFrame {

    /**
     * Creates new form DatabaseSelector
     */
    public DatabaseSelector() {
        try {
            initComponents();
                   OracleDatabaseConnection conn=new OracleDatabaseConnection();
                      Connection connector=conn.checkLogin(conn.hostn,conn.portn,conn.databasen,conn.usern,conn.passn);
                   Statement stmt=connector.createStatement();
                   String squery="select * from databaser where userid="+tableeasy.MainActivity.usernames;
                   ResultSet rs = stmt.executeQuery(squery);
                           ResultSetMetaData metaData = rs.getMetaData();
                           int d=1;
                            button1.setVisible(false);
                             button2.setVisible(false); button3.setVisible(false); button4.setVisible(false);
                              button5.setVisible(false);
                              button6.setVisible(false);
                              button7.setVisible(false);
                               button8.setVisible(false);
                                button9.setVisible(false);
                                 button10.setVisible(false);
                           while(rs.next())
                           {
                               if(d==1)
                               {
                                   button1.setVisible(true);
                                   tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button1.setText(tableeasy.MainActivity.databases[d]);
                               }
                               if(d==2)
                               {
                                    button2.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button2.setText(tableeasy.MainActivity.databases[d]);
                                   
                               }
                                 if(d==3)
                               {
                                    button3.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button3.setText(tableeasy.MainActivity.databases[d]);
                                   
                               }
                                   if(d==4)
                               {
                                    button4.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button4.setText(tableeasy.MainActivity.databases[d]);
                                   
                               }
                                     if(d==5)
                               {
                                    button5.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button5.setText(tableeasy.MainActivity.databases[d]);
                                   
                               }
                                       if(d==6)
                               {
                                    button6.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button6.setText(tableeasy.MainActivity.databases[d]);
                                   
                               }
                                         if(d==7)
                               {
                                    button7.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button7.setText(tableeasy.MainActivity.databases[d]);
                                   

                               }
                                          if(d==8)
                               {
                                    button8.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button8.setText(tableeasy.MainActivity.databases[d]);
                                   
                               }
                                           if(d==9)
                               {
                                    button9.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button9.setText(tableeasy.MainActivity.databases[d]);
                                   
                               }
                                            if(d==10)
                               {
                                    button10.setVisible(true);
                                     tableeasy.MainActivity.databases[d]=rs.getString(metaData.getColumnName(1));
                                   button10.setText(tableeasy.MainActivity.databases[d]);
                                   
                               }
                                         d++;
                           }
                           tableeasy.MainActivity.noofdata=d-1;
                           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        button5 = new javax.swing.JRadioButton();
        button4 = new javax.swing.JRadioButton();
        button7 = new javax.swing.JRadioButton();
        button2 = new javax.swing.JRadioButton();
        button1 = new javax.swing.JRadioButton();
        button6 = new javax.swing.JRadioButton();
        button3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        button8 = new javax.swing.JRadioButton();
        button9 = new javax.swing.JRadioButton();
        button10 = new javax.swing.JRadioButton();

        jRadioButton10.setText("jRadioButton10");

        jRadioButton9.setText("jRadioButton9");

        jRadioButton8.setText("jRadioButton8");

        jRadioButton12.setText("jRadioButton12");

        jButton1.setText("jButton1");

        buttonGroup1.add(button5);

        buttonGroup1.add(button4);

        buttonGroup1.add(button7);

        buttonGroup1.add(button2);

        buttonGroup1.add(button1);

        buttonGroup1.add(button6);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(button3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Available Database List");

        jButton2.setText("Select Database");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button2)
                                    .addComponent(button3)
                                    .addComponent(button5)
                                    .addComponent(button4)
                                    .addComponent(button6))
                                .addGap(284, 284, 284)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button9)
                                    .addComponent(button10))
                                .addGap(0, 145, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button8)
                        .addGap(155, 155, 155))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1))
                            .addComponent(button8))
                        .addGap(18, 18, 18)
                        .addComponent(button2))
                    .addComponent(button9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button3)
                    .addComponent(button10))
                .addGap(18, 18, 18)
                .addComponent(button4)
                .addGap(18, 18, 18)
                .addComponent(button5)
                .addGap(18, 18, 18)
                .addComponent(button6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       
            if(button1.isSelected())
                    tableeasy.MainActivity.selecteddata=1;
            else if(button2.isSelected())
                    tableeasy.MainActivity.selecteddata=2;
             else if(button3.isSelected())
                    tableeasy.MainActivity.selecteddata=3;
             else if(button4.isSelected())
                    tableeasy.MainActivity.selecteddata=4;
             else if(button5.isSelected())
                    tableeasy.MainActivity.selecteddata=5;
             else if(button6.isSelected())
                    tableeasy.MainActivity.selecteddata=6; 
             else if(button7.isSelected())
                    tableeasy.MainActivity.selecteddata=7;
             else if(button8.isSelected())
                    tableeasy.MainActivity.selecteddata=8;
             else if(button9.isSelected())
                    tableeasy.MainActivity.selecteddata=9;
             else if(button10.isSelected())
                    tableeasy.MainActivity.selecteddata=10;
            
            dispose();
             
       
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatabaseSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatabaseSelector().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton button1;
    private javax.swing.JRadioButton button10;
    private javax.swing.JRadioButton button2;
    private javax.swing.JRadioButton button3;
    private javax.swing.JRadioButton button4;
    private javax.swing.JRadioButton button5;
    private javax.swing.JRadioButton button6;
    private javax.swing.JRadioButton button7;
    private javax.swing.JRadioButton button8;
    private javax.swing.JRadioButton button9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables
}
