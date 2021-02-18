package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import edu.eci.arsw.blueprints.services.FiltrosServices;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;
/**
 *
 * @author Verbo Camacho,Nikolai Bermudez
 */
public class FiltroRedundanciaTest  {
    /**
     * Se agregan 3 puntos iguales
     * el Filtro Redundancia deberia borrar 2 y dejar un solo punto
     */
    @Test
    public void deberiaRedundancia() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author1 = "Nik";
        String name1 = "Whithepalms";
        Point[] puntos = new Point[]{
                new Point(-10, 20),
                new Point(-10, 20),
                new Point(-10, 20)};
        Blueprint blueprintone = new Blueprint(author1, name1, puntos);
        FlServices.filtroredu(blueprintone);
       // la longitud de la lista de puntos de blueprint debe ser igual a 1
        assertEquals(1,blueprintone.getPoints().size());
    }
    /**
     * Se agregan 6 puntos, hay 4 puntos iguales consecutivos
     * el Filtro Redundancia deberia borrar 2 y dejar 4 puntos
     */
    @Test
    public void deberiaRedundancia2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author1 = "Nik";
        String name1 = "Whithepalms";
        Point[] puntos = new Point[]{
                new Point(-10, 20),
                new Point(1, 10),
                new Point(-10, 20),
                new Point(-10, 20),
                new Point(10, 10),
                new Point(10, 10)};
        Blueprint blueprintone = new Blueprint(author1, name1, puntos);
        FlServices.filtroredu(blueprintone);
        // la longitud de la lista de puntos de blueprint debe ser igual a 4
        assertEquals(4,blueprintone.getPoints().size());

    }
    /**
     * Se agregan 2 puntos iguales
     * el Filtro Redundancia deberia borrar 1 y dejar un solo punto
     */
    @Test
    public void deberiaRedundancia3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author1 = "Nik";
        String name1 = "Whithepalms";
        Point[] puntos = new Point[]{
                new Point(-10, 20),
                new Point(-10, 20)};
        Blueprint blueprintone = new Blueprint(author1, name1, puntos);
        FlServices.filtroredu(blueprintone);
        // la longitud de la lista de puntos de blueprint debe ser igual a 1
        assertEquals(1,blueprintone.getPoints().size());
    }
    /**
     * Se agregan 2 puntos diferentes
     * el Filtro Redundancia no deberia borrar
     */
    @Test
    public void deberiaRedundancia4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author1 = "Nik";
        String name1 = "Whithepalms";
        Point[] puntos = new Point[]{
                new Point(-10, 20),
                new Point(-10, 30)};
        Blueprint blueprintone = new Blueprint(author1, name1, puntos);
        FlServices.filtroredu(blueprintone);
        // la longitud de la lista de puntos de blueprint debe ser igual a 2
        assertEquals(2,blueprintone.getPoints().size());
    }
    /**
     * Se agregan 3 puntos
     * el Filtro Muestreo deberia borrar 1 y dejar 2 puntos
     */
    @Test
    public void deberiaMuestreo() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author2 = "Verb";
        String name2 = "Bigman";
        Point[] puntos = new Point[]{
                new Point(90, 20),
                new Point(-10, 16),
                new Point(-60, 17)};
        Blueprint blueprinttwo = new Blueprint(author2, name2, puntos);
        FlServices.filtromue(blueprinttwo);
        // la longitud de la lista de puntos de blueprint debe ser igual a 2
        assertEquals(2,blueprinttwo.getPoints().size());


    }
    /**
     * Se agregan 4 puntos
     * el Filtro Muestreo deberia borrar 2 y dejar 2 puntos
     */
    @Test
    public void deberiaMuestreo2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author2 = "Verb";
        String name2 = "Bigman";
        Point[] puntos = new Point[]{
                new Point(90, 20),
                new Point(-10, 16),
                new Point(-10, 26),
                new Point(-60, 17)};
        Blueprint blueprinttwo = new Blueprint(author2, name2, puntos);
        FlServices.filtromue(blueprinttwo);
        // la longitud de la lista de puntos de blueprint debe ser igual a 2
        assertEquals(2,blueprinttwo.getPoints().size());

    }
    /**
     * Se agregan 6 puntos
     * el Filtro Muestreo deberia borrar 3 y dejar 3 puntos
     */
    @Test
    public void deberiaMuestreo3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author2 = "Verb";
        String name2 = "Bigman";
        Point[] puntos = new Point[]{
                new Point(90, 20),
                new Point(-10, 16),
                new Point(-10, 26),
                new Point(-10, 16),
                new Point(-10, 26),
                new Point(-60, 17)};
        Blueprint blueprinttwo = new Blueprint(author2, name2, puntos);
        FlServices.filtromue(blueprinttwo);
        // la longitud de la lista de puntos de blueprint debe ser igual a 3
        assertEquals(3,blueprinttwo.getPoints().size());
    }
    /**
     * Se agregan 2 puntos
     * el Filtro Muestreo deberia borrar 2 y dejar 1 puntos
     */
    @Test
    public void deberiaMuestreo4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        FiltrosServices FlServices=ac.getBean(FiltrosServices.class);
        String author2 = "Verb";
        String name2 = "Bigman";
        Point[] puntos = new Point[]{
                new Point(90, 20),
                new Point(-60, 17)};
        Blueprint blueprinttwo = new Blueprint(author2, name2, puntos);
        FlServices.filtromue(blueprinttwo);
        // la longitud de la lista de puntos de blueprint debe ser igual a 1
        assertEquals(1,blueprinttwo.getPoints().size());
    }
}