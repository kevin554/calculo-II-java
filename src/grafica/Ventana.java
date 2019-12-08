package grafica;

import grafica.formulario.Formulario;
import grafica.formulario.PanelFormularioSistemaDeEcuaciones;
import grafica.formulario.PanelFormularioSemiParabola;
import grafica.formulario.PanelFormularioElipse;
import grafica.formulario.PanelFormularioEcuacionCuadratica;
import grafica.formulario.PanelFormularioCirculo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.FactoryEcuacion;
import logica.PageViewer;

public class Ventana extends JFrame {
    
    private Formulario objFormulario;
    private PanelBienvenida panelBienvenida;
    private PanelPortada panelPortada;    
    
    private CardLayout layout;
    private JPanel panelPrincipal;
    private VentanaCoordenadas ventanaCoordenadas;
        
    public Ventana() {
        init();
    }

    private void init() {
        layout = new PageViewer();
        panelPrincipal = new JPanel(layout);
        
        //CONFIGURAMOS LA VENTANA
        panelPortada = new PanelPortada();
        panelPrincipal.add(panelPortada, "Portada");
        objFormulario = new PanelFormularioSistemaDeEcuaciones(this);
        panelPrincipal.add(objFormulario, "Sistema de Ecuaciones");
        objFormulario = new PanelFormularioSemiParabola(this);
        panelPrincipal.add(objFormulario, "SemiParabola");
        objFormulario = new PanelFormularioCirculo(this);
        panelPrincipal.add(objFormulario, "Circulo");
        objFormulario = new PanelFormularioEcuacionCuadratica(this);
        panelPrincipal.add(objFormulario, "Ecuacion Cuadratica");
        objFormulario = new PanelFormularioElipse(this);
        panelPrincipal.add(objFormulario, "Elipse");
        panelBienvenida = new PanelBienvenida();
        panelPrincipal.add(panelBienvenida, "Panel Bienvenida");
        
        this.add(panelPrincipal, BorderLayout.CENTER);
        
        comenzarPresentacion();
        
        JMenuBar barra = new JMenuBar();
        JMenu mnNuevo = new JMenu("Nuevo");
        JMenu mnOpciones = new JMenu("Opciones");
        JMenuItem itmSistemaDeEcuaciones = new JMenuItem("Sistema de Ecuaciones");
        JMenuItem itmParabola = new JMenuItem("Parabola");
        JMenuItem itmSemiParabola = new JMenuItem("SemiParabola");
        JMenuItem itmCirculo = new JMenuItem("Circulo");
        JMenuItem itmElipse = new JMenuItem("Elipse");
        JMenuItem itmSalir = new JMenuItem("Salir");
        JMenuItem itmCambiarNombre = new JMenuItem("Cambiar Nombre");
        JMenuItem itmFraseCelebre = new JMenuItem("Frase Celebre");
        JMenuItem itmAcercaDe = new JMenuItem("Acerca De");

        //AÑADIMOS LA BARRA DE MENÚ
        setJMenuBar(barra);
        barra.add(mnNuevo);
        barra.add(mnOpciones);
        mnNuevo.add(itmSistemaDeEcuaciones);
        mnNuevo.add(itmParabola);
        mnNuevo.add(itmSemiParabola);
        mnNuevo.add(itmCirculo);
        mnNuevo.add(itmElipse);
        mnNuevo.addSeparator();
        mnNuevo.add(itmSalir);
        mnOpciones.add(itmCambiarNombre);
        mnOpciones.add(itmFraseCelebre);
        mnOpciones.add(itmAcercaDe);

        //AÑADIMOS ACTIONLISTENER Y KEYLISTENER A LOS COMPONENTES QUE LO REQUIERAN
        itmSistemaDeEcuaciones.addActionListener(this::mostrarPanel);
        itmParabola.addActionListener(this::mostrarPanel);
        itmSemiParabola.addActionListener(this::mostrarPanel);
        itmCirculo.addActionListener(this::mostrarPanel);
        itmElipse.addActionListener(this::mostrarPanel);
        itmSalir.addActionListener(this::salir);
        itmCambiarNombre.addActionListener(this::cambiarNombreDeUsuario);
        itmFraseCelebre.addActionListener(this::mostrarFraseCelebre);
        itmAcercaDe.addActionListener(this::mostrarInformacionPrograma);
        
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
        ventanaCoordenadas = new VentanaCoordenadas();
    }
    
    public void cambiarNombreDeUsuario(ActionEvent e) {
        escribirFichero();
    }
    
    private void escribirFichero() {
        File archivo = new File("Nombre de Usuario.txt");
                
        try (BufferedWriter out = new BufferedWriter(new FileWriter(archivo))) {
            String nombre = JOptionPane.showInputDialog(this, "Su nombre:");
            
            if (nombre != null) 
                out.write(nombre);
        } catch (java.io.IOException ex) {
            /* TODO-CODE here*/
        }
    }

    public void comenzarPresentacion() {
        layout.show(panelPrincipal, "Panel Bienvenida");
        
        new Thread(this::presentacion).start();
    }

    public void presentacion() {        
        try { Thread.sleep(1500); } catch (InterruptedException e) { }
        
        layout.show(panelPrincipal, "Portada");
        pack();
    }
    
    /**
     * Muestra en pantalla el formulario correspondiente para el menu escogido
     * @param e 
     */
    public void mostrarPanel(ActionEvent e) {
        String tipoEcuacion = FactoryEcuacion.obtenerEcuacion(e.getActionCommand());
        layout.show(panelPrincipal, tipoEcuacion);
        objFormulario.enfocar();
        
        this.pack();
    }

    /**
     * Despliega una ventana con una frase celebre
     * @param e
     */
    public void mostrarFraseCelebre(ActionEvent e) {
        JOptionPane.showMessageDialog(this,
                "Denme un punto de apoyo y destaparé una fría \n"
                + "                                     "
                + "                           'Arquimedes'");
    }
    
    /**
     * Despliega una ventana con la informacion acerca del programa
     * @param e
     */
    public void mostrarInformacionPrograma(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new PanelAcercaDe(), "Acerca De",
                JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Sale del programa
     * @param e 
     */
    public void salir(ActionEvent e) {
        System.exit(0);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public Formulario getObjFormulario() {
        return objFormulario;
    }

    public void setObjFormulario(Formulario objFormulario) {
        this.objFormulario = objFormulario;
    }

    public PanelBienvenida getPanelBienvenida() {
        return panelBienvenida;
    }

    public void setPanelBienvenida(PanelBienvenida panelBienvenida) {
        this.panelBienvenida = panelBienvenida;
    }

    public PanelPortada getPanelPortada() {
        return panelPortada;
    }

    public void setPanelPortada(PanelPortada panelPortada) {
        this.panelPortada = panelPortada;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }
    
    public VentanaCoordenadas getVentanaCoordenadas() {
        return ventanaCoordenadas;
    }

    public void setVentanaCoordenadas(VentanaCoordenadas ventanaCoordenadas) {
        this.ventanaCoordenadas = ventanaCoordenadas;
    }
    // </editor-fold>
}
