package logica.ecuaciones;

import grafica.PanelCoordenadas;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Una ecuacion de 2do grado que graficamente se representa con una parabola
 */
public class Parabola extends Ecuacion {

    //Datos ingresados en los campos de texto de la Ecuacion Cuadratica (Parabola)
    private double J;
    private double K;
    private double L;
        
    public Parabola() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public double getJ() {
        return J;
    }

    public void setJ(int J) {
        this.J = J;
    }

    public double getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }

    public double getL() {
        return L;
    }

    public void setL(int L) {
        this.L = L;
    }
    
    private void setX() {
        x = (-K) / (2 * J);        
    }

    private void setY() {
        y = ((4 * (J * J) * L) - (J * K * K)) / (4 * J * J);
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
     * Grafica el punto de Interseccion y la Parabola
     */
    @Override
    public void graficarEcuacion(Graphics g, PanelCoordenadas panel) {
        elPanel = panel;
        
        // Punto de Interseccion
        g.fillOval((int) (elPanel.distanciaHorizontalAlOrigen() + 
                (getX() * elPanel.getMargen()) - elPanel.getMitadPunto()),
                (int) (elPanel.distanciaVerticalAlOrigen() - 
                        (getY() * elPanel.getMargen()) - elPanel.getMitadPunto()),
                7, 7);
        
        // Parabola
        Polygon p = new Polygon();
        double scala = 0.025;

        if (getJ() < 0) {    //Si el primer dato es negativo
            for (int i = -300; i < 300; i++) {
                p.addPoint((int) (i + elPanel.distanciaHorizontalAlOrigen() + 
                        getX() * elPanel.getMargen()),
                        (int) (elPanel.distanciaVerticalAlOrigen() - 
                                (getY() * elPanel.getMargen()) + (int) (scala * i * i)));
            }
            
            g.drawPolygon(p);
        } else {
            for (int i = -300; i < 300; i++) {
                p.addPoint((int) (i + elPanel.distanciaHorizontalAlOrigen() + 
                        getX() * elPanel.getMargen()),
                        (int) (elPanel.distanciaVerticalAlOrigen() - 
                                (getY() * elPanel.getMargen()) - (int) (scala * i * i)));
            }
            
            g.drawPolygon(p);
        }
    }
}