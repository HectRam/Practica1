/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Hector
 */
import java.io.*;
import java.util.StringTokenizer;
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public void leer()
    {
        String thisLine;
        thisLine = null;
        String etiqueta = null, codop = null, operando = null;
        
                try{
            BufferedReader lectb = new BufferedReader(new FileReader("arch.asm"));
            File arch = new File("arch.asm");
            boolean banEnd;
            banEnd = false;
            
                    while((thisLine = lectb.readLine()) != null){
                        
                     if(thisLine.charAt(0) == ';'){
                         System.out.println("Comentario");
                     }
                     else{
                         
                         
                     }
                        
                        
                        
                        
                        System.out.println(thisLine);//muestra temporal
                       if("End".equals(thisLine)){
                           banEnd = true;
                       }
                       if(banEnd != false)
                       {
                           //System.out.println("Error: no se encontro el final del archivo(End)");
                       }
                    }
                //System.out.println("Fin del recorrido");              
                }catch(Exception e){
                    
    }
        
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Practica1 H = new Practica1();
         H.leer();
    }
    
}
