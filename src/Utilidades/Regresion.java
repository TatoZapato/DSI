/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades;
/**
 *
 * @author Jorge
 */

public class Regresion {
  private double[] x;  //datos
  private double[] y;
  double[][] m;    //matriz de los coeficientes
  double[] t;      //términos independientes


  public Regresion(double[] x, double[] y) {
    this.x=x;
    this.y=y;
  }
  
  //calcular numero de datos
  private int n (double[] x){
      return x.length;
  }
  
  //Calcular sumatoria X
  private double Sx(double[] x){
    double Sx= 0.0;
    
    for (int i=0; i<x.length;i++){
        Sx+=x[i];
    }
      return Sx;
  }
  
  //Calcular sumatoria Y
  private double Sy(double[] y){
    double Sy= 0.0;
    
    for (int i=0; i<y.length;i++){
        Sy+=y[i];
    }
      return Sy;
  }

  //Calcular sumatoria X*Y
  private double Sxy(double[] x, double[] y){
    double Sxy= 0.0;  
    
    for (int i=0; i<y.length;i++){
        Sxy+=x[i]*y[i];
    }
      return Sxy;
  }
  
  //calcular sumatoria X*X
  private double Sxx(double[] x){
    double Sxx= 0.0;
    
    for (int i=0; i<x.length;i++){
        Sxx+=x[i]*x[i];
    }
      return Sxx;
  }
 
  
  
  
  //calcular m
  public double m(){
      double m=0.0;
      double Sx = Sx(x);
      double Sxx = Sxx(x);
      double Sy = Sy(y);
      double Sxy = Sxy(x,y);
      int n= n(x);
      
      m= (n*Sxy - Sx*Sy)/(n*Sxx - Sx*Sx);      
      return m;
  }
 
  //calcular n
  public double n(){
      double nReturn=0.0;
      double Sx = Sx(x);
      double Sxx = Sxx(x);
      double Sy = Sy(y);
      double Sxy = Sxy(x,y);
      int n= n(x);
      
      nReturn= (Sxx*Sy - Sx*Sxy)/(n*Sxx - Sx*Sx);      
      return nReturn;
  }

  
}
