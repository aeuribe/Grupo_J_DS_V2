package com.ucab.cmcapp.logic.dtos;

public class P_QDto extends BaseDto{
    private PersonaDto _id_agresor;
    private PersonaDto _id_victima;
    private QuerellaDto _id_querella;

    public P_QDto() {
    }

    public P_QDto(long id, PersonaDto _id_agresor, PersonaDto _id_victima, QuerellaDto _id_querella) {
        super(id);
        this._id_agresor = _id_agresor;
        this._id_victima = _id_victima;
        this._id_querella = _id_querella;
    }

    public PersonaDto get_id_agresor() {
        return _id_agresor;
    }

    public void set_id_agresor(PersonaDto _id_agresor) {
        this._id_agresor = _id_agresor;
    }

    public PersonaDto get_id_victima() {
        return _id_victima;
    }

    public void set_id_victima(PersonaDto _id_victima) {
        this._id_victima = _id_victima;
    }

    public QuerellaDto get_id_querella() {
        return _id_querella;
    }

    public void set_id_querella(QuerellaDto _id_querella) {
        this._id_querella = _id_querella;
    }
}
