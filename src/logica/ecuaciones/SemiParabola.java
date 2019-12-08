package logica.ecuaciones;

import grafica.PanelCoordenadas;
import java.awt.Graphics;

public class SemiParabola extends Ecuacion {
    
    //Datos ingresados en los campos de texto de la SemiParabola
    private double X;
    private double Y;

    public SemiParabola() {
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    @Override
    public double getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    @Override
    public double getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    // </editor-fold>
    
    /**
     * Grafica la SemiParabola
     */
    @Override
    public void graficarEcuacion(Graphics g, PanelCoordenadas panel) {
        elPanel = panel;
        
        //Punto de Interseccion
        g.fillOval((int) (elPanel.distanciaHorizontalAlOrigen() + (getX() * elPanel.getMargen()) - elPanel.getMitadPunto()),
                (int) (elPanel.distanciaVerticalAlOrigen() - (getY() * elPanel.getMargen()) - elPanel.getMitadPunto()), 7, 7);
        
        //SemiParabola
        double scala = 0.025;
        /**
         * Para dibujar la semiparabola, dibujaremos lineas simulando que 
         * son puntos... por ende, los parametros x0, y0 seran los mismos 
         * que x1, y1
         */
        if (getY() < 0) {    //Si el primer dato es negativo
            for (int i = -300; i < 0; i++) {
                g.drawLine((int) (elPanel.distanciaVerticalAlOrigen() + (getX() * elPanel.getMargen()) - (int) (scala * i * i)),
                        (int) (i - (getY() * elPanel.getMargen()) + elPanel.distanciaHorizontalAlOrigen()),
                        (int) (elPanel.distanciaVerticalAlOrigen() + (getX() * elPanel.getMargen()) - (int) (scala * i * i)),
                        (int) (i - (getY() * elPanel.getMargen()) + elPanel.distanciaHorizontalAlOrigen()));
            }
        } else {
            for (int i = -300; i < 0; i++) {
                g.drawLine((int) (elPanel.distanciaVerticalAlOrigen() + (getX() * elPanel.getMargen()) + (int) (scala * i * i)),
                        (int) (i - (getY() * elPanel.getMargen()) + elPanel.distanciaHorizontalAlOrigen()), 
                        (int) (elPanel.distanciaVerticalAlOrigen() + (getX() * elPanel.getMargen()) + (int) (scala * i * i)),
                        (int) (i - (getY() * elPanel.getMargen()) + elPanel.distanciaHorizontalAlOrigen()));
            }
        }
    }
}