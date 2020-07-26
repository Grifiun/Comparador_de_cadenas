package comparador;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase dedicada al algoritmo
 * @author grifiun
 */
public class Algoritmo {  
    List<ArrayList> resultado = new ArrayList<>();
    private char[] cadena1, cadena2;

    /**
     * Constructor de la clase Algoritmo
     * Tiene como funcion recibir 2 palabras de clase String
     * Para luego transformarlos a cadenas de caracteres
     * Y despues comparar dichas cadenas y dar un resultado
     * @param palabra1
     * @param palabra2 
     */
    public Algoritmo(String palabra1, String palabra2){
        this.cadena1 = palabra1.toCharArray();
        this.cadena2 = palabra2.toCharArray();
        comparar();
        imprimirResultado();
    }
    
    /**
     * Funcion encargada de revisar la cadena de mayor tamano
     * Equivalente entre ambas cadenas     * 
     */
    private void comparar(){        
        
        
        /**
         * Primer ciclo
         * comienza desde la primera posicion de la primera cadena
         * y termina en la ultima posicion
         */
        for(int i = 0; i < cadena1.length; i++){
            /**
             * Segundo ciclo
             * Comienza desde la primera posicion de la segunda cadena 
             * y termina en la ultima posicion
             */
            for(int j = 0; j < cadena2.length; j++){
                //Se comparan las posiciones de las cadenas
                if(cadena1[i] == cadena2[j]){
                    ArrayList<Character> aux = new ArrayList<>();
                    /**
                     * Si son iguales, se siguen comparando las siguientes posiciones
                     * de ambas palabras, ej: aA comparado aA, las "A" mayus serian las
                     * que se comparan despues de la primera posicion confirmada
                     * en este caso las "a"
                     */
                    aux.add(cadena1[i]);//se agrega el primer caracter 
                    boolean finalizar = true;//Variable encargada de finalizar el ciclo while
                    int k = 1;//variable que se usara para comparar las siguientes pos
                    while(finalizar){//si finalizar es falso el ciclo termina
                        if((i+k) >= cadena1.length || (j+k) >= cadena2.length)//se revisa si existen los caracteres a comparar
                            finalizar = false;//si no existen entonces el ciclo termina
                        else{//si existen se comparan
                            if(cadena1[i+k] == cadena2[j+k]){//si las siguientes cadenas son iguales
                                aux.add(cadena1[i+k]);//se agrega el siguiente caracter igual
                                k++;
                            }else{//de lo contrario, termina el ciclo
                                finalizar = false;
                            }                        
                        }  
                    }//Fin while 
                    
                    resultado.add(aux);//Agregamos el resultado de esta vuelta a la lista de resultados                   
                }       
            }
        } 
    }

    /**
     * Imprimimos los resultados de mayor longitud
     * En caso de que hayan varios del mismo tamano
     * todas seran impresas
     */
    private void imprimirResultado() {       
        int tam = analizarLongitud();
        for(int i = 0; i < resultado.size(); i++){
            if(resultado.get(i).size() == tam){//Si es del tamano max, se imprimira                
                    for(int ii = 0; ii < resultado.get(i).size(); ii++){
                        System.out.print(resultado.get(i).get(ii));
                    }
                    System.out.println("");
            
            }
        }
    }
    
    /**
     * Metodo utilizado para analizar la mayor longitud de 
     * los posibles resultados
     * @return 
     */
    private int analizarLongitud(){
        int tamano = 0;
        for(int i = 0; i < resultado.size(); i++){            
            int tamAux = (Integer)resultado.get(i).size();
            if(tamAux > tamano){
                /**
                 * Si el tamano de la cadena actual es mayor que el tamano general, se reemplaza su valor
                 */
                tamano = resultado.get(i).size();
            }
        }        
        return tamano;
    }
}
