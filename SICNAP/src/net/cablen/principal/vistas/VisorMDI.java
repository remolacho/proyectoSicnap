package net.cablen.principal.vistas;


public class VisorMDI {
	
	 private static final  VistaMDI frmMenu = buildMid();
	 
	 private static VistaMDI buildMid() {
	        try {
	               VistaMDI vista = new VistaMDI();
	              // System.out.println("se creo");
	               return vista;
	        }
	        catch (Throwable ex) {
	        	  return null;
	        }
	}
	 
	public static VistaMDI getFrmMenu() {
	        return frmMenu;
	}
	 
}
