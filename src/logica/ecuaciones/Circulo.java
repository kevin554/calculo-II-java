package logica.ecuaciones;

import grafica.PanelCoordenadas;
import java.awt.Graphics;
public class Circulo extends Ecuacion{

    //Datos ingresados en los campos de texto del Circulo
    private double H;
    private double K;
    private double R;

    public Circulo() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public double getH() {
        return H;
    }

    public void setH(double H) {
        this.H = H;
    }

    public double getK() {
        return K;
    }

    public void setK(double K) {
        this.K = K;
    }

    public double getR() {
        return R;
    }

    public void setR(double R) {
        this.R = R;
    }
    // </editor-fold>
    
    public double[] getEcuacionCirculo() {
        double[] vector = new double[3];
        
        vector[0] = H * 2;
        vector[1] = K * 2;
        vector[2] = (H * H) + (K * K) - (R * R);
        
        return vector;
    }
    
    /**
     * Grafica el Circulo
     */
    @Override
    public void graficarEcuacion(Graphics g, PanelCoordenadas panel) {
        elPanel = panel;
        
        //Punto de Interseccion
        g.fillOval((int) (elPanel.distanciaHorizontalAlOrigen() + (getH() * elPanel.getMargen()) - elPanel.getMitadPunto()),
                (int) (elPanel.distanciaVerticalAlOrigen() - (getK() * elPanel.getMargen()) - elPanel.getMitadPunto()), 7, 7);
        
        //Circulo
        g.drawOval((int)(elPanel.distanciaHorizontalAlOrigen() - (getR() * elPanel.getMargen()) + (getH() * elPanel.getMargen())), 
                (int)(elPanel.distanciaVerticalAlOrigen() - (getR() * elPanel.getMargen()) - (getK() * elPanel.getMargen())), 
                (int)(getR() * 2 * elPanel.getMargen()),
                (int)(getR() * 2 * elPanel.getMargen()));
    }
}