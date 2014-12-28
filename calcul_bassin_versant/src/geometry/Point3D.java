/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

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

    public boolean equals(Point3D point) {
        return (this.getPosx() == point.getPosx()
                && this.getPosy() == point.getPosy()
                && this.getPosz() == point.getPosz());
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

    public static Point3D intersection(Segment segment, Point3D point, Vecteur vecteur) {
        double a1, b1, c1;
        double a2, b2, c2;
        Point3D intersect = new Point3D(0, 0, 0);
        Point3D pointSeg1 = segment.getPoint1(); // pour simplifier l'écriture de plusieurs expressions
        Point3D pointSeg2 = segment.getPoint2();

        a1 = vecteur.getValx();
        b1 = -vecteur.getValy();
        c1 = (a1 * point.getPosx() - b1 * point.getPosy());

        Vecteur vect = new Vecteur(segment);

        a2 = vect.getValx();
        b2 = -vect.getValy();
        c2 = (a2 * pointSeg1.getPosx() - b2 * pointSeg2.getPosy());

        if ((a1 == a2) && (b1 == b2)) {
            //TODO gerer l'erreur dû au parrallélisme
        } else {
            intersect.setPosx((c1 * b2 + c2 * b1) / (a1 * b2 + a2 * b1));
            intersect.setPosy((c1 * a2 + c2 * a1) / (b1 * a2 + b2 * a1));

            if (pointSeg1.getPosx() == pointSeg2.getPosx()) {
                intersect.setPosz(pointSeg1.getPosz() + (pointSeg2.getPosz() - pointSeg1.getPosz()) * ((pointSeg1.getPosy() - intersect.getPosy()) / (pointSeg1.getPosy() - pointSeg2.getPosy())));

            } else {
                intersect.setPosz(pointSeg1.getPosz() + (pointSeg2.getPosz() - pointSeg1.getPosz()) * ((pointSeg1.getPosx() - intersect.getPosx()) / (pointSeg1.getPosx() - pointSeg2.getPosx())));
            }

        }

        return intersect;

    }

}
