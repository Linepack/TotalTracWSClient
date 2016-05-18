package org.linepack;
import java.io.IOException;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import org.linepack.DAO.ParametroDAO;
import org.linepack.DAO.RequisicaoDAO;
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
    public static void main() throws IOException{
        
        Parametro parametro = new ParametroDAO().getByNamedQuery("getParametroAtivo");
        
        Date dataInicial = new Date();
        Date dataFinal = new Date();
        Requisicao requisicao = new RequisicaoDAO().getByNamedQuery("getRequisicaoAtiva");
        if (requisicao != null){
            dataInicial = requisicao.getDataHoraFinal();
            dataFinal = new Date();            
        } else {
            requisicao.setDataHoraInicial(dataInicial);
            requisicao.setDataHoraFinal(dataFinal);
        }                     
                        
        /*
        System.out.println("Entrou!");
        AlertasPorVeiculo alertasPorVeiculo = new AlertasPorVeiculo();
        alertasPorVeiculo.getAlertasPorVeiculo();*/
    }
}
