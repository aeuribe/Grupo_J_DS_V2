package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.exceptions.AuthenticationException;
import com.ucab.cmcapp.common.util.JWT;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.composite.AuthenticateUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/auth")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class AuthService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(AuthService.class);

    @POST
    @Path("/login")
    public Response loginUser(UsuarioDto UsuarioDto) {
        //region Instrumentation DEBUG
        _logger.debug("POST in AuthService.loginUser");
        //endregion
        Usuario entity;
        UsuarioDto authenticatedUser;
        AuthenticateUsuarioCommand authCommand = null;

        try {
            // Lógica de autenticación
            entity = UsuarioMapper.mapDtoToEntity(UsuarioDto);
            authCommand = CommandFactory.createAuthenticateUsuarioCommand( entity );
            authCommand.execute();
            authenticatedUser = UsuarioMapper.mapEntityToDto(authCommand.getReturnParam());

            // Generar token JWT después de la autenticación exitosa
            String jwtToken = JWT.createToken(authenticatedUser.get_correo_electronico());

            if (authenticatedUser.getRol().equals("ADMIN")){
                // Devolver el token como respuesta
                return Response.ok().entity(jwtToken).build();
            }


        } catch (AuthenticationException e) {
            _logger.error("Authentication failed: {}", e.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity("Authentication failed").build();
        } catch (Exception e) {
            _logger.error("Error during login: {}", e.getMessage());
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build());
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("Authentication failed").build();
    }
}
