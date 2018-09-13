
package ox_project;

import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

public class F_register extends javax.swing.JFrame {

    /**
     * Creates new form F_register
     */
    public F_register() {
        initComponents();
    }

    // เอาไว้เช็คไอดีซ้ำ
    public static boolean booleancheckID = false;
    
    public void submitRegister(){
        
        MongoClientURI uri  = new MongoClientURI("mongodb://admin:abc123456@ds237922.mlab.com:37922/ox_59160117");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
      
        MongoCollection<Document> user = db.getCollection("user");
        
        List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("ID",tx_id.getText())
                .append("Pass", tx_pass.getText())
                .append("Name", tx_Name.getText())
               
        );
        user.insertMany(seedData);
            JLabel label = new JLabel("สมัครเรียบร้อย");
            label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label);
        
        client.close(); 
    }
    
    public boolean checkrepass(){
        if(tx_pass.getText().equals(tx_repass.getText())){
            System.out.println("ซ้ำ");
            return true;
        }else {
            return false;
        }
    }
    
    public void checkID(){
        
        MongoClientURI uri  = new MongoClientURI("mongodb://admin:abc123456@ds237922.mlab.com:37922/ox_59160117");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        
        MongoCollection<Document> user = db.getCollection("user");
       
        try {
            
            Document myDoc = user.find(eq("ID", tx_id.getText())).first();
            System.out.println(myDoc.toJson());
            booleancheckID = true;
            
        } catch (Exception e) {
            System.out.println("ดักว่าไอดีไม่ซ้ำ");
            //ดักไอดีซ้ำและคืนค่า Boolean
            booleancheckID = false;
        }      
    }
    public boolean checkEmpty(){
        if(tx_id.getText().equals("")||tx_pass.getText().equals("")||tx_Name.getText().equals("")){
           
            return true;
        }else {
            return false;
        }     
    }
    
    public void reset(){
        tx_Name.setText("");
        tx_id.setText("");
        tx_pass.setText("");
        tx_repass.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        btn_summit = new keeptoo.KButton();
        tx_id = new javax.swing.JTextField();
        tx_Name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tx_pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tx_repass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_summit.setText("Register");
        btn_summit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_summitActionPerformed(evt);
            }
        });

        tx_id.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        tx_Name.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel1.setText("User :");

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel2.setText("Pass :");

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel3.setText("Name :");

        tx_pass.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel4.setText("ConfirmPass :");

        tx_repass.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_summit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tx_repass, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(tx_pass)
                            .addComponent(tx_id)
                            .addComponent(tx_Name))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tx_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_repass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(76, 76, 76)
                .addComponent(btn_summit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_summitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_summitActionPerformed
        // TODO add your handling code here:
        checkrepass();  
        checkID();
        checkEmpty();
        checkrepass();       
        if(booleancheckID){
            JLabel label = new JLabel("มีไอดีนี้อยู่ในระบบแล้ว");
            label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
           
            reset();
        }else{
            if(checkEmpty()){
                JLabel label = new JLabel("กรุณากรอกข้อมูลให้ครบถ้วน");
                label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                reset();
             
            }else if(!checkEmpty()){
            if(!checkrepass()){
                JLabel label = new JLabel("Password ไม่ตรงกัน");
                label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                reset();
            }
            else{
                submitRegister();
                reset();
            }
             
            }
        }       
    }//GEN-LAST:event_btn_summitActionPerformed

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
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btn_summit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField tx_Name;
    private javax.swing.JTextField tx_id;
    private javax.swing.JPasswordField tx_pass;
    private javax.swing.JPasswordField tx_repass;
    // End of variables declaration//GEN-END:variables
}
