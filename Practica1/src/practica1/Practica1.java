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
import java.util.Vector;
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public void leer()
    {
        Scanner s = new Scanner(System.in);
        String thisLine,dir,a=".asm",ax;
        thisLine = null;
        int poslin,c=0;
        
        String etiqueta = null, codop = null, operando = null, comentario=null,instruccion= null,linToken=null,auxcod=null;
        Vector<String> cadena;
        cadena = new Vector<>();
        System.out.print("Ruta del archivo? ");
          dir= s.nextLine();
         /**
          * System.out.print(dir);
          */
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
                        codop=" ";
	            	operando=" ";
	            	etiqueta=" ";
	                c++;
                       comentario=" ";      
                 //  System.out.println("Linea       \n"+thisLine);
                   
                   StringTokenizer Token = new StringTokenizer(thisLine);
                   
                   while(Token.hasMoreTokens())
                   {
                       
                   linToken=Token.nextToken();
                    
                   
                 
                  /**
                   * 
                   * if(thisLine.charAt(0) == ';'){
                   * System.out.println("Comentario");   
                   * } 
                   * la linea sacada de nexToken
                   */
                //   System.out.println("Token: "+linToken);
                  if(thisLine.charAt(0) == ' ' || thisLine.charAt(0) == '\t'){
                             
                            // etiqueta = null;
                            //System.out.print("Etiqueta"+etiqueta);
                            espacio =true; 
                            
                           
                         }
                  else{
                      espacio = false;
                  }
                 /**
                  * comentario (empiezan con ; puede ir seguido de cualquier digito  del cero al nueve, cualquier caracter de la 'a' a la 'z' incluyendo mayusculas )
                  */
                     if(linToken.matches(";[0-9a-zA-Z._ ]*")){

                         poslin=thisLine.indexOf(';');
                         
                      // System.out.println("Posicion linea del comentario   "+poslin+1);
                         comentario=thisLine.substring(poslin+1);
                         
                         StringTokenizer at = new StringTokenizer(comentario);
                         linToken="";
                         while(at.hasMoreTokens()){
                             ax=at.nextToken();
                           //  System.out.println("Ax    "+ax);
                            cadena.add(ax);
                         
                         }
                     }
                       
                     else{
                         /**
                         * Entra Codop
                         */
                             if(linToken.matches("^[a-zA-Z].[/.]{0,1}.${1,5}")){
                         
                         StringTokenizer aucod = new StringTokenizer(linToken);
                         codop=aucod.nextToken();
                         System.out.println("Es codop   "+codop);
                         
                         
                         }
                             else{
                                 /**
                                  * Entra Operando
                                  */
                                 if(codop!=" "&&linToken!=codop){
                                  
                                     operando=linToken;
                                     System.out.println("Operando  "+operando);
                                     if(codop.equals(" ")){
                                         
                                         codop=linToken;
                                         
                                         
                                         System.out.println("Codop2   "+codop);
                                         operando=" ";
                                         
                                     }
                                     /**
                                      * Cierra Operando
                                      */
                                         
                                 }
                                 else
                                 {
                                     /**
                                      * Espacio
                                      */
                                     thisLine.split("\\s");
                                     
                                     
                                     
                                 }
                                     
                                     
                                     
                             }
                         
                             
                     }
                        
                        
                        
                   }   
                       // System.out.println(thisLine);//muestra temporal
                       /*if("END".equals(thisLine = lectb.readLine())){//verifica si tiene End
                           banEnd = true;
                       }
                       if(banEnd != false)
                       {
                           System.out.println("Error: no se encontro el final del archivo(End)");
                       }*/
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
