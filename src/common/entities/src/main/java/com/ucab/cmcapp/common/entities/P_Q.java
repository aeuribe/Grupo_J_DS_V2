package com.ucab.cmcapp.common.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//import com.ucab.cmcapp.common.entities;

@Entity
@Table ( name = "P_Q")
public class P_Q implements Serializable
{
    @Id
    @OneToOne
    @JoinColumn ( name = "id_querella")
    private Querella _id_querella;


    @Id
    @ManyToOne
    @JoinColumn ( name = "id_persona")
    private Persona _id_agresor;

    @Id
    @ManyToOne
    @JoinColumn ( name = "id_persona")
    private Persona _id_victima;

    public P_Q() {
    }

    public P_Q(Querella _id_querella, Persona _id_agresor, Persona _id_victima) {
        this._id_querella = _id_querella;
        this._id_agresor = _id_agresor;
        this._id_victima = _id_victima;
    }

    public Querella get_id_querella() {
        return _id_querella;
    }

    public void set_id_querella(Querella _id_querella) {
        this._id_querella = _id_querella;
    }

    public Persona get_id_agresor() {
        return _id_agresor;
    }

    public void set_id_agresor(Persona _id_agresor) {
        this._id_agresor = _id_agresor;
    }

    public Persona get_id_victima() {
        return _id_victima;
    }

    public void set_id_victima(Persona _id_victima) {
        this._id_victima = _id_victima;
    }
}
