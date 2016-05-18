/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.linepack.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "ge_totaltrac_requisicoes")
public class Requisicao extends BaseModel implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_inicial")
    private Date dataHoraInicial;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_final")
    private Date dataHoraFinal;

    public Date getDataHoraInicial() {
        return dataHoraInicial;
    }

    public void setDataHoraInicial(Date dataHoraInicial) {
        this.dataHoraInicial = dataHoraInicial;
    }

    public Date getDataHoraFinal() {
        return dataHoraFinal;
    }

    public void setDataHoraFinal(Date dataHoraFinal) {
        this.dataHoraFinal = dataHoraFinal;
    }

}
