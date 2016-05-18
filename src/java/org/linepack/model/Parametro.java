/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.linepack.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "ge_totaltrac_parametro")
@NamedQuery(name = "getParametroAtivo", query = "select p from Parametro p where p.isAtivo = 1")
public class Parametro extends BaseModel implements Serializable {

    @Column(name = "empcliente")
    private Integer codigoClienteTotalTrac;
    private String login;
    private String senha;
    @Column(name = "st_ativo")
    private Integer isAtivo;

    public Integer getCodigoClienteTotalTrac() {
        return codigoClienteTotalTrac;
    }

    public void setCodigoClienteTotalTrac(Integer codigoClienteTotalTrac) {
        this.codigoClienteTotalTrac = codigoClienteTotalTrac;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(Integer isAtivo) {
        this.isAtivo = isAtivo;
    }

}
