
package com.mycompany.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;


public class PhaseListenerSemeru implements PhaseListener
{
//antes da face
    @Override
    public void beforePhase(PhaseEvent fase) {
        if( fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Antes da fase" +getPhaseId());
            //vai iniciar a transaçao setar na requeest a sessao do hibernate
            Session session=HibernateUtil.getSessionfactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
            
        }
    }
    //Depois da face
    @Override
    public void afterPhase(PhaseEvent fase) {
         System.out.println("Depois da fase" +getPhaseId());
        if(fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
            
            Session session =FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                //se ocorreu algo errado e a sesão ainda estar ativa
                if(session.getTransaction().isActive()){
                    //ver o que estar inserido no banco rolback,disfaz o que foi feito
                    session.beginTransaction().rollback(); 
                }
            }finally{
                session.close();
            }
        }
        
    }

    
//usado em todas as faces usado para abertura e fechamento de sessao com o banco de Dados
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
