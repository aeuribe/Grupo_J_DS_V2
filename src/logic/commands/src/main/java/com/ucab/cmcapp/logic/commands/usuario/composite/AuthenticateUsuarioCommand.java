package com.ucab.cmcapp.logic.commands.usuario.composite;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByEmailCommand;

import com.ucab.cmcapp.common.entities.Usuario;

public class AuthenticateUsuarioCommand extends Command<Usuario>
{
    private Usuario _user;
    private Usuario _result;
    private GetUsuarioByEmailCommand _getUserCommand;


    public AuthenticateUsuarioCommand(Usuario usuario) {
        _user = usuario;
        /*        _user = new Usuario();
        _user.set_correo_electronico(email);
        _user.set_password(password);*/
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            getHandler().beginTransaction();

            // Obtener el usuario por nombre de usuario
            _getUserCommand = CommandFactory.createGetUsuarioByEmailCommand(_user, getHandler());
            _getUserCommand.execute();
            Usuario storedUser = _getUserCommand.getReturnParam();

            // Verificar la autenticación
            if (storedUser != null && storedUser.get_password().equals(_user.get_password())) {
                _result = storedUser;
            } else {
                // La autenticación falla si el usuario no existe o la contraseña no coincide
                _result = null;
            }

            getHandler().finishTransaction();
            getHandler().closeSession();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Usuario getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
