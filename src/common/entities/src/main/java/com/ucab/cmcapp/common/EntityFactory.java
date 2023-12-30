package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory

{
    /**
     * Method that returns an instance of User class
     */
    public static User createUser()
    {
        return new User();
    }

    /**
     * Method that returns an instance of User class
     */
    public static User createUser(long id)
    {
        return new User(id);
    }

    /**
     * Method that returns an instance of UserType class
     */
    public static UserType createUserType()
    {
        return new UserType();
    }

    /**
     * Method that returns an instance of UserType class
     */
    public static UserType createUserType(long id)
    {
        return new UserType(id);
    }

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


    public static Querella createQuerella () {
        return new Querella();
    }

    public static Querella createQuerella ( long id_querella){
        return new Querella( id_querella );
    }


    public static P_Q createP_Q(){
        return createP_Q();
    }

    public static P_Q createP_Q( Querella id_querella, Persona id_agresor, Persona id_victima ){
        return new P_Q( id_querella, id_agresor, id_victima);

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

    public static Zona_de_Seguridad createZona_de_Seguridad (){
        return new Zona_de_Seguridad();
    }

    public static Zona_de_Seguridad createZona_de_Seguridad (long id_zona){
        return new Zona_de_Seguridad(id_zona);
    }

    public static D_Z createD_Z (){
        return new D_Z();
    }

    public static D_Z createD_Z (Zona_de_Seguridad id_zona, Dispositivo id_dispositivo){
        return new D_Z(id_zona, id_dispositivo);
    }

    //posicionamiento
    public  static Posicionamiento createPosicionamiento (){
        return new Posicionamiento();
    }

    public static Posicionamiento createPosicionamiento(long id_posicionamiento){
        return  new Posicionamiento(id_posicionamiento);
    }

    //alerta
    public static Alerta craeteAlerta () {
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
