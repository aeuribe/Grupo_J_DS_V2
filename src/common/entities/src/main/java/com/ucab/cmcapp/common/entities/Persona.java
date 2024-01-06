package com.ucab.cmcapp.common.entities;
import javax.persistence.*;
import java.util.Date;
//import com.ucab.cmcapp.common.entities;

/**
 * Name:                Persona.
 * Description:         Entity Persona.
 */
@Entity
@Table(name = "PERSONA")
public class Persona {

    @Id
    @Column (name = "id_persona")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long _id_persona;


    @Column (name = "p_nombre")
    private String _primer_nombre;

    @Column (name = "p_apellido")
    private String _primer_apellido;

    @Column (name = "s_nombre")
    private String _segundo_nombre;

    @Column (name = "s_apellido")
    private String _segundo_apellido;

    @Column (name = "sexo")
    private char _sexo;

    @Column (name = "fec_nac")
    private Date fec_nac;


    public Persona(Long _id_persona, String _primer_nombre, String _primer_apellido, String _segundo_nombre, String _segundo_apellido, char _sexo, Date fec_nac, Usuario usuario) {
        this._id_persona = _id_persona;
        this._primer_nombre = _primer_nombre;
        this._primer_apellido = _primer_apellido;
        this._segundo_nombre = _segundo_nombre;
        this._segundo_apellido = _segundo_apellido;
        this._sexo = _sexo;
        this.fec_nac = fec_nac;
    }

    public Persona() {
    }

    public Persona(Long _id_persona) {
        this._id_persona = _id_persona;
    }

    public Long get_id_persona() {
        return _id_persona;
    }

    public String get_primer_nombre() {
        return _primer_nombre;
    }

    public String get_primer_apellido() {
        return _primer_apellido;
    }

    public String get_segundo_nombre() {
        return _segundo_nombre;
    }

    public String get_segundo_apellido() {
        return _segundo_apellido;
    }

    public char get_sexo() {
        return _sexo;
    }

    public Date getFec_nac() {
        return fec_nac;
    }

    public void set_id_persona(Long _id_persona) {
        this._id_persona = _id_persona;
    }

    public void set_primer_nombre(String _primer_nombre) {
        this._primer_nombre = _primer_nombre;
    }

    public void set_primer_apellido(String _primer_apellido) {
        this._primer_apellido = _primer_apellido;
    }

    public void set_segundo_nombre(String _segundo_nombre) {
        this._segundo_nombre = _segundo_nombre;
    }

    public void set_segundo_apellido(String _segundo_apellido) {
        this._segundo_apellido = _segundo_apellido;
    }

    public void set_sexo(char _sexo) {
        this._sexo = _sexo;
    }

    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }


}
