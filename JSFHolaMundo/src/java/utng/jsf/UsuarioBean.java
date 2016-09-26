/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author TICLAB1
 */
@Named(value = "usuario")
@SessionScoped
public class UsuarioBean implements Serializable {

    private String nombre;
    private String apellidos;
    private String clave;
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        this.nombre = "";
        this.apellidos = "";
        this.clave = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getSaludo(){
        if(nombre.length()==0){
        return "";
        }else{
            return "¡Bienvenido a JSF2 + Ajax, "+nombre+"!";
        }
    }
    
}
