/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import java.util.ArrayList;

/**
 * gere les objet de type Poin3D
 *
 * @author Utilisateur
 */
public class Point3D {

    private double posx;
    private double posy;
    private double posz;

    /**
     * classic constructor
     *
     * @param posx
     * @param posy
     * @param posz
     */
    public Point3D(double posx, double posy, double posz) {
        this.posx = posx;
        this.posy = posy;
        this.posz = posz;
    }

    public Point3D() {
        this.posx = 0;
        this.posy = 0;
        this.posz = 0;
    }

    /**
     * Teste l'égalité entre 2 points
     *
     * @param point
     * @return
     */
    public boolean equals(Point3D point) {
        return (this.getPosx() == point.getPosx()
                && this.getPosy() == point.getPosy()
                && this.getPosz() == point.getPosz());
    }

    @Override
    /**
     * surcharge de toString
     */
    public String toString() {
        return ("\tx:" + posx + "\ty:" + posy + "\tz:" + posz); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the value of posz
     *
     * @return the value of posz
     */
    public double getPosz() {
        return posz;
    }

    /**
     * Set the value of posz
     *
     * @param posz new value of posz
     */
    public void setPosz(double posz) {
        this.posz = posz;
    }

    /**
     * Get the value of posy
     *
     * @return the value of posy
     */
    public double getPosy() {
        return posy;
    }

    /**
     * Set the value of posy
     *
     * @param posy new value of posy
     */
    public void setPosy(double posy) {
        this.posy = posy;
    }

    /**
     * Get the value of posx
     *
     * @return the value of posx
     */
    public double getPosx() {
        return posx;
    }

    /**
     * Set the value of posx
     *
     * @param posx new value of posx
     */
    public void setPosx(double posx) {
        this.posx = posx;
    }

    /**
     * renvoie le point de projection d'un point sur un segment suivant un
     * vecteur
     *
     * @param segment
     * @param point
     * @param vecteur
     * @return
     */
    public static Point3D intersection(Segment segment, Point3D point, Vecteur vecteur) {
        double a1, b1, c1;
        double a2, b2, c2;
        Point3D intersect = new Point3D(0, 0, 0);
        Point3D pointSeg1 = segment.getPoint1(); // pour simplifier l'écriture de plusieurs expressions
        Point3D pointSeg2 = segment.getPoint2();

        a1 = vecteur.getValx();
        b1 = -vecteur.getValy();
        c1 = (a1 * point.getPosx() + b1 * point.getPosy());

        Vecteur vect = new Vecteur(segment);

        a2 = vect.getValx();
        b2 = -vect.getValy();
        c2 = (a2 * pointSeg1.getPosx() + b2 * pointSeg1.getPosy());
        if ((a1 == a2) && (b1 == b2)) {
            //TODO gerer l'erreur dû au parrallélisme
        } else {
            intersect.setPosx((c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1));
            intersect.setPosy((c1 * a2 - c2 * a1) / (b1 * a2 - b2 * a1));

            if (pointSeg1.getPosx() == pointSeg2.getPosx()) {
                intersect.setPosz(pointSeg1.getPosz() + (pointSeg2.getPosz() - pointSeg1.getPosz()) * ((pointSeg1.getPosy() - intersect.getPosy()) / (pointSeg1.getPosy() - pointSeg2.getPosy())));

            } else {
                intersect.setPosz(pointSeg1.getPosz() + (pointSeg2.getPosz() - pointSeg1.getPosz()) * ((pointSeg1.getPosx() - intersect.getPosx()) / (pointSeg1.getPosx() - pointSeg2.getPosx())));
            }

        }
        return intersect;

    }

    public ArrayList<Triangle> calculBassin(ArrayList<Triangle> triangles) {

        ArrayList<Triangle> bassinVersant = new ArrayList<>();

        for (Triangle triangle : triangles) {
            if (triangle.getPoint1().equals(this)) {
                if (triangle.getPoint2().getPosz() >= this.getPosz()) {

                    if (triangle.getSegment1().getTridroit() != null) {
                        triangle.getSegment1().getTridroit().calculProjete(triangle.getSegment1(), bassinVersant);
                    }
                    if (triangle.getSegment1().getTrigauche() != null) {
                        triangle.getSegment1().getTrigauche().calculProjete(triangle.getSegment1(), bassinVersant);
                    }
                }

                    if (triangle.getPoint3().getPosz() >= this.getPosz()){
                    if(triangle.getSegment3().getTridroit() !=null){
                        triangle.getSegment3().getTridroit().calculProjete(triangle.getSegment3(), bassinVersant);
                    }
                    if(triangle.getSegment3().getTrigauche() != null){
                        triangle.getSegment3().getTrigauche().calculProjete(triangle.getSegment3(), bassinVersant);
                    }

                }
            }
            

           if (triangle.getPoint2().equals(this)) {
                if (triangle.getPoint1().getPosz() >= this.getPosz()) {

                    if (triangle.getSegment1().getTridroit() != null) {
                        triangle.getSegment1().getTridroit().calculProjete(triangle.getSegment1(), bassinVersant);
                    }
                    if (triangle.getSegment1().getTrigauche() != null) {
                        triangle.getSegment1().getTrigauche().calculProjete(triangle.getSegment1(), bassinVersant);
                    }
                }

                    if (triangle.getPoint3().getPosz() >= this.getPosz()){
                    if(triangle.getSegment2().getTridroit() !=null){
                        triangle.getSegment2().getTridroit().calculProjete(triangle.getSegment2(), bassinVersant);
                    }
                    if(triangle.getSegment2().getTrigauche() != null){
                        triangle.getSegment2().getTrigauche().calculProjete(triangle.getSegment2(), bassinVersant);
                    }

                }
            }

            if (triangle.getPoint3().equals(this)) {
                if (triangle.getPoint3().equals(this)) {
                if (triangle.getPoint2().getPosz() >= this.getPosz()) {

                    if (triangle.getSegment2().getTridroit() != null) {
                        triangle.getSegment2().getTridroit().calculProjete(triangle.getSegment2(), bassinVersant);
                    }
                    if (triangle.getSegment2().getTrigauche() != null) {
                        triangle.getSegment2().getTrigauche().calculProjete(triangle.getSegment2(), bassinVersant);
                    }
                }

                    if (triangle.getPoint1().getPosz() >= this.getPosz()){
                    if(triangle.getSegment3().getTridroit() !=null){
                        triangle.getSegment3().getTridroit().calculProjete(triangle.getSegment3(), bassinVersant);
                    }
                    if(triangle.getSegment3().getTrigauche() != null){
                        triangle.getSegment3().getTrigauche().calculProjete(triangle.getSegment3(), bassinVersant);
                    }

                }
            }
            }

        }
        return bassinVersant;
    }

}
