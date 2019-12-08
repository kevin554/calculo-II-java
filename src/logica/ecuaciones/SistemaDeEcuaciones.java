package logica.ecuaciones;

import grafica.PanelCoordenadas;
import java.awt.Graphics;

public class SistemaDeEcuaciones extends Ecuacion {

    //Datos ingresados en los campos de texto del Sistema de Ecuaciones
    private double A;
    private double B;
    private double C;
    private double D;
    private double E;
    private double F;
    
    public SistemaDeEcuaciones() {
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

    public double getC() {
        return C;
    }

    public void setC(double C) {
        this.C = C;
    }

    public double getD() {
        return D;
    }

    public void setD(double D) {
        this.D = D;
    }

    public double getE() {
        return E;
    }

    public void setE(double E) {
        this.E = E;
    }

    public double getF() {
        return F;
    }

    public void setF(double F) {
        this.F = F;
    }
    
    private void setX() {
        setY();
        x = (C - (B * y)) / A;
    }

    private void setY() {
        y = ((A * F) - (D * C)) / ((A * E) - (D * B));
    }
    
    @Override
    public double getX() {
        setX();
        
        return x;
    }

    @Override
    public double getY() {
        setY();
        
        return y;
    }
    // </editor-fold>
    
    /** 
     * Grafica el punto de Interseccion y las lineas correspondientes
     */
    @Override
    public void graficarEcuacion(Graphics g, PanelCoordenadas panel) {
        elPanel = panel;
        
        // Punto de Interseccion
        g.fillOval((int) (elPanel.distanciaHorizontalAlOrigen() + (getX() * elPanel.getMargen()) - elPanel.getMitadPunto()),
                (int) (elPanel.distanciaVerticalAlOrigen() - (getY() * elPanel.getMargen()) - elPanel.getMargen()), 7, 7);
        
        // Primera linea del Sistema de Ecuaciones
        double y1 = getC() / getB();
        g.drawLine((int) (elPanel.distanciaHorizontalAlOrigen() - ((getC() / getA()) * elPanel.getMargen() * 14)),
                (int) (elPanel.distanciaVerticalAlOrigen() - ((y1 * elPanel.getMargen()) * 15)),
                (int) (elPanel.distanciaHorizontalAlOrigen() + (getB() * 15 * elPanel.getMargen())),
                (int) (elPanel.distanciaVerticalAlOrigen() - (y1 * elPanel.getMargen()) + ((getA() * 15 * elPanel.getMargen()))));
        
        // Segunda linea del Sistema de Ecuaciones
        double y2 = getF() / getE();
        g.drawLine((int) (elPanel.distanciaHorizontalAlOrigen() - ((getF() / getD()) * elPanel.getMargen() * 14)),
                (int) (elPanel.distanciaVerticalAlOrigen() - ((y2 * elPanel.getMargen()) * 15)),
                (int) (elPanel.distanciaHorizontalAlOrigen() - ((getE() * elPanel.getMargen()) * 15)),
                (int) (elPanel.distanciaVerticalAlOrigen() - (y2 * elPanel.getMargen()) - ((getD() * elPanel.getMargen()) * 15)));
    }
}