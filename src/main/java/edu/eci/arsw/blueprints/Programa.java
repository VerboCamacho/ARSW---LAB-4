package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;

import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.FiltroRedundancia;
import edu.eci.arsw.blueprints.persistence.impl.Filtrosubmuestreo;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import edu.eci.arsw.blueprints.services.FiltrosServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bpServices = ac.getBean(BlueprintsServices.class);
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author1 = "Nik";
        String author2 = "Verb";
        String name1 = "Whithepalms";
        String name2 = "Bigman";
        Point[] puntos = new Point[]{ new Point(-10, 10),new Point(-10, 10),new Point(-10, 10)};
        Blueprint blueprintone = new Blueprint(author1, name1, puntos);
        Blueprint blueprinttwo = new Blueprint(author2, name2, puntos);
        FiltroRedundancia pre=new FiltroRedundancia();
        pre.setBluepri(blueprintone);
        Filtrosubmuestreo pre2=new Filtrosubmuestreo();
        pre2.setBluepri(blueprinttwo);
        try {
            bpServices.addNewBlueprint(blueprintone);
            bpServices.addNewBlueprint(blueprinttwo);
            System.out.println("prueba filtro sub muestreo");
            for (Point p:blueprinttwo.getPoints()){
              System.out.println(p.getX()+" "+p.getY());
            }
            System.out.println("--------------------------------------");
            System.out.println("prueba filtro redundancia");
            for (Point p:blueprintone.getPoints()){
                System.out.println(p.getX()+" "+p.getY());
            }

        } catch (BlueprintPersistenceException e) {
            e.printStackTrace();
        }
    }
}