/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

/**
 * gere les objet de type Triangle
 *
 * @author Utilisateur
 */
public class Triangle {

    private Segment segment1;
    private Segment segment2;
    private Segment segment3;

    private Point3D point1;
    private Point3D point2;
    private Point3D point3;

    /**
     * basic constructor based on Segment l'ordre des points est déterminé en
     * cherchant celui qui est commun aux segments 1 et 2
     *
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
        if (segment1.getPoint1() == segment2.getPoint1()) {
            this.point1 = segment1.getPoint2();
            this.point2 = segment1.getPoint1();
            this.point3 = segment2.getPoint2();
        }
        if (segment1.getPoint2() == segment2.getPoint1()) {
            this.point1 = segment1.getPoint1();
            this.point2 = segment1.getPoint2();
            this.point3 = segment2.getPoint2();
        }
        if (segment1.getPoint1() == segment2.getPoint2()) {
            this.point1 = segment1.getPoint2();
            this.point2 = segment1.getPoint1();
            this.point3 = segment2.getPoint1();
        }
        if (segment1.getPoint2() == segment2.getPoint2()) {
            this.point1 = segment1.getPoint1();
            this.point2 = segment1.getPoint2();
            this.point3 = segment2.getPoint1();
        }
    }

    /**
     * basic constructor based on Point
     *
     * @param point1
     * @param point2
     * @param point3
     */
    public Triangle(Point3D point1, Point3D point2, Point3D point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.segment1 = new Segment(point1, point2);
        this.segment2 = new Segment(point2, point3);
        this.segment3 = new Segment(point3, point1);
    }

    /**
     * default constructor
     */
    public Triangle() {
        this.point1 = new Point3D(0, 0, 0);
        this.point2 = new Point3D(0, 0, 0);
        this.point3 = new Point3D(0, 0, 0);
        this.segment1 = new Segment(point1, point2);
        this.segment2 = new Segment(point2, point3);
        this.segment3 = new Segment(point3, point1);
    }

