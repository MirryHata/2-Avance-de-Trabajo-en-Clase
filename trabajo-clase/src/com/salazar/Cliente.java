package com.salazar;

import com.salazar.excepciones.ErrorValidacion;

public class Cliente {

    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Cliente(String id, String nombre, String apellido){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id.length()!= 13){
            throw new ErrorValidacion("El numero de identidad debe contener 13 caracteres.");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    public String getTelefono(){

        return telefono;
    }

    public void setTelefono(String telefono) throws ErrorValidacion {
        if(!telefono.matches("^(\\+504\\s?)?[0-9]{4}\\-?[0-9]{4}")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ErrorValidacion {
        if(!email.matches("^[A-Za-z0-9_]+@[a-z]+\\.[a-z]{2,}$")){
            throw new ErrorValidacion("El Email es invalido");
        }
        this.email = email;
    }
}
