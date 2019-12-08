package grafica.formulario;

import grafica.Ventana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logica.ecuaciones.Ecuacion;

/**
 * Panel Abstracto que implementa los listeners necesarios para la accion de los
 * botones y la interfaz Formulario
 */
public abstract class Formulario extends JPanel implements KeyListener, IFormulario{

    /**
     * Etiqueta para notificarle al usuario que los campos de texto sólo admiten 
     * números
     */
    protected JLabel lbAdvertencia;
    protected JButton btnDespejar;
    protected JButton btnVerGrafica;
    
    protected DecimalFormat formato;
    protected Ecuacion punto;
    
    protected Ventana laVentana;

    public Formulario() {
        init();
    }

    public Formulario(Ventana laVentana) {
        this.laVentana = laVentana;
        
        init();
    }
    
    private void init() {
        lbAdvertencia = new JLabel();
        btnDespejar = new JButton("Despejar");
        btnVerGrafica = new JButton("Ver Grafica");

        formato = new DecimalFormat();
        
        btnDespejar.addActionListener(this::despejar);
        btnVerGrafica.addActionListener(this::verGrafica);
        
        formato.setDecimalSeparatorAlwaysShown(false);
        
        this.setLayout(null);
        this.setBackground(Color.WHITE);
    }
    
    /**
     * Elimina una letra (solo se deben escribir numeros)
     * @param e 
     */
    protected void eliminarLetra(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            e.consume();
            
            new Thread(this::mostrarAdvertencia).start();
        }
    }
    
    /**
     * Le muestra un mensaje al usuario indicandole que no puede ingresar letras
     * en los campos de texto
     */
    protected void mostrarAdvertencia() {
        lbAdvertencia.setText("Sólo num en la ecuacion");
        
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) { /* TODO-CODE here */ }
        }
        
        lbAdvertencia.setText("");
    }
    
    /**
     * Abre una ventana con la ecuacion graficada
     * @param evt
     */
    protected void verGrafica(ActionEvent evt) {
        obtenerDatos();
        
        laVentana.getVentanaCoordenadas().getElPanel().setPunto(punto);
        laVentana.getVentanaCoordenadas().pack();
        laVentana.getVentanaCoordenadas().setLocationRelativeTo(null);
        laVentana.getVentanaCoordenadas().setVisible(true);
    }
    
    @Override
    public abstract Dimension getPreferredSize();
    
    /**
     * A diferencia de los otros metodos, KeyTyped será abstracto debido a que
     * el codigo variará en las subclases
     * @param e 
     */
    @Override
    public abstract void keyTyped(KeyEvent e);
    
    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {        
        if (e.getKeyCode() == KeyEvent.VK_C) 
            vaciarCampos();   
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public JLabel getLbAdvertencia() {
        return lbAdvertencia;
    }

    public void setLbAdvertencia(JLabel lbAdvertencia) {
        this.lbAdvertencia = lbAdvertencia;
    }

    public JButton getBtnDespejar() {
        return btnDespejar;
    }

    public void setBtnDespejar(JButton btnDespejar) {
        this.btnDespejar = btnDespejar;
    }

    public JButton getBtnVerGrafica() {
        return btnVerGrafica;
    }

    public void setBtnVerGrafica(JButton btnVerGrafica) {
        this.btnVerGrafica = btnVerGrafica;
    }

    public DecimalFormat getFormato() {
        return formato;
    }

    public void setFormato(DecimalFormat formato) {
        this.formato = formato;
    }

    public Ecuacion getPunto() {
        return punto;
    }

    public void setPunto(Ecuacion punto) {
        this.punto = punto;
    }

    public Ventana getLaVentana() {
        return laVentana;
    }

    public void setLaVentana(Ventana laVentana) {
        this.laVentana = laVentana;
    }
    // </editor-fold>
}