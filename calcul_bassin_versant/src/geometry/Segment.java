/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import java.util.ArrayList;

/**
 * gere les objets de type Segment prenant en compte les triangles juxtaposés et
 * leur état de traitement
 *
 * @author Utilisateur
 */
public class Segment {

    private Point3D point1;
    private Point3D point2;
    private Triangle tridroit;
    private Triangle trigauche;
    private boolean traiteDroit;
    private boolean traiteGauche;

    /**
     * classic constructor
     *
     * @param point1
     * @param point2
     */
    public Segment(Point3D point1, Point3D point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.tridroit = null;
        this.trigauche = null;
        this.traiteDroit = false;
        this.traiteGauche = false;
    }

    /**
     * complete constructor
     *
     * @param point1
     * @param point2
     * @param tridroit
     * @param trigauche
     */
    public Segment(Point3D point1, Point3D point2, Triangle tridroit, Triangle trigauche) {
        this.point1 = point1;
        this.point2 = point2;
        this.tridroit = tridroit;
        this.trigauche = trigauche;
        this.traiteDroit = false;
        this.traiteGauche = false;
    }

    /**
     * Default constructor
     */
    public Segment() {
        this.point1 = new Point3D(0, 0, 0);
        this.point2 = new Point3D(0, 0, 0);
        this.tridroit = new Triangle();
        this.trigauche = new Triangle();
        this.traiteDroit = false;
        this.traiteGauche = false;
    }

    /**
     * cherche et complete trigauche et tridroit du segment selon une liste de
     * triangle donné, et met à jour les triangle concernés
     *
     * @param triangles liste de triangles dans lequel il faut chercher ceux
     * juxtaposés au segment manipulé
     */
    public void chercheTriangle(ArrayList<Triangle> triangles) {

        for (Triangle triangle : triangles) {
            if (triangle.getPoint1().equals(point1) && triangle.getPoint2().equals(point2)){
                this.setTridroit(triangle);
                triangle.setSegment1(this);
            }
            if (triangle.getPoint2().equals(point1) && triangle.getPoint3().equals(point2)){
                this.setTridroit(triangle);
                triangle.setSegment2(this);
            }
            if (triangle.getPoint3().equals(point1) && triangle.getPoint1().equals(point2)){
                this.setTridroit(triangle);
                triangle.setSegment3(this);
            }

            if (triangle.getPoint2().equals(point1) && triangle.getPoint1().equals(point2)){
                this.setTrigauche(triangle);
                triangle.setSegment1(this);
            }
            if (triangle.getPoint3().equals(point1) && triangle.getPoint2().equals(point2)){
                this.setTrigauche(triangle);
                triangle.setSegment2(this);
            }
            if (triangle.getPoint1().equals(point1) && triangle.getPoint3().equals(point2)){
                this.setTrigauche(triangle);
                triangle.setSegment3(this);
            }
        }

    }

    /**
     * vérifie l'égalité entre 2 segments
     *
     * @param segment
     * @return
     */
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
    public Point3D getPoint2() {
        return point2;
    }

    /**
     * Set the value of point2
     *
     * @param point2 new value of point2
     */
    public void setPoint2(Point3D point2) {
        this.point2 = point2;
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
     * Set the value of point1
     *
     * @param point1 new value of point1
     */
    public void setPoint1(Point3D point1) {
        this.point1 = point1;
    }

    /**
     * Get the value of traiteDroit
     *
     * @return the value of point1
     */
    public boolean gettraiteDroit() {
        return traiteDroit;
    }

    /**
     * Set the value of traiteDroit
     *
     * @param traiteDroit new value of traiteDroit
     */
    public void setTraiteDroit(boolean traiteDroit) {
        this.traiteDroit = traiteDroit;
    }

    /**
     * Get the value of traiteGauche
     *
     * @return the value of traiteGauche
     */
    public boolean getTraiteGauche() {
        return traiteGauche;
    }

    /**
     * Set the value of traiteGauche
     *
     * @param traiteGauche new value of traiteGauche
     */
    public void setTraiteGauche(boolean traiteGauche) {
        this.traiteGauche = traiteGauche;
    }

    /**
     * gere la propagation d'un bassin versant dans le cas où le triangle du
     * maillage necessite d'etre découpé Le segment est celui qui peut étendre
     * le bassin versant
     *
     * @param point séparateur du segment en 2, calculé precedemment selon le
     * bassin versant
     * @param bassin triangle où le bassin versant c'est propagé, et dont seule
     * une partie est intégré dans le bassin versant, nécessitant un redecoupage
     * du segment d'où l'eau peut provenir et des 2 triangles adjacent (triangle
     * appelant la methode calculprojete)
     * @param passant point du triangle "bassin" , appartenant égalemment au
     * segment à découper et au segment parametre de la methode calculProjete
     * ayant entrainé l'appel de cette methode
     * @param bassinVersant
     */
    public void decoupe(Point3D point, Triangle bassin, Point3D passant, ArrayList<Triangle> bassinVersant) {

        Point3D pointExtGauche = new Point3D(0, 0, 0);
        Point3D pointExtDroit = new Point3D(0, 0, 0);
        Segment seg1 = new Segment(this.getPoint1(), point);
        Segment seg2 = new Segment(point, this.getPoint2());
        Segment segDroitExt1 = new Segment();
        Segment segGaucheExt1 = new Segment();
        Segment segDroitExt2 = new Segment();
        Segment segGaucheExt2 = new Segment();
        Segment segDroitMid;
        Segment segGaucheMid;
        Triangle triDroit1 = new Triangle();
        Triangle triDroit2 = new Triangle();
        Triangle triGauche1 = new Triangle();
        Triangle triGauche2 = new Triangle();

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

           //ajoute les 2 nouveaux triangles au nouveau segment qui les sépare
            segDroitMid.setTridroit(triDroit1);
            segDroitMid.setTrigauche(triDroit2);

            // modifie les segment extérieurs pour qu'ils prennent en compte les 2 nouveaux triangles
            if (this.getTridroit().equals(segDroitExt1.getTridroit())) {
                segDroitExt1.setTridroit(triDroit1);
            } else {
                segDroitExt1.setTrigauche(triDroit1);
                
            }

            if (this.getTridroit().equals(segDroitExt2.getTridroit())) {
                segDroitExt2.setTridroit(triDroit2);
            } else {               
                segDroitExt2.setTrigauche(triDroit2);
            }

        }

        // découpe du 2eme triangle  juxtaposé
        if (this.getTrigauche()
                != null) {
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
            if (this.getTrigauche().equals(segGaucheExt1.getTridroit())) {
                segGaucheExt1.setTridroit(triGauche1);
            } else {
                segGaucheExt1.setTrigauche(triGauche1);
                
            }

            if (this.getTrigauche().equals(segGaucheExt2.getTridroit())) {
                segGaucheExt2.setTridroit(triGauche2);
            } else {
                segGaucheExt2.setTrigauche(triGauche2);
            }

        }

        // ajout des 4 triangles créés aux 2 segments séparant les 2 anciens triangles
        if (this.getTridroit() != null) {
            seg2.setTridroit(triDroit2);
            seg1.setTridroit(triDroit1);
        }
        if (this.getTrigauche() != null) {
            seg2.setTrigauche(triGauche1);
            seg1.setTrigauche(triGauche2);
        }

        
        // Ajout du triangle correspondant au bassin versant et propagation du bassin (cas où le triangle qui a provoqué la séparation était le triangle droit du segment actuel)
        if ((bassin.equals(this.getTridroit()))) {

            if (triDroit1.getPoint1().equals(passant) || triDroit1.getPoint2().equals(passant) || triDroit1.getPoint3().equals(passant)) {
                bassinVersant.add(triDroit1);
                if (triDroit1.equals(triDroit1.getSegment1().getTridroit())) {
                    if (triDroit1.getSegment1().getTrigauche() != null) {
                        triDroit1.getSegment1().getTrigauche().calculProjete(triDroit1.getSegment1(), bassinVersant);
                    }
                } else {

                    if (triDroit1.getSegment1().getTridroit() != null) {
                        triDroit1.getSegment1().getTridroit().calculProjete(triDroit1.getSegment1(), bassinVersant);
                    }
                }

                if (triDroit1.equals(triDroit1.getSegment2().getTridroit())) {
                    if (triDroit1.getSegment2().getTrigauche() != null) {
                        triDroit1.getSegment2().getTrigauche().calculProjete(triDroit1.getSegment2(), bassinVersant);
                    }
                } else {
                    if (triDroit1.getSegment2().getTridroit() != null) {
                        triDroit1.getSegment2().getTridroit().calculProjete(triDroit1.getSegment2(), bassinVersant);
                    }
                }

                if (triDroit1.equals(triDroit1.getSegment3().getTridroit())) {
                    if (triDroit1.getSegment3().getTrigauche() != null) {
                        triDroit1.getSegment3().getTrigauche().calculProjete(triDroit1.getSegment3(), bassinVersant);
                    }
                } else {
                    if (triDroit1.getSegment3().getTridroit() != null) {
                        triDroit1.getSegment3().getTridroit().calculProjete(triDroit1.getSegment3(), bassinVersant);
                    }
                }

            } else {
                bassinVersant.add(triDroit2);
                if (triDroit2.equals(triDroit2.getSegment1().getTridroit())) {
                    if (triDroit2.getSegment1().getTrigauche() != null) {
                        triDroit2.getSegment1().getTrigauche().calculProjete(triDroit2.getSegment1(), bassinVersant);
                    }
                } else {
                    if (triDroit2.getSegment1().getTridroit() != null) {
                        triDroit2.getSegment1().getTridroit().calculProjete(triDroit2.getSegment1(), bassinVersant);
                    }
                }

                if (triDroit2.equals(triDroit2.getSegment2().getTridroit())) {
                    if (triDroit2.getSegment2().getTrigauche() != null) {
                        triDroit2.getSegment2().getTrigauche().calculProjete(triDroit2.getSegment2(), bassinVersant);
                    }
                } else {
                    if (triDroit2.getSegment2().getTridroit() != null) {
                        triDroit2.getSegment2().getTridroit().calculProjete(triDroit2.getSegment2(), bassinVersant);
                    }
                }

                if (triDroit2.equals(triDroit2.getSegment3().getTridroit())) {
                    if (triDroit2.getSegment3().getTrigauche() != null) {
                        triDroit2.getSegment3().getTrigauche().calculProjete(triDroit2.getSegment3(), bassinVersant);
                    }
                } else {
                    if (triDroit2.getSegment3().getTridroit() != null) {
                        triDroit2.getSegment3().getTridroit().calculProjete(triDroit2.getSegment3(), bassinVersant);
                    }
                }
            }
        }

        // Ajout du triangle correspondant au bassin versant et propagation du bassin (cas où le triangle qui a provoqué la séparation était le triangle gauche du segment actuel)
        if (bassin.equals(this.getTrigauche())) {

            if (triGauche1.getPoint1().equals(passant) || triGauche1.getPoint2().equals(passant) || triGauche1.getPoint3().equals(passant)) {
                bassinVersant.add(triGauche1);
                if (triGauche1.equals(triGauche1.getSegment1().getTridroit())) {
                    triGauche1.getSegment1().getTrigauche().calculProjete(triGauche1.getSegment1(), bassinVersant);
                } else {
                    if (triGauche1.getSegment1().getTridroit() != null) {
        
                        triGauche1.getSegment1().getTridroit().calculProjete(triGauche1.getSegment1(), bassinVersant);
                    }
                }

                if (triGauche1.getSegment2().getTridroit().equals(triGauche1)) {
                    triGauche1.getSegment2().getTrigauche().calculProjete(triGauche1.getSegment2(), bassinVersant);
                } else {

                    triGauche1.getSegment2().getTridroit().calculProjete(triGauche1.getSegment2(), bassinVersant);
                }

                if (triGauche1.equals(triGauche1.getSegment3().getTridroit())) {
                    if (triGauche1.getSegment3().getTrigauche() != null) {
                        triGauche1.getSegment3().getTrigauche().calculProjete(triGauche1.getSegment3(), bassinVersant);
                    }
                } else {
                    if (triGauche1.getSegment3().getTridroit() != null) {
                        triGauche1.getSegment3().getTridroit().calculProjete(triGauche1.getSegment3(), bassinVersant);
                    }
                }

            } else {
                bassinVersant.add(triGauche2);
                if (triGauche2.equals(triGauche2.getSegment1().getTridroit())) {
                    triGauche2.getSegment1().getTrigauche().calculProjete(triGauche2.getSegment1(), bassinVersant);
                } else {
                    triGauche2.getSegment1().getTridroit().calculProjete(triGauche2.getSegment1(), bassinVersant);
                }

                if (triGauche2.equals(triGauche2.getSegment2().getTridroit())) {
                    triGauche2.getSegment2().getTrigauche().calculProjete(triGauche2.getSegment2(), bassinVersant);
                } else {
                    triGauche2.getSegment2().getTridroit().calculProjete(triGauche2.getSegment2(), bassinVersant);
                }

                if (triGauche2.equals(triGauche2.getSegment3().getTridroit())) {
                    triGauche2.getSegment3().getTrigauche().calculProjete(triGauche2.getSegment3(), bassinVersant);
                } else {
                    triGauche2.getSegment3().getTridroit().calculProjete(triGauche2.getSegment3(), bassinVersant);
                }
            }

        }

    }
}
