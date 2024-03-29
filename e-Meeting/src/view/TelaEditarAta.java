/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConexaoSQLite;
import dao.ReuniaoDao;
import javax.swing.table.DefaultTableModel;
import model.Reuniao;

/**
 *
 * @author Paulo
 */
public class TelaEditarAta extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaEditarAta
     */
    public TelaEditarAta() {
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
        tbReunioesAta = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAta = new javax.swing.JTextArea();

        setClosable(true);
        setResizable(true);
        setTitle("Editar Descrição");

        tbReunioesAta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Descrição", "Data", "Hora Inicio", "Hora Fim", "Proprietario", "Sala"
            }
        ));
        tbReunioesAta.setUpdateSelectionOnSort(false);
        tbReunioesAta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbReunioesAtaFocusGained(evt);
            }
        });
        tbReunioesAta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbReunioesAtaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbReunioesAtaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbReunioesAta);

        btnEditar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        taAta.setColumns(20);
        taAta.setRows(5);
        jScrollPane2.setViewportView(taAta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(140, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbReunioesAtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReunioesAtaMouseClicked
    }//GEN-LAST:event_tbReunioesAtaMouseClicked

    private void tbReunioesAtaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbReunioesAtaFocusGained
    }//GEN-LAST:event_tbReunioesAtaFocusGained

    private void tbReunioesAtaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReunioesAtaMouseReleased
        taAta.setText(tbReunioesAta.getValueAt(tbReunioesAta.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tbReunioesAtaMouseReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        ConexaoSQLite connection = new ConexaoSQLite();
        ReuniaoDao rd = new ReuniaoDao(connection);
        Reuniao r = rd.gerarAtaDownload(tbReunioesAta.getValueAt(tbReunioesAta.getSelectedRow(), 0).toString());
        r.setDescricao(taAta.getText());
        connection.conectar();
        rd.atualizarAta(r);
        alimentarTabela();
    }//GEN-LAST:event_btnEditarActionPerformed
    
     public void alimentarTabela() {

        DefaultTableModel tbRc = (DefaultTableModel) tbReunioesAta.getModel();
        tbRc.setNumRows(0);
        ConexaoSQLite connection = new ConexaoSQLite();
        ReuniaoDao rd = new ReuniaoDao(connection);

        for (Reuniao r : rd.listarTodasReunioes()) {
            
            System.out.println(r);
            
            tbRc.addRow(new Object[]{
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taAta;
    private javax.swing.JTable tbReunioesAta;
    // End of variables declaration//GEN-END:variables
}
