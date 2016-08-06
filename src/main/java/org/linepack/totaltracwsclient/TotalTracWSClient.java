package org.linepack.totaltracwsclient;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import org.linepack.totaltracwsclient.DAO.ParametroDAO;
import org.linepack.totaltracwsclient.DAO.RequisicaoDAO;
import org.linepack.totaltracwsclient.evento.AlertasPorVeiculo;
import org.linepack.totaltracwsclient.model.Parametro;
import org.linepack.totaltracwsclient.model.Requisicao;
import org.linepack.totaltracwsclient.util.Log;

/**
 *
 * @author Leandro
 */
@Stateless
public class TotalTracWSClient {

    @Schedule(second = "0", minute = "*/1", hour = "*", persistent = false)
    public static void main() throws IOException {
        try {
            Parametro parametro = new ParametroDAO().getByNamedQuery("getParametroAtivo");

            Date dataInicial = new Date();
            Date dataFinal = new Date();
            Requisicao requisicaoAnterior = new RequisicaoDAO().getByNamedQuery("getRequisicaoAtiva");
            Requisicao requisicaoNova = new Requisicao();
            if (requisicaoAnterior != null) {                
                requisicaoNova.setDataHoraInicial(requisicaoAnterior.getDataHoraFinal());
                requisicaoNova.setDataHoraFinal(new Date());                
            } else {                
                requisicaoNova.setDataHoraInicial(dataInicial);
                requisicaoNova.setDataHoraFinal(dataFinal);
            }
            AlertasPorVeiculo alertasPorVeiculo = new AlertasPorVeiculo();                        
            alertasPorVeiculo.getAlertasPorVeiculo(parametro, requisicaoNova);
        } catch (Exception e) {
            Log.write("Erro na Classe Main: " + Arrays.toString(e.getStackTrace()));            
        }
    }
}