    /**
     * Renvoie l'égalité complete entre 2 objets de type Triangle ( les objets
     * le constituant sont identiques)
     *
     * @param triangle
     * @return
     */
    public boolean equals(Triangle triangle) {

        if (this == null || triangle == null) {
            return false;
        } else {

            return (this.getPoint1().equals(triangle.getPoint1())
                    && this.getPoint2().equals(triangle.getPoint2())
                    && this.getPoint3().equals(triangle.getPoint3())
                    && this.getSegment1().equals(triangle.getSegment1())
                    && this.getSegment2().equals(triangle.getSegment2())
                    && this.getSegment3().equals(triangle.getSegment3()));
        }
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
    public Point3D getPoint1() {
        return point1;
    }

    /**
     * Set the value of segment1
     *
     * @param point1 new value of point1
     */
    public void setPoint1(Point3D point1) {
        this.point1 = point1;
    }

    /**
     * Get the value of point2
     *
     * @return the value of point2
     */
    public Point3D getPoint2() {
        return point2;
    }

    /**
     * Set the value of segment2
     *
     * @param point2 new value of point2
     */
    public void setPoint2(Point3D point2) {
        this.point2 = point2;
    }

    /**
     * Get the value of point3
     *
     * @return the value of point3
     */
    public Point3D getPoint3() {
        return point3;
    }

    /**
     * Set the value of segment3
     *
     * @param point3 new value of point3
     */
    public void setPoint3(Point3D point3) {
        this.point3 = point3;
    }

    /**
     * calcule le vecteur pente en 2D indiquant la direction de plus forte
     * descente d'une surface en 2.5D
     *
     * @return
     */
    public Vecteur calculPente() {
        Vecteur pente = new Vecteur(0, 0);
        double x1 = this.getPoint1().getPosx() - this.getPoint2().getPosx();
        double x2 = this.getPoint1().getPosx() - this.getPoint3().getPosx();
        double y1 = this.getPoint1().getPosy() - this.getPoint2().getPosy();
        double y2 = this.getPoint1().getPosy() - this.getPoint3().getPosy();
        double z1 = this.getPoint1().getPosz() - this.getPoint2().getPosz();
        double z2 = this.getPoint1().getPosz() - this.getPoint3().getPosz();

        if (x1 * y2 - y1 * x2 >= 0) {
            pente.setValx((y1 * z2 - z1 * y2));
            pente.setValy((z1 * x2 - x1 * z2));
        } else {
            pente.setValx(-(y1 * z2 - z1 * y2));
            pente.setValy(-(z1 * x2 - x1 * z2));
        }

        return pente;
    }

    public void calculProjete(Segment segment) {
        if ((!segment.gettraiteDroit() && (segment.getTridroit().equals(this)) || (!segment.getTraiteGauche() && (segment.getTrigauche().equals(this))))) {

            if (segment.getTridroit().equals(this)) {
                segment.setTraiteDroit(true);
            } else {
                segment.setTraiteGauche(true);
            }

            Point3D pointA = new Point3D(0, 0, 0);
            Point3D pointB = new Point3D(0, 0, 0);
            Point3D pointC = new Point3D(0, 0, 0);
            Segment segmentAB = new Segment();
            Segment segmentBC = new Segment();
            Segment segmentAC = new Segment();

            Vecteur pente = new Vecteur();

            pente = this.calculPente();

            if (this.getPoint1().equals(segment.getPoint1()) || this.getPoint1().equals(segment.getPoint2())) {
                pointA = this.getPoint1();
                pointB = this.getPoint2();
                pointC = this.getPoint3();
                segmentAB = this.getSegment1();
                segmentBC = this.getSegment2();
                segmentAC = this.getSegment3();

            } else {
                if (this.getPoint2().equals(segment.getPoint1()) || this.getPoint2().equals(segment.getPoint2())) {
                    pointA = this.getPoint2();
                    pointB = this.getPoint3();
                    pointC = this.getPoint1();
                    segmentAB = this.getSegment2();
                    segmentBC = this.getSegment3();
                    segmentAC = this.getSegment1();
                } else {
                    pointA = this.getPoint3();
                    pointB = this.getPoint1();
                    pointC = this.getPoint2();
                    segmentAB = this.getSegment3();
                    segmentBC = this.getSegment1();
                    segmentAC = this.getSegment2();
                }
            }

            //1er cas: pas de propagation:
            double angleBC = (new Vecteur(pointB, pointC).calculAngle());
            double angleCB = (new Vecteur(pointC, pointB).calculAngle());

            double angleAB = (new Vecteur(pointA, pointB).calculAngle());
            double angleAC = (new Vecteur(pointA, pointC).calculAngle());

            double anglePente = this.calculPente().calculAngle();

            if (Vecteur.distAngle(angleBC, anglePente) <= Vecteur.distAngle(angleBC, angleCB)) {
                //rien pour le moment, il n'y a pas de propagation donc pas d'appel récursif
            } else {

                //2eme cas : propagation totale du triangle
                if (Vecteur.distAngle(angleAB, anglePente) < Vecteur.distAngle(angleAB, angleAC)) {
                    // projection sur le triangle entier
                    //TODO Il faudra l'ajouter au bassin
                    
                    if(segmentAB.getTridroit().equals(this)){
                        segmentAB.getTrigauche().calculProjete(segmentAB);
                    }
                    else{
                        segmentAB.getTridroit().calculProjete(segmentAB);
                    }
                    if(segmentAC.getTridroit().equals(this)){
                        segmentAC.getTrigauche().calculProjete(segmentAC);
                    }
                    else{
                        segmentAC.getTridroit().calculProjete(segmentAC);
                    }

                } else { // Les 2 cas précédents ont priorité sur les 2 qui suivent pour les cas qui sont en commun

                    Point3D separation = new Point3D(0, 0, 0);

                    //3eme cas : propagation partielle sur le triangle, comprenant une partie du segment AC
                    if (Vecteur.distAngle(angleCB, anglePente) <= Vecteur.distAngle(angleCB, angleAB)) {

                        //projection de B sur le segmentAC suivant la pente 
                        separation = Point3D.intersection(segmentAC, pointB, pente);
                        segmentAC.decoupe(separation, this, pointC);

                    }

                    //4ème cas : propagation partielle sur le triangle, comprenant une partie du segment AB
                    if (Vecteur.distAngle(angleAC, anglePente) <= Vecteur.distAngle(angleAC, angleBC)) {

                        // projection de C sur le segmentAB suivant la pente
                        separation = Point3D.intersection(segmentAB, pointC, pente);
                        segmentAB.decoupe(separation, this, pointB);
                    }
                }
            }
        }
    }

}
