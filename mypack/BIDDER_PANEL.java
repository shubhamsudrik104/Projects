
package mypack;

import database.DatabaseConnection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import static mypack.car.buildTableModel;
import org.postgresql.jdbc.PgResultSetMetaData;

import utility.Bd_utility;

/**
 *
 * @author User
 */
public class BIDDER_PANEL extends javax.swing.JFrame {

    /**
     * Creates new form BIDDER_PANEL
     */
    public BIDDER_PANEL() {
        initComponents();
        Bd_utility.setImage(this,"image/wood2.jpg", 1406, 756);
         this.getRootPane().setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.black));
        
         sec = car.sec;
        startTimer();
        timer.start();

        carname = car.adminNameData;
        price = car.adminPriceData;
        imageS = car.adminImageData;

        itemname.setText(carname);
        itemprice.setText(price);
        itemphoto.setIcon(imageS);   
    }

    public void startTimer() {
  
       timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sec == 60) {
                    timerLabel.setText("AUCTION NOT STARTED!");
                } else  {
                    sec--;
                }

                if (sec == -1) {
                    timer.stop();
                    
                    String sql = "select * FROM bid WHERE bid = (SELECT MAX(bid) FROM bid)";
                    try {
                        Class.forName("org.postgresql.Driver");
            java.sql.Connection con = DatabaseConnection.getConnection();
                
                        Statement statement = con.createStatement();
                        ResultSet rs = statement.executeQuery(sql);
                        while (rs.next()) {
                            bidder = rs.getString("name");
                            bid = rs.getInt("bid");
                        }

                        String sql1 = "update car_auction " +
                                "set sold_to = ?, sold_at = ? " +
                                "WHERE carname = ?";
                     //   String sql2 = "delete from  bid";

                        PreparedStatement psmt = con.prepareStatement(sql1);
                        psmt.setString(1, bidder);
                        psmt.setInt(2, bid);
                        psmt.setString(3, carname);
                        psmt.executeUpdate();

                        PreparedStatement psmt1 = con.prepareStatement("delete from  bid");
                        psmt1.executeUpdate();

                        JOptionPane.showMessageDialog(null, "***ITEM***" +"["+ carname +"]"+ "***SOLD TO***" +"["+ bidder +"]"+"***AT***" +"["+ bid+"]");

                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
                    }
                    tableData();
                    
                } else if (sec >= 0 && sec < 10) {
                    timerLabel.setText("00:0" + sec);
                } else {
                    timerLabel.setText("00:" + sec);
                }
                
            }
        });
    }
    public void tableData() {
        try {
            String sql = "select * FROM bid";
            Class.forName("org.postgresql.Driver");
            java.sql.Connection con = DatabaseConnection.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            bidtable.setModel(buildTableModel(rs));
            
        } catch (Exception ex1) {
            JOptionPane.showMessageDialog(null, "Error: " + ex1.getMessage());
        }
    }
    
      
   
    public static DefaultTableModel buildTableModel(ResultSet rs)
throws SQLException {
PgResultSetMetaData metaData = (PgResultSetMetaData) rs.getMetaData();
// names of columns
Vector<String> columnNames = new Vector<>();
int columnCount = metaData.getColumnCount();
for (int column = 1; column <= columnCount; column++) {
columnNames.add(metaData.getColumnName(column));
}
// data of the table
Vector<Vector<Object>> data = new Vector<Vector<Object>>();
while (rs.next()) {
Vector<Object> vector = new Vector<Object>();
for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
vector.add(rs.getObject(columnIndex));
}
data.add(vector);
}
return new DefaultTableModel(data, columnNames);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtbidname = new javax.swing.JTextField();
        txtbid = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bidtable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        itemname = new javax.swing.JLabel();
        itemprice = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        itemphoto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1406, 756));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bid panel for cars");

        jLabel11.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("EMAIL");

        lblemail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblemail.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bider name");

        txtbidname.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        txtbidname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbidnameActionPerformed(evt);
            }
        });

        txtbid.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Bid amount");

        jButton2.setBackground(new java.awt.Color(102, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Verify Button");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bidtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BIDER NAME", "BIDER PRICE"
            }
        ));
        jScrollPane1.setViewportView(bidtable);

        jButton3.setBackground(new java.awt.Color(255, 51, 0));
        jButton3.setFont(new java.awt.Font("DVBW-TTSurekh", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ADD BID");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 102, 0));
        jButton4.setFont(new java.awt.Font("DVBW-TTSurekh", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CANCEL BID");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SELLING ITEM DETAILS");

        jLabel2.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CAR Name");

        jLabel3.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BASEPRICE");

        jLabel6.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CAR IMAGE");

        itemname.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        itemname.setForeground(new java.awt.Color(255, 255, 255));

        itemprice.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        itemprice.setForeground(new java.awt.Color(255, 255, 255));

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TIMER");

        timerLabel.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(255, 255, 255));
        timerLabel.setText("1:00");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtbid, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtbidname, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(itemname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemprice, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(timerLabel)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtbidname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtbid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtbidnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbidnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbidnameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String vname=txtbidname.getText();
        try{
            
            Class.forName("org.postgresql.Driver");
            Connection con = DatabaseConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from register where name= '"+vname+"'");
           if(rs.next()){
               lblemail.setText(rs.getString("email"));
            JOptionPane.showMessageDialog(null,"CUSTOMER IS REGISTER","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            
           }
           else{
          JOptionPane.showMessageDialog(null,"CUSTOMER IS NOT REGISTER","Invalid customer",JOptionPane.WARNING_MESSAGE);
          txtbidname.setText("");
                        txtbid.setText("");
           }}
           catch(Exception e){}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String bidName= txtbidname.getText();
String bidPrice= txtbid.getText();

if (bidName.equals("") || bidPrice.equals("")) {
                JOptionPane.showMessageDialog(null,"FEILDS EMPTY (put information properly)","Field Empty",JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        String sql = "INSERT INTO bid (bid, name) VALUES ( CAST(? AS NUMERIC),?)";
                         Class.forName("org.postgresql.Driver");
            java.sql.Connection con = DatabaseConnection.getConnection();
              java.sql.PreparedStatement statement = con.prepareStatement(sql);
                

                  int bidValue = Integer.parseInt(bidPrice); // Convert bidPrice safely
            statement.setInt(1, bidValue);
            statement.setString(2, bidName);
            statement.executeUpdate();
          JOptionPane.showMessageDialog(null,"BIDD ADDED SUCCESSFULLY ","Success",JOptionPane.INFORMATION_MESSAGE);

                        txtbidname.setText("");
                        txtbid.setText("");
                        lblemail.setText("");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,"CUSTOMER IS NOT REGISTER IN AUCTION");
                                  JOptionPane.showMessageDialog(null,"REGISTER CUSTOMER FIRST","INVALID CUSTOMER",JOptionPane.WARNING_MESSAGE);
                                    txtbidname.setText("");
                        txtbid.setText("");
                        lblemail.setText("");
                    }
                    tableData();
                }
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtbidname.setText("");
        txtbid.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(BIDDER_PANEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BIDDER_PANEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BIDDER_PANEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BIDDER_PANEL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BIDDER_PANEL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bidtable;
    private javax.swing.JLabel itemname;
    private javax.swing.JLabel itemphoto;
    private javax.swing.JLabel itemprice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JTextField txtbid;
    private javax.swing.JTextField txtbidname;
    // End of variables declaration//GEN-END:variables
  private String price = "", carname = "", bidder = "";
    private ImageIcon imageS;
    private int bid;
    Timer timer;
    private  int sec;
    
}
