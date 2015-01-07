/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul_bassin_versant;

import geometry.*;
import java.util.ArrayList;

/**
 * Calcul le bassin versant d'un point
 *
 * @author Utilisateur
 */
public class Calcul_bassin_versant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Point3D pointA = new Point3D(0, 0, 10);
        Point3D pointB = new Point3D(1, 0, 5);
        Point3D pointC = new Point3D(0, 1, 5);
        Point3D pointD = new Point3D(1, 1, 2);
        Point3D pointE = new Point3D(2, 0, 2);
        Point3D pointF = new Point3D(2, 1, 1);
        Point3D pointG = new Point3D(0, 2, 2);
        Point3D pointH = new Point3D(1, 2, 1);
        Point3D pointI = new Point3D(2, 2, 0);

        Segment segAB = new Segment(pointA, pointB);
        Segment segBD = new Segment(pointB, pointD);
        Segment segBC = new Segment(pointB, pointC);
        Segment segAC = new Segment(pointA, pointC);
        Segment segCD = new Segment(pointC, pointD);
        Segment segBE = new Segment(pointB, pointE);
        Segment segEF = new Segment(pointE, pointF);
        Segment segDF = new Segment(pointD, pointF);
        Segment segBF = new Segment(pointB, pointF);
        Segment segFI = new Segment(pointF, pointI);
        Segment segHI = new Segment(pointH, pointI);
        Segment segGH = new Segment(pointG, pointH);
        Segment segCG = new Segment(pointC, pointG);
        Segment segDG = new Segment(pointD, pointG);  
        Segment segDH = new Segment(pointD, pointH);
        Segment segFH = new Segment(pointF, pointH);

        Triangle triABC = new Triangle(segAB, segBC, segAC);
        Triangle triBDC = new Triangle(segBD, segCD, segBC);
        Triangle triBFD = new Triangle(segBF,segDF,segBD);
        Triangle triBEF = new Triangle(segBE,segEF,segBF);
        Triangle triCDG = new Triangle(segCD,segDG,segCG);
        Triangle triDHG = new Triangle(segDH,segGH,segDG);
        Triangle triDFH = new Triangle(segDF,segFH,segDH);
        Triangle triFIH = new Triangle(segFI,segHI,segFH);
        
        ArrayList<Triangle> triangles = new ArrayList<>();
        ArrayList<Segment> segments = new ArrayList<>();
        
        triangles.add(triABC);
        triangles.add(triBDC);
        triangles.add(triBFD);
        triangles.add(triBEF);
        triangles.add(triCDG);
        triangles.add(triDHG);
        triangles.add(triDFH);
        triangles.add(triFIH);
        
        segments.add(segAB);
        segments.add(segBD);
        segments.add(segBC);
        segments.add(segAC);
        segments.add(segCD);
        segments.add(segBE);
        segments.add(segEF);
        segments.add(segDF);
        segments.add(segBF);
        segments.add(segFI);
        segments.add(segHI);
        segments.add(segGH);
        segments.add(segCG);
        segments.add(segDG);
        segments.add(segDH);
        segments.add(segFH);
        
        for(Segment segment: segments){
            segment.chercheTriangle(triangles);
        }
        
        ArrayList<Triangle> resultat = new ArrayList<>();
        
        triFIH.calculProjete(segFH, resultat);
        System.out.println(resultat.size());

    }

}
