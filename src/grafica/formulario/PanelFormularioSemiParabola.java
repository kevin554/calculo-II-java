package grafica.formulario;

import grafica.Ventana;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.ecuaciones.SemiParabola;

public class PanelFormularioSemiParabola extends Formulario {
    
    private JTextField tfY;
    private JLabel lbOperacion;
    private JLabel[] lbRaiz;
    private JLabel lbX;
    private JTextField tfX;

    public PanelFormularioSemiParabola(Ventana laVentana) {
        super(laVentana);
        
        init();
    }
    
    private void init() {
        tfY = new JTextField();
        lbOperacion = new JLabel("+");
        lbRaiz = new JLabel[2];
        lbX = new JLabel("x");
        tfX = new JTextField();
        
        super.punto = new SemiParabola();
        
        lbRaiz[0] = new JLabel("V");
        lbRaiz[1] = new JLabel("___");
        Font fuente = lbRaiz[0].getFont();
        lbRaiz[0].setFont(new Font(fuente.getFontName(), 0, 32));
        lbRaiz[1].setFont(new Font(fuente.getFontName(), 0, 20));
        
        //AÑADIMOS LOS COMPONENTES DEL CIRCULO
        this.add(tfY);
        this.add(lbOperacion);
        this.add(lbRaiz[0]);
        this.add(lbRaiz[1]);
        this.add(lbX);
        this.add(tfX);
        this.add(btnDespejar);
        this.add(btnVerGrafica);
        this.add(lbAdvertencia);
        
        tfY.setBounds(20, 10, 20, 25);
        lbOperacion.setBounds(45, 10, 10, 25);
        lbRaiz[0].setBounds(60, 7, 25, 25);
        lbRaiz[1].setBounds(77, -15, 45, 25);
        lbX.setBounds(80, 10, 20, 25);
        tfX.setBounds(90, 10, 20, 25);
        
        btnDespejar.setBounds(10, 50, 90, 30);
        btnVerGrafica.setBounds(110, 50, 100, 30);
        lbAdvertencia.setBounds(30, 90, 140, 30);
        
        //AÑADIMOS LISTENERS A LOS COMPONENTES
        tfX.addKeyListener(this);
        tfY.addKeyListener(this);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 170);
    }

    @Override
    public void obtenerDatos() {
        String X = tfX.getText();
        String Y = tfY.getText();

        X = X.replaceAll(" ", "");
        Y = Y.replaceAll(" ", "");

        if (X.equals("")) 
            ((SemiParabola)punto).setX(0);
         else if (X.equals("-"))
             ((SemiParabola)punto).setX(-1);
         else 
            ((SemiParabola)punto).setX(Integer.parseInt(X) + (Integer.parseInt(X) * -2));        

        if (Y.equals("")) 
            ((SemiParabola)punto).setY(0);
         else if (Y.equals("-"))
             ((SemiParabola)punto).setY(-1);
         else 
            ((SemiParabola)punto).setY(Integer.parseInt(Y));
    }
    
    @Override
    public void despejar(ActionEvent evt) {
        obtenerDatos();
        
        JOptionPane.showMessageDialog(null, "x = " + 
                formato.format((((SemiParabola)punto).getX())));
    }
    
    @Override
    public void enfocar() {
        tfY.grabFocus();
    }
    
    @Override
    public void vaciarCampos() {
        tfX.setText("");
        tfY.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == tfX || e.getSource() == tfY) 
            eliminarLetra(e);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public JTextField getTfY() {
        return tfY;
    }

    public void setTfY(JTextField tfY) {
        this.tfY = tfY;
    }

    public JLabel getLbOperacion() {
        return lbOperacion;
    }

    public void setLbOperacion(JLabel lbOperacion) {
        this.lbOperacion = lbOperacion;
    }

    public JLabel[] getLbRaiz() {
        return lbRaiz;
    }

    public void setLbRaiz(JLabel[] lbRaiz) {
        this.lbRaiz = lbRaiz;
    }

    public JLabel getLbX() {
        return lbX;
    }

    public void setLbX(JLabel lbX) {
        this.lbX = lbX;
    }

    public JTextField getTfX() {
        return tfX;
    }

    public void setTfX(JTextField tfX) {
        this.tfX = tfX;
    }
    // </editor-fold>
}
