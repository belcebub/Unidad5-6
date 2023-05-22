/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package src;

import javax.swing.JFileChooser;

/**
 *
 * @author Belzee
 */
public class FrmNuevo extends javax.swing.JDialog {

    /**
     * Creates new form FrmNuevo
     */
    public FrmNuevo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVO ARCHIVO DE TEXTO");

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

        jMenuBar1.add(mnuArchivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opcGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcGuardarActionPerformed
        String nombreArchivo;
        int opc;
        JFileChooser dlgGuardar = new JFileChooser();
        
        try {
            dlgGuardar.setFileSelectionMode(JFileChooser.FILES_ONLY);
            dlgGuardar.addChoosableFileFilter(new FiltroTxt());
            opc = dlgGuardar.showSaveDialog(this);
            if(opc == JFileChooser.APPROVE_OPTION) {
                nombreArchivo = dlgGuardar.getSelectedFile().getPath() + ".txt";
                if(!aat.existeArchivo(nombreArchivo)) {
                    aat.guardarArchivo(nombreArchivo, txtTexto.getText());
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_opcGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenuItem opcGuardar;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
