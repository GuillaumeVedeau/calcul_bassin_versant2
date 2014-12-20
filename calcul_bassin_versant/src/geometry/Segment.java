/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

/**
 * gere les objets de type Segment
 *
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
     *
     * @param point1
     * @param point2
     */
    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.tridroit = new Triangle();
        this.trigauche = new Triangle();
        this.traite = false;
    }

    /**
     * complete constructor
     *
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
        this.traite = false;
    }
    
    public Segment(){
        this.point1 = new Point(0,0,0);
        this.point2 = new Point(0,0,0);
        this.tridroit = new Triangle();
        this.trigauche = new Triangle();
        this.traite = false;
    }
            

    public boolean equals(Segment segment) {
        return (this.getPoint1().equals(segment.getPoint1())
                && this.getPoint2().equals(segment.getPoint2())
                && this.getTridroit() == segment.getTridroit()
                && this.getTrigauche() == segment.getTrigauche());
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

    /**
     * Get the value of point1
     *
     * @return the value of point1
     */
    public boolean gettraite() {
        return traite;
    }

    /**
     * Set the value of traite
     *
     * @param traite new value of traite
     */
    public void setTraite(boolean traite) {
        this.traite = traite;
    }

    public void decoupe(Point point) {

        Point pointExtGauche = new Point(0, 0, 0);
        Point pointExtDroit = new Point(0, 0, 0);
        Segment seg1 = new Segment(this.getPoint1(), point);
        Segment seg2 = new Segment(point, this.getPoint2());
        Segment segDroitExt1 = new Segment();
        Segment segGaucheExt1 = new Segment();
        Segment segDroitExt2 = new Segment();
        Segment segGaucheExt2 = new Segment();
        Segment segDroitMid;
        Segment segGaucheMid;
        Triangle triDroit1;
        Triangle triDroit2;
        Triangle triGauche1;
        Triangle triGauche2;

        // découpe du 1er triangle  juxtaposé
        if (this.getTridroit() != null) {
            if (this.getTridroit().getPoint1() == this.getPoint1() || this.getTridroit().getPoint2() == this.getPoint1()) {
                if (this.getTridroit().getPoint1() == this.getPoint2() || this.getTridroit().getPoint2() == this.getPoint2()) {
                    pointExtDroit = this.getTridroit().getPoint3();
                    segDroitExt1 = this.getTridroit().getSegment3();
                    segDroitExt2 = this.getTridroit().getSegment2();

                }
            }
            if (this.getTridroit().getPoint2() == this.getPoint1() || this.getTridroit().getPoint3() == this.getPoint1()) {
                if (this.getTridroit().getPoint2() == this.getPoint2() || this.getTridroit().getPoint3() == this.getPoint2()) {
                    pointExtDroit = this.getTridroit().getPoint1();
                    segDroitExt1 = this.getTridroit().getSegment1();
                    segDroitExt2 = this.getTridroit().getSegment3();

                }
            }
            if (this.getTridroit().getPoint1() == this.getPoint1() || this.getTridroit().getPoint3() == this.getPoint1()) {
                if (this.getTridroit().getPoint1() == this.getPoint2() || this.getTridroit().getPoint3() == this.getPoint2()) {
                    pointExtDroit = this.getTridroit().getPoint2();
                    segDroitExt1 = this.getTridroit().getSegment2();
                    segDroitExt2 = this.getTridroit().getSegment1();

                }
            }

            segDroitMid = new Segment(point, pointExtDroit);

            triDroit1 = new Triangle(seg1, segDroitMid, segDroitExt1);
            triDroit2 = new Triangle(segDroitExt2, segDroitMid, seg2);

            // modifie les segment extérieurs pour qu'ils prennent en compte les 2 nouveaux triangles
            segDroitMid.setTridroit(triDroit1);
            segDroitMid.setTrigauche(triDroit2);

            if (segDroitExt1.getTridroit().equals(this.getTridroit())) {
                segDroitExt1.setTridroit(triDroit1);
            } else {
                segDroitExt1.setTrigauche(triDroit1);
            }

            if (segDroitExt2.getTridroit().equals(this.getTridroit())) {
                segDroitExt2.setTridroit(triDroit2);
            } else {
                segDroitExt2.setTrigauche(triDroit2);
            }

        }

        // découpe du 2eme triangle  juxtaposé
        if (this.getTrigauche()!= null) {
            if (this.getTrigauche().getPoint1() == this.getPoint1() || this.getTrigauche().getPoint2() == this.getPoint1()) {
                if (this.getTrigauche().getPoint1() == this.getPoint2() || this.getTrigauche().getPoint2() == this.getPoint2()) {
                    pointExtGauche = this.getTrigauche().getPoint3();
                    segGaucheExt1 = this.getTrigauche().getSegment3();
                    segGaucheExt2 = this.getTrigauche().getSegment2();

                }
            }
            if (this.getTrigauche().getPoint2() == this.getPoint1() || this.getTrigauche().getPoint3() == this.getPoint1()) {
                if (this.getTrigauche().getPoint2() == this.getPoint2() || this.getTrigauche().getPoint3() == this.getPoint2()) {
                    pointExtGauche = this.getTrigauche().getPoint1();
                    segGaucheExt1 = this.getTrigauche().getSegment1();
                    segGaucheExt2 = this.getTrigauche().getSegment3();

                }
            }
            if (this.getTrigauche().getPoint1() == this.getPoint1() || this.getTrigauche().getPoint3() == this.getPoint1()) {
                if (this.getTrigauche().getPoint1() == this.getPoint2() || this.getTrigauche().getPoint3() == this.getPoint2()) {
                    pointExtGauche = this.getTrigauche().getPoint2();
                    segGaucheExt1 = this.getTrigauche().getSegment2();
                    segGaucheExt2 = this.getTrigauche().getSegment1();

                }
            }

            segGaucheMid = new Segment(point, pointExtGauche);

            triGauche1 = new Triangle(seg2, segGaucheMid, segGaucheExt1);
            triGauche2 = new Triangle(segGaucheExt2, segGaucheMid, seg1);

            //ajoute les 2 nouveaux triangles au nouveau segment qui les sépare
            
            segGaucheMid.setTridroit(triGauche1);
            segGaucheMid.setTrigauche(triGauche2);
            
            // modifie les segment extérieurs pour qu'ils prennent en compte les 2 nouveaux triangles
            if (segGaucheExt1.getTridroit().equals(this.getTrigauche())) {
                segDroitExt1.setTridroit(triGauche1);
            } else {
                segDroitExt1.setTrigauche(triGauche1);
            }

            if (segGaucheExt2.getTridroit().equals(this.getTrigauche())) {
                segGaucheExt2.setTridroit(triGauche2);
            } else {
                segGaucheExt2.setTrigauche(triGauche2);
            }

        }
    }

}
