package net.cablen.caja.estadoDeCuentas.modelo;

import jxl.*;
import jxl.read.biff.BiffException;


import java.io.*;
import java.text.NumberFormat;
import java.util.Date;

//import javax.swing.JOptionPane;

public class EstadoDeCuentas {
	
	PrintWriter logExcel = null;
	PrintWriter logKey = null;
	Date fecha = new Date();
	
	public String cargarEstado(String path){	
	
		String ext = "";
		String msg ="";
		String convrtFloat  ="";
		String referencia=""; //pasa a ser la referenica del banco para ser almacenada
		int resulExcel =  0;
		int resultDB = 0;
		
		ext = path.substring(path.length() - 3,path.length());
		
		if (ext.equals("xls")){

			try {	
				
				
				logExcel = this.crearlog("logEstadoCuenta" + fecha.getYear() +  fecha.getMonth() +  fecha.getDay() + ".txt");
				logKey = this.crearlog("registrosDuplicados"  + fecha.getYear() +  fecha.getMonth() +  fecha.getDay() + ".txt");
				
				Workbook archivoExcel = Workbook.getWorkbook(new File(path));
				
				for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) { 
					
					Sheet hoja = archivoExcel.getSheet(sheetNo); 
					int numFilas = hoja.getRows(); 
					
					for (int fila = 0; fila < numFilas; fila++) { 
						
					        EstadosCuenta edoCu = new EstadosCuenta();
					        EstadosCuentaDao edoDao = new EstadosCuentaDao(); 
					        String strFloat="";
					        convrtFloat = hoja.getCell(3, fila).getContents();
					        char[] acumCh = new char[convrtFloat.length()];
					        int tam = convrtFloat.length();
					        int i = 0;
					        char tmp = 0;

					        while (i < tam){
					        	tmp = convrtFloat.charAt(i);		        	
					        	acumCh[i] = tmp;	        	
					        	i++;
					        };
					        
					        i=0;
					        
					        while (i < tam){	
					        	if (tam >= 4){
					        		tmp = acumCh[tam -3];
					        		if (!Character.isDigit(tmp)){
					        			tmp ='.';
					        		}
					        		acumCh[tam -3] = tmp;					        		 		
					        	}
					        	
					        	if (tam >= 4){
					        		tmp = acumCh[tam -2];
					        		if (!Character.isDigit(tmp)){
					        			tmp ='.';
					        		}
					        		acumCh[tam -2] = tmp;					        		 		
					        	}
					        	
					        	
					        	if (tam > 7){
					        		tmp = acumCh[tam -7];
					        		if (!Character.isDigit(tmp)){				        	
					        				tmp=' ';
					        		}
					        		acumCh[tam -7] = tmp;		        	
					        	}

					        	strFloat = strFloat + acumCh[i];
					        	i++;
					        	
					        };
					        
					        convrtFloat = strFloat.replace(" ","").toString();
					       // System.out.println(convrtFloat);
					       
						    try {
						    	 edoCu.setMonto(Float.parseFloat(convrtFloat)); 
						    	 
						    	 if (edoCu.getMonto() > 0){
						    	
						    		 edoCu.setFechaPago(convtFecha(hoja.getCell(0, fila).getContents()));
						    		 edoCu.setDescripcion(hoja.getCell(2, fila).getContents());
						    		 referencia = validarReferencia(hoja.getCell(2, fila).getContents(),edoCu.getDescripcion(),hoja.getCell(1, fila).getContents());
						    		 edoCu.setReferencia(referencia);
						    		 edoCu.setCodBanco(hoja.getCell(4, fila).getContents());
						    		 edoCu.setEstatus(0);	
						    		 resultDB = edoDao.guardar(edoCu);
						    		 
						    		 if (resultDB < 0){
						    			 
						    			 	String[] filaLog = new String[5];
											filaLog[0] = hoja.getCell(0, fila).getContents();
											filaLog[1] = hoja.getCell(1, fila).getContents();
											filaLog[2] = hoja.getCell(2, fila).getContents();
											filaLog[3] = hoja.getCell(3, fila).getContents();
											filaLog[4] = hoja.getCell(4, fila).getContents();
											escribirLogDB(filaLog);
						    			    filaLog = null;
						    			    
						    		 }
						    		 
						    	 }
						    	 
							} catch (Exception e) {
								
								String[] filaLog = new String[6];
								filaLog[0] = hoja.getCell(0, fila).getContents();
								filaLog[1] = hoja.getCell(1, fila).getContents();
								filaLog[2] = hoja.getCell(2, fila).getContents();
								filaLog[3] = hoja.getCell(3, fila).getContents();
								filaLog[4] = hoja.getCell(4, fila).getContents();
								filaLog[5] = " Problema " +  e.toString();
								escribirLogExcel(filaLog);
								filaLog = null;
								//JOptionPane.showMessageDialog(null,e.toString());
								resulExcel = -1;
								
							}
					
							edoCu = null;
							edoDao = null;
						
					}
					
					logExcel.close();
					logKey.close();
					
					Runtime proceso = Runtime.getRuntime();
					proceso.exec("notepad.exe logEstadoCuenta" + fecha.getYear() +  fecha.getMonth() +  fecha.getDay() + ".txt");
					proceso.exec("notepad.exe registrosDuplicados"  + fecha.getYear() +  fecha.getMonth() +  fecha.getDay() + ".txt");
					
					
				}
				
				if (resulExcel == 0){
					msg = "Se almacenaron los datos con exito";
				}else{
					msg = "Se almacenaron los datos con algunos problemas";
					
				}
				
				return msg;
				
			} catch (BiffException | IOException e) {
				System.out.println("error");
				msg = "Recuerda guardar el archivo como libreo 97-2003 de excel";
				return msg;
			} 
			
		}else {
			
			msg = "Recuerda guardar el archivo como libreo 97-2003 de excel";
			return msg;
			
		}
	
	}
	
	
	/*
	 * valida la referencia para ser almacenada en la BD cuando el campo viene totalmente en 0 
	 * 
	 * */
	private String validarReferencia(String loteB, String desc,String ref){
		
		String refBancaria ="";
		String lote="";
	    String colDesc = "";
	    
	    if (loteB.length() >= 3)
	    	colDesc = loteB.substring(0,3);

		if (colDesc.equals("AB.")){
			
		    lote = desc.substring(desc.length()-13,desc.length());	
			
			refBancaria = lote.replace(" ","");
			//System.out.println(refBancaria);
			
		}else if (colDesc.equals("TDB")){
			
		    lote = desc.substring(desc.length()-13,desc.length() - 9);	
			
			refBancaria = lote.replace(" ","") + ref;
			//System.out.println(refBancaria);
		
		}else{	
			refBancaria = ref;
		}
	
		return refBancaria;
		
	}
	
	/*
	 * Valida el formato extraido del archivo y lo coloca en el formato que corresponde
	 * para ser almacenados en la BD
	 * */
	private String convtFecha(String cadena){ 
		
		String dia="";
		String mes="";
		String ano="";
		String fecha="";
		String separador="";
		int tamano;
		
		tamano = cadena.length();
		
		if (tamano == 8){

			separador =  cadena.substring(2,3);
			
			if (separador.equals("/")){
				
				dia = cadena.substring(0,2);
				mes = cadena.substring(3,5);
				ano = cadena.substring(6,8);
				fecha = "20" + ano + separador + mes + separador + dia;
				
			}else {
				
				dia = cadena.substring(0,2);
				mes = cadena.substring(2,4);
				ano = cadena.substring(4,8);
				fecha = ano + "/" + mes + "/" + dia;
			}
			
		}else{
			dia = cadena.substring(0,2);
			mes = cadena.substring(3,5);
			ano = cadena.substring(6,10);
			fecha = ano + "/" + mes + "/" + dia;
		}
	
		return fecha;

	}
	
	
	 private PrintWriter crearlog(String nombre){

		  
			try {
				File archivo = new File(nombre);
				FileWriter writer;
				writer = new FileWriter(archivo);
				PrintWriter log = new PrintWriter(writer);
				return log;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		   
		 	
	 }
	 
	 private void escribirLogExcel(String[] cadena){
		 	  
		 	  logExcel.write(cadena[0] +  " ");
		 	  logExcel.write(cadena[1] +  " ");
		 	  logExcel.write(cadena[2] +  " ");
		 	  logExcel.write(cadena[3] +  " ");
		 	  logExcel.write(cadena[4] +  " ");
		 	  logExcel.write(cadena[5]);
		 	  logExcel.println();
		 	  logExcel.write("_____________________________________________________");
		 	  logExcel.println();
	}

	 private void escribirLogDB(String[] cadena){
	 	  
		 	logKey.write(cadena[0] +  " ");
		 	logKey.write(cadena[1] +  " ");
	 		logKey.write(cadena[2] +  " ");
	 		logKey.write(cadena[3] +  " ");
	 		logKey.write(cadena[4] +  " ");
	 		logKey.println();
	 		logKey.write("_____________________________________________________");
	 		logKey.println();
	 }
	 
	 public EstadosCuenta obtener(String ref){
		 
		 EstadosCuenta objEstC =null;
		 EstadosCuentaDao objDao = new EstadosCuentaDao();
		 objEstC = objDao.findByRef(ref);
		 objDao = null;
		 return objEstC;
		 
	 }
	

}
