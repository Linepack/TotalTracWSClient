package org.linepack.evento;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import webservice.gslog.systemsat.ListaAlertasPorEventoResponse;
import webservice.gslog.systemsat.ListaAlertasPorVeiculo;
import webservice.gslog.systemsat.Posicoes;
import webservice.gslog.systemsat.PosicoesSoap;

/**
 *
 * @author Leandro
 */
public class AlertasPorVeiculo {

    public void getAlertasPorVeiculo() throws JAXBException {
        ListaAlertasPorVeiculo alertas = new ListaAlertasPorVeiculo();
        alertas.setEmpCliente("138481");
        alertas.setLogin("unicampo@totaltrac");
        alertas.setSenha("unicampo@totaltrac");
        alertas.setDataInicial("17/05/2016 23:00:00");
        alertas.setDataFinal("18/05/2016 05:00:00");        
        //alertas.setIdentificacaoIntegracao("AYP-0877");
                        
        Posicoes port = new Posicoes();
        PosicoesSoap soap = port.getPosicoesSoap();

        ListaAlertasPorEventoResponse resposta = new ListaAlertasPorEventoResponse();

        resposta.setListaAlertasPorEventoResult(
                soap.listaAlertasPorVeiculo(alertas.getEmpCliente(), alertas.getLogin(),
                        alertas.getSenha(), alertas.getDataInicial(), alertas.getDataFinal(),
                        "", true));
        
        JAXBContext context = JAXBContext.newInstance(ListaAlertasPorEventoResponse.class);
        Marshaller m = context.createMarshaller();        
        File file = new File("C:\\Users\\Leandro\\Desktop\\RESPOSTA.XML");
        m.marshal(resposta, file);

    }

}
