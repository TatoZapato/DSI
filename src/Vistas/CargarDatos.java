/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Utilidades.Inventario.ArbolRaleo;
import Utilidades.Inventario.Inventario;
import Utilidades.Inventario.ParametroGeneral;
import Utilidades.Inventario.ParametroParcela;
import Utilidades.Inventario.TablaRodal;
import Utilidades.Persistencia.DAO.BancoDatos.BancoDatosDAO;
import Utilidades.Persistencia.DAO.FuncionDAO;
import Utilidades.Persistencia.DAO.ModeloDAO;
import Utilidades.Persistencia.DAO.ParametroGeneralDAO;
import Utilidades.Persistencia.DAO.ParametroParcelaDAO;
import Utilidades.Persistencia.DAO.TablaRodalDAO;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.ProcesamientoInventario;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Führer
 */
public class CargarDatos extends javax.swing.JFrame {

    private Inventario inventarioActual;
    private static LinkedList<Inventario> misInventarios;
    private DetalleCarga detalle;

    /**
     * Creates new form CargarDatos
     */
    public CargarDatos() {
        initComponents();
    }

    public CargarDatos(LinkedList<Inventario> inventarios) {
        initComponents();
        misInventarios = inventarios;
        llenarTablaInventarios(misInventarios);
    }

    public static void llenarTablaInventarios(LinkedList<Inventario> lista) {
        misInventarios = lista;
        String[][] arr = new String[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            arr[i][0] = lista.get(i).getOrdenTrabajo() + "";
            arr[i][1] = lista.get(i).getFundo();
            arr[i][2] = lista.get(i).getRodal();
            arr[i][3] = lista.get(i).getParcela() + "";
            arr[i][4] = lista.get(i).getEstado();
            arr[i][5] = lista.get(i).getTipoInventario() + "";
        }
        TablaDatosInventario.setModel(new javax.swing.table.DefaultTableModel(
                arr,
                new String[]{
                    "Num. Orden", "Fundo", "Rodal", "Parcela", "Estado", "Tipo Inv."
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TablaDatosInventario.getColumn("Num. Orden").setMaxWidth(120);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosInventario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxVolumen = new javax.swing.JComboBox();
        ComboBoxAltura = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        btnDealle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cargar Datos de Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 3, 24))); // NOI18N

        TablaDatosInventario.setAutoCreateRowSorter(true);
        TablaDatosInventario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TablaDatosInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaDatosInventario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaDatosInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosInventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatosInventario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calculo de Valores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 3, 20))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Función Volumen:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Modelo Altura:");

        ComboBoxVolumen.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ComboBoxVolumen.setModel(new javax.swing.DefaultComboBoxModel(FuncionDAO.obtenerTodosLasFuncionesArray()));

        ComboBoxAltura.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ComboBoxAltura.setModel(new javax.swing.DefaultComboBoxModel(ModeloDAO.obtenerTodosLosModelosArray()));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboBoxVolumen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxAltura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboBoxVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCargar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.setEnabled(false);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnDealle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDealle.setText("Ver Detalle");
        btnDealle.setEnabled(false);
        btnDealle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDealleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDealle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDealle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaDatosInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosInventarioMouseClicked
        //inventarioActual = misInventarios.get(TablaDatosInventario.getSelectedRow());
        btnDealle.setEnabled(true);
        btnCargar.setEnabled(true);
    }//GEN-LAST:event_TablaDatosInventarioMouseClicked

    private void btnDealleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDealleActionPerformed
         inventarioActual = misInventarios.get(TablaDatosInventario.getSelectedRow());
        detalle = new DetalleCarga(inventarioActual);
        detalle.setLocationRelativeTo(null);
        detalle.setVisible(true);
    }//GEN-LAST:event_btnDealleActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        
        System.out.println(misInventarios.get(TablaDatosInventario.getSelectedRow()).getOrdenTrabajo());
        inventarioActual = misInventarios.get(TablaDatosInventario.getSelectedRow());
        if (inventarioActual == null || ComboBoxVolumen.getSelectedItem().equals("") || ComboBoxAltura.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar:\n-Modelo de Altura\n-Función de Volumen\n-Inventario", "Advertencia", 1);
        } else {
            String modeloAltura = ComboBoxAltura.getSelectedItem().toString(), funcionVolumen = ComboBoxVolumen.getSelectedItem().toString();
            LinkedList<ArbolRaleo> arboles = new LinkedList();
            try {
                arboles = BancoDatosDAO.obtenerTodosLosArbolRaleoSeleccionados(inventarioActual);
                if (arboles.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "No hay datos en la Base de Datos sobre Arboles de Raleo", "Advertencia", 1);
                }
                //System.out.println("PASO ARBOLES : "+arboles.size());
                ParametroGeneral parametroG = ProcesamientoInventario.obtenerParametroGeneral(inventarioActual, arboles, modeloAltura, funcionVolumen);

                TablaRodal tablaR = ProcesamientoInventario.obtenerTablaRodal(parametroG, inventarioActual, modeloAltura, funcionVolumen);

                ParametroParcela parametroP = ProcesamientoInventario.obtenerParametroParcela(parametroG, inventarioActual, funcionVolumen);
                
                System.out.println("Parcela: "+parametroP);
                parametroG.toString();
                try {
                    //Reportes
                    ParametroGeneralDAO.insertarParametroGeneral(parametroG);
                    System.out.println("Parametro General Listo");
                    System.out.println(tablaR.getEspecie());
                    TablaRodalDAO.insertarTablaRodal(tablaR);
                    System.out.println("2");
                    ParametroParcelaDAO.insertarParametroParcela(parametroP);
                    System.out.println("3");
                    //Parametro General
                } catch (SQLException sql) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el Parametro General", "Información", 1);
                }
                JOptionPane.showMessageDialog(this, "Se ha cargado con éxito", "Información", 1);

            } catch (DAOException ex) {
                if(ex.getError() == 0) {
                    JOptionPane.showMessageDialog(this, "No existen Arboles Raleo asociados", "Información", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al recuperar los Arboles Raleo", "Información", 1);
                    System.err.println(ex.getLocalizedMessage());
                }
            }

        }
    }//GEN-LAST:event_btnCargarActionPerformed

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
            java.util.logging.Logger.getLogger(CargarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxAltura;
    private javax.swing.JComboBox ComboBoxVolumen;
    private static javax.swing.JTable TablaDatosInventario;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnDealle;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
