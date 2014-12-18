/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

/**
 * complete constructor
 * @author Utilisateur
 */
public class Segment {

    private Point point1;
    private Point point2;
    private Triangle tridroit;
    private Triangle trigauche;
    private boolean traite;

    
    /**
     * classic constructor
     * @param point1
     * @param point2 
     */
    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.traite = false;
    }

    /**
     * complete constructor
     * @param point1
     * @param point2
     * @param tridroit
     * @param trigauche 
     */
    public Segment(Point point1, Point point2, Triangle tridroit, Triangle trigauche) {
        this.point1 = point1;
        this.point2 = point2;
        this.tridroit = tridroit;
        this.trigauche = trigauche;
        this.traite= false;
    }
    
    
    
    

    /**
     * Get the value of trigauche
     *
     * @return the value of trigauche
     */
    public Triangle getTrigauche() {
        return trigauche;
    }

    /**
     * Set the value of trigauche
     *
     * @param trigauche new value of trigauche
     */
    public void setTrigauche(Triangle trigauche) {
        this.trigauche = trigauche;
    }


    /**
     * Get the value of tridroit
     *
     * @return the value of tridroit
     */
    public Triangle getTridroit() {
        return tridroit;
    }

    /**
     * Set the value of tridroit
     *
     * @param tridroit new value of tridroit
     */
    public void setTridroit(Triangle tridroit) {
        this.tridroit = tridroit;
    }


    /**
     * Get the value of point2
     *
     * @return the value of point2
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Set the value of point2
     *
     * @param point2 new value of point2
     */
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    /**
     * Get the value of point1
     *
     * @return the value of point1
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Set the value of point1
     *
     * @param point1 new value of point1
     */
    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

}
