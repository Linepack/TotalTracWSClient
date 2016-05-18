package org.linepack.evento;

import java.io.File;
import java.text.SimpleDateFormat;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.linepack.model.Parametro;
import org.linepack.model.Requisicao;
import webservice.gslog.systemsat.ListaAlertasPorEventoResponse;
import webservice.gslog.systemsat.ListaAlertasPorVeiculo;
import webservice.gslog.systemsat.Posicoes;
import webservice.gslog.systemsat.PosicoesSoap;

/**
 *
 * @author Leandro
 */
public class AlertasPorVeiculo {

    public void getAlertasPorVeiculo(Parametro parametro, Requisicao requisicao) throws JAXBException {
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

        ListaAlertasPorEventoResponse resposta = new ListaAlertasPorEventoResponse();

        resposta.setListaAlertasPorEventoResult(
                soap.listaAlertasPorVeiculo(alertas.getEmpCliente(), alertas.getLogin(),
                        alertas.getSenha(), alertas.getDataInicial(), alertas.getDataFinal(),
                        "", true));

    }

}
