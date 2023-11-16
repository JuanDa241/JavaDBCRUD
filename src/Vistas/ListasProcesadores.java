/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Entidades.Procesador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DB.ProcesadorDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListasProcesadores extends javax.swing.JFrame {
        ArrayList<Procesador> proc= null;
    /**
     * Creates new form ListasProcesadores
     */
    public ListasProcesadores() {
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

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproce = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblproce.setAutoCreateRowSorter(true);
        tblproce.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Fabricante", "Gama", "Frecuencia", "Nucleos", "GPU", "Construccion NM", "Generacion Redes"
            }
        ));
        jScrollPane1.setViewportView(tblproce);

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar))
                .addContainerGap(347, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int indice = tblproce.getSelectedRow();
         ProcesadorDAO pdao = new ProcesadorDAO();
        Procesador procesa = this.proc.get(indice);

        try{
            int resp= JOptionPane.showConfirmDialog(this, "se eliminara el procesador "+procesa.getNombre()+""+procesa.getFabricante()+"¿Esta seguro?");
            if(resp == JOptionPane.YES_OPTION){
                if(pdao.eliminarProcesador(procesa.getNombre())){
                    JOptionPane.showMessageDialog(this, "Se elimino correctamente el procesador");
                }else {
                    JOptionPane.showMessageDialog(this, "Se presento un error al eliminar");

                }
            }else if(resp == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(this, "No se elimino el procesador");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        this.listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(ListasProcesadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListasProcesadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListasProcesadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListasProcesadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListasProcesadores().setVisible(true);
            }
        });
    }
    
    private void listar(){
        ProcesadorDAO pdao = new ProcesadorDAO();
       
        try{
            if(txtBuscar.getText().isEmpty()){
                proc= pdao.listadoProcesadores();
            }else{
                proc = pdao.buscarPorNombre(txtBuscar.getText());
                if(proc.size() == 0){
                    JOptionPane.showMessageDialog(this,"El nombre del procesador no existe o esta mal escrito");
                }
            }
            
            
            DefaultTableModel modelo = new  DefaultTableModel();
            modelo.addColumn("NOMBRE");
            modelo.addColumn("FABRICANTE");
            modelo.addColumn("GAMA");
            modelo.addColumn("FRECUENCIA");
            modelo.addColumn("GPU");
            modelo.addColumn("CONSTRUCCION_PROCESO_NM");
            modelo.addColumn("GENERACION_TECNOLOGICA_REDES");
            
            for (Procesador procesador : proc){
                String[] fila = new String [7];//cada fila que se agregue esta va a contener 7 columnas
                fila[0] = procesador.getNombre();
                fila[1] = procesador.getFabricante();
                fila[2] = procesador.getGama();
                fila[3] = procesador.getFrecuencia();
                fila[4] = procesador.getGpu();
                fila[5] = procesador.getConstruccion_proceso_nanometros();
                fila[6] = procesador.getGeneracion_tecnologica_redes();
                
                modelo.addRow(fila);
                tblproce.setModel(modelo);// a la tabla de la vista le paso la informacion que se acabo de crear con el metodo.
            }
                
        }catch (Exception e){
         System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblproce;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
