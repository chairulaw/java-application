/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuspgadmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author CHAIRULAW
 */
public class transaksi extends javax.swing.JFrame {
public Connection conn;
public java.sql.Statement cn;
public DatabaseConnection databaseConnection;
    /**
     * Creates new form transaksi
     */
    public transaksi() {
        initComponents();
        databaseConnection = new DatabaseConnection();
        databaseConnection.koneksi();
        tampildata();
        bersih();
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
//            JOptionPane.showMessageDialog(null, "Koneksi berhasil ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal " + e);
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
        DefaultTableModel tabelnyo =  new DefaultTableModel();
        tabelnyo.addColumn("ID Transaksi");
        tabelnyo.addColumn("tanggal cuci");
        tabelnyo.addColumn("ID Pelanggan");
        tabelnyo.addColumn("Nama Pelanggan");
        tabelnyo.addColumn("ID Petugas");
        tabelnyo.addColumn("Nama Petugas");
        tabelnyo.addColumn("ID Layanan");
        tabelnyo.addColumn("Jenis Layanan");
        tabelnyo.addColumn("Tanggal Selesai");
        tabelnyo.addColumn("Berat Cucian");
        tabelnyo.addColumn("Harga Per Kilo");
        tabelnyo.addColumn("Harga Layanan");
        tabelnyo.addColumn("Tips Pencuci");
        
        try{
        String sql="SELECT transaksicuci.idtransaksi, transaksicuci.tglcuci, pelanggan.idpelanggan, pelanggan.namapelanggan, petugas.idpetugas, petugas.namapetugas, layanan.idlayanan, layanan.jenislayanan, transaksicuci.tglselesai, transaksicuci.beratcucian, transaksicuci.hargaperkilo, transaksicuci.hargalayanan, transaksicuci.tipspencuci FROM transaksicuci JOIN pelanggan ON pelanggan.idpelanggan= transaksicuci.idpelanggan JOIN petugas ON petugas.idpetugas = transaksicuci.idpetugas JOIN layanan on layanan.idlayanan = transaksicuci.idlayanan";
        ResultSet rs = databaseConnection.getStatement().executeQuery(sql);
        while(rs.next())
        {
         tabelnyo.addRow(new Object[]{
         rs.getString(1),
         rs.getString(2),
         rs.getString(3),
         rs.getString(4),
         rs.getString(5),
         rs.getString(6),
         rs.getString(7),
         rs.getString(8),
         rs.getString(9),
         rs.getString(10),
         rs.getString(11),
         rs.getString(12),
         rs.getString(13)
         });
        }
        tabeltransaksi.setModel(tabelnyo);

        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Ada Kesalahan " + e);
}}
    
    void bersih(){
    idtransaksi.setText("");
    tglcuci.setText("");
    idpelanggan.setText("");
    namapelanggan.setText("");
    idpetugas.setText("");
    namapetugas.setText("");
    idlayanan.setText("");
    jenislayanan.setText("");
    tglselesai.setText("");
    beratcucian.setText("");
    hargaperkg.setText("");
    hargalayanan.setText("");
    tipspencuci.setText("");
//    statuskamar.setText("");
//    hargakamar.setText("");
//    stokkamar.setText("");
//    jumlahpesan.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        beratcucian = new javax.swing.JTextField();
        hargaperkg = new javax.swing.JTextField();
        idtransaksi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        idpetugas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        namapetugas = new javax.swing.JTextField();
        btpetugas = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        idlayanan = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jenislayanan = new javax.swing.JTextField();
        btlayanan = new javax.swing.JButton();
        hargalayanan = new javax.swing.JTextField();
        btexit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idpelanggan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namapelanggan = new javax.swing.JTextField();
        btpelanggan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeltransaksi = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tglcuci = new javax.swing.JTextField();
        btsave = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btupdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btdelete = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        tglselesai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tipspencuci = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel13.setText("berat cucian");

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));

        jLabel7.setText("ID petugas");

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jLabel8.setText("Masukkan petugas!");

        jLabel9.setText("Nama petugas");

        btpetugas.setText("+");
        btpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpetugasActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jLabel17.setText("Masukkan layanan!");

        jLabel18.setText("ID layanan");

        jLabel20.setText("jenis layanan");

        btlayanan.setText("+");
        btlayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlayananActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idpetugas))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(namapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(btpetugas))))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idlayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jenislayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(btlayanan))))
                    .addComponent(jLabel17))
                .addGap(242, 242, 242))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btpetugas)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idlayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jenislayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btlayanan))))))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        btexit.setText("EXIT");
        btexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexitActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel2.setText("ID pelanggan");

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jLabel3.setText("Masukkan Data pelanggan !");

        jLabel4.setText("Nama pelanggan");

        btpelanggan.setText("+");
        btpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idpelanggan))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(namapelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(btpelanggan))
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namapelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btpelanggan))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel5.setText("harga perkilo");

        tabeltransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeltransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeltransaksi);

        jLabel6.setText("harga layanan");

        btsave.setText("SAVE");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });

        jLabel12.setText("tanggal cuci");

        btupdate.setText("UPDATE");
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });

        jLabel1.setText("id transaksi");

        btdelete.setText("DELETE");
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });

        jLabel14.setText("tanggal selesai\\");

            jLabel10.setText("tips pencuci");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(beratcucian, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(hargaperkg, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jLabel6)
                            .addGap(45, 45, 45)
                            .addComponent(hargalayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75)
                            .addComponent(jLabel10)
                            .addGap(45, 45, 45)
                            .addComponent(tipspencuci, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(idtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(tglcuci, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addComponent(tglselesai, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btsave)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btupdate)
                            .addGap(217, 217, 217)
                            .addComponent(btdelete)
                            .addGap(217, 217, 217)
                            .addComponent(btexit)
                            .addGap(143, 143, 143))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(idtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(tglcuci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(tglselesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(56, 56, 56)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(hargalayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13)
                            .addComponent(beratcucian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hargaperkg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tipspencuci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btsave)
                        .addComponent(btupdate)
                        .addComponent(btdelete)
                        .addComponent(btexit))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpetugasActionPerformed
        // TODO add your handling code here:
        new datapetugas().show();
    }//GEN-LAST:event_btpetugasActionPerformed

    private void btexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btexitActionPerformed

    private void btpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpelangganActionPerformed
        // TODO add your handling code here:
//        new datapelanggan().show();
    }//GEN-LAST:event_btpelangganActionPerformed

    private void tabeltransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltransaksiMouseClicked
        // TODO add your handling code here:
        int row =0;
        if(evt.getClickCount()==1){
            row=tabeltransaksi.getSelectedRow();

            idtransaksi.setText(tabeltransaksi.getValueAt(row, 0).toString());
            tglcuci.setText(tabeltransaksi.getValueAt(row, 1).toString());
            idpelanggan.setText(tabeltransaksi.getValueAt(row, 2).toString());
            namapelanggan.setText(tabeltransaksi.getValueAt(row, 3).toString());
            idpetugas.setText(tabeltransaksi.getValueAt(row, 4).toString());
            namapetugas.setText(tabeltransaksi.getValueAt(row, 5).toString());
            idlayanan.setText(tabeltransaksi.getValueAt(row, 6).toString());
            jenislayanan.setText(tabeltransaksi.getValueAt(row, 7).toString());
            tglselesai.setText(tabeltransaksi.getValueAt(row, 8).toString());
            beratcucian.setText(tabeltransaksi.getValueAt(row, 9).toString());
            hargaperkg.setText(tabeltransaksi.getValueAt(row, 10).toString());
            hargalayanan.setText(tabeltransaksi.getValueAt(row, 11).toString());
            tipspencuci.setText(tabeltransaksi.getValueAt(row, 12).toString());
            // Convert the date strings to Date objects
            btsave.setEnabled(true);
        }
    }//GEN-LAST:event_tabeltransaksiMouseClicked

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
        // TODO add your handling code here:
        try{
            databaseConnection.koneksi();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // FIELD:: idreservasi, idtamu, idkamar, in, out, jumlahtamu

            //                if (tglpinjam.getDate() != null && tglkembalikan.getDate() != null) {
                //                    String tanggalpinjam= dateFormat.format(tglpinjam.getDate());
                //                    String tanggalkembalikan= dateFormat.format(tglkembalikan.getDate());

                String sql="insert into transaksicuci values('"+ idtransaksi.getText() +"','"+
                tglcuci.getText() +"', '"+ tglselesai.getText() +"','"+ idpelanggan.getText() +"','"+
                idpetugas.getText() +"','"+ idlayanan.getText() +"','"+ beratcucian.getText() +"','"+ 
                        hargaperkg.getText() +"','"+ hargalayanan.getText() +"','"+ tipspencuci.getText() +"')";
                System.out.println(sql);
                databaseConnection.getStatement().executeUpdate(sql);
                tampildata();
                databaseConnection.getConnection().close();
                bersih();
                //                }

            btsave.setEnabled(true);

            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Proses Penyimpanan Data Gagal" + e);
        }

        /*It appears that my JDateChooser is unable to display the selected date,
        and the Save button shows an error that I'm not exactly sure about,
        particularly in the "((JTextField)...." part. When executed, it indicates that the
        data-saving process is successful, but upon checking in MySQL, none of the data is stored.*/
    }//GEN-LAST:event_btsaveActionPerformed

    private void btupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupdateActionPerformed
        // TODO add your handling code here:
        try{
            databaseConnection.koneksi();
            //            SimpleDateFormat tglpinjam = new SimpleDateFormat("yyyy-MM-dd");
            //            SimpleDateFormat tglkembali = new SimpleDateFormat("yyyy-MM-dd");

            // FIELD:: idreservasi, idtamu, idkamar, in, out, jumlahtamu
            //            JOptionPane.showMessageDialog(null,"update id sblm if: " + idpeminjaman.getText());

            String sql="update transaksicuci set tglcuci='"+ tglcuci.getText() +"', tglselesai='"+
            tglselesai.getText() +"', idpelanggan= '"+ idpelanggan.getText() +"', idpetugas= '"+ idpetugas.getText() +"',"
            + "idlayanan= '"+ idlayanan.getText() +"', beratcucian= '"+ beratcucian.getText() +"', hargaperkilo= '"+ 
                    hargaperkg.getText() +"', hargalayanan= '"+ hargalayanan.getText() +"',tipspencuci= '"+ 
                    tipspencuci.getText() +"' where idtransaksi='"+ idtransaksi.getText() +"'";
            databaseConnection.getStatement().executeUpdate(sql);
            tampildata();
            databaseConnection.getConnection().close();
            bersih();

            JOptionPane.showMessageDialog(null,"Data Berhasil Di Update");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Update Data Gagal" + e);
        }
    }//GEN-LAST:event_btupdateActionPerformed

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
        // TODO add your handling code here:
        try{
            databaseConnection.koneksi();
            String deleteReservasiSQL = "DELETE FROM transaksicuci WHERE idtransaksi='" + idtransaksi.getText() + "'";
            databaseConnection.getStatement().executeUpdate(deleteReservasiSQL);
            tampildata();
            databaseConnection.getConnection().close();
            bersih();

            JOptionPane.showMessageDialog(null,"Data Berhasil Di Hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hapus Data Gagal" + e.getMessage());
        }
    }//GEN-LAST:event_btdeleteActionPerformed

    private void btlayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlayananActionPerformed
        // TODO add your handling code here:
//        new datalayanan().show();
    }//GEN-LAST:event_btlayananActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beratcucian;
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btexit;
    private javax.swing.JButton btlayanan;
    private javax.swing.JButton btpelanggan;
    private javax.swing.JButton btpetugas;
    private javax.swing.JButton btsave;
    private javax.swing.JButton btupdate;
    private javax.swing.JTextField hargalayanan;
    private javax.swing.JTextField hargaperkg;
    public static javax.swing.JTextField idlayanan;
    public static javax.swing.JTextField idpelanggan;
    public static javax.swing.JTextField idpetugas;
    private javax.swing.JTextField idtransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jenislayanan;
    public static javax.swing.JTextField namapelanggan;
    public static javax.swing.JTextField namapetugas;
    private javax.swing.JTable tabeltransaksi;
    private javax.swing.JTextField tglcuci;
    private javax.swing.JTextField tglselesai;
    private javax.swing.JTextField tipspencuci;
    // End of variables declaration//GEN-END:variables
}
