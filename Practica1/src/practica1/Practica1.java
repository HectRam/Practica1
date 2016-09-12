/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
solo los metodos 
y parametros
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
        String thisLine,dir,a=".asm",ax=null;
        thisLine = null;
        int poslin=0,c=0,pos=0;
        
        String etiqueta = null, codop = null, operando = null, comentario=null,linToken=null,exEt=null;
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
            boolean banEnd,espacio,banCom;
            banEnd = false;
            espacio = false;
            banCom= false;
            
             System.out.println("Linea---ETQ-----CODOP-----OPER---");
            
             while((thisLine = lectb.readLine()) != null && banEnd != true){ //empieza a leer las lineas en loop
                        codop=" ";
	            	operando=" ";
	            	etiqueta=" ";
	                c++;
                       comentario=" ";    
                       
                  // System.out.println("Linea       \n"+thisLine);
                  // System.out.println("aqui "+linToken);
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
                     //  System.out.println("Token: "+linToken);
                  if(thisLine.charAt(0) == ' ' || thisLine.charAt(0) == '\t'){
                             
                            
                            espacio = true; 
                            
                       
                         }
                  else{
                      espacio = false;
                  }
                 /**
                  * comentario (empiezan con ; puede ir seguido de cualquier digito  del cero al nueve, cualquier caracter de la 'a' a la 'z' incluyendo mayusculas )
                  */
                    if(linToken.matches(".*[;].*")){

                         poslin=thisLine.indexOf(';');
                         
                      // System.out.println("Posicion linea del comentario   "+poslin+1);
                         comentario=thisLine.substring(poslin+1);
                         
                         StringTokenizer at = new StringTokenizer(comentario);
                         linToken=" ";
                         while(at.hasMoreTokens()){
                             ax=at.nextToken();
                     //      System.out.println("Ax    "+ax);
                            cadena.add(ax);
                         
                         }
                         linToken=" ";
                         banCom= true;
                     }
                      /**
                       * EntraEtiqueta
                       */
                       /*
                         if(linToken.matches("^[a-zA-Z]{1}[\\w]{0,8}$"))
                         {
                             System.out.println("Etiqueta "+linToken);
                         }*/
                         /**
                         * Entra Codop
                         */
                                if(linToken.matches("^[a-zA-Z]{1,4}(?!\\d )[/.]{0,1}[a-zA-Z]$")&&banCom==false){
                         
                         StringTokenizer aucod = new StringTokenizer(linToken);
                         codop=aucod.nextToken();
                     // System.out.println("Es codop   "+codop);
                         
                        if(codop.matches("^[a-z]{1,4}")&&!"equ".equals(codop)||codop.matches("^[ET][\\w]")){
                            etiqueta=codop;

                            codop="null";
                        }
                         
                         }
                                
                                /**
                                  * Entra Operando
                                  */  
                             else{
                                 
                     /**
                       
                      if(linToken.matches("^[a-z](?!\\d ){0,}[/.]{0,1}.{1,5}")){
                        
                        
                             System.out.println("residuo cod "+linToken);
                             
                                      }
                      */               
                                /**
                                  * Entra Operando
                                  */  
                                 if(codop!=" "&&linToken!=codop&&banCom==false){
                                  
                                     operando=linToken;
                                 //    System.out.println("Operando  "+operando);
                                    
                                     if(codop.equals(" ")){
                                         
                                         codop=linToken;
                                         
                                         
                                        System.err.println("Error Linea: "+c+"Hubo un error en el operando "+codop);
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
                                     
                                     if(espacio==false)
                                     {
                                           // thisLine.split(";");
                                         pos=0;
                                         exEt=" "; 
                                     
                                        // exEt=thisLine.substring(0,pos);
                                        // System.out.println("Pos "+pos);
                                         if(linToken.matches("^[a-zA-Z]{1,8}[^;]{0,1}[\\w]$")&&banCom==false)
                                         {
                                             
                                            //System.out.println("Lin token "+linToken);
                                            if(poslin!=0&&thisLine.charAt(poslin)!=' '&&poslin>2){
                                            //   System.out.println("com pos"+thisLine.charAt(poslin)+"Npos "+poslin);
                                               exEt=thisLine.substring(0,poslin);
                                            //   System.out.println("Etiqueta comen "+exEt);
                                            }
                                            
                                            //System.out.println("Et despues! "+exEt);
                                           //if(linToken.equals(exEt)){
                                               
                                               etiqueta=linToken;
                                             //  System.out.println("etiqueta  "+etiqueta);
                                               
                                               
                                              
                                          //}      
  
                                         
                                     }
                                      
                                     }
                                     
                                     cadena.clear();
                                     
                                     
                                 }
                                     
                                     
                                     
                             }
                         
                             
                     
                        
                        
                        
                   }
                   
                   if(codop==" "){
                       codop="null";
                   }
                   if(etiqueta==" ")
                   {
                       etiqueta="null";
                   }
                   if(operando==" "){
                     operando="null";
                     }
                  if(codop!= "null"){
                  System.out.println(c+"  ee  "+etiqueta+"  cc  "+codop+"  oo  "+operando);
                  }
                  if(operando!="null"&&codop=="null"&&etiqueta!="null"||operando=="null"&&codop=="null"&&etiqueta!="null"||operando!="null"&&codop=="null"&&etiqueta=="null")
                  {
                      System.out.println("Linea: "+c+" Error no se puede tener tener etiqueta u operando sin codop");
                  }
                     //  System.out.println(thisLine);//muestra temporal
                     banCom=false;
                     if(codop.equals("END")||codop.equals("End")||codop.equals("end")){//verifica si tiene End
                           banEnd = true;
                       }
                      else if(banEnd != false)
                       {
                           System.err.println("Error: no se encontro el final del archivo(End)");
                       }
                    }
                //System.out.println("Fin del recorrido");              
                }catch(Exception e){
                    System.err.println("Hubo un error \n"+e);
    }
        
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Practica1 H = new Practica1();
         H.leer();
    }
    
}
