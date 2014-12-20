/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package geometry;

/**
 *
 * @author Utilisateur
 */
public class Vecteur {
    
    private int valx;
    private int valy;

    /**
     * Default constructor
     */
    public Vecteur() {
        valx =0;
        valy=0;
    }

    /**
     * Classic constructor
     * @param valx
     * @param valy 
     */
    public Vecteur(int valx, int valy) {
        this.valx = valx;
        this.valy = valy;
    }

    /**
     * Constructor based on Segment
     * @param segment 
     */
    public Vecteur(Segment segment) {
        this.valx = segment.getPoint1().getPosx() - segment.getPoint2().getPosx();
        this.valy = segment.getPoint1().getPosy() - segment.getPoint2().getPosy();
    }
    
    /**
     * Constructor based on 2 Point
     * @param point1
     * @param point2 
     */
    public Vecteur(Point point1, Point point2){
        this.valx = point1.getPosx() - point2.getPosx();
        this.valx = point2.getPosy() - point2.getPosy();
    }
    
    

    
    
    
    /**
     * Get the value of valy
     *
     * @return the value of valy
     */
    public int getValy() {
        return valy;
    }

    /**
     * Set the value of valy
     *
     * @param valy new value of valy
     */
    public void setValy(int valy) {
        this.valy = valy;
    }


    /**
     * Get the value of valx
     *
     * @return the value of valx
     */
    public int getValx() {
        return valx;
    }

    /**
     * Set the value of valx
     *
     * @param valx new value of valx
     */
    public void setValx(int valx) {
        this.valx = valx;
    }
    

}
