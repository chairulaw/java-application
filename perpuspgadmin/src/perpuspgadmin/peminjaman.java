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
public class peminjaman extends javax.swing.JFrame {
public Connection conn;
public java.sql.Statement cn;
public DatabaseConnection databaseConnection;
    /**
     * Creates new form reservasi
     */
    public  peminjaman() {
        initComponents();
        databaseConnection = new DatabaseConnection();
        databaseConnection.koneksi();
        tampildata();
        bersih();
    }

    public class DatabaseConnection {
    private Connection conn;
    private java.sql.Statement cn;
    private final String URL = "jdbc:postgresql://localhost:5432/perpustakaan";
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
    
    public void year() {
         
        Date now = new Date(0);
         
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("YYYY"); 
 
        System.out.println("It is " + simpleDateformat.format(now));
 
}
    
    public void tampildata(){
        DefaultTableModel tabelnyo =  new DefaultTableModel();
        tabelnyo.addColumn("ID Peminjaman");
        tabelnyo.addColumn("Nama Peminjam");
        tabelnyo.addColumn("ID Petugas");
        tabelnyo.addColumn("Nama Petugas");
        tabelnyo.addColumn("ID Buku");
        tabelnyo.addColumn("Nama Buku");
        tabelnyo.addColumn("Pengarang");
        tabelnyo.addColumn("Penerbit");
        tabelnyo.addColumn("Tanggal Terbit");
        tabelnyo.addColumn("Stok Buku");
        tabelnyo.addColumn("Jumlah Pinjam");
        tabelnyo.addColumn("Tanggal Pinjam");
        tabelnyo.addColumn("Tanggal Kembalikan");
        
        try{
        String sql="SELECT peminjaman.idpeminjaman, peminjaman.namapeminjam, petugas.idpetugas, petugas.namapetugas, "
                + "bukuperpus.idbuku, bukuperpus.namabuku, bukuperpus.pengarang, bukuperpus.penerbit, bukuperpus.tahunterbit, "
                + "bukuperpus.stokbuku, peminjaman.jumlahpinjam, peminjaman.tanggalpinjam, peminjaman.tanggalkembali "
                + "FROM peminjaman JOIN bukuperpus ON bukuperpus.idbuku = peminjaman.idbuku "
                + "JOIN petugas ON petugas.idpetugas = peminjaman.idpetugas";
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
        tabelpeminjaman.setModel(tabelnyo);

        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Ada Kesalahan " + e);
}}
    
    void bersih(){
    idpeminjaman.setText("");
    namapeminjam.setText("");
    idpetugas.setText("");
    namapetugas.setText("");
    alamat.setText("");
    nohp.setText("");
    idbuku.setText("");
    namabuku.setText("");
    pengarang.setText("");
    penerbit.setText("");
    jumlahpinjam.setText("");
    stokbuku.setText("");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpeminjaman = new javax.swing.JTable();
        btsave = new javax.swing.JButton();
        btupdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btdelete = new javax.swing.JButton();
        idpeminjaman = new javax.swing.JTextField();
        btexit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idpetugas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namapetugas = new javax.swing.JTextField();
        bttambahpetugas = new javax.swing.JButton();
        nohp = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        idbuku = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        namabuku = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pengarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bttambahbuku = new javax.swing.JButton();
        penerbit = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        stokbuku = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        dtterbit = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namapeminjam = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jumlahpinjam = new javax.swing.JTextField();
        tglpinjam = new javax.swing.JTextField();
        tglkembali = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelpeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelpeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpeminjaman);

        btsave.setText("SAVE");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });

        btupdate.setText("UPDATE");
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Peminjaman");

        btdelete.setText("DELETE");
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });

        btexit.setText("EXIT");
        btexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexitActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel2.setText("ID Petugas");

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jLabel3.setText("Masukkan Data Petugas !");

        jLabel4.setText("Nama Petugas");

        bttambahpetugas.setText("+");
        bttambahpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahpetugasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(996, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idpetugas))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(namapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(nohp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttambahpetugas)
                        .addGap(299, 299, 299))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttambahpetugas)
                        .addGap(53, 53, 53))))
        );

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));

        jLabel7.setText("ID Buku");

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jLabel8.setText("Masukkan Data Buku !");

        jLabel9.setText("Nama Buku");

        jLabel10.setText("Pengarang");

        jLabel11.setText("Tanggal Terbit");

        bttambahbuku.setText("+");
        bttambahbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahbukuActionPerformed(evt);
            }
        });

        jLabel15.setText("Penerbit");

        jLabel19.setText("Stok Buku");

        dtterbit.setDateFormatString("yyyy-MM-dd");

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
                            .addComponent(idbuku))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(namabuku, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(dtterbit, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(stokbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addComponent(bttambahbuku))
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namabuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtterbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(bttambahbuku)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stokbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jLabel5.setText("Tanggal Pinjam");

        jLabel6.setText("Tanggal Kembalikan");

        jLabel12.setText("Nama Peminjam");

        jLabel13.setText("Jumlah Pinjam");

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
                        .addComponent(jumlahpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45)
                        .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(idpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(namapeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(namapeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel13)
                        .addComponent(jumlahpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsave)
                    .addComponent(btupdate)
                    .addComponent(btdelete)
                    .addComponent(btexit))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelpeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpeminjamanMouseClicked
        // TODO add your handling code here:
        int row =0;
        if(evt.getClickCount()==1){
            row=tabelpeminjaman.getSelectedRow();

            idpeminjaman.setText(tabelpeminjaman.getValueAt(row, 0).toString());
            namapeminjam.setText(tabelpeminjaman.getValueAt(row, 1).toString());
            idpetugas.setText(tabelpeminjaman.getValueAt(row, 2).toString());
            namapetugas.setText(tabelpeminjaman.getValueAt(row, 3).toString());
            nohp.setText(tabelpeminjaman.getValueAt(row, 4).toString());
            alamat.setText(tabelpeminjaman.getValueAt(row, 5).toString());
            idbuku.setText(tabelpeminjaman.getValueAt(row, 6).toString());
            namabuku.setText(tabelpeminjaman.getValueAt(row, 7).toString());
            pengarang.setText(tabelpeminjaman.getValueAt(row, 8).toString());
            penerbit.setText(tabelpeminjaman.getValueAt(row, 9).toString());
            tglpinjam.setText(tabelpeminjaman.getValueAt(row, 11).toString());
            tglkembali.setText(tabelpeminjaman.getValueAt(row, 12).toString());
            // Convert the date strings to Date objects
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date terbit = dateFormat.parse(tabelpeminjaman.getValueAt(row, 10).toString());
                dtterbit.setDate(terbit);
//                Date tanggalpinjam = dateFormat.parse(tabelpeminjaman.getValueAt(row, 11).toString());
//                tglpinjam.setDate(terbit);
//                Date tanggalkembali = dateFormat.parse(tabelpeminjaman.getValueAt(row, 12).toString());
//                tglkembalikan.setDate(terbit);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stokbuku.setText(tabelpeminjaman.getValueAt(row, 13).toString());
            jumlahpinjam.setText(tabelpeminjaman.getValueAt(row, 14).toString());
            btsave.setEnabled(true);
        }
    }//GEN-LAST:event_tabelpeminjamanMouseClicked

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
        // TODO add your handling code here:
        try{
                databaseConnection.koneksi();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                // FIELD:: idreservasi, idtamu, idkamar, in, out, jumlahtamu

//                if (tglpinjam.getDate() != null && tglkembalikan.getDate() != null) {
//                    String tanggalpinjam= dateFormat.format(tglpinjam.getDate());
//                    String tanggalkembalikan= dateFormat.format(tglkembalikan.getDate());


                    String sql="insert into peminjaman values('"+ idpeminjaman.getText() +"','"+
                    idpetugas.getText() +"', '"+ idbuku.getText() +"','"+ namapeminjam.getText() +"','"+
                    jumlahpinjam.getText() +"','"+ tglpinjam.getText() +"','"+ tglkembali.getText() +"')";
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

            

                String sql="update peminjaman set tanggalpinjam='"+ tglpinjam.getText() +"', tanggalkembali='"+
                tglkembali.getText() +"', idpetugas= '"+ idpetugas.getText() +"', idbuku= '"+ idbuku.getText() +"',"
                + "namapeminjam= '"+ namapeminjam.getText() +"', jumlahpinjam= '"+ jumlahpinjam.getText() +"' where idpeminjaman='"+ idpeminjaman.getText() +"'";
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
            String deleteReservasiSQL = "DELETE FROM peminjaman WHERE idpeminjaman='" + idpeminjaman.getText() + "'";
    databaseConnection.getStatement().executeUpdate(deleteReservasiSQL);
    tampildata();   
    databaseConnection.getConnection().close();
    bersih();

            JOptionPane.showMessageDialog(null,"Data Berhasil Di Hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hapus Data Gagal" + e.getMessage());
        }
    }//GEN-LAST:event_btdeleteActionPerformed

    private void btexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btexitActionPerformed

    private void bttambahpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahpetugasActionPerformed
        // TODO add your handling code here:
        new datapetugas().show();
    }//GEN-LAST:event_bttambahpetugasActionPerformed

    private void bttambahbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahbukuActionPerformed
        // TODO add your handling code here:
        new databuku().show();
    }//GEN-LAST:event_bttambahbukuActionPerformed

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
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField alamat;
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btexit;
    private javax.swing.JButton btsave;
    private javax.swing.JButton bttambahbuku;
    private javax.swing.JButton bttambahpetugas;
    private javax.swing.JButton btupdate;
    public static com.toedter.calendar.JDateChooser dtterbit;
    public static javax.swing.JTextField idbuku;
    private javax.swing.JTextField idpeminjaman;
    public static javax.swing.JTextField idpetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField jumlahpinjam;
    public static javax.swing.JTextField namabuku;
    private javax.swing.JTextField namapeminjam;
    public static javax.swing.JTextField namapetugas;
    public static javax.swing.JTextField nohp;
    public static javax.swing.JTextField penerbit;
    public static javax.swing.JTextField pengarang;
    public static javax.swing.JTextField stokbuku;
    private javax.swing.JTable tabelpeminjaman;
    private javax.swing.JTextField tglkembali;
    private javax.swing.JTextField tglpinjam;
    // End of variables declaration//GEN-END:variables
}