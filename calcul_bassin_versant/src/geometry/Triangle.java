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
    
    private Point point1;
    private Point point2;
    private Point point3;

    /**
     * basic constructor based on Segment
     * l'ordre des points est déterminé en cherchant celui qui est commun aux segments 1 et 2
     * @param segment1
     * @param segment2
     * @param segment3 
     */
    public Triangle(Segment segment1, Segment segment2, Segment segment3) {
        this.segment1 = segment1;
        this.segment2 = segment2;
        this.segment3 = segment3;
        
        
        this.point1 = segment1.getPoint1();
        this.point2 = segment1.getPoint2();
        if(segment1.getPoint1() == segment2.getPoint1()){
            this.point1 = segment1.getPoint2();
            this.point2 = segment1.getPoint1();
            this.point3 = segment2.getPoint2();
        }
        if(segment1.getPoint2() == segment2.getPoint1()){
            this.point1 = segment1.getPoint1();
            this.point2 = segment1.getPoint2();
            this.point3 = segment2.getPoint2();
        }
        if(segment1.getPoint1() == segment2.getPoint2()){
            this.point1 = segment1.getPoint2();
            this.point2 = segment1.getPoint1();
            this.point3 = segment2.getPoint1();
        }
       if(segment1.getPoint2() == segment2.getPoint2()){
            this.point1 = segment1.getPoint1();
            this.point2 = segment1.getPoint2();
            this.point3 = segment2.getPoint1();
        }
    }

    /**
     * basic constructor based on Point
     * @param point1
     * @param point2
     * @param point3 
     */
    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.segment1 = new Segment(point1,point2);
        this.segment2 = new Segment(point2,point3);
        this.segment3 = new Segment(point3,point1);
    }
    
    /**
     * default constructor
     */
    public Triangle(){
        this.point1 = new Point(0,0,0);
        this.point2 = new Point(0,0,0);
        this.point3 = new Point(0,0,0);
        this.segment1 = new Segment(point1,point2);
        this.segment2 = new Segment(point2,point3);
        this.segment3 = new Segment(point3,point1);
    }
    
    public boolean equals(Triangle triangle){
        
        return(this.getPoint1().equals(triangle.getPoint1())
                &&
                this.getPoint2().equals(triangle.getPoint2())
                &&
                this.getPoint3().equals(triangle.getPoint3())
                &&
                this.getSegment1().equals(triangle.getSegment1())
                &&
                this.getSegment2().equals(triangle.getSegment2())
                &&
                this.getSegment3().equals(triangle.getSegment3()));
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
    
    /**
     * Get the value of point1
     * 
     * @return the value of point1
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     Set the value of segment1
     *
     * @param point1 new value of point1
     */
    public void setPoint1(Point point1) {
        this.point1 = point1;
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
     Set the value of segment2
     *
     * @param point2 new value of point2
     */
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

     /**
     * Get the value of point3
     * 
     * @return the value of point3
     */
    public Point getPoint3() {
        return point3;
    }

     /**
     Set the value of segment3
     *
     * @param point3 new value of point3
     */
    public void setPoint3(Point point3) {
        this.point3 = point3;
    }
    
    public Vecteur calculPente(){
        Vecteur pente = new Vecteur(0,0);
        int x1 = this.getPoint1().getPosx() - this.getPoint2().getPosx();
        int x2 = this.getPoint1().getPosx() - this.getPoint3().getPosx();
        int y1 = this.getPoint1().getPosy() - this.getPoint2().getPosy();
        int y2 = this.getPoint1().getPosy() - this.getPoint3().getPosy();
        int z1 = this.getPoint1().getPosz() - this.getPoint2().getPosz();
        int z2 = this.getPoint1().getPosz() - this.getPoint3().getPosz();
     
        if(x1*y2 - y1*x2 >= 0){
            pente.setValx((y1*z2 - z1*y2));
            pente.setValy((z1*x2 - x1*z2));
        }
        else{
            pente.setValx(-(y1*z2 - z1*y2));
            pente.setValy(-(z1*x2 - x1*z2));
        }
        
        return pente;
    }
    

}
