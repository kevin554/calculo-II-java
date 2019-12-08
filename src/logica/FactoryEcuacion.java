package logica;

public class FactoryEcuacion {

    /**
     * Devuelve el nombre con el que se agrego un panel al CardLayout en base
     * al texto enviado por parametro
     * @param menu El comando del menu que invoca al metodo
     * @return El nombre del panel correspondiente
     */
    public static String obtenerEcuacion(String menu) {
        switch (menu) {
            case "Sistema de Ecuaciones":
                return "Sistema de Ecuaciones";
            case "Parabola":
                return "Ecuacion Cuadratica";
            case "SemiParabola":
                return "SemiParabola";
            case "Circulo":
                return "Circulo";
            case "Elipse":
                return "Elipse";
                
            default:
                return null;
        }
    }
}