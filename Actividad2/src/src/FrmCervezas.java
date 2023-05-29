/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Geraf
 */
public class FrmCervezas extends javax.swing.JFrame {
    
    public static Archivo a = new Archivo();
    /**
     * Creates new form FrmCervezas
     */
    public FrmCervezas() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opcAyuda = new javax.swing.JMenuItem();
        opcAcercaDe = new javax.swing.JMenuItem();
        opcSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        opcAltas = new javax.swing.JMenuItem();
        opcConsInd = new javax.swing.JMenuItem();
        opcConsGral = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 51));

        jMenu1.setBackground(new java.awt.Color(0, 51, 51));
        jMenu1.setText("Sistema");

        opcAyuda.setText("Ayuda");
        jMenu1.add(opcAyuda);

        opcAcercaDe.setText("Acerca de...");
        opcAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAcercaDeActionPerformed(evt);
            }
        });
        jMenu1.add(opcAcercaDe);

        opcSalir.setText("Salir");
        opcSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcSalirActionPerformed(evt);
            }
        });
        jMenu1.add(opcSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(0, 153, 153));
        jMenu2.setText("Cervezas");

        opcAltas.setText("Altas");
        opcAltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAltasActionPerformed(evt);
            }
        });
        jMenu2.add(opcAltas);

        opcConsInd.setText("Consulta individual");
        opcConsInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcConsIndActionPerformed(evt);
            }
        });
        jMenu2.add(opcConsInd);

        opcConsGral.setText("Consulta general");
        jMenu2.add(opcConsGral);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_opcSalirActionPerformed

    private void opcAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAcercaDeActionPerformed
        JOptionPane.showMessageDialog(this,
                "Sistema: CERVECERIA LA BUENA CRUDA\n" + 
                        "version 1.0\n" +
                        "Programadores:\n"+ 
                        "  Joseph Abraham Duran Vargas\n" +
                        "  Luis Gerardo Esteban Flores\n" +
                        "  Alejandro Jesus Damian Rodriguez\n" +
                        "Fecha: 15 de Mayo del 2023", 
                "Acerca de...", 
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_opcAcercaDeActionPerformed

    private void opcAltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAltasActionPerformed
        new FrmAlta(this, true).setVisible(true);
    }//GEN-LAST:event_opcAltasActionPerformed

    private void opcConsIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcConsIndActionPerformed
        int clave;
        String claveTexto;
        
        claveTexto = JOptionPane.showInputDialog(this,
                "Clave a consultar",
                "Ingresar Clave",
                JOptionPane.QUESTION_MESSAGE);
        if (claveTexto != null) {
            clave = Integer.parseInt(claveTexto);
            boolean num = a.busqueda(clave);
            if (num != false) {
                new FrmConsultaIndividual(this, true, clave).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(
                this, 
                "No existe ninguna producto con esa clave",
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_opcConsIndActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCervezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCervezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCervezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCervezas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCervezas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem opcAcercaDe;
    private javax.swing.JMenuItem opcAltas;
    private javax.swing.JMenuItem opcAyuda;
    private javax.swing.JMenuItem opcConsGral;
    private javax.swing.JMenuItem opcConsInd;
    private javax.swing.JMenuItem opcSalir;
    // End of variables declaration//GEN-END:variables
}
