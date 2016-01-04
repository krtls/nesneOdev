package nesneproje;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author beatles
 */

public class Kelime extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private Connection conn = null; //Bağlantı nesnemiz
    private final String dbUrl = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private final String dbName = "kelimeDb"; //veritabanının ismi
    private final String properties= "?useUnicode=true&amp;characterEncoding=utf8"; //Türkçe karakter problemi yaşamamak için
    private final String driver = "com.mysql.jdbc.Driver";//MySQL-Java bağlantısını sağlayan JDBC sürücüsü
    private final String userName = "root"; //veritabanı için kullanıcı adı
    private final String password = ""; //kullanıcı şifresi
    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    private Statement stmt;
    
    ArrayList<String> nGrams;
    
    public Kelime() {
        this.nGrams = new ArrayList<>();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 78, 360, 272));

        jLabel2.setText("Cümleler");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 48, -1, -1));

        jLabel3.setText("Dil Seçiniz");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("TR");
        jRadioButton1.setName("radioTr"); // NOI18N
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("EN");
        jRadioButton2.setName("radioEn"); // NOI18N
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("FR");
        jRadioButton3.setName("radioFr"); // NOI18N
        jPanel2.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        jButton3.setText("Temp'e Ekle");
        jButton3.setName("tempEkle"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 60, 110));

        jButton4.setText("Kelimeye Göre");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 150, -1));

        jButton2.setText("Tabloya Ekle");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, 84));

        jLabel1.setText("URL Adres:");
        jLabel1.setToolTipText("");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 18, -1, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 13, 251, -1));

        jButton1.setText("ÇEK");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 12, -1, -1));

        jButton5.setText("3-Gram'a Göre");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 150, -1));

        jLabel4.setText("Dil Tespiti");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 210, -1));

        jLabel5.setText("Veritabanı Kayıt");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 10, 140));

        jTabbedPane1.addTab("Dil Tespit", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String[] gramArr_tr = new String[50];
        String[] gramArr_en = new String[50];
        String[] gramArr_fr = new String[50];

        String sql1="SELECT gram_tr from gramlar_tr";
        String sql2="SELECT gram_en from gramlar_en limit 50";
        String sql3="SELECT gram_fr from gramlar_fr";

        try {
            stmt = (Statement) baglantiAc(); //veritabanına bağlanılıyor

            res = stmt.executeQuery(sql1); //tablodaki kayıtlar getiriliyor
            int i=0;
            while(res.next()){
                gramArr_tr[i] = res.getString("gram_tr");
                i++;
            }

            res = stmt.executeQuery(sql2); //tablodaki kayıtlar getiriliyor
            i=0;
            while(res.next()){
                gramArr_en[i] = res.getString("gram_en");
                i++;
            }

            res = stmt.executeQuery(sql3); //tablodaki kayıtlar getiriliyor
            i=0;
            while(res.next()){
                gramArr_fr[i] = res.getString("gram_fr");
                i++;
            }

        } catch (Exception ex) {
            Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Malesef");
        }
        try {
            baglantiKapat();
        } catch (Exception ex) {
            Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
        }

        String ayrac=" ;,.";

        StringTokenizer st=new StringTokenizer(jTextArea1.getText(), ayrac);
        //System.out.println(st.countTokens());
        int uz, i, gramAdet=0;
        String gram;

        while(st.hasMoreTokens()){
            gram = "_"+st.nextToken().toLowerCase()+"_";
            uz=gram.length(); i= 0;
            while (i<uz-2){
                nGrams.add(gram.substring(i, i+3));
                i++; gramAdet++;
            }

        }

        System.out.println(gramAdet);
        System.out.println(nGrams);

        String[] sinanacakMetinArr = new String[gramAdet];

        for(i=0; i<gramAdet; i++){
            sinanacakMetinArr[i] = nGrams.get(i);
            System.out.println(sinanacakMetinArr[i]);

        }

        int adetTr = dizi_karsilastir(sinanacakMetinArr, gramArr_tr);
        int adetEn = dizi_karsilastir(sinanacakMetinArr, gramArr_en);
        int adetFr = dizi_karsilastir(sinanacakMetinArr, gramArr_fr);

          if(adetTr==0 && adetEn==0 && adetFr==0){
            JOptionPane.showMessageDialog(null, "Maalesef Dil Belirlenemedi!");
            return;
        }
        
        if(adetTr>adetEn)
        if(adetTr>adetFr)
        JOptionPane.showMessageDialog(null, "TÜRKÇE");
        else
        JOptionPane.showMessageDialog(null, "FRANSIZCA");
        else if(adetEn>adetFr)
        JOptionPane.showMessageDialog(null, "İNGİLİZCE");
        else
        JOptionPane.showMessageDialog(null, "FRANSIZCA");

    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String url = jTextField1.getText();
        jTextArea1.setText("");
        try
        {
            //File file = new File("K:/index.html");
            Document doc = Jsoup.connect(url).get();
            jLabel2.setText("Sayfa Başlığı: " + doc.title());
            //div etiketini tasiyan tum elementleri getir
            Elements elements = doc.getElementsByTag("div");

            //Elements nesnesi icerisindeki her bir div elementinin icerigini yaz
            for (Element e : elements)
            {
                jTextArea1.append(e.text());
                jTextArea1.append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String tabloAdi=null, tabloAdi2=null, alan1=null, alan2=null;

        if(jRadioButton1.isSelected()){
            tabloAdi="kelimeler_tr";
            alan1="kelime_tr";
            tabloAdi2="gramlar_tr";
            alan2="gram_tr";
        }
        if(jRadioButton2.isSelected()){
            tabloAdi="kelimeler_en";
            alan1="kelime_en";
            tabloAdi2="gramlar_en";
            alan2="gram_en";
        }
        if(jRadioButton3.isSelected()){
            tabloAdi="kelimeler_fr";
            alan1="kelime_fr";
            tabloAdi2="gramlar_fr";
            alan2="gram_fr";
        }

        String sql="SELECT kelime, count(*) as adet FROM kelimeler_temp group by kelime order by adet desc limit 50";
        String sql2="SELECT gram, count(*) as adet FROM gramlar_temp group by gram order by adet desc limit 50";
        try {
            stmt = (Statement) baglantiAc(); //veritabanına bağlanılıyor
            res = stmt.executeQuery(sql); //tablodaki kayıtlar getiriliyor
            //JOptionPane.showMessageDialog(null, "okkkk");
        } catch (Exception ex) {
            Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Malesef");
        }
        System.out.println(res);
        try {
            int cvp = JOptionPane.showConfirmDialog(null, "Tabloya Eklemek İstiyor musunuz?", "Ekleme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cvp == JOptionPane.YES_OPTION) {
                stmt.executeUpdate("insert into "+ tabloAdi +" ("+alan1+", adet) ("+sql+")");
                stmt.executeUpdate("delete from kelimeler_temp");
                stmt.executeUpdate("insert into "+ tabloAdi2 +" ("+alan2+", adet) ("+sql2+")");
                stmt.executeUpdate("delete from gramlar_temp");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            baglantiKapat();
        } catch (Exception ex) {
            Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String[] kelimeArr_tr = new String[50];
        String[] kelimeArr_en = new String[50];
        String[] kelimeArr_fr = new String[50];

        String sql1="SELECT kelime_tr from kelimeler_tr";
        String sql2="SELECT kelime_en from kelimeler_en limit 50";
        String sql3="SELECT kelime_fr from kelimeler_fr";

        try {
            stmt = (Statement) baglantiAc(); //veritabanına bağlanılıyor

            res = stmt.executeQuery(sql1); //tablodaki kayıtlar getiriliyor
            int i=0;
            while(res.next()){
                kelimeArr_tr[i] = res.getString("kelime_tr");
                i++;
            }

            res = stmt.executeQuery(sql2); //tablodaki kayıtlar getiriliyor
            i=0;
            while(res.next()){
                kelimeArr_en[i] = res.getString("kelime_en");
                i++;
            }

            res = stmt.executeQuery(sql3); //tablodaki kayıtlar getiriliyor
            i=0;
            while(res.next()){
                kelimeArr_fr[i] = res.getString("kelime_fr");
                i++;
            }

        } catch (Exception ex) {
            Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Malesef");
        }
        try {
            baglantiKapat();
        } catch (Exception ex) {
            Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
        }

        String ayrac=" ;,.";

        StringTokenizer st=new StringTokenizer(jTextArea1.getText(), ayrac);
        //System.out.println(st.countTokens());
        String[] sinanacakMetinArr = new String[st.countTokens()];
        int i = 0;
        while(st.hasMoreTokens()){
            sinanacakMetinArr[i] = st.nextToken().toLowerCase();
            //System.out.println(sinanacakMetinArr[i]);
            i++;
        }
        int adetTr = dizi_karsilastir(sinanacakMetinArr, kelimeArr_tr);
        int adetEn=dizi_karsilastir(sinanacakMetinArr, kelimeArr_en);
        int adetFr=dizi_karsilastir(sinanacakMetinArr, kelimeArr_fr);

        if(adetTr==0 && adetEn==0 && adetFr==0){
            JOptionPane.showMessageDialog(null, "Maalesef Dil Belirlenemedi!");
            return;
        }
        
        if(adetTr>adetEn)
        if(adetTr>adetFr)
        JOptionPane.showMessageDialog(null, "TÜRKÇE");
        else
        JOptionPane.showMessageDialog(null, "FRANSIZCA");
        else if(adetEn>adetFr)
        JOptionPane.showMessageDialog(null, "İNGİLİZCE");
        else
        JOptionPane.showMessageDialog(null, "FRANSIZCA");

    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(JOptionPane.showConfirmDialog(this, "Temp Tablosuna Ekleyecek misiniz?", "Kelime Ekleme", JOptionPane.YES_NO_OPTION)==0)
        kelime_ayir(jTextArea1.getText());

    }                                        
    
    public java.sql.Statement baglantiAc() throws Exception {
    Class.forName(driver).newInstance();
    conn = (Connection) DriverManager.getConnection(dbUrl + dbName + properties, userName, password);//bağlantı açılıyor
    return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    //return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    
}
    
    public PreparedStatement baglantiAc(String sql) throws Exception {
    try{
        Class.forName(driver).newInstance();
        conn = (Connection) DriverManager.getConnection(dbUrl+ dbName+ properties, userName, password);//bağlantı açılıyor
        //JOptionPane.showMessageDialog(null, "Bağlandı");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Bağlanamadı");
       
    }    
    return conn.prepareStatement(sql); //sorguya uygun hazır ifadeyi döndür
    }
    
    public void baglantiKapat() throws Exception {
        conn.close();
    }
    
    public void kelime_ayir(String str){

        String ayrac=" ;,.";
        String kelime;

        StringTokenizer st=new StringTokenizer(str,ayrac);
        System.out.println(st.countTokens()); 
        while(st.hasMoreTokens()){
            kelime=st.nextToken().toLowerCase();
            kelime_ekle_temp(kelime);
            System.out.println(kelime);
            gram_olustur(kelime);
        }
        
}
    
    public void gram_olustur(String str) {
        int uz, i=0;
        String gram;
        str="_"+str+"_";
        System.out.println(str);
        
        uz=str.length();
        while (i<uz-2){
            //nGrams.add(str.substring(i, i+3));
            //System.out.println("GRAM: "+nGrams);
            gram = str.substring(i, i+3);
            System.out.println(gram);
            
            i++;
           
            try {                                         

                String sql = "INSERT INTO gramlar_temp (gram) VALUES (?)";
                try {
                    PreparedStatement preStmt = baglantiAc(sql);
                    preStmt.setString(1, gram);
                    System.out.println(preStmt);                                 
                    preStmt.executeUpdate(); 

                }
                catch (Exception e) {
                    JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi", "Kelimeler", JOptionPane.PLAIN_MESSAGE);
                }
                baglantiKapat();
            }
            catch (Exception ex) {
                Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    public void kelime_ekle_temp(String kelime){
        try {                                         
            
            String sql = "INSERT INTO kelimeler_temp (kelime) VALUES (?)";
            try {
                PreparedStatement preStmt = baglantiAc(sql);
                preStmt.setString(1, kelime);
                System.out.println(preStmt); 
                //preStmt.executeQuery("SET NAMES 'latin5'");
                preStmt.executeUpdate(); //sorguyu çalıştır
                
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi", "Kelimeler", JOptionPane.PLAIN_MESSAGE);
            }
            baglantiKapat();
        }
        catch (Exception ex) {
            Logger.getLogger(Kelime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    public int dizi_karsilastir(String[] arr1, String[] arr2){
        int adet = 0;
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if(arr1[i] == null ? arr2[j] == null : arr1[i].equals(arr2[j]))
                    adet++;
            }
        }    
    return adet;
    }
    

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
            java.util.logging.Logger.getLogger(Kelime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kelime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kelime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kelime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Kelime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   


    
}
