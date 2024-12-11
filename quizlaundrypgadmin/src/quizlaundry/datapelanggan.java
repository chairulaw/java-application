/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizlaundry;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author CHAIRULAW
 */
public class datapelanggan extends javax.swing.JFrame {
public Connection conn;
private java.sql.Statement cn;
public DatabaseConnection datapelanggandatabaseConnection;
    /**
     * Creates new form datapelanggan
     */
    public datapelanggan() {
        initComponents();
        datapelanggandatabaseConnection = new DatabaseConnection();
        datapelanggandatabaseConnection.koneksi();
        conn = datapelanggandatabaseConnection.getConnection();
        cn = datapelanggandatabaseConnection.getStatement();
        tampildata();
    }
    
     public class DatabaseConnection {
    private Connection conn;
    private java.sql.Statement cn;
    private final String URL = "jdbc:postgresql://localhost:5432/laundry";
    private final String USER = "postgres"; // admin
    private final String PASSWORD = "admin"; // admin

    public void koneksi() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            cn = conn.createStatement();
            JOptionPane.showMessageDialog(null, "Koneksi berhasil.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal.");
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public java.sql.Statement getStatement() {
        return cn;
    }
}

    public void tampildata(){
    DefaultTableModel tabelnyo = new DefaultTableModel();
    tabelnyo.addColumn("ID pelanggan");
    tabelnyo.addColumn("Nama pelanggan");
    tabelnyo.addColumn("jenis kelamin");
    tabelnyo.addColumn("alamat");
    tabelnyo.addColumn("nohp");
    tabelnyo.addColumn("keterangan");
    
    try{
    datapelanggandatabaseConnection.koneksi();
    String sql = "SELECT * FROM pelanggan";
    ResultSet rs= cn.executeQuery(sql);
    while(rs.next())
    {
        tabelnyo.addRow(new Object[]{
        rs.getString(1),
        rs.getString(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5),
        rs.getString(6)
    });
    }
    
    datapelanggan.setModel(tabelnyo);
    
  }catch(Exception e){
    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan menampilkan data " + e);
    System.out.println(e.getMessage());
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

        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datapelanggan = new javax.swing.JTable();
        carikamar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel16.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jLabel16.setText("Cari");

        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jLabel15.setText("data pelanggan");

        datapelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        datapelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datapelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(datapelanggan);

        carikamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carikamarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(carikamar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carikamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void datapelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datapelangganMouseClicked
        // TODO add your handling code here:
        int row;
        row = datapelanggan.getSelectedRow();
            pelanggan.idpelanggan.setText(datapelanggan.getValueAt(row, 0).toString());
            pelanggan.namapelanggan.setText(datapelanggan.getValueAt(row, 1).toString());
            pelanggan.jeniskelamin.setText(datapelanggan.getValueAt(row, 2).toString());
            pelanggan.alamat.setText(datapelanggan.getValueAt(row, 3).toString());
            pelanggan.nohp.setText(datapelanggan.getValueAt(row, 4).toString());
            pelanggan.keterangan.setText(datapelanggan.getValueAt(row, 5).toString());
        this.dispose();
    }//GEN-LAST:event_datapelangganMouseClicked

    private void carikamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carikamarActionPerformed
        // TODO add your handling code here:
        //        DefaultTableModel tabelnyo = new DefaultTableModel();
        //        tabelnyo.addColumn("ID Kamar");
        //        tabelnyo.addColumn("Nama Kamar");
        //        tabelnyo.addColumn("Tipe Kamar");
        //        tabelnyo.addColumn("Harga Kamar");
        //        tabelnyo.addColumn("Status Kamar");
        //
        //        try{
            //            datakamardatabaseConnection.koneksi();
            //            String sql = "Select * from kamar where " + "idkamar ='" +
            //            carikamar.getText() + "' or " + "namakamar like '%" + carikamar.getText() + "%'";
            //
            //            ResultSet rs = cn.executeQuery(sql); while (rs.next()) {
                //                tabelnyo.addRow(new Object[]{
                    //                    rs.getString(1),
                    //                    rs.getString(2),
                    //                    rs.getString(3),
                    //                    rs.getString(4),
                    //                    rs.getString(5)
                    //                });
            //            }
        //
        //            databuku.setModel(tabelnyo);
        //
        //        }catch (Exception e){ JOptionPane.showMessageDialog(null,"Terjadi Kesalahan " + e);
        //        }
    }//GEN-LAST:event_carikamarActionPerformed

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
            java.util.logging.Logger.getLogger(datapelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datapelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datapelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datapelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datapelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carikamar;
    private javax.swing.JTable datapelanggan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
