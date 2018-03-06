package Db;

import Entities.CalculatorEntity;
import Entities.IntegrationEntity;
import Entities.SlauEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBOperations {
    public List<CalculatorEntity> getCalc(){
        EntityManager em = EclipseLinkEM.getEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM calculator");
        List<Object> objectList=query.getResultList();

        List<CalculatorEntity> result = new ArrayList<CalculatorEntity>();
        Iterator it = objectList.iterator();
        while(it.hasNext()){
            Object[] o = (Object[])it.next();
            result.add(new CalculatorEntity(
                    Integer.valueOf(String.valueOf(o[0])),
                    Double.valueOf(String.valueOf(o[1])),
                    Double.valueOf(String.valueOf(o[2])),
                    String.valueOf(o[3]),
                    Double.valueOf(String.valueOf(o[4]))));
        }
        return result;
    }
    public void setCalc(double x, double y, String op,double answer){
        EntityManager em = EclipseLinkEM.getEntityManager();
        CalculatorEntity myCalc = new CalculatorEntity(x,y,op,answer);
        em.getTransaction().begin();
        em.persist(myCalc);
        em.getTransaction().commit();
    }

    public List<IntegrationEntity> getIntegr(){
        EntityManager em = EclipseLinkEM.getEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM Integration");
        List<Object> objectList=query.getResultList();

        List<IntegrationEntity> result = new ArrayList<IntegrationEntity>();
        Iterator it = objectList.iterator();
        while(it.hasNext()){
            Object[] o = (Object[])it.next();
            result.add(new IntegrationEntity(
                    Integer.valueOf(String.valueOf(o[0])),
                    Double.valueOf(String.valueOf(o[1])),
                    Double.valueOf(String.valueOf(o[2])),
                    Double.valueOf(String.valueOf(o[3])),
                    Double.valueOf(String.valueOf(o[4])),
                    Integer.valueOf(String.valueOf(o[5])),
                    Double.valueOf(String.valueOf(o[6])),
                    Double.valueOf(String.valueOf(o[7])),
                    Double.valueOf(String.valueOf(o[8]))));
        }
        return result;
    }
    public void setIntegr(double cX3, double cX2, double cX,
                          double c, int numSteps, double leftLimit,
                          double rightLimit, double answer){
        EntityManager em = EclipseLinkEM.getEntityManager();
        IntegrationEntity myIntegr = new IntegrationEntity(cX3,cX2,cX,c,numSteps,leftLimit,rightLimit,answer);
        em.getTransaction().begin();
        em.persist(myIntegr);
        em.getTransaction().commit();
    }

    public List<SlauEntity> getSlau(){
        EntityManager em = EclipseLinkEM.getEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM slau");
        List<Object> objectList=query.getResultList();

        List<SlauEntity> result = new ArrayList<SlauEntity>();
        Iterator it = objectList.iterator();
        while(it.hasNext()){
            Object[] o = (Object[])it.next();
            result.add(new SlauEntity(
                    Integer.valueOf(String.valueOf(o[0])),
                    Integer.valueOf(String.valueOf(o[1])),
                    String.valueOf(o[2]),
                    String.valueOf(o[3])
                    ));
        }
        return result;
    }
    public void setSlau(int sizeSlau, String equations, String answer){
        EntityManager em = EclipseLinkEM.getEntityManager();
        SlauEntity mySlau = new SlauEntity(sizeSlau,equations,answer);
        em.getTransaction().begin();
        em.persist(mySlau);
        em.getTransaction().commit();
    }
}