package org.linepack;

import java.io.IOException;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import org.linepack.DAO.ParametroDAO;
import org.linepack.DAO.RequisicaoDAO;
import org.linepack.evento.AlertasPorVeiculo;
import org.linepack.model.Parametro;
import org.linepack.model.Requisicao;
import org.linepack.util.Log;

/**
 *
 * @author Leandro
 */
@Stateless
public class TotalTracWSClient {

    @Schedule(second = "*/3", minute = "*", hour = "*", persistent = false)
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
            Log.write("Erro na Classe Main: " + e.getMessage());
        }
    }
}
