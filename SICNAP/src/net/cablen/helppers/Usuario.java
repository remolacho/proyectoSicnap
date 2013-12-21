package net.cablen.helppers;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.cablen.usuario.modelo.Usuarios;

public class Usuario {
	
	private static Usuarios userGenrico;
	
	public static Usuarios getUser(){
		
		return userGenrico;
		
	}
	
	public static void setUser(Usuarios user){
		
		userGenrico = user;
		
	}

}
