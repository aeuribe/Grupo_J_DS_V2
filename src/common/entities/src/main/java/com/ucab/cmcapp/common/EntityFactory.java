package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory

{
    /**
     * Method that returns an instance of User class
     */

    public static Persona createPersona(){
        return new Persona();
    }

    public static Persona createPersona(long _id_persona){
        return new Persona(_id_persona);
    }

    public static Usuario createUsuario() {
        return new Usuario();
    }

    public  static Usuario createUsuario( long _id_usuario ){
        return new Usuario(_id_usuario);
    }

    public static Usuario createUsuario( String _email){
        return new Usuario(_email);
    }


    public static Querella createQuerella () {
        return new Querella();
    }

    public static Querella createQuerella ( long id_querella){
        return new Querella( id_querella );
    }


    public static Dispositivo createDispositivo (){
        return  new Dispositivo();
    }

    public static Dispositivo createDispositivo (long id_dispositivo){
        return new Dispositivo(id_dispositivo);
    }

    public static Historial_Conexion createHistorial_Conexion (){
        return  new Historial_Conexion();
    }

    public static Historial_Conexion createHistorial_Conexion (long id_historial){
        return new Historial_Conexion(id_historial);
    }


    public static ZonaSeguridad createZonaSeguridad (){
        return new ZonaSeguridad();
    }

    public static ZonaSeguridad createZonaSeguridad (long id_zona){
        return new ZonaSeguridad(id_zona);
    }

    //posicionamiento
    public  static Posicionamiento createPosicionamiento (){
        return new Posicionamiento();
    }

    public static Posicionamiento createPosicionamiento(long id_posicionamiento){
        return  new Posicionamiento(id_posicionamiento);
    }

    //alerta
    public static Alerta createAlerta () {
        return new Alerta();
    }

    public static Alerta createAlerta(long id_alerta){
        return new Alerta(id_alerta);
    }

    //evento
    public static Evento createEvento(){
        return new Evento();
    }

    public static Evento createEvento(long id_evento){
        return new Evento();
    }
}
