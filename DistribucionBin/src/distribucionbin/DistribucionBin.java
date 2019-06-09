/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionbin;

import java.util.Scanner;

/**
 *
 * @author Jusot
 */
public class DistribucionBin {
    
   //En ésta función de factorial su capacidad máxima es 170!
    public static double Factorial(int n){
        double m=n;
        if (n==0 || n==1)
            return 1;
        if (n==2)
            return 2;
        for (int f=n; f>2; f--){
            m=m*(f-1);
        }
        return m;
    }
            
    public static float Probabilidad(int n, float p, int x)
    {
        int t=n-x; 
        float q=(float) (1-p);
        float b=0;
        double m=Factorial(n);
        double k=Factorial(x);
        double h=Factorial(t);
        b=(float) ((m/(k*h))*(Math.pow(p,x))*(Math.pow(q,t)));
        return b;
    }
    public static float Minprobabi(int n, float p, int x, int k)
    {
        float m=0;
        for (int i=x; i<=k; i++){
            m=m+(Probabilidad(n,p,i));
        }
        return m;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        System.out.println("DISTRIBUCIONES BINOMIALES");
        System.out.print("Julian Giraldo Cardona.");
        System.out.println(" | Jhon Brayan Medina G.");
        System.out.print("Digite Cantidad de objetos en la probabilidad [n]: ");
        int n= entrada.nextInt();
        System.out.print("Digite el valor de la probabilidad a utilizar [p]: ");
        float p= entrada.nextFloat();
        System.out.print("Digite el valor de Xmax: ");
        int x= entrada.nextInt();
        System.out.print("Digite el valor de Xmin: ");
        int z= entrada.nextInt();
        int s=x-z;
        if (s!=x){
        float m= Minprobabi(n,p,s,x);
        System.out.print("El valor de la probabilidad con Xmin["+s+"] es: ");
        System.out.println(""+m+"");
        }
        if(s==x){
        float c=Probabilidad(n, p, s);
        System.out.print("El valor de la probabilidad con Xmax["+s+"] es: ");
        System.out.println(""+c+"");
        }
        String opcion="no";
        
    System.out.println("------------------------------------");

       do {
         opcion = entrada.nextLine();
         switch (opcion)
         {
           case "si":System.out.print("Digite el nuevo valor de Xmax: ");
                    int o= entrada.nextInt();
                    System.out.print("Digite el nuevo valor de Xmin: ");
                    int a= entrada.nextInt();
                    int w=o-a;
                    if (w!=o){
                    float m= Minprobabi(n,p,w,o);
                    System.out.print("El valor de la probabilidad con Xmin["+w+"] es: ");
                    System.out.println(""+m+"");
                    }
                    if (w==o){
                    float l=Probabilidad(n,p,w);
                    System.out.print("El valor de la probabilidad con Xmax["+x+"] es: ");
                    System.out.println(""+l+"");
                    }
                    break;
           case "no": System.out.println("\n\nFin.\n");
                    break;
          }
         System.out.print("Quiere agregar otros valores de Xmax y Xmin? si/no: " );
        } while (!"no".equals(opcion));
    }
        
    }
    


