package org.linepack;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.linepack.model.Parametro;
import org.linepack.util.EntityManagerUtil;

/**
 *
 * @author Leandro
 */
@Stateless
public class TotalTracWSClient {    
    
    @Schedule(second = "*/3", minute = "*", hour = "*", persistent = false)
    public static void main(){
                                
        
        Parametro parametro = new Parametro();             
        EntityManager em = new EntityManagerUtil().getEntityManager();                        
        parametro = em.find(Parametro.class, 1);
        
        System.out.println(parametro.getCodigoClienteTotalTrac());
        
        /*
        System.out.println("Entrou!");
        AlertasPorVeiculo alertasPorVeiculo = new AlertasPorVeiculo();
        alertasPorVeiculo.getAlertasPorVeiculo();*/
    }
}
