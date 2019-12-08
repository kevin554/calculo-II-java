package grafica.formulario;

import grafica.Ventana;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.ecuaciones.Parabola;

public class PanelFormularioEcuacionCuadratica extends Formulario {
    
    private JLabel lbY;
    private JLabel lbX2;
    private JLabel lbX;
    private JTextField tfA;
    private JTextField tfB;
    private JTextField tfC;

    public PanelFormularioEcuacionCuadratica(Ventana laVentana) {
        super(laVentana);
        
        init();
    }
    
    private void init() {
        lbY = new JLabel("y=");
        lbX2 = new JLabel("x²");
        lbX = new JLabel("x");
        tfA = new JTextField();
        tfB = new JTextField();
        tfC = new JTextField();
        
        super.punto = new Parabola();
        
        //AÑADIMOS LOS COMPONENTES DE LA PARABOLA
        this.add(lbY);
        this.add(tfA);
        this.add(lbX2);
        this.add(tfB);
        this.add(lbX);
        this.add(tfC);
        this.add(btnDespejar);
        this.add(btnVerGrafica);
        this.add(lbAdvertencia);

        lbY.setBounds(10, 10, 20, 30);
        tfA.setBounds(30, 10, 20, 30);
        lbX2.setBounds(50, 10, 20, 30);
        tfB.setBounds(65, 10, 25, 30);
        lbX.setBounds(90, 10, 20, 30);
        tfC.setBounds(100, 10, 20, 30);
                
        btnDespejar.setBounds(10, 50, 90, 30);
        btnVerGrafica.setBounds(110, 50, 100, 30);
        lbAdvertencia.setBounds(30, 90, 140, 30);
        
        //AÑADIMOS LISTENERS A LOS COMPONENTES
        tfA.addKeyListener(this);
        tfB.addKeyListener(this);
        tfC.addKeyListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 170);
    }
    
    @Override
    public void obtenerDatos() {
        String J = tfA.getText();
        String K = tfB.getText();
        String L = tfC.getText();

        J = J.replaceAll(" ", "");
        K = K.replaceAll(" ", "");
        L = L.replaceAll(" ", "");
        
        if (J.equals("")) 
            ((Parabola)punto).setJ(1);
         else if (J.equals("+")) 
            ((Parabola)punto).setJ(1);
         else if (J.equals("-")) 
            ((Parabola)punto).setJ(-1);
         else 
            ((Parabola)punto).setJ(Integer.parseInt(J));        

        if (K.equals("")) 
            ((Parabola)punto).setK(1);
         else if (K.equals("+")) 
            ((Parabola)punto).setK(1);
         else if (K.equals("-")) 
            ((Parabola)punto).setK(-1);
         else 
            ((Parabola)punto).setK(Integer.parseInt(K));        

        if (L.equals("")) 
            ((Parabola)punto).setL(1);
         else 
            ((Parabola)punto).setL(Integer.parseInt(L));
    }

    @Override
    public void vaciarCampos() {
        tfA.setText("");
        tfB.setText("");
        tfC.setText("");
    }

    @Override
    public void enfocar() {
        tfA.grabFocus();
    }

    @Override
    public void despejar(ActionEvent evt) {
        obtenerDatos();
        
        JOptionPane.showMessageDialog(null, 
                " x = " + formato.format(((Parabola)punto).getX())
                + "\n y = " + formato.format(((Parabola)punto).getY()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == tfA || e.getSource() == tfB || e.getSource() == tfC) 
            eliminarLetra(e);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public JLabel getLbY() {
        return lbY;
    }

    public void setLbY(JLabel lbY) {
        this.lbY = lbY;
    }

    public JLabel getLbX2() {
        return lbX2;
    }

    public void setLbX2(JLabel lbX2) {
        this.lbX2 = lbX2;
    }

    public JLabel getLbX() {
        return lbX;
    }

    public void setLbX(JLabel lbX) {
        this.lbX = lbX;
    }

    public JTextField getTfA() {
        return tfA;
    }

    public void setTfA(JTextField tfA) {
        this.tfA = tfA;
    }

    public JTextField getTfB() {
        return tfB;
    }

    public void setTfB(JTextField tfB) {
        this.tfB = tfB;
    }

    public JTextField getTfC() {
        return tfC;
    }

    public void setTfC(JTextField tfC) {
        this.tfC = tfC;
    }
    // </editor-fold>
}
