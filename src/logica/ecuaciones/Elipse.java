package logica.ecuaciones;

import grafica.PanelCoordenadas;
import java.awt.Graphics;

public class Elipse extends Ecuacion {

    //Datos ingresados en los campos de texto de la Elipse
    private double A;
    private double B;

    public Elipse() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }
    // </editor-fold>
    
    /**
     * Grafica la Elipse
     */
    @Override
    public void graficarEcuacion(Graphics g, PanelCoordenadas panel) {
        elPanel = panel;
        
        //Elipse
        g.drawRoundRect((int)(elPanel.distanciaHorizontalAlOrigen() - getA() * elPanel.getMargen()),
                (int)(elPanel.distanciaVerticalAlOrigen() - getB() * elPanel.getMargen()),
                (int)(getA() * 2 * elPanel.getMargen()),
                (int)(getB() * 2 * elPanel.getMargen()),
                (int)(getB() * 100), (int)(getA() * 100));
    }
}