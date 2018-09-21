/**
 * 
 */
package model;

import cUtil.CList;

/**
 * @author Santiago
 *
 */
public class Match {
	
	private CList<Player> actualPlayers;
	
	/**
	 * 
	 */
	public Match(Player[] players) {
		actualPlayers = new CList<>();
		// TODO Auto-generated constructor stub
		for (int i = 0; i < players.length; i++) {
			if(players[i]!=null) {
				actualPlayers.add(players[i]);
			}
		}
	}
	
	
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
	
	public String getFirst() {
		return actualPlayers.get(0).getNickName();
	}
}
