/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package geometry;

/**
 * gere les objet de type Point
 * @author Utilisateur
 */
public class Point {
    
    private int posx;
    private int posy;
    private int posz;
    
    /**
     * classic constructor
     * @param posx
     * @param posy
     * @param posz 
     */
    public Point(int posx, int posy, int posz) {
        this.posx = posx;
        this.posy = posy;
        this.posz = posz;
    }
    
    public boolean equals(Point point){
        return(this.getPosx()==point.getPosx()
                &&
                this.getPosy()==point.getPosy()
                &&
                this.getPosz()==point.getPosz());
    }

    /**
     * Get the value of posz
     *
     * @return the value of posz
     */
    public int getPosz() {
        return posz;
    }

    /**
     * Set the value of posz
     *
     * @param posz new value of posz
     */
    public void setPosz(int posz) {
        this.posz = posz;
    }


    /**
     * Get the value of posy
     *
     * @return the value of posy
     */
    public int getPosy() {
        return posy;
    }

    /**
     * Set the value of posy
     *
     * @param posy new value of posy
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }


    /**
     * Get the value of posx
     *
     * @return the value of posx
     */
    public int getPosx() {
        return posx;
    }

    /**
     * Set the value of posx
     *
     * @param posx new value of posx
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    
}
