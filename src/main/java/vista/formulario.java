/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


//librerias 
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.*;


//se manda a llamar la clase que generamos en el paquete conexion
import conexion.conexion;
import javax.swing.JOptionPane;
public class formulario extends javax.swing.JFrame {
    
    
     conexion cn = new conexion();

    Connection con;

    Statement st;

    ResultSet rs;

    int id = 0;

    /**
     * Creates new form formulario
     */
    public formulario() {
        initComponents();
    }
    
    
 //metodo  para alta de registros
    public void altaUsuarios() {

      
       
     

        String productoNombre = this.txtProducto.getText(); //guarda producto

        
        
        int precioProducto =  Integer.parseInt(txtPrecio.getText()); //Guarda el valor de el precio
        
        
        int cantidadProducto = Integer.parseInt(txtCantidad.getText()); //Guarda la cantidad del prducto 
        
      
        

        try {
            
            if ( (productoNombre.equals("")) ) {//inicia if
                
                JOptionPane.showMessageDialog(rootPane, "Debe ingresar datos");
                
            } else {
                        
                
                  
        float descuento; //se delcara variable descuento
                float precioFinal = 0;
        
        
        
        //if else para calcular el descuento de acuero a la cantidad de piezas llevadas
        if(cantidadProducto <= 50){
        
                    precioProducto = precioProducto * cantidadProducto;

         descuento = (int) (precioProducto *.05);
         
          precioFinal = precioProducto- descuento ;
          String sqlAlta = "Insert INTO venta (producto,precio,cantidad,importe_final) values ('"+productoNombre+"', '"+precioProducto+"','"+cantidadProducto+"','"+precioFinal+"' )"; //variable objeto que lleva una instruccion de base de datos
               
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sqlAlta);
                
                  
        String percioString= String.valueOf(precioProducto);
        String PreciofinalString = Float.toString(precioFinal);
        
                
              
                 txtVendido.setText(productoNombre);
                 txtimporteInicial.setText(percioString);
                 txtDescuento.setText("5%");
                 txtimporteFinal.setText(PreciofinalString);
                
         
        }else if (cantidadProducto >=51  && cantidadProducto <100 ){
                            precioProducto = precioProducto * cantidadProducto;

        descuento = (int) (precioProducto *0.10);
        
                 precioFinal = precioProducto- descuento ;

         String sqlAlta = "Insert INTO venta (producto,precio,cantidad,importe_final) values ('"+productoNombre+"', '"+precioProducto+"','"+cantidadProducto+"','"+precioFinal+"' )"; //variable objeto que lleva una instruccion de base de datos
               
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sqlAlta);
                  
        String percioString= String.valueOf(precioProducto);
        String PreciofinalString = Float.toString(precioFinal);
        
                
              
                 txtVendido.setText(productoNombre);
                 txtimporteInicial.setText(percioString);
                 txtDescuento.setText("10%");
                 txtimporteFinal.setText(PreciofinalString);
                
        
        }else if (cantidadProducto >= 101){
                                precioProducto = precioProducto * cantidadProducto;

       
        descuento = (int) (precioProducto *0.20);
        
                 precioFinal = precioProducto- descuento;
                 
                 
                String sqlAlta = "Insert INTO venta (producto,precio,cantidad,importe_final) values ('"+productoNombre+"', '"+precioProducto+"','"+cantidadProducto+"','"+precioFinal+"' )"; //variable objeto que lleva una instruccion de base de datos
               
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sqlAlta);
                
                
                  
        String percioString= String.valueOf(precioProducto);
        String PreciofinalString = Float.toString(precioFinal);
        
                
              
                 txtVendido.setText(productoNombre);
                 txtimporteInicial.setText(percioString);
                 txtDescuento.setText("20%");
                 txtimporteFinal.setText(PreciofinalString);

        }
        
      
                
                
            }//termina else

        } catch (Exception e) { //inicia catch 2
            
            JOptionPane.showMessageDialog(null, "error base de datos\n " +e);

        }//termina catch 2

    }//termina try 2 

    
    //inicia metodo limpiar 
    public void Limpiar() {

        txtProducto.setText(null);
        txtPrecio.setText(null);
        txtCantidad.setText(null);
        txtVendido.setText(null);
        txtimporteInicial.setText(null);
        txtDescuento.setText(null);
        txtimporteFinal.setText(null);
                
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblprecio = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblvendido = new javax.swing.JLabel();
        txtimporteFinal = new javax.swing.JTextField();
        lblimporte = new javax.swing.JLabel();
        txtVendido = new javax.swing.JTextField();
        lblimporte1 = new javax.swing.JLabel();
        txtimporteInicial = new javax.swing.JTextField();
        lblimporte2 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Producto");

        lblprecio.setText("Precio");

        lblCantidad.setText("Cantidad");

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblvendido.setText("Producto Vendido");

        lblimporte.setText("Importe inicial");

        txtVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendidoActionPerformed(evt);
            }
        });

        lblimporte1.setText("Descuento");

        lblimporte2.setText("importe final");

        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblprecio)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCantidad)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnMostrar)
                        .addGap(26, 26, 26)
                        .addComponent(btnNuevo)
                        .addGap(33, 33, 33)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblvendido)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblimporte)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtimporteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVendido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblimporte2)
                            .addComponent(lblimporte1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtimporteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblprecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidad)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrar)
                            .addComponent(btnNuevo)
                            .addComponent(btnCerrar))
                        .addGap(36, 36, 36)
                        .addComponent(lblvendido))
                    .addComponent(txtVendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblimporte)
                    .addComponent(txtimporteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblimporte1)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblimporte2)
                    .addComponent(txtimporteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendidoActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        
        altaUsuarios();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        Limpiar();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);// cierra ventana
    }//GEN-LAST:event_btnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblimporte;
    private javax.swing.JLabel lblimporte1;
    private javax.swing.JLabel lblimporte2;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lblvendido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtVendido;
    private javax.swing.JTextField txtimporteFinal;
    private javax.swing.JTextField txtimporteInicial;
    // End of variables declaration//GEN-END:variables
}
