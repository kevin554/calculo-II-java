package grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBienvenida extends JPanel {

    private JLabel lbBienvenida;
    
    public PanelBienvenida() {
        init();
    }
    
    private void init() {
        lbBienvenida = new JLabel("Bienvenido");
        
        // CONFIGURAMOS EL PANEL
        this.setBackground(Color.white);
        this.setLayout(null);
        this.add(lbBienvenida);
        
        //CONFIGURAMOS LA BIENVENIDA        
        Font fuente = new Font("Segoe Print", 2, 34);
        leerFichero();
        lbBienvenida.setFont(fuente);
        lbBienvenida.setBounds(0, 0, 335, 220);  
    }

    public void leerFichero() {
        String archivo = "Nombre de Usuario.txt";
        
        try (BufferedReader in = new BufferedReader(new FileReader(archivo))) {
            String nombre = in.readLine();
            
            if (nombre != null)
                lbBienvenida.setText("Bienvenido " + nombre);
        } catch (java.io.IOException ex) {
            /* TODO-CODE here */
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(355, 220);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public JLabel getLbBienvenida() {
        return lbBienvenida;
    }

    public void setLbBienvenida(JLabel lbBienvenida) {
        this.lbBienvenida = lbBienvenida;
    }
    // </editor-fold>
}