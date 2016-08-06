package org.linepack.totaltracwsclient.evento;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.linepack.totaltracwsclient.DAO.PosicaoDAO;
import org.linepack.totaltracwsclient.DAO.RequisicaoDAO;
import org.linepack.totaltracwsclient.model.Parametro;
import org.linepack.totaltracwsclient.model.Requisicao;
import org.linepack.totaltracwsclient.util.Log;
import webservice.gslog.systemsat.ListaAlertasPorEventoResponse;
import webservice.gslog.systemsat.ListaAlertasPorVeiculo;
import webservice.gslog.systemsat.Posicao;
import webservice.gslog.systemsat.Posicoes;
import webservice.gslog.systemsat.PosicoesSoap;

/**
 *
 * @author Leandro
 */
public class AlertasPorVeiculo {

    public void getAlertasPorVeiculo(Parametro parametro, Requisicao requisicao) throws IOException {
        try {
            ListaAlertasPorVeiculo alertas = new ListaAlertasPorVeiculo();
            alertas.setEmpCliente(parametro.getCodigoClienteTotalTrac().toString());
            alertas.setLogin(parametro.getLogin());
            alertas.setSenha(parametro.getSenha());
            String mask = "dd/MM/yyyy HH:mm:ss";
            SimpleDateFormat dateFormat = new SimpleDateFormat(mask);
            alertas.setDataInicial(dateFormat.format(requisicao.getDataHoraInicial()));
            alertas.setDataFinal(dateFormat.format(requisicao.getDataHoraFinal()));
                        
            //Call remote Method
            Posicoes port = new Posicoes();
            PosicoesSoap soap = port.getPosicoesSoap();
            
            Log.write("Feito A requisicao ao WS");
            ListaAlertasPorEventoResponse resposta = new ListaAlertasPorEventoResponse();

            resposta.setListaAlertasPorEventoResult(
                    soap.listaAlertasPorVeiculo(alertas.getEmpCliente(), alertas.getLogin(),
                            alertas.getSenha(), alertas.getDataInicial(), alertas.getDataFinal(),
                            "", true));

            for (Posicao posicaoWs : resposta.getListaAlertasPorEventoResult().getPosicao()) {
                org.linepack.totaltracwsclient.model.Posicao posicaoModel = new org.linepack.totaltracwsclient.model.Posicao();
                posicaoModel.setIdPosicao(String.valueOf(posicaoWs.getIdPosicao()));
                posicaoModel.setIdVeiculo(String.valueOf(posicaoWs.getIdVeiculo()));
                posicaoModel.setIdCliente(String.valueOf(posicaoWs.getIdCliente()));
                posicaoModel.setIdentificacaoMotorista(posicaoWs.getIdentificacaoMotorista());
                posicaoModel.setNomeMotorista(posicaoWs.getNomeMotorista());
                posicaoModel.setObservacao(posicaoWs.getObservacao());
                posicaoModel.setAnotacao(posicaoWs.getAnotacao());
                posicaoModel.setIsAlerta(String.valueOf(posicaoWs.isIsAlerta()));
                posicaoModel.setIdFornecedorLocalizacao(String.valueOf(posicaoWs.getIdFornecedorLocalizacao()));
                posicaoModel.setDescricaoVeiculo(posicaoWs.getDescricaoVeiculo());
                posicaoModel.setIdentificacaoVeiculo(posicaoWs.getIdentificacaoVeiculo());
                posicaoModel.setIdentificacaoIntegracao(posicaoWs.getIdentificacaoIntegracao());
                posicaoModel.setPlaca(posicaoWs.getPlaca());
                posicaoModel.setNomeCliente(posicaoWs.getNomeCliente());
                posicaoModel.setIdEvento(String.valueOf(posicaoWs.getIdEvento()));
                posicaoModel.setDescricaoEvento(posicaoWs.getDescricaoEvento());
                posicaoModel.setNumeroSerie(posicaoWs.getNumeroSerie());
                posicaoModel.setLatitude(String.valueOf(posicaoWs.getLatitude()));
                posicaoModel.setLongitude(String.valueOf(posicaoWs.getLongitude()));
                posicaoModel.setDirecao(String.valueOf(posicaoWs.getDirecao()));
                posicaoModel.setVelocidade(String.valueOf(posicaoWs.getVelocidade()));
                posicaoModel.setRpm(String.valueOf(posicaoWs.getRPM()));
                posicaoModel.setOdometro(String.valueOf(posicaoWs.getOdometro()));
                posicaoModel.setIgnicao(String.valueOf(posicaoWs.isIgnicao()));
                posicaoModel.setTemperatura(String.valueOf(posicaoWs.getTemperatura()));
                posicaoModel.setTemperaturaSensor1(String.valueOf(posicaoWs.getTemperaturaSensor1()));
                posicaoModel.setTemperaturaSensor2(String.valueOf(posicaoWs.getTemperaturaSensor2()));
                posicaoModel.setTemperaturaSensor3(String.valueOf(posicaoWs.getTemperaturaSensor3()));
                posicaoModel.setUnidadeTemperatura(posicaoWs.getUnidadeTemperatura());
                posicaoModel.setAltitude(String.valueOf(posicaoWs.getAltitude()));
                posicaoModel.setNivelBateria(String.valueOf(posicaoWs.getNivelBateria()));
                posicaoModel.setNivelBateriaPrincipal(String.valueOf(posicaoWs.getNivelBateriaPrincipal()));
                posicaoModel.setUnidadeBateria(posicaoWs.getUnidadeBateria());
                posicaoModel.setNivelSinal(String.valueOf(posicaoWs.getNivelSinal()));
                posicaoModel.setNumeroSatelite(String.valueOf(posicaoWs.getNumeroSatelite()));
                posicaoModel.setStatusEntradas(posicaoWs.getStatusEntradas());
                posicaoModel.setStatusSaidas(posicaoWs.getStatusSaidas());
                posicaoModel.setDataGPS(posicaoWs.getDataGPS().toGregorianCalendar().getTime());
                posicaoModel.setDataServidor(posicaoWs.getDataServidor().toGregorianCalendar().getTime());
                posicaoModel.setLocalizacao(posicaoWs.getLocalizacao());
                posicaoModel.setHorimetro(String.valueOf(posicaoWs.getHorimetro()));      
                posicaoModel.setDataInclusao(new Date());
                posicaoModel.setNomeInclusao("JAVA");
                PosicaoDAO posicaoDAO = new PosicaoDAO();
                posicaoDAO.insert(posicaoModel);
            }

            RequisicaoDAO requisicaoDAO = new RequisicaoDAO();
            requisicao.setDataInclusao(new Date());
            requisicao.setNomeInclusao("JAVA");
            requisicaoDAO.insert(requisicao);

        } catch (Exception e) {
            Log.write("Erro ao realizar requisicao: " + e.toString());
        }

    }


  

}
