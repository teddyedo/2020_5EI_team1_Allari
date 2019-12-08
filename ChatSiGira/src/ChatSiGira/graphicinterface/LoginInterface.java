/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSiGira.graphicinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Allari Edoardo
 * 
 */

public class LoginInterface extends javax.swing.JFrame {

    /**
     * Creates new form LoginInterface
     */
    public LoginInterface() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color (0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BackgroundWhite = new javax.swing.JPanel();
        SignInLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        ErrorLabel = new javax.swing.JLabel();
        TextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        UserLabel1 = new javax.swing.JLabel();
        ChatSiGiraLabel = new javax.swing.JLabel();
        UserIconLabel = new javax.swing.JLabel();
        BackgroundPaper = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackgroundWhite.setBackground(new java.awt.Color(255, 255, 255));
        BackgroundWhite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SignInLabel.setFont(new java.awt.Font("Product Sans", 1, 24)); // NOI18N
        SignInLabel.setForeground(new java.awt.Color(0, 0, 0));
        SignInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignInLabel.setText("SIGN IN");
        BackgroundWhite.add(SignInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 100, 30));

        LoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button.png"))); // NOI18N
        LoginButton.setToolTipText("");
        LoginButton.setBorder(null);
        LoginButton.setContentAreaFilled(false);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        BackgroundWhite.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 300, 70));

        ErrorLabel.setForeground(new java.awt.Color(0, 0, 0));
        ErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundWhite.add(ErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 300, -1));

        TextField.setBackground(new java.awt.Color(255, 255, 255));
        TextField.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        TextField.setBorder(null);
        TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldActionPerformed(evt);
            }
        });
        BackgroundWhite.add(TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 220, 30));
        BackgroundWhite.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 200, 10));

        UserLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        UserLabel1.setForeground(new java.awt.Color(0, 0, 0));
        UserLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLabel1.setText("Username");
        BackgroundWhite.add(UserLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 80, 60));

        ChatSiGiraLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icona_1.png"))); // NOI18N
        BackgroundWhite.add(ChatSiGiraLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        UserIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_user_male_circle_60px_1.png"))); // NOI18N
        BackgroundWhite.add(UserIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        BackgroundPaper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DesignPNG .png"))); // NOI18N
        BackgroundWhite.add(BackgroundPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(BackgroundWhite, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundPaper;
    private javax.swing.JPanel BackgroundWhite;
    private javax.swing.JLabel ChatSiGiraLabel;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel SignInLabel;
    private javax.swing.JTextField TextField;
    private javax.swing.JLabel UserIconLabel;
    private javax.swing.JLabel UserLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
