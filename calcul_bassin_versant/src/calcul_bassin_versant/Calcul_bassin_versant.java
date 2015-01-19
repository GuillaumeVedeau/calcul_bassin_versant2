/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul_bassin_versant;

import Utilitaires.LectureWrl;
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

        Point3D point0 = new Point3D(0, 1, 2);
        Point3D point1 = new Point3D(1, 1, 3);
        Point3D point2 = new Point3D(2, 1, 4);
        Point3D point3 = new Point3D(3, 1, 5);
        Point3D point4 = new Point3D(4, 1, 6);
        Point3D point5 = new Point3D(0.5, 0, 1);
        Point3D point6 = new Point3D(1.5, 0, 2);
        Point3D point7 = new Point3D(2.5, 0, 3);
        Point3D point8 = new Point3D(3.5, 0, 4.0);
        Point3D point9 = new Point3D(0.5, 2, 1);
        Point3D point10 = new Point3D(1.5, 2, 2);
        Point3D point11 = new Point3D(2.5, 2, 3);
        Point3D point12 = new Point3D(3.5, 2, 4.0);

        Segment seg09 = new Segment(point0, point9);
        Segment seg19 = new Segment(point9, point1);
        Segment seg01 = new Segment(point0, point1);
        Segment seg05 = new Segment(point0, point5);
        Segment seg15 = new Segment(point1, point5);
        Segment seg56 = new Segment(point5, point6);
        Segment seg16 = new Segment(point1, point6);
        Segment seg12 = new Segment(point1, point2);
        Segment seg26 = new Segment(point2, point6);
        Segment seg110 = new Segment(point1, point10);
        Segment seg910 = new Segment(point9, point10);
        Segment seg210 = new Segment(point2, point10);
        Segment seg211 = new Segment(point2, point11);
        Segment seg1011 = new Segment(point10, point11);  
        Segment seg67 = new Segment(point6, point7);
        Segment seg27 = new Segment(point7, point2);
        Segment seg37 = new Segment(point7, point3);
        Segment seg23 = new Segment(point2, point3);
        Segment seg311 = new Segment(point3, point11);
        Segment seg1112 = new Segment(point11, point12);
        Segment seg78 = new Segment(point7, point8);
        Segment seg38 = new Segment(point3, point8);
        Segment seg34 = new Segment(point3, point4);
        Segment seg312 = new Segment(point3, point12);
        Segment seg412 = new Segment(point4, point12);
        Segment seg48 = new Segment(point4, point8);

        Triangle triABC = new Triangle(seg01, seg19, seg09);
        Triangle triBDC = new Triangle(seg15, seg01, seg05);
        Triangle triBFD = new Triangle(seg110,seg910,seg19);
        Triangle triBEF = new Triangle(seg16,seg26,seg12);
        Triangle triCDG = new Triangle(seg210,seg211,seg1011);
        Triangle triDHG = new Triangle(seg26,seg67,seg27);
        Triangle triDFH = new Triangle(seg211,seg23,seg311);
        Triangle triFIH = new Triangle(seg27,seg37,seg23);
        Triangle triFIH1 = new Triangle(seg312,seg1112,seg311);
        Triangle triFIH2 = new Triangle(seg78,seg48,seg37);
        Triangle triFIH3 = new Triangle(seg34,seg412,seg312);
        Triangle triFIH4 = new Triangle(seg38,seg48,seg34);
        
        
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
        triangles.add(triFIH1);
        triangles.add(triFIH2);
        triangles.add(triFIH3);
        triangles.add(triFIH4);
        
        segments.add(seg09);
        segments.add(seg19);
        segments.add(seg01);
        segments.add(seg05);
        segments.add(seg15);
        segments.add(seg56);
        segments.add(seg16);
        segments.add(seg12);
        segments.add(seg26);
        segments.add(seg110);
        segments.add(seg910);
        segments.add(seg210);
        segments.add(seg211);
        segments.add(seg1011);
        segments.add(seg67);
        segments.add(seg27);
        segments.add(seg37);
        segments.add(seg23);
        segments.add(seg311);
        segments.add(seg1112);
        segments.add(seg78);
        segments.add(seg38);
        segments.add(seg34);
        segments.add(seg312);
        segments.add(seg412);
        segments.add(seg48);
      
        
        
        
        for(Segment segment: segments){
            segment.chercheTriangle(triangles);
        }
        
        ArrayList<Triangle> resultat = new ArrayList<>();
        
        triCDG.calculProjete(seg1011, resultat);
        System.out.println(resultat.size());
        
        for(Triangle triangle : resultat)
        {
        System.out.println(triangle);
        }
        
        
        /*LectureWrl test = new LectureWrl("C:/Users/Utilisateur/Documents/NetBeansProjects/calcul_bassin_versant/calcul_bassin_versant/Chezine.wrl");
        System.out.println(test.getListeTriangle().get(0));
        Triangle.construction(test.getListeTriangle(),new ArrayList<>());
        System.out.println(test.getListeTriangle().get(0).getSegment1().getPoint1());
        System.out.println(test.getListePoint().get(502).calculBassin(test.getListeTriangle()).size());*/
    }

}
