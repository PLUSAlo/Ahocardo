/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import audio.AePlayWave;
import audio.PlayAudio;
import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alondra Guerra
 *
 */
public class Ahorcado extends javax.swing.JFrame {

    /**
     * Creates new form Ahorcado
     */
    private String[] imagenes = {"ahorcado01.png", "ahorcado02.png",
        "ahorcado03.png", "ahorcado04.png", "ahorcado05.png",
        "ahorcado06.png", "ahorcado07.png"};

    private String[] palabras = new String[20];

    private char letra;
    private int aciertos;
    private boolean[] correctas;

    //Almacena las palabras leidas desde el archivo
    private Map<String, String> listaPalabras = new HashMap<>();
    private Integer intentos = 0;// almacena el numero de intentos
    private Integer contador = 0;// cuenta las palabras de la lista
    //palabra a adivinar
    private StringBuilder palabra = new StringBuilder();

    public Ahorcado() {
        initComponents();
        centrarForma();

    }

    private void leerArchivo(File aFile) {//Metodo que sirve para leer el documento externo
        int conta = 0;

        try {
            BufferedReader input = new BufferedReader(new FileReader(aFile));
            try {
                String line = null;//se extrae linea por linea de texto
                while ((line = input.readLine()) != null) {
                    //coleccion Map (clave, valor)
                    listaPalabras.put("" + conta, line);
                    conta++;
                }
            } finally {
                input.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void loadNextWord(int indice) {//Metodo donde lee palabra por palabra

        String line = listaPalabras.get("" + indice);
        StringBuilder wordConGuion = new StringBuilder();
        //simbolo de diferencia entre palabra y descripcion
        String[] datos = line.split(":");

        palabra = new StringBuilder();

        //palabra a cargar en los controles
        for (Character car : datos[0].toUpperCase().toCharArray()) {
            palabra.append(car);
            palabra.append(" ");
            wordConGuion.append("_");//Cambia cada letra de la palabra por un guion
            wordConGuion.append(" ");//Separa cada letra con un espacio
        }

        txtDescripcion.setText(datos[1]);
        txtPalabra.setText(wordConGuion.toString());
        txtAdivinar.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btonInicio = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblIntentos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelAhorcado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblPalabra = new javax.swing.JLabel();
        txtPalabra = new javax.swing.JTextField();
        lblDescrip = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblAdivinar = new javax.swing.JLabel();
        txtAdivinar = new javax.swing.JTextField();
        lblLetras = new javax.swing.JLabel();
        txtErradas = new javax.swing.JTextField();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setResizable(false);

        setMinimumSize(new java.awt.Dimension(600, 550));
        setPreferredSize(new java.awt.Dimension(600, 550));

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Juego del Ahorcado");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, java.awt.BorderLayout.PAGE_START);

        jPanel6.setPreferredSize(new java.awt.Dimension(700, 200));
        jPanel6.setRequestFocusEnabled(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 150));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 200));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btonInicio.setBackground(new java.awt.Color(0, 102, 102));
        btonInicio.setFont(new java.awt.Font("Segoe Script", 3, 24)); // NOI18N
        btonInicio.setForeground(new java.awt.Color(0, 51, 51));
        btonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inicio_1.png"))); // NOI18N
        btonInicio.setToolTipText("");
        btonInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btonInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btonInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonInicioActionPerformed(evt);
            }
        });
        jPanel4.add(btonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, 50));

        jLabel6.setBackground(new java.awt.Color(204, 255, 255));
        jLabel6.setFont(new java.awt.Font("Old English Text MT", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Intentos");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, 40));

        lblIntentos.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblIntentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIntentos.setText("0");
        jPanel4.add(lblIntentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 90, 70));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(490, 150));

        labelAhorcado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ahorcado01.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.setDoubleBuffered(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(labelAhorcado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 212, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAhorcado, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel1);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(700, 300));
        jPanel2.setLayout(new java.awt.GridLayout(4, 2));

        lblPalabra.setBackground(new java.awt.Color(0, 51, 51));
        lblPalabra.setFont(new java.awt.Font("Sitka Subheading", 2, 36)); // NOI18N
        lblPalabra.setForeground(new java.awt.Color(0, 255, 204));
        lblPalabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPalabra.setText("Palabra");
        lblPalabra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPalabra.setOpaque(true);
        jPanel2.add(lblPalabra);

        txtPalabra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPalabra.setToolTipText("");
        jPanel2.add(txtPalabra);

        lblDescrip.setBackground(new java.awt.Color(0, 51, 51));
        lblDescrip.setFont(new java.awt.Font("Sitka Subheading", 2, 36)); // NOI18N
        lblDescrip.setForeground(new java.awt.Color(0, 255, 204));
        lblDescrip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescrip.setText("Descripcion");
        lblDescrip.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblDescrip.setOpaque(true);
        jPanel2.add(lblDescrip);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel2.add(jScrollPane1);

        lblAdivinar.setBackground(new java.awt.Color(0, 51, 51));
        lblAdivinar.setFont(new java.awt.Font("Sitka Subheading", 2, 36)); // NOI18N
        lblAdivinar.setForeground(new java.awt.Color(0, 255, 204));
        lblAdivinar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdivinar.setText("Adivinar");
        lblAdivinar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAdivinar.setOpaque(true);
        jPanel2.add(lblAdivinar);

        txtAdivinar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdivinarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdivinarKeyTyped(evt);
            }
        });
        jPanel2.add(txtAdivinar);

        lblLetras.setBackground(new java.awt.Color(0, 51, 51));
        lblLetras.setFont(new java.awt.Font("Sitka Subheading", 2, 36)); // NOI18N
        lblLetras.setForeground(new java.awt.Color(0, 255, 204));
        lblLetras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLetras.setText("Letras erradas");
        lblLetras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblLetras.setOpaque(true);
        jPanel2.add(lblLetras);
        jPanel2.add(txtErradas);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonInicioActionPerformed
        try {
            AePlayWave aw;
            URL url = PlayAudio.class.getResource("/audio/end.wav");//cambiar nombre y descargar audio del ahorcado
            aw = new AePlayWave(url);
            aw.start();
        } catch (URISyntaxException ex) {
            Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
        }

        File archivo = new File("C:\\Users\\Alondra\\Desktop\\Ahorcado\\texto.txt"); 
        leerArchivo(archivo);//para leer el archivo de texto metodo

        loadNextWord(contador);//cargar la primera palabra
        txtAdivinar.requestFocus();//posiciona el cursor sobre el componente 

        txtPalabra.setEnabled(false);//Inabilitar el txtfield de palabra
        txtDescripcion.setEnabled(false);//Inabilitar el txtfield de la descripcion
        // reiniciar();
    }//GEN-LAST:event_btonInicioActionPerformed

    private void reiniciar() {//Metodo para reiniciar el juego
        
        intentos = 0;
        txtPalabra.setEnabled(false);
        txtDescripcion.setEnabled(false);
        lblIntentos.setText(intentos.toString());
        labelAhorcado.setIcon(new ImageIcon(getClass().getResource("/images/" + imagenes[intentos])));
        txtErradas.setText("");
        
        if (contador < 4) {//Establecemos cuando se termina el juego
            loadNextWord(contador);
        } else {
        JOptionPane.showMessageDialog(null, "Juego Terminado");
        System.exit(0);
//            int YesOrNo = JOptionPane.showConfirmDialog(null, "Juego Terminado" + "\n ¿Quiere seguir jugando?", "Salir", JOptionPane.YES_NO_OPTION);
//            if (YesOrNo == 0) {
//                JOptionPane.showMessageDialog(null, "Juego Nuevo");
//                File archivo = new File("C:\\Users\\Alondra\\Desktop\\Ahorcado\\texto.txt"); 
//                leerArchivo(archivo);//para leer el archivo de texto metodo
//                
//                              
//                intentos = 0;
//                txtPalabra.setEnabled(false);
//                txtDescripcion.setEnabled(false);
//                lblIntentos.setText(intentos.toString());
//                labelAhorcado.setIcon(new ImageIcon(getClass().getResource("/images/" + imagenes[intentos])));
//                txtErradas.setText("");
//                
//               
//                                
//                
//            } else {
//                System.exit(0);
//            }

        }

       
    }

   
       

    private void txtAdivinarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdivinarKeyTyped
        char car = evt.getKeyChar();
        if(!(Character.isAlphabetic(car))){
            evt.consume();
        }else{
        String letra = "" + car;
        letra = letra.toUpperCase();
        car = letra.charAt(0);

        int pos = palabra.indexOf("" + car);

        if (pos >= 0) { // Cuando la letra es correcta
            aciertos++;

            StringBuilder word = new StringBuilder(txtPalabra.getText());
            word.replace(pos, pos + 1, "" + car);
            txtPalabra.setText(word.toString());
        
            if (verificarGano()) {
                JOptionPane.showMessageDialog(this, "!!Correcto!! "+"\nContinamos con la siguiente palabra.");
                contador++;
                reiniciar();

            }

        } else {//Cuando la letra no es correcta

            //cambiar la imagen
            lblIntentos.setText(intentos.toString());
            labelAhorcado.setIcon(new ImageIcon(getClass().getResource("/images/" + imagenes[intentos])));
            txtErradas.setText(txtErradas.getText() + car);

            if (intentos >= 6) {
                JOptionPane.showMessageDialog(this, "¡¡ESTAS AHORCADO!!" + "\n La palabra correcta es: " + palabra + "\nContinamos con la siguiente palabra." );
                reiniciar();
            }
            intentos++;

        }
        
        }

    }//GEN-LAST:event_txtAdivinarKeyTyped

    public boolean verificarGano() {//Metodo para comprobar la palabra correcta
        String palabra2 = "";

        for (int i = 0; i < palabra.length(); i++) {
            palabra2 += palabra.charAt(i);
        }
        return (txtPalabra.getText().equalsIgnoreCase(palabra2));
    }

    private void txtAdivinarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdivinarKeyReleased
        txtAdivinar.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_txtAdivinarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void centrarForma() {

        //Dimension de la pantalla ANCHO Y ALTO
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //Dimension de la ventana
        Dimension ventana = this.getSize();
        //posicion del borde superior izquierdo de la pantalla
        double posX = (pantalla.getWidth() - ventana.getWidth()) / 2.0;
        double posY = (pantalla.getHeight() - ventana.getHeight()) / 2.0;

        //Establece la posicion
        this.setLocation((int) posX, (int) posY);
    }

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
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ahorcado().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btonInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAhorcado;
    private javax.swing.JLabel lblAdivinar;
    private javax.swing.JLabel lblDescrip;
    private javax.swing.JLabel lblIntentos;
    private javax.swing.JLabel lblLetras;
    private javax.swing.JLabel lblPalabra;
    private javax.swing.JTextField txtAdivinar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtErradas;
    private javax.swing.JTextField txtPalabra;
    // End of variables declaration//GEN-END:variables

}
