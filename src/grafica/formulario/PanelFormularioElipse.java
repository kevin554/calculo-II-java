package grafica.formulario;

import grafica.Ventana;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import logica.ecuaciones.Elipse;

public class PanelFormularioElipse extends Formulario {
    
    private JLabel lbX;
    private JLabel lbSuma;
    private JLabel lbY;
    private JLabel lbResultado;
    private JLabel[] lbDivisor;
    private JTextField tfA;
    private JLabel[] lbPotencias;
    private JTextField tfB;

    public PanelFormularioElipse(Ventana laVentana) {
        super(laVentana);
        
        init();
    }
    
    private void init() {
        lbX = new JLabel("x²");
        lbSuma = new JLabel("+");
        lbY = new JLabel("y²");
        lbResultado = new JLabel("=  1");
        lbDivisor = new JLabel[2];
        tfA = new JTextField();
        lbPotencias = new JLabel[2];
        tfB = new JTextField();
        
        super.punto = new Elipse();

        lbDivisor[0] = new JLabel("__");
        lbDivisor[1] = new JLabel("__");
        lbPotencias[0] = new JLabel("²");
        lbPotencias[1] = new JLabel("²");
        
        //AÑADIMOS LOS COMPONENTES DEL CIRCULO
        this.add(lbX);
        this.add(lbSuma);
        this.add(lbY);
        this.add(lbResultado);
        this.add(lbDivisor[0]);
        this.add(lbDivisor[1]);
        this.add(tfA);
        this.add(lbPotencias[0]);
        this.add(tfB);
        this.add(lbPotencias[1]);
        this.add(btnDespejar);
        this.add(btnVerGrafica);
        this.add(lbAdvertencia);
        
        lbX.setBounds(20, 10, 20, 30);
        lbSuma.setBounds(40, 20, 20, 30);
        lbY.setBounds(60, 10, 20, 30);
        lbResultado.setBounds(80, 20, 20, 30);
        lbDivisor[0].setBounds(17, 20, 20, 20);
        lbDivisor[1].setBounds(57, 20, 20, 20);        
        tfA.setBounds(15, 40, 20, 30);
        lbPotencias[0].setBounds(35, 35, 20, 20);
        tfB.setBounds(55, 40, 20, 30);
        lbPotencias[1].setBounds(75, 35, 20, 20);
        
        btnVerGrafica.setBounds(110, 80, 100, 30);
        lbAdvertencia.setBounds(30, 116, 140, 30);
        
        //AÑADIMOS LISTENERS A LOS COMPONENTES
        btnDespejar.removeActionListener(this::despejar);
        tfA.addKeyListener(this);
        tfB.addKeyListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 170);
    }

    @Override
    public void obtenerDatos() {
        String A = tfA.getText();
        String B = tfB.getText();

        A = A.replaceAll(" ", "");
        B = B.replaceAll(" ", "");

        if (A.equals("")) 
            ((Elipse)punto).setA(1);
         else if (A.equals("+")) 
            ((Elipse)punto).setA(1);
         else if (A.equals("-")) 
            ((Elipse)punto).setA(-1);
         else
            ((Elipse)punto).setA((int) Math.pow(Integer.parseInt(A), 0.5));

        if (B.equals("")) 
            ((Elipse)punto).setB(1);
         else if (B.equals("+")) 
            ((Elipse)punto).setB(1);
         else if (B.equals("-")) 
            ((Elipse)punto).setB(-1);
         else 
            ((Elipse)punto).setB((int) Math.pow(Integer.parseInt(B), 0.5));
    }

    @Override
    public void vaciarCampos() {
        tfA.setText("");
        tfB.setText("");
    }

    @Override
    public void enfocar() {
        tfA.grabFocus();
    }

    @Override
    public void despejar(ActionEvent evt) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == tfA || e.getSource() == tfB) 
            eliminarLetra(e);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public JLabel getLbX() {
        return lbX;
    }

    public void setLbX(JLabel lbX) {
        this.lbX = lbX;
    }

    public JLabel getLbSuma() {
        return lbSuma;
    }

    public void setLbSuma(JLabel lbSuma) {
        this.lbSuma = lbSuma;
    }

    public JLabel getLbY() {
        return lbY;
    }

    public void setLbY(JLabel lbY) {
        this.lbY = lbY;
    }

    public JLabel getLbResultado() {
        return lbResultado;
    }

    public void setLbResultado(JLabel lbResultado) {
        this.lbResultado = lbResultado;
    }

    public JLabel[] getLbDivisor() {
        return lbDivisor;
    }

    public void setLbDivisor(JLabel[] lbDivisor) {
        this.lbDivisor = lbDivisor;
    }

    public JTextField getTfA() {
        return tfA;
    }

    public void setTfA(JTextField tfA) {
        this.tfA = tfA;
    }

    public JLabel[] getLbPotencias() {
        return lbPotencias;
    }

    public void setLbPotencias(JLabel[] lbPotencias) {
        this.lbPotencias = lbPotencias;
    }

    public JTextField getTfB() {
        return tfB;
    }

    public void setTfB(JTextField tfB) {
        this.tfB = tfB;
    }
    // </editor-fold>
}
