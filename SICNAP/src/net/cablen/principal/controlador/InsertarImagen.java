package net.cablen.principal.controlador;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class InsertarImagen implements Border{

	BufferedImage buf;
	
	public InsertarImagen() {

		try {
			URL imagenPath = new URL(getClass().getResource("fondo.jpg").toString());
			buf = ImageIO.read(imagenPath);	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Mal");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO");
			e.printStackTrace();
		}
		
	
	}
	
	@Override
	public Insets getBorderInsets(Component arg0) {
		return new Insets(0, 0, 0, 0);
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y,
			int w, int h) {
		
		g.drawImage(buf,(x + (w - buf.getWidth()) / 2), (y + (h - buf.getHeight()) /2),null);
		
	}

}
