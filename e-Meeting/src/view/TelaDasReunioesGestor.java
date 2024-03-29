/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConexaoSQLite;
import dao.GestorRecursosDao;
import dao.ReuniaoDao;
import dao.UsuarioDao;
import javax.swing.table.DefaultTableModel;
import model.Reuniao;
import model.Usuario;

/**
 *
 * @author Paulo
 */
public class TelaDasReunioesGestor extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaDasReunioesGestor
     */
    public TelaDasReunioesGestor() {
        initComponents();
        alimentarTabela();
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
        tbReunioesGestor = new javax.swing.JTable();
        btnConfirmaReuniao = new javax.swing.JButton();

        setBackground(new java.awt.Color(230, 240, 240));
        setClosable(true);
        setResizable(true);

        tbReunioesGestor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Descrição", "Data", "Hora Inicio", "Hora Fim", "Proprietario", "Sala"
            }
        ));
        jScrollPane1.setViewportView(tbReunioesGestor);

        btnConfirmaReuniao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirmaReuniao.setText("Confirmar");
        btnConfirmaReuniao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaReuniaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(btnConfirmaReuniao, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmaReuniao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmaReuniaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaReuniaoActionPerformed
        
       DefaultTableModel tbGr = (DefaultTableModel) tbReunioesGestor.getModel();
       ConexaoSQLite connection = new ConexaoSQLite();
       GestorRecursosDao grDao = new GestorRecursosDao(connection);
       ReuniaoDao rd = new ReuniaoDao(connection);
       connection.conectar();
       rd.inserirReuniao(grDao.gerarNConfirmadas(tbGr.getValueAt(tbReunioesGestor.getSelectedRow(), 0).toString()));
       connection.conectar();
       grDao.deleteConf(tbGr.getValueAt(tbReunioesGestor.getSelectedRow(), 0).toString());
       tbGr.getValueAt(tbReunioesGestor.getSelectedRow(), 0);
       btnConfirmaReuniao.setText(tbGr.getValueAt(tbReunioesGestor.getSelectedRow(), 0).toString());
       tbGr.removeRow(tbReunioesGestor.getSelectedRow());
        
        
    }//GEN-LAST:event_btnConfirmaReuniaoActionPerformed

    public void alimentarTabela() {

        DefaultTableModel tbGr = (DefaultTableModel) tbReunioesGestor.getModel();
        tbGr.setNumRows(0);
        ConexaoSQLite connection = new ConexaoSQLite();
        GestorRecursosDao grDao = new GestorRecursosDao(connection);

        for (Reuniao r : grDao.listarTodasReunioesGestorR()) {
            
            System.out.println(r);
            
            tbGr.addRow(new Object[]{
                r.getId(),
                r.getDescricao(),
                r.getDataReuniao(),
                r.getHorarioInicio(),
                r.getHorarioFim(),
                r.getProprietario(),
                r.getLocal()
                
            });

        }

    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmaReuniao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbReunioesGestor;
    // End of variables declaration//GEN-END:variables
}
