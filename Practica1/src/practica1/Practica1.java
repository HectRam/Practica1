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
import java.util.Scanner;
import java.util.StringTokenizer;
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public void leer()
    {
        Scanner s = new Scanner(System.in);
        String thisLine,dir,a=".asm";
        thisLine = null;
        int poslin;
        String etiqueta = null, codop = null, operando = null, comentario=null,instruccion= null,linToken=null;
        
        System.out.print("Ruta del archivo? ");
          dir= s.nextLine();
         // System.out.print(dir);
                try{
             FileInputStream fstr = new FileInputStream(dir+a);
             DataInputStream input = new DataInputStream(fstr);
            BufferedReader lectb = new BufferedReader(new InputStreamReader(input));
           // StringTokenizer Token = new StringTokenizer(dir+a);
            boolean banEnd,espacio;
            banEnd = false;
            espacio = false;
            
            
            //System.out.println(" Linea  Etiqueta  Codop    Oper");
            
             while((thisLine = lectb.readLine()) != null){ //empieza a leer las lineas en loop
                       
                       comentario=" ";      
                   System.out.println("Linea       \n"+thisLine);
                   
                   StringTokenizer Token = new StringTokenizer(thisLine);
                   
                   while(Token.hasMoreTokens())
                   {
                       
                   linToken=Token.nextToken();
                    
                   
                  System.out.println("Token: "+linToken);
                  /*     
                     if(thisLine.charAt(0) == ';'){
                         System.out.println("Comentario");   
                     }*/
                  if(thisLine.charAt(0) == ' ' || thisLine.charAt(0) == '\t'){
                             
                            // etiqueta = null;
                            //System.out.print("Etiqueta"+etiqueta);
                            espacio =true; 
                          
                         }
                  else{
                      espacio = false;
                  }
                     if(linToken.matches(";[0-9a-zA-Z._ ]*")){

                         poslin=thisLine.indexOf(';');
                         
                       //  System.out.println("posicion   "+poslin);
                         comentario=thisLine.substring(poslin+1);
                         
                         StringTokenizer auxc = new StringTokenizer(comentario);
                         while(auxc.hasMoreTokens()){
                         
                         
                         }
                        
                         
                         
                         
                         
                     }
                     else{
                         
                         
                         
                         
                         
                         
                         
                         
                     }
                        
                        
                        
                   }   
                       // System.out.println(thisLine);//muestra temporal
                       if("END".equals(thisLine = lectb.readLine())){//verifica si tiene End
                           banEnd = true;
                       }
                       if(banEnd != false)
                       {
                           System.out.println("Error: no se encontro el final del archivo(End)");
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
