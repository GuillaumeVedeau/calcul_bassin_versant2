/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import java.util.ArrayList;

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
    // approximation par defaut faite sur les calcul d'angle (1°)
    private static double approximationAngulaire = 0.16;

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

        if (segment1.getPoint1() == segment2.getPoint1() || segment1.getPoint1() == segment2.getPoint2()) {
            this.point1 = segment1.getPoint2();
            this.point2 = segment1.getPoint1();

            if (segment1.getPoint1() == segment2.getPoint1()) {
                this.point3 = segment2.getPoint2();
            } else {
                this.point3 = segment2.getPoint1();
            }
        } else {
            this.point1 = segment1.getPoint1();
            this.point2 = segment1.getPoint2();

            if (segment1.getPoint2() == segment2.getPoint1()) {
                this.point3 = segment2.getPoint2();
            } else {
                this.point3 = segment2.getPoint1();
            }
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
     * construit les objets nécessaires au calcul du bassin versant
     * @param triangles
     * @param segments permet de récuperer la liste des segments créés si besoin
     */
    public static void construction(ArrayList<Triangle> triangles, ArrayList<Segment> segments){
        
        for(Triangle triangle : triangles){
            if(triangle.getSegment1()==null){
                Segment seg1 = new Segment(triangle.getPoint1(), triangle.getPoint2());
                segments.add(seg1);
                seg1.chercheTriangle(triangles);
            }
            if(triangle.getSegment2()==null){
                Segment seg2 = new Segment(triangle.getPoint2(), triangle.getPoint3());
                segments.add(seg2);
                seg2.chercheTriangle(triangles);
            }
            if(triangle.getSegment3()==null){
                Segment seg3 = new Segment(triangle.getPoint3(), triangle.getPoint1());
                segments.add(seg3);
                seg3.chercheTriangle(triangles);
            }
        }
        
    }

    @Override
    /**
     * surcharge de toString
     */
    public String toString() {
        return ("Triangle:" + "\n\tpoint1\t" + point1.toString() + "\n\tpoint2\t" + point2.toString() + "\n\tpoint3\t" + point3.toString());
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

            return ((this.getPoint1().equals(triangle.getPoint1())
                    && this.getPoint2().equals(triangle.getPoint2())
                    && this.getPoint3().equals(triangle.getPoint3()))
                    || (this.getPoint1().equals(triangle.getPoint2())
                    && this.getPoint2().equals(triangle.getPoint3())
                    && this.getPoint3().equals(triangle.getPoint1()))
                    || (this.getPoint1().equals(triangle.getPoint3())
                    && this.getPoint2().equals(triangle.getPoint1())
                    && this.getPoint3().equals(triangle.getPoint2())));
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
     * Get the value of approximation angulaire
     * @return the value of approximation angulaire
     */
    public static double getApproximationAngulaire(){
        return approximationAngulaire;
    }
    
    /**
     * Set the value of approximation angulaire
     * @param appro new value of approximation angulaire
     */
    public static void setApproximationAngulaire(double appro){
        approximationAngulaire = appro;
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

    /**
     * calcule la part d'un triangle faisant partie du bassin versant sachant le
     * segment qui l'y relie, et propage ensuite selon les nouveaux segments qui
     * y sont rattaché
     *
     * @param segment
     * @param bassinVersant
     */
    public void calculProjete(Segment segment, ArrayList<Triangle> bassinVersant) {

        if (((!segment.gettraiteDroit() && (this.equals(segment.getTridroit()))) || ((!segment.getTraiteGauche()
                && (this.equals(segment.getTrigauche())))))) {

            if (this.equals(segment.getTridroit())) {
                segment.setTraiteDroit(true);
            } else {
                segment.setTraiteGauche(true);
            }

            Point3D pointA = new Point3D();
            Point3D pointB = new Point3D();
            Point3D pointC = new Point3D();
            Segment segmentAB = new Segment();
            Segment segmentBC = new Segment();
            Segment segmentAC = new Segment();

            Vecteur pente = new Vecteur();

            pente = this.calculPente();

            if (segment.getPoint1().equals(this.getPoint1())) {

                if (segment.getPoint2().equals(this.getPoint2())) {

                    pointA = this.getPoint3();
                    pointB = this.getPoint1();
                    pointC = this.getPoint2();
                    segmentAB = this.getSegment3();
                    segmentBC = this.getSegment1();
                    segmentAC = this.getSegment2();
                } else {
                    pointA = this.getPoint2();
                    pointB = this.getPoint3();
                    pointC = this.getPoint1();
                    segmentAB = this.getSegment2();
                    segmentBC = this.getSegment3();
                    segmentAC = this.getSegment1();
                }
            }

            if (segment.getPoint1().equals(this.getPoint2())) {

                if (segment.getPoint2().equals(this.getPoint3())) {

                    pointA = this.getPoint1();
                    pointB = this.getPoint2();
                    pointC = this.getPoint3();
                    segmentAB = this.getSegment1();
                    segmentBC = this.getSegment2();
                    segmentAC = this.getSegment3();
                } else {
                    pointA = this.getPoint3();
                    pointB = this.getPoint1();
                    pointC = this.getPoint2();
                    segmentAB = this.getSegment3();
                    segmentBC = this.getSegment1();
                    segmentAC = this.getSegment2();
                }
            }

            if (segment.getPoint1().equals(this.getPoint3())) {

                if (segment.getPoint2().equals(this.getPoint1())) {

                    pointA = this.getPoint2();
                    pointB = this.getPoint3();
                    pointC = this.getPoint1();
                    segmentAB = this.getSegment2();
                    segmentBC = this.getSegment3();
                    segmentAC = this.getSegment1();
                } else {
                    pointA = this.getPoint1();
                    pointB = this.getPoint2();
                    pointC = this.getPoint3();
                    segmentAB = this.getSegment1();
                    segmentBC = this.getSegment2();
                    segmentAC = this.getSegment3();
                }
            }

            double angleBC = (new Vecteur(pointB, pointC).calculAngle());
            double angleCB = (new Vecteur(pointC, pointB).calculAngle());

            double angleAB = (new Vecteur(pointA, pointB).calculAngle());
            double angleAC = (new Vecteur(pointA, pointC).calculAngle());

            Vecteur pente1 = this.calculPente();

            if ((pente1.getValx() == 0) && (pente1.getValy() == 0)) {
                // projection sur le triangle entier dans le cas d'une surface horizontale
                bassinVersant.add(this);

                if (segmentAB.getTridroit() != null) {
                    if (segmentAB.getTridroit().equals(this)) {
                        if (segmentAB.getTrigauche() != null) {
                            segmentAB.getTrigauche().calculProjete(segmentAB, bassinVersant);

                        }
                    } else {
                        segmentAB.getTridroit().calculProjete(segmentAB, bassinVersant);
                    }
                }

                if (segmentAC.getTridroit() != null) {
                    if (segmentAC.getTridroit().equals(this)) {
                        if (segmentAC.getTrigauche() != null) {

                            segmentAC.getTrigauche().calculProjete(segmentAC, bassinVersant);

                        }
                    } else {
                        segmentAC.getTridroit().calculProjete(segmentAC, bassinVersant);
                    }
                }
            } else {

                double anglePente = pente1.calculAngle();

                if (((Vecteur.distAngle(angleBC, anglePente) - Vecteur.distAngle(angleBC, angleCB)) < approximationAngulaire) || (Math.abs(angleBC - anglePente) < approximationAngulaire)) {
                //1er cas: pas de propagation:
                    //rien pour le moment, il n'y a pas de propagation donc pas d'appel récursif

                } else {
                    //2eme cas : propagation totale du triangle
                    if (((Vecteur.distAngle(angleAB, anglePente) - Vecteur.distAngle(angleAB, angleAC)) < approximationAngulaire) || (Math.abs(angleAB - anglePente) < approximationAngulaire)) {

                        // projection sur le triangle entier
                        bassinVersant.add(this);

                        if (segmentAB.getTridroit() != null) {
                            if (segmentAB.getTridroit().equals(this)) {
                                if (segmentAB.getTrigauche() != null) {
                                    segmentAB.getTrigauche().calculProjete(segmentAB, bassinVersant);

                                }
                            } else {
                                segmentAB.getTridroit().calculProjete(segmentAB, bassinVersant);
                            }
                        }

                        if (segmentAC.getTridroit() != null) {
                            if (segmentAC.getTridroit().equals(this)) {
                                if (segmentAC.getTrigauche() != null) {

                                    segmentAC.getTrigauche().calculProjete(segmentAC, bassinVersant);

                                }
                            } else {
                                segmentAC.getTridroit().calculProjete(segmentAC, bassinVersant);
                            }
                        }

                    } else { // Les 2 cas précédents ont priorité sur les 2 qui suivent pour les cas qui sont en commun

                        Point3D separation = new Point3D(0, 0, 0);

                        //3eme cas : propagation partielle sur le triangle, comprenant une partie du segment AC
                        if (Vecteur.distAngle(angleCB, anglePente) <= Vecteur.distAngle(angleCB, angleAB)) {

                            //projection de B sur le segmentAC suivant la pente 
                            separation = Point3D.intersection(segmentAC, pointB, pente);
                            segmentAC.decoupe(separation, this, pointC, bassinVersant);

                        }

                        //4ème cas : propagation partielle sur le triangle, comprenant une partie du segment AB
                        if (Vecteur.distAngle(angleAC, anglePente) <= Vecteur.distAngle(angleAC, angleBC)) {

                            // projection de C sur le segmentAB suivant la pente
                            separation = Point3D.intersection(segmentAB, pointC, pente);
                            segmentAB.decoupe(separation, this, pointB, bassinVersant);

                        }
                    }
                }
            }
        }
    }

}
