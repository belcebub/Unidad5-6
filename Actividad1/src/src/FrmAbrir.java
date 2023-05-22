/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package src;

import java.io.IOException;
import javax.swing.JOptionPane;
import static src.FrmPrincipal.aat;

/**
 *
 * @author beelze
 */
public class FrmAbrir extends javax.swing.JDialog {

    String nombreArchivo;
    /**
     * Creates new form FrmAbrir
     */
    public FrmAbrir(java.awt.Frame parent, boolean modal, String nombreArchivo) {
        super(parent, modal);
        this.nombreArchivo = nombreArchivo;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        opcGuardar = new javax.swing.JMenuItem();
        opcGuardarComo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ABRIR ARCHIVO DE TEXTO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        mnuArchivo.setText("Archivo");

        opcGuardar.setText("Guardar");
        opcGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcGuardarActionPerformed(evt);
            }
        });
        mnuArchivo.add(opcGuardar);

        opcGuardarComo.setText("Guardar como");
        mnuArchivo.add(opcGuardarComo);

        jMenuBar1.add(mnuArchivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String texto;
        
        try {
            texto = aat.leerArchivo(nombreArchivo);
            txtTexto.setText(texto);
        }  catch (IOException ioe) {
            JOptionPane.showMessageDialog(this,
                    ioe.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                aat.cerrarArchivoLectura();
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(this,
                        ioe.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }      
    }//GEN-LAST:event_formWindowOpened

    private void opcGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcGuardarActionPerformed
        try {
            aat.guardarArchivo(nombreArchivo, txtTexto.getText());
            JOptionPane.showMessageDialog(this, 
                    "Archivo " + nombreArchivo + " guardado con éxito", 
                    "Aviso", 
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(this,
                    ioe.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                aat.cerrarArchivoEscritura();
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(this,
                        ioe.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_opcGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenuItem opcGuardar;
    private javax.swing.JMenuItem opcGuardarComo;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}