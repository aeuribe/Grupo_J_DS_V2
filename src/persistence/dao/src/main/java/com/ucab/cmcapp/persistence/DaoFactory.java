package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.common.entities.Posicionamiento;
import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory
{
    private DaoFactory() {}

    public static UserDao createUserDao( DBHandler handler )
    {
        return new UserDao( handler );
    }

    public static UsuarioDao createUsuarioDao ( DBHandler handler){
        return new UsuarioDao( handler );
    }

    public static PersonaDao createPersonaDao ( DBHandler handler){
        return new PersonaDao( handler );
    }

    public  static QuerellaDao createQuerellaDao ( DBHandler handler){
        return new QuerellaDao( handler );
    }

    public  static DispositivoDao createDispositivoDao ( DBHandler handler ){
        return new DispositivoDao( handler );
    }

    public  static Historial_ConexionDao createHistorial_ConexionDao ( DBHandler handler ){
        return new Historial_ConexionDao( handler );
    }

    public  static Zona_de_SeguridadDao createZona_de_SeguridadDao ( DBHandler handler ){
        return new Zona_de_SeguridadDao( handler );
    }


    public static PosicionamientoDao createPosicionamientoDao ( DBHandler handler ){
        return new PosicionamientoDao( handler );
    }

    public static EventoDao createEventoDao ( DBHandler handler ){
        return new EventoDao( handler );
    }

    public static AlertaDao createAlertaDao (DBHandler handler ){
        return new AlertaDao( handler );
    }
}

