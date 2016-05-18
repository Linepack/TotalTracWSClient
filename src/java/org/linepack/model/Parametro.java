/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.linepack.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "ge_totaltrac_parametros")
public class Parametro extends BaseModel implements Serializable {

    @Column(name = "empcliente")
    private Integer codigoClienteTotalTrac;
    private String login;
    private String senha;
    

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
            
}
