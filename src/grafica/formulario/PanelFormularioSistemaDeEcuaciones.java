package grafica.formulario;

import grafica.Ventana;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.ecuaciones.SistemaDeEcuaciones;

public class PanelFormularioSistemaDeEcuaciones extends Formulario {
    
    private ImageIcon imgLlave;
    private JLabel lbLlave;
        
    private JLabel lbPrimeraEcuacionX;
    private JLabel lbPrimeraEcuacionY;
    private JLabel lbSegundaEcuacionX;
    private JLabel lbSegundaEcuacionY;
    
    private JTextField tfPrimeraEcuacionX;
    private JTextField tfPrimeraEcuacionY;
    private JTextField tfSegundaEcuacionX;
    private JTextField tfSegundaEcuacionY;
    private JTextField tfResultadoPrimeraEcuacion;
    private JTextField tfResultadoSegundaEcuacion;

    public PanelFormularioSistemaDeEcuaciones(Ventana laVentana) {
        super(laVentana);
        
        init();
    }
    
    private void init() {
        imgLlave = new ImageIcon(getClass()
                .getResource("/imagenes/Llavecita.png"));
        lbLlave = new JLabel(imgLlave);

        lbPrimeraEcuacionX = new JLabel("x");
        lbPrimeraEcuacionY = new JLabel("y =");
        lbSegundaEcuacionX = new JLabel("x");
        lbSegundaEcuacionY = new JLabel("y =");

        tfPrimeraEcuacionX = new JTextField();
        tfPrimeraEcuacionY = new JTextField();
        tfSegundaEcuacionX = new JTextField();
        tfSegundaEcuacionY = new JTextField();
        tfResultadoPrimeraEcuacion = new JTextField();
        tfResultadoSegundaEcuacion = new JTextField();
    
        super.punto = new SistemaDeEcuaciones();
        
        //AÑADIMOS LOS COMPONENTES DEL SISTEMA DE ECUACIONES
        this.add(lbLlave);
        this.add(lbPrimeraEcuacionX);
        this.add(tfPrimeraEcuacionX);
        this.add(lbPrimeraEcuacionY);
        this.add(tfPrimeraEcuacionY);
        this.add(tfResultadoPrimeraEcuacion);
        this.add(lbSegundaEcuacionX);
        this.add(tfSegundaEcuacionX);
        this.add(lbSegundaEcuacionY);
        this.add(tfSegundaEcuacionY);
        this.add(tfResultadoSegundaEcuacion);
        this.add(btnDespejar);
        this.add(btnVerGrafica);
        this.add(lbAdvertencia);
        
        lbLlave.setBounds(10, 10, imgLlave.getIconWidth(), imgLlave.getIconHeight());
        tfPrimeraEcuacionX.setBounds(30, 10, 30, 30);
        lbPrimeraEcuacionX.setBounds(62, 10, 30, 30);
        tfPrimeraEcuacionY.setBounds(74, 10, 30, 30);
        lbPrimeraEcuacionY.setBounds(106, 10, 30, 30);
        tfResultadoPrimeraEcuacion.setBounds(126, 10, 30, 30);

        tfSegundaEcuacionX.setBounds(30, 50, 30, 30);
        lbSegundaEcuacionX.setBounds(62, 50, 30, 30);
        tfSegundaEcuacionY.setBounds(74, 50, 30, 30);
        lbSegundaEcuacionY.setBounds(106, 50, 30, 30);
        tfResultadoSegundaEcuacion.setBounds(126, 50, 30, 30);

        lbAdvertencia.setBounds(30, 130, 140, 30);
        btnDespejar.setBounds(10, 90, 90, 30);
        btnVerGrafica.setBounds(110, 90, 100, 30);
        
        //AÑADIMOS LISTENERS A LOS COMPONENTES
        tfPrimeraEcuacionX.addKeyListener(this);
        tfPrimeraEcuacionY.addKeyListener(this);
        tfResultadoPrimeraEcuacion.addKeyListener(this);
        tfSegundaEcuacionX.addKeyListener(this);
        tfSegundaEcuacionY.addKeyListener(this);
        tfResultadoSegundaEcuacion.addKeyListener(this);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 170);
    }

    @Override
    public void enfocar() {
        tfPrimeraEcuacionX.grabFocus();
    }
        
    @Override
    public void obtenerDatos() {
        String A = tfPrimeraEcuacionX.getText();
        String B = tfPrimeraEcuacionY.getText();
        String C = tfResultadoPrimeraEcuacion.getText();
        String D = tfSegundaEcuacionX.getText();
        String E = tfSegundaEcuacionY.getText();
        String F = tfResultadoSegundaEcuacion.getText();

        A = A.replaceAll(" ", "");
        B = B.replaceAll(" ", "");
        C = C.replaceAll(" ", "");
        D = D.replaceAll(" ", "");
        E = E.replaceAll(" ", "");
        F = F.replaceAll(" ", "");

        if (A.equals("")) 
            ((SistemaDeEcuaciones)punto).setA(1);
         else if (A.equals("+")) 
            ((SistemaDeEcuaciones)punto).setA(1);
         else if (A.equals("-")) 
            ((SistemaDeEcuaciones)punto).setA(-1);
         else 
            ((SistemaDeEcuaciones)punto).setA(Integer.parseInt(A));        

        if (B.equals("")) 
            ((SistemaDeEcuaciones)punto).setB(1);
         else if (B.equals("+")) 
            ((SistemaDeEcuaciones)punto).setB(1);
         else if (B.equals("-")) 
            ((SistemaDeEcuaciones)punto).setB(-1);
         else 
            ((SistemaDeEcuaciones)punto).setB(Integer.parseInt(B));        

        if (C.equals("")) 
            ((SistemaDeEcuaciones)punto).setC(1);
         else if (C.equals("+")) 
            ((SistemaDeEcuaciones)punto).setC(1);
         else if (C.equals("-")) 
            ((SistemaDeEcuaciones)punto).setC(-1);
         else 
            ((SistemaDeEcuaciones)punto).setC(Integer.parseInt(C));
      
        if (D.equals("")) 
            ((SistemaDeEcuaciones)punto).setD(1);
         else if (D.equals("+")) 
            ((SistemaDeEcuaciones)punto).setD(1);
         else if (D.equals("-")) 
            ((SistemaDeEcuaciones)punto).setD(-1);
         else 
            ((SistemaDeEcuaciones)punto).setD(Integer.parseInt(D));        

        if (E.equals("")) 
            ((SistemaDeEcuaciones)punto).setE(1);
         else if (E.equals("+")) 
            ((SistemaDeEcuaciones)punto).setE(1);
         else if (E.equals("-")) 
            ((SistemaDeEcuaciones)punto).setE(-1);
         else 
            ((SistemaDeEcuaciones)punto).setE(Integer.parseInt(E));        

        if (F.equals("")) 
            ((SistemaDeEcuaciones)punto).setF(1);
         else if (F.equals("+")) 
            ((SistemaDeEcuaciones)punto).setF(1);
         else if (F.equals("-")) 
            ((SistemaDeEcuaciones)punto).setF(-1);
         else 
            ((SistemaDeEcuaciones)punto).setF(Integer.parseInt(F));        
    }
    
    @Override
    public void despejar(ActionEvent evt) {
        obtenerDatos();
        
        try {
            JOptionPane.showMessageDialog(null, " x = " + 
                    formato.format(((SistemaDeEcuaciones)punto).getX()) + 
                    "\n y = " + 
                    formato.format(((SistemaDeEcuaciones)punto).getY()));
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, 
                    "El sistema no tiene un punto " + "de intersección" + 
                    "\n Intente con otros datos");
        }        
    }
    
    @Override
    public void vaciarCampos() {
        tfPrimeraEcuacionX.setText("");
        tfPrimeraEcuacionY.setText("");
        tfResultadoPrimeraEcuacion.setText("");
        tfSegundaEcuacionX.setText("");
        tfSegundaEcuacionY.setText("");
        tfResultadoSegundaEcuacion.setText("");
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == tfPrimeraEcuacionX ||
                e.getSource() == tfPrimeraEcuacionY || 
                e.getSource() == tfResultadoPrimeraEcuacion ||
                e.getSource() == tfSegundaEcuacionX || 
                e.getSource() == tfSegundaEcuacionY || 
                e.getSource() == tfResultadoSegundaEcuacion) {
            eliminarLetra(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public ImageIcon getImgLlave() {
        return imgLlave;
    }

    public void setImgLlave(ImageIcon imgLlave) {
        this.imgLlave = imgLlave;
    }

    public JLabel getLbLlave() {
        return lbLlave;
    }

    public void setLbLlave(JLabel lbLlave) {
        this.lbLlave = lbLlave;
    }

    public JLabel getLbPrimeraEcuacionX() {
        return lbPrimeraEcuacionX;
    }

    public void setLbPrimeraEcuacionX(JLabel lbPrimeraEcuacionX) {
        this.lbPrimeraEcuacionX = lbPrimeraEcuacionX;
    }

    public JLabel getLbPrimeraEcuacionY() {
        return lbPrimeraEcuacionY;
    }

    public void setLbPrimeraEcuacionY(JLabel lbPrimeraEcuacionY) {
        this.lbPrimeraEcuacionY = lbPrimeraEcuacionY;
    }

    public JLabel getLbSegundaEcuacionX() {
        return lbSegundaEcuacionX;
    }

    public void setLbSegundaEcuacionX(JLabel lbSegundaEcuacionX) {
        this.lbSegundaEcuacionX = lbSegundaEcuacionX;
    }

    public JLabel getLbSegundaEcuacionY() {
        return lbSegundaEcuacionY;
    }

    public void setLbSegundaEcuacionY(JLabel lbSegundaEcuacionY) {
        this.lbSegundaEcuacionY = lbSegundaEcuacionY;
    }

    public JTextField getTfPrimeraEcuacionX() {
        return tfPrimeraEcuacionX;
    }

    public void setTfPrimeraEcuacionX(JTextField tfPrimeraEcuacionX) {
        this.tfPrimeraEcuacionX = tfPrimeraEcuacionX;
    }

    public JTextField getTfPrimeraEcuacionY() {
        return tfPrimeraEcuacionY;
    }

    public void setTfPrimeraEcuacionY(JTextField tfPrimeraEcuacionY) {
        this.tfPrimeraEcuacionY = tfPrimeraEcuacionY;
    }

    public JTextField getTfSegundaEcuacionX() {
        return tfSegundaEcuacionX;
    }

    public void setTfSegundaEcuacionX(JTextField tfSegundaEcuacionX) {
        this.tfSegundaEcuacionX = tfSegundaEcuacionX;
    }

    public JTextField getTfSegundaEcuacionY() {
        return tfSegundaEcuacionY;
    }

    public void setTfSegundaEcuacionY(JTextField tfSegundaEcuacionY) {
        this.tfSegundaEcuacionY = tfSegundaEcuacionY;
    }

    public JTextField getTfResultadoPrimeraEcuacion() {
        return tfResultadoPrimeraEcuacion;
    }

    public void setTfResultadoPrimeraEcuacion(JTextField tfResultadoPrimeraEcuacion) {
        this.tfResultadoPrimeraEcuacion = tfResultadoPrimeraEcuacion;
    }

    public JTextField getTfResultadoSegundaEcuacion() {
        return tfResultadoSegundaEcuacion;
    }

    public void setTfResultadoSegundaEcuacion(JTextField tfResultadoSegundaEcuacion) {
        this.tfResultadoSegundaEcuacion = tfResultadoSegundaEcuacion;
    }
    // </editor-fold>
}
