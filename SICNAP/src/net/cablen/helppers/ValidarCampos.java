package net.cablen.helppers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ValidarCampos {
	
	public static String soloFecha(){
		
		Date fecha = new Date();  
	    String patron = "yyyy/MM/dd";	    
	    SimpleDateFormat formato = new SimpleDateFormat(patron);
		return formato.format(fecha);
		
	}
	
	
	public static String soloFecha(Date fecha){
		
	    String patron = "yyyy/MM/dd";	    
	    SimpleDateFormat formato = new SimpleDateFormat(patron);
		return formato.format(fecha);
		
	}
	
	public static int compararFechas(Date fechaI) {
		Date fechaActual = new Date();
        int result = fechaI.compareTo(fechaActual);	
        if (result > 0) {
        //	System.out.println(result);//es mayor
           return 1;
        }else {
        //	System.out.println(result);
           return 0;
        }
        
    }
	
}
