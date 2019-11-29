/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConexaoSQLite;
import dao.SalaDao;
import model.Sala;

/**
 *
 * @author Paulo
 */
public class TelaDoGestor extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public TelaDoGestor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpGestorR = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmCadastro = new javax.swing.JMenu();
        miConfirmarReuniao = new javax.swing.JMenuItem();
        miCriarSala = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miLogoff = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dpGestorRLayout = new javax.swing.GroupLayout(dpGestorR);
        dpGestorR.setLayout(dpGestorRLayout);
        dpGestorRLayout.setHorizontalGroup(
            dpGestorRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dpGestorRLayout.setVerticalGroup(
            dpGestorRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jmCadastro.setText("Cadastro");

        miConfirmarReuniao.setText("Confirmar Reuniao");
        miConfirmarReuniao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConfirmarReuniaoActionPerformed(evt);
            }
        });
        jmCadastro.add(miConfirmarReuniao);

        miCriarSala.setText("Criar Sala");
        miCriarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCriarSalaActionPerformed(evt);
            }
        });
        jmCadastro.add(miCriarSala);

        jMenuBar1.add(jmCadastro);

        jMenu2.setText("Sair");

        miLogoff.setText("Logoff");
        miLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoffActionPerformed(evt);
            }
        });
        jMenu2.add(miLogoff);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpGestorR)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpGestorR)
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miCriarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCriarSalaActionPerformed
        
        
        TelaCadastroSala tS = new TelaCadastroSala();
        dpGestorR.add(tS);
        tS.setVisible(true);
        
        
    }//GEN-LAST:event_miCriarSalaActionPerformed

    private void miConfirmarReuniaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConfirmarReuniaoActionPerformed
        
        TelaDasReunioesGestor tgr = new TelaDasReunioesGestor();
        dpGestorR.add(tgr);
        tgr.setVisible(true);
        
    }//GEN-LAST:event_miConfirmarReuniaoActionPerformed

    private void miLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoffActionPerformed
        TelaInicial ti = new TelaInicial();
        ti.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_miLogoffActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDoGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDoGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDoGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDoGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDoGestor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpGestorR;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmCadastro;
    private javax.swing.JMenuItem miConfirmarReuniao;
    private javax.swing.JMenuItem miCriarSala;
    private javax.swing.JMenuItem miLogoff;
    // End of variables declaration//GEN-END:variables
}
