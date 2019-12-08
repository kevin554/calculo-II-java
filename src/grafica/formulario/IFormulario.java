package grafica.formulario;

import java.awt.event.ActionEvent;

/**
 * Interfase que representa a un Formulario. Esta interfase incluye los metodos
 * necesarios para trabajar con los datos de la capa de negocios. El cuerpo de
 * los metodos variará en los distintos formularios.
 */
public interface IFormulario {

    /**
     * Crea un objeto de la ecuacion en base a los datos ingresados(si no hay
     * datos ingresados, automaticamente se colocan datos coherentes)
     */
    public void obtenerDatos();

    /**
     * Elimina los datos escritos en los campos de texto
     */
    public void vaciarCampos();

    /**
     * El primer campo de texto queda seleccionado
     */
    public void enfocar();

    /**
    * Muestra al usuario la ecuacion para los datos que ingresó
     * @param evt
    */
    public void despejar(ActionEvent evt);
}
