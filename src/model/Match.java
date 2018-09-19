/**
 * 
 */
package model;

/**
 * @author Santiago
 *
 */
public class Match {
	
	
	public double standardDeviation(int[] latencyArray) {
		
		  int valor [] = new int[latencyArray.length];
		  int sumatoria = 0;
		  float media = 0;
		  double varianza = 0.0;
		  double desviacion= 0.0; 
		   
		                //se abre el flujo entrada
		  
		  System.out .println("Ingrese el valor de 10 numeros"
		                                     +" como muestra");
		  //petición de datos y sumatoria de todos
		  for (int i = 0; i < latencyArray.length; i++ ){
		   
		   valor[i] = latencyArray[i];
		   
		   sumatoria = sumatoria + valor[i];
		    
		  }
		  
		  media = sumatoria / latencyArray.length; //media aritmetica 
		  
		  //se hace la suma de las diferencias respecto a la media
		  for(int i = 0 ; i < latencyArray.length; i++){
		   double rango;
		   rango = Math.pow(valor[i] - media, 2);
		   varianza = varianza + rango;
		  }
		  varianza = varianza / latencyArray.length;//suma de diferencias sobre "n"
		  //teniendo ya la varinza sólo debemos sacarle raiz cuadrada 
		  //tendremos la desviación estandar
		  desviacion = Math.sqrt(varianza);
		  
		  return desviacion;
	}
}
