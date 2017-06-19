package view;

import audio.AePlayWave;
import audio.PlayAudio;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neftali Aguilar
 * 
 */
public class AhorcadoBueno extends javax.swing.JFrame {

    /**
     * Creates new form Ahorcado
     */
    
    //Almacena las palabras leidas desde el archivo
    private Map<String, String> listaPalabras = new HashMap<>();
    private Integer intentos = 1;// almacena el numero de intentos
    private Integer contador = 0;// cuenta las palabras de la lista
    //palabra a adivinar
    private StringBuilder palabra = new StringBuilder();
    
    public AhorcadoBueno() {
        initComponents();
        centrarForma();
        
        
    }
    
    private void leerArchivo(File aFile){
        int conta = 0;
        
        try{
            BufferedReader input = new BufferedReader(new FileReader(aFile));
            try{
                String line = null;//se extrae linea por linea de texto
                while ((line = input.readLine()) != null){
                    //coleccion Map (clave, valor)
                    listaPalabras.put("" + conta,line);
                    conta++;
                }
            }  finally {
                input.close();
            } 
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void loadNextWord(int indice){
        
        String line = listaPalabras.get("" + indice);
        StringBuilder wordConGuion = new StringBuilder();
        //simbolo de diferencia entre palabra y descripcion
        String[] datos = line.split(":");
        
        //palabra a cargar en los controles
        for (Character car : datos[0].toUpperCase().toCharArray()) {
            palabra.append(car);
            palabra.append(" ");
            wordConGuion.append("_");
            wordConGuion.append(" ");
        }
        
        txtPalabra.setText(datos[1]);
        txtDescripcion.setText(wordConGuion.toString());
        txtAdivinar.setText("");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btonInicio = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelAhorcado = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblPalabra = new javax.swing.JLabel();
        txtPalabra = new javax.swing.JTextField();
        lblDescrip = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblAdivinar = new javax.swing.JLabel();
        txtAdivinar = new javax.swing.JTextField();
        lblLetras = new javax.swing.JLabel();
        txtErradas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 677));

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 550));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Old English Text MT", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Juego del Ahorcado");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        jPanel6.setPreferredSize(new java.awt.Dimension(700, 200));
        jPanel6.setRequestFocusEnabled(false);
        jPanel6.setLayout(new java.awt.GridLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 150));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 200));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btonInicio.setBackground(new java.awt.Color(0, 102, 102));
        btonInicio.setFont(new java.awt.Font("Segoe Script", 3, 24)); // NOI18N
        btonInicio.setForeground(new java.awt.Color(0, 51, 51));
        btonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inicio_1.png"))); // NOI18N
        btonInicio.setToolTipText("");
        btonInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btonInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        btonInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonInicioActionPerformed(evt);
            }
        });
        jPanel4.add(btonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 200, 50));

        jLabel6.setBackground(new java.awt.Color(204, 255, 255));
        jLabel6.setFont(new java.awt.Font("Old English Text MT", 2, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Intentos");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 150, 50));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(490, 150));

        labelAhorcado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ahorcado01.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelAhorcado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAhorcado, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel2);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel5.setPreferredSize(new java.awt.Dimension(436, 300));
        jPanel5.setLayout(new java.awt.GridLayout(4, 2));

        lblPalabra.setBackground(new java.awt.Color(0, 51, 51));
        lblPalabra.setFont(new java.awt.Font("Sitka Subheading", 2, 36)); // NOI18N
        lblPalabra.setForeground(new java.awt.Color(0, 255, 204));
        lblPalabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPalabra.setText("Palabra");
        lblPalabra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPalabra.setOpaque(true);
        lblPalabra.setPreferredSize(new java.awt.Dimension(60, 50));
        jPanel5.add(lblPalabra);

        txtPalabra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPalabra.setToolTipText("");
        jPanel5.add(txtPalabra);

        lblDescrip.setBackground(new java.awt.Color(0, 51, 51));
        lblDescrip.setFont(new java.awt.Font("Sitka Subheading", 2, 36)); // NOI18N
        lblDescrip.setForeground(new java.awt.Color(0, 255, 204));
        lblDescrip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescrip.setText("Descripcion");
        lblDescrip.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblDescrip.setOpaque(true);
        lblDescrip.setPreferredSize(new java.awt.Dimension(60, 50));
        jPanel5.add(lblDescrip);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel5.add(jScrollPane1);

        lblAdivinar.setBackground(new java.awt.Color(0, 51, 51));
        lblAdivinar.setFont(new java.awt.Font("Sitka Subheading", 2, 36)); // NOI18N
        lblAdivinar.setForeground(new java.awt.Color(0, 255, 204));
        lblAdivinar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdivinar.setText("Adivinar");
        lblAdivinar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAdivinar.setOpaque(true);
        lblAdivinar.setPreferredSize(new java.awt.Dimension(60, 50));
        jPanel5.add(lblAdivinar);
        jPanel5.add(txtAdivinar);

        lblLetras.setBackground(new java.awt.Color(0, 51, 51));
        lblLetras.setFont(new java.awt.Font("Sitka Subheading", 2, 36)); // NOI18N
        lblLetras.setForeground(new java.awt.Color(0, 255, 204));
        lblLetras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLetras.setText("Letras erradas");
        lblLetras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblLetras.setOpaque(true);
        lblLetras.setPreferredSize(new java.awt.Dimension(60, 50));
        jPanel5.add(lblLetras);
        jPanel5.add(txtErradas);

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonInicioActionPerformed
        try {
            AePlayWave aw;
            URL url = PlayAudio.class.getResource("/audio/end.wav");//cambiar nombre y descargar audio del gato
            aw = new AePlayWave(url);
            aw.start();
        } catch (URISyntaxException ex) {
            Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File archivo = new File("C:\\Users\\Alondra\\Desktop\\Ahorcado\\texto.txt");
        leerArchivo(archivo);//para leer el archivo de texto metodo
        
        loadNextWord(contador);//cargar la primera palabra
        txtAdivinar.requestFocus();//posiciona el cursor sobre el componente 
        
          txtPalabra.setEnabled(false);
          txtDescripcion.setEnabled(false);
    }//GEN-LAST:event_btonInicioActionPerformed

        private void centrarForma(){
        
        //Dimension de la pantalla ANCHO Y ALTO
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //Dimension de la ventana
        Dimension ventana = this.getSize();
        //posicion del borde superior izquierdo de la pantalla
        double posX = (pantalla.getWidth() - ventana.getWidth())/2.0;
        double posY = (pantalla.getHeight() - ventana.getHeight())/2.0;
        
        //Establece la posicion
        this.setLocation((int)posX, (int)posY);
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
            java.util.logging.Logger.getLogger(AhorcadoBueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AhorcadoBueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AhorcadoBueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AhorcadoBueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAhorcado;
    private javax.swing.JLabel lblAdivinar;
    private javax.swing.JLabel lblDescrip;
    private javax.swing.JLabel lblLetras;
    private javax.swing.JLabel lblPalabra;
    private javax.swing.JTextField txtAdivinar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtErradas;
    private javax.swing.JTextField txtPalabra;
    // End of variables declaration//GEN-END:variables
}
