/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.linepack.totaltracwsclient.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "ge_totaltrac_posicao")
public class Posicao extends BaseModel implements Serializable {

    private String idPosicao;
    private String idVeiculo;
    private String idCliente;
    private String identificacaoMotorista;
    private String nomeMotorista;
    private String observacao;
    private String anotacao;
    private String isAlerta;
    private String idFornecedorLocalizacao;
    private String descricaoVeiculo;
    private String identificacaoVeiculo;
    private String identificacaoIntegracao;
    private String placa;
    private String nomeCliente;
    private String idEvento;
    private String descricaoEvento;
    private String numeroSerie;
    private String latitude;
    private String longitude;
    private String direcao;
    private String velocidade;
    private String rpm;
    private String odometro;
    private String ignicao;
    private String temperatura;
    private String temperaturaSensor1;
    private String temperaturaSensor2;
    private String temperaturaSensor3;
    private String unidadeTemperatura;
    private String altitude;
    private String nivelBateria;
    private String nivelBateriaPrincipal;
    private String unidadeBateria;
    private String nivelSinal;
    private String numeroSatelite;
    private String statusEntradas;
    private String statusSaidas;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGPS;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataServidor;
    private String localizacao;
    private String horimetro;

    public String getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(String idPosicao) {
        this.idPosicao = idPosicao;
    }

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdentificacaoMotorista() {
        return identificacaoMotorista;
    }

    public void setIdentificacaoMotorista(String identificacaoMotorista) {
        this.identificacaoMotorista = identificacaoMotorista;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public String getIsAlerta() {
        return isAlerta;
    }

    public void setIsAlerta(String isAlerta) {
        this.isAlerta = isAlerta;
    }

    public String getIdFornecedorLocalizacao() {
        return idFornecedorLocalizacao;
    }

    public void setIdFornecedorLocalizacao(String idFornecedorLocalizacao) {
        this.idFornecedorLocalizacao = idFornecedorLocalizacao;
    }

    public String getDescricaoVeiculo() {
        return descricaoVeiculo;
    }

    public void setDescricaoVeiculo(String descricaoVeiculo) {
        this.descricaoVeiculo = descricaoVeiculo;
    }

    public String getIdentificacaoVeiculo() {
        return identificacaoVeiculo;
    }

    public void setIdentificacaoVeiculo(String identificacaoVeiculo) {
        this.identificacaoVeiculo = identificacaoVeiculo;
    }

    public String getIdentificacaoIntegracao() {
        return identificacaoIntegracao;
    }

    public void setIdentificacaoIntegracao(String identificacaoIntegracao) {
        this.identificacaoIntegracao = identificacaoIntegracao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }

    public String getRpm() {
        return rpm;
    }

    public void setRpm(String rpm) {
        this.rpm = rpm;
    }

    public String getOdometro() {
        return odometro;
    }

    public void setOdometro(String odometro) {
        this.odometro = odometro;
    }

    public String getIgnicao() {
        return ignicao;
    }

    public void setIgnicao(String ignicao) {
        this.ignicao = ignicao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTemperaturaSensor1() {
        return temperaturaSensor1;
    }

    public void setTemperaturaSensor1(String temperaturaSensor1) {
        this.temperaturaSensor1 = temperaturaSensor1;
    }

    public String getTemperaturaSensor2() {
        return temperaturaSensor2;
    }

    public void setTemperaturaSensor2(String temperaturaSensor2) {
        this.temperaturaSensor2 = temperaturaSensor2;
    }

    public String getTemperaturaSensor3() {
        return temperaturaSensor3;
    }

    public void setTemperaturaSensor3(String temperaturaSensor3) {
        this.temperaturaSensor3 = temperaturaSensor3;
    }

    public String getUnidadeTemperatura() {
        return unidadeTemperatura;
    }

    public void setUnidadeTemperatura(String unidadeTemperatura) {
        this.unidadeTemperatura = unidadeTemperatura;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(String nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public String getNivelBateriaPrincipal() {
        return nivelBateriaPrincipal;
    }

    public void setNivelBateriaPrincipal(String nivelBateriaPrincipal) {
        this.nivelBateriaPrincipal = nivelBateriaPrincipal;
    }

    public String getUnidadeBateria() {
        return unidadeBateria;
    }

    public void setUnidadeBateria(String unidadeBateria) {
        this.unidadeBateria = unidadeBateria;
    }

    public String getNivelSinal() {
        return nivelSinal;
    }

    public void setNivelSinal(String nivelSinal) {
        this.nivelSinal = nivelSinal;
    }

    public String getNumeroSatelite() {
        return numeroSatelite;
    }

    public void setNumeroSatelite(String numeroSatelite) {
        this.numeroSatelite = numeroSatelite;
    }

    public String getStatusEntradas() {
        return statusEntradas;
    }

    public void setStatusEntradas(String statusEntradas) {
        this.statusEntradas = statusEntradas;
    }

    public String getStatusSaidas() {
        return statusSaidas;
    }

    public void setStatusSaidas(String statusSaidas) {
        this.statusSaidas = statusSaidas;
    }

    public Date getDataGPS() {
        return dataGPS;
    }

    public void setDataGPS(Date dataGPS) {
        this.dataGPS = dataGPS;
    }

    public Date getDataServidor() {
        return dataServidor;
    }

    public void setDataServidor(Date dataServidor) {
        this.dataServidor = dataServidor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getHorimetro() {
        return horimetro;
    }

    public void setHorimetro(String horimetro) {
        this.horimetro = horimetro;
    }

}
