package grafica.formulario;

import grafica.Ventana;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.ecuaciones.Circulo;

public class PanelFormularioCirculo extends Formulario {
    
    private JTextField tfH;
    private JTextField tfK;
    private JTextField tfR;
    
    private JLabel lbC;
    private JLabel lbComa;
    private JLabel lbR;
    private JLabel lbPotencia;

    public PanelFormularioCirculo(Ventana laVentana) {
        super(laVentana);
        
        init();
    }

    private void init() {
        tfH = new JTextField();
        tfK = new JTextField();
        tfR = new JTextField();
        
        lbC = new JLabel("C (");
        lbComa = new JLabel(",");
        lbR = new JLabel(") r = ");
        lbPotencia = new JLabel("²");
        
        super.punto = new Circulo();
        
        //AÑADIMOS LOS COMPONENTES DEL CIRCULO
        this.add(lbC);
        this.add(tfH);
        this.add(lbComa);
        this.add(tfK);
        this.add(lbR);
        this.add(tfR);
        this.add(lbPotencia);
        this.add(btnDespejar);
        this.add(btnVerGrafica);
        this.add(lbAdvertencia);
        
        lbC.setBounds(10, 10, 20, 30);
        tfH.setBounds(30, 10, 20, 30);
        lbComa.setBounds(50, 10, 20, 30);
        tfK.setBounds(55, 10, 20, 30);
        lbR.setBounds(80, 10, 30, 30);
        tfR.setBounds(100, 10, 20, 30);
        lbPotencia.setBounds(120, 10, 20, 30);
        
        btnDespejar.setBounds(10, 50, 90, 30);
        btnVerGrafica.setBounds(110, 50, 100, 30);
        lbAdvertencia.setBounds(30, 90, 140, 30);
        
        //AÑADIMOS LISTENERS A LOS COMPONENTES QUE LO REQUIERAN
        tfH.addKeyListener(this);
        tfK.addKeyListener(this);
        tfR.addKeyListener(this);
    }
    
    @Override
    public void obtenerDatos() {
        String H = tfH.getText();
        String K = tfK.getText();
        String R = tfR.getText();

        H = H.replaceAll(" ", "");
        K = K.replaceAll(" ", "");
        R = R.replaceAll(" ", "");

        if (H.equals("")) 
            ((Circulo) punto).setH(1);
         else if (H.equals("+")) 
            ((Circulo) punto).setH(1);
         else if (H.equals("-")) 
            ((Circulo) punto).setH(-1);
         else 
            ((Circulo) punto).setH(Integer.parseInt(H));        

        if (K.equals("")) 
            ((Circulo) punto).setK(1);
         else if (K.equals("+")) 
            ((Circulo) punto).setK(1);
         else if (K.equals("-")) 
            ((Circulo) punto).setK(-1);
         else 
            ((Circulo) punto).setK(Integer.parseInt(K));        

        if (R.equals("")) 
            ((Circulo) punto).setR(1);
         else 
            ((Circulo) punto).setR(Integer.parseInt(R));        
    }
    
    @Override
    public void despejar(ActionEvent evt) {
        obtenerDatos();
        
        JOptionPane.showMessageDialog(null, " x² + y² + " + 
                formato.format(((Circulo) punto).getEcuacionCirculo()[0]) + " x + " + 
                formato.format(((Circulo) punto).getEcuacionCirculo()[1]) + "y + " + 
                formato.format(((Circulo) punto).getEcuacionCirculo()[2]) + " = 0");
    }
    
    @Override
    public void enfocar() {
        tfH.grabFocus();
    }
    
    @Override
    public void vaciarCampos() {
        tfH.setText("");
        tfK.setText("");
        tfR.setText("");
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 170);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == tfH || e.getSource() == tfK || e.getSource() == tfR) 
            eliminarLetra(e);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public JTextField getTfH() {
        return tfH;
    }

    public void setTfH(JTextField tfH) {
        this.tfH = tfH;
    }

    public JTextField getTfK() {
        return tfK;
    }

    public void setTfK(JTextField tfK) {
        this.tfK = tfK;
    }

    public JTextField getTfR() {
        return tfR;
    }

    public void setTfR(JTextField tfR) {
        this.tfR = tfR;
    }

    public JLabel getLbC() {
        return lbC;
    }

    public void setLbC(JLabel lbC) {
        this.lbC = lbC;
    }

    public JLabel getLbComa() {
        return lbComa;
    }

    public void setLbComa(JLabel lbComa) {
        this.lbComa = lbComa;
    }

    public JLabel getLbR() {
        return lbR;
    }

    public void setLbR(JLabel lbR) {
        this.lbR = lbR;
    }

    public JLabel getLbPotencia() {
        return lbPotencia;
    }

    public void setLbPotencia(JLabel lbPotencia) {
        this.lbPotencia = lbPotencia;
    }
    // </editor-fold>
}
