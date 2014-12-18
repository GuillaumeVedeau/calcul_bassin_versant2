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
public class Triangle {

    private Segment segment1;
    private Segment segment2;
    private Segment segment3;

    /**
     * basic constructor
     * @param segment1
     * @param segment2
     * @param segment3 
     */
    public Triangle(Segment segment1, Segment segment2, Segment segment3) {
        this.segment1 = segment1;
        this.segment2 = segment2;
        this.segment3 = segment3;
    }
    
    

    /**
     * Get the value of segment3
     *
     * @return the value of segment3
     */
    public Segment getSegment3() {
        return segment3;
    }

    /**
     * Set the value of segment3
     *
     * @param segment3 new value of segment3
     */
    public void setSegment3(Segment segment3) {
        this.segment3 = segment3;
    }

    /**
     * Get the value of segment2
     *
     * @return the value of segment2
     */
    public Segment getSegment2() {
        return segment2;
    }

    /**
     * Set the value of segment2
     *
     * @param segment2 new value of segment2
     */
    public void setSegment2(Segment segment2) {
        this.segment2 = segment2;
    }

    /**
     * Get the value of segment1
     *
     * @return the value of segment1
     */
    public Segment getSegment1() {
        return segment1;
    }

    /**
     * Set the value of segment1
     *
     * @param segment1 new value of segment1
     */
    public void setSegment1(Segment segment1) {
        this.segment1 = segment1;
    }

}
