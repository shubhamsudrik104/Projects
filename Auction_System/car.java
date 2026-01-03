/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mypack;

import database.DatabaseConnection;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.BorderFactory;
import utility.Bd_utility;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.postgresql.jdbc.PgResultSetMetaData;

    


/**
 *
 * @author User
 */
public class car extends javax.swing.JFrame {

    /**
     * Creates new form car
     */
    public car() {
        initComponents();
        Bd_utility.setImage(this,"image/lambo.jpg", 1406, 756);
                 this.getRootPane().setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.black));


    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnselectcar = new javax.swing.JButton();
        txtcname = new javax.swing.JTextField();
        txtcprice = new javax.swing.JTextField();
        txtcdetail = new javax.swing.JTextField();
        btnstart = new javax.swing.JButton();
        btnadditem = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartable = new javax.swing.JTable();
        txtcpath = new javax.swing.JTextField();
        timerlabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        lblphoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CAR Auction ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Car Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Car Details");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Base Price");

        btnselectcar.setBackground(new java.awt.Color(45, 218, 193));
        btnselectcar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnselectcar.setText("Select car");
        btnselectcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselectcarActionPerformed(evt);
            }
        });

        txtcname.setBackground(new java.awt.Color(153, 94, 94));
        txtcname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtcname.setForeground(new java.awt.Color(255, 255, 255));

        txtcprice.setBackground(new java.awt.Color(153, 94, 94));
        txtcprice.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtcprice.setForeground(new java.awt.Color(255, 255, 255));
        txtcprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcpriceActionPerformed(evt);
            }
        });

        txtcdetail.setBackground(new java.awt.Color(153, 94, 94));
        txtcdetail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtcdetail.setForeground(new java.awt.Color(255, 255, 255));

        btnstart.setBackground(new java.awt.Color(252, 97, 9));
        btnstart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnstart.setText("Start Auction");
        btnstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstartActionPerformed(evt);
            }
        });

        btnadditem.setBackground(new java.awt.Color(45, 218, 193));
        btnadditem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnadditem.setText("Add Item");
        btnadditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadditemActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cartable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CarName", "Car Image", "BasePrice", "SOLD TO", "SOLD AT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartableMouseClicked(evt);
            }
        });
        cartable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cartableComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(cartable);

        txtcpath.setBackground(new java.awt.Color(153, 94, 94));
        txtcpath.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtcpath.setForeground(new java.awt.Color(255, 255, 255));

        timerlabel.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        timerlabel.setForeground(new java.awt.Color(255, 0, 0));
        timerlabel.setText("1:00");

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("TIMER");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("X");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(lblphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcdetail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnselectcar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnadditem, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcpath, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnstart, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)
                        .addGap(358, 358, 358)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timerlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timerlabel)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnstart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(84, 84, 84))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnselectcar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcpath, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnadditem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnselectcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselectcarActionPerformed
    JFileChooser fileChooser = new JFileChooser();
            int rs = fileChooser.showOpenDialog(null);
            if (rs == JFileChooser.APPROVE_OPTION) {
                File selectedImage = fileChooser.getSelectedFile();
                txtcpath.setText(selectedImage.getAbsolutePath());
                lblphoto.setIcon(resize(txtcpath.getText()));
            }
        
        
        

    }//GEN-LAST:event_btnselectcarActionPerformed

    public ImageIcon resize(String path) {
        ImageIcon myImg = new ImageIcon(path);
        Image image = myImg.getImage();
        Image newImage = image.getScaledInstance(322, 286, Image.SCALE_SMOOTH);
        ImageIcon finalpic =new  ImageIcon(newImage);
        adminImageData= finalpic;
        lblphoto.setIcon(adminImageData); 
        return new  ImageIcon(newImage);
    }
      public void startTimer() {
        timer = new Timer(1000, (ActionEvent e) -> {
            sec--;
            if (sec == -1) {
                timer.stop();
                try {
                
                } catch (Exception ex) {
                    
                }
            } else if (sec >= 0 && sec < 10) {
                timerlabel.setText("00:0" + sec);
            } else {
                timerlabel.setText("00:" + sec);
            }
        });
    }
       public void tableData() {
        try {
         String sql = "SELECT  carname ,details,  base_price,image_path,sold_to,sold_at FROM car_auction;";
                  //   String sql = "SELECT  * FROM car_auction;";

            Class.forName("org.postgresql.Driver");
                        Connection con = DatabaseConnection.getConnection();
                        Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            cartable.setModel(buildTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
   
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
throws SQLException {
PgResultSetMetaData metaData = (PgResultSetMetaData) rs.getMetaData();
// names of columns
Vector<String> columnNames = new Vector<String>();
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



           

    private void btnstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstartActionPerformed
if (txtcname.getText().isEmpty() || txtcdetail.getText().isEmpty() || txtcprice.getText().isEmpty()|| txtcpath.getText().isEmpty())
        {
        JOptionPane.showMessageDialog(null,"FEILDS EMPTY (put information properly)","Field Empty",JOptionPane.WARNING_MESSAGE);
        }
        else{    
        startTimer();
                timer.start(); 
        }
    }//GEN-LAST:event_btnstartActionPerformed

    private void btnadditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadditemActionPerformed
    String cname = txtcname.getText().trim();
    String detail = txtcdetail.getText();
    String price = txtcprice.getText(); 
    String cpath=txtcpath.getText();
                    if (txtcname.getText().isEmpty() || txtcdetail.getText().isEmpty() || txtcprice.getText().isEmpty()|| txtcpath.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"FEILDS EMPTY (put information properly)","Field Empty",JOptionPane.WARNING_MESSAGE);
 
              return;
            }

            
            try{
            
            Class.forName("org.postgresql.Driver");
            Connection con = DatabaseConnection.getConnection();
            
            String sql = "INSERT INTO car_auction (carname, details, base_price, image_path) VALUES (?, ?, ?, ?)";
              PreparedStatement statement = con.prepareStatement(sql);
                File f = new File(txtcpath.getText());
                    InputStream inputStream = new FileInputStream(f);

                    statement.setString(1, cname);
                    statement.setString(2, detail); 
                    statement.setBigDecimal(3, new java.math.BigDecimal(price));
                    statement.setBinaryStream(4, inputStream);
                    statement.executeUpdate();
                  //  fetchuser();
 tableData();
                    JOptionPane.showMessageDialog(null, "INFORMATION ADDED SUCCESSFULLY" ,"SUCCESS",JOptionPane.INFORMATION_MESSAGE);

                    txtcname.setText("");
                    txtcdetail.setText("");
                    txtcprice.setText("");
                    txtcpath.setText("");
                    lblphoto.setIcon(null);
                   
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
           
                    
             
         

    }//GEN-LAST:event_btnadditemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtcpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcpriceActionPerformed

    private void cartableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartableMouseClicked
DefaultTableModel dm = (DefaultTableModel) cartable.getModel();
                int selectedRow = cartable.getSelectedRow();
                adminNameData = dm.getValueAt(selectedRow, 0).toString();
                txtcname.setText(adminNameData);
               byte[] img = (byte[]) dm.getValueAt(selectedRow, 3); 
               //String img = dm.getValueAt(selectedRow, 3).toString();
                ImageIcon imageIcon = new ImageIcon(img);
                Image im = imageIcon.getImage();
                Image newimg = im.getScaledInstance(322, 286, Image.SCALE_SMOOTH);
                ImageIcon finalPic = new ImageIcon(newimg);
                adminImageData = finalPic;
                lblphoto.setIcon(adminImageData);
                adminPriceData = dm.getValueAt(selectedRow, 2).toString();
                txtcprice.setText(adminPriceData);
                adminDetails = dm.getValueAt(selectedRow, 1).toString();
                txtcdetail.setText(adminDetails);
          
    }//GEN-LAST:event_cartableMouseClicked

    private void cartableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cartableComponentShown
    // TODO add your handling code here:
    }//GEN-LAST:event_cartableComponentShown

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
            java.util.logging.Logger.getLogger(car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new car().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btnselectcar;
    private javax.swing.JButton btnstart;
    private javax.swing.JTable cartable;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JLabel timerlabel;
    private javax.swing.JTextField txtcdetail;
    private javax.swing.JTextField txtcname;
    private javax.swing.JTextField txtcpath;
    private javax.swing.JTextField txtcprice;
    // End of variables declaration//GEN-END:variables
  public static String adminDetails="";
public static String adminNameData="";
    public static String adminPriceData="";
    public static ImageIcon adminImageData;
    
    Timer timer;
    byte[] photo=null;
    String filename=null;
     public static int sec = 60;

}

