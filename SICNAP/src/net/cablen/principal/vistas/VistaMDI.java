package net.cablen.principal.vistas;

import java.awt.Color;

import javax.swing.*;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import net.cablen.helppers.Usuario;
import net.cablen.principal.controlador.Controller_MDI;
import net.cablen.principal.controlador.InsertarImagen;

import java.awt.GridLayout;
import java.awt.Toolkit;

public class VistaMDI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBarra;
	private JMenu itemContrato,mISalir,mCajas,mCociliar,mReportCaja,mConfig,mOperaciones,mPrecinto,mRecibos,mSoporte,mCallCenter,mCartera;
	public JDesktopPane formMdi;
	public JMenuItem sIAsigContratos,sincroContratos,sIBuscarPromotor,sIReferencia,sIEstCuenta,sIViewRefe,sIviewConcilia,sIReportReferencia,sIReportConciliaciones,sIAbobyCont
	                 ,sIReportContratos,sIBancos,sIImpF,sIOficina,sICajero,sIAsigPrecinto,sIProcPrecinto,sIAboPrecinto,sIReportPrecinto,sIRecibo,sIProcRecibo,sIReportRecibo,
	                 sITroubleshooting,sIreportCallCenter,sIListCC,sICartera,sIReportCartera;
	Controller_MDI control;

	public VistaMDI(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/sistema.png"));
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	public void  inicializar(){
		formMdi = new JDesktopPane();
		formMdi.setBorder(new InsertarImagen());
		control = new Controller_MDI(this);
		setTitle("Sistema de Informacion Cable Norte Aplicado SICNAP     USER " + Usuario.getUser().getNombre() + " " + Usuario.getUser().getApellido());
		this.cargarMenu();
		formMdi.setBackground(new Color(125,150,200));// un colorcito p escritorio
		setJMenuBar(menuBarra);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(control);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		getContentPane().add(formMdi);	
		setVisible(true);
	
	}
	
	private void cargarMenu(){

		
		  menuBarra = new JMenuBar();
 
	/*________________________________________Configuracion del Sistema____________________________________________*/

		  mConfig = new JMenu("Sistema");
	    
		    Icon atIconBanco = new ImageIcon("img/banco.png");
		    sIBancos = new JMenuItem("Agregar Bancos",atIconBanco);
		    sIBancos.addActionListener(control);
		    
		    Icon atIconCajero = new ImageIcon("img/cajero.png");
		    sICajero = new JMenuItem("Agregar Cajero",atIconCajero);
		    sICajero.addActionListener(control);
		    
		    Icon atIcoImp = new ImageIcon("img/imp.png");
		    sIImpF = new JMenuItem("Agregar Impresora",atIcoImp);
		    sIImpF.addActionListener(control);
		    
		    Icon atIconOfi = new ImageIcon("img/oficina.png");
		    sIOficina = new JMenuItem("Agregar Oficinas/Lotes",atIconOfi);
		    sIOficina.addActionListener(control);
		    
		    Icon atIcon = new ImageIcon("img/iconPromotor.png");
	        sIBuscarPromotor = new JMenuItem("Agregar Promotores/Entes",atIcon);
	        sIBuscarPromotor.addActionListener(control);
	      
	        
	     mConfig.add(sIBancos);
	     mConfig.add(sICajero);
	     mConfig.add(sIImpF);
	     mConfig.add(sIOficina);
	     mConfig.add(sIBuscarPromotor);
			
	/*_____________________________________________________________________________________________________________*/
		  
		  
		       
		 
/*______________________________________________________________________________________________*/		  
	
	Icon atIcon1 = new ImageIcon("img/iconsincro.png");
	Icon atIcon2 = new ImageIcon("img/iconContrato.png");
	Icon atIcon11 = new ImageIcon("img/iconEstado.png");
	Icon atIcon12 = new ImageIcon("img/icoInformes.png");
	mOperaciones = new JMenu("Operaciones");
		
		itemContrato = new JMenu("Contratos");
		itemContrato.setIcon(atIcon11);    
		    sIAsigContratos = new JMenuItem("Asignar Pre-Contratos",atIcon2);
		  	sIAsigContratos.addActionListener(control);
		  	sincroContratos = new JMenuItem("Procesar Pre-Contratos",atIcon1);
		  	sincroContratos.addActionListener(control);
		    sIAbobyCont = new JMenuItem("Asignado",atIcon11);
		    sIAbobyCont.addActionListener(control);
		    sIReportContratos = new JMenuItem("Reporte",atIcon12);
		    sIReportContratos.addActionListener(control);
		 itemContrato.add(sIAsigContratos);
		 itemContrato.add(sincroContratos);
		 itemContrato.add(sIAbobyCont);  
		 itemContrato.addSeparator();
		 itemContrato.add(sIReportContratos);
		 
		 mPrecinto = new JMenu("Precintos");
			Icon atPre = new ImageIcon("img/precinto.png");	
			sIAsigPrecinto = new JMenuItem("Asignar",atIcon2);
			sIAsigPrecinto.addActionListener(control);
			sIProcPrecinto = new JMenuItem("Sincronizar",atIcon1);
			sIProcPrecinto.addActionListener(control);
			sIAboPrecinto = new JMenuItem("Asignado",atIcon11);
			sIAboPrecinto.addActionListener(control);
			sIReportPrecinto = new JMenuItem("Reporte",atIcon12);
			sIReportPrecinto.addActionListener(control);
			
		 mPrecinto.setIcon(atPre);
		 mPrecinto.add(sIAsigPrecinto);
		 mPrecinto.add(sIProcPrecinto);
		// mPrecinto.add(sIAboPrecinto);
		 mPrecinto.addSeparator();
		 mPrecinto.add(sIReportPrecinto);
		 
		 Icon atRecibo = new ImageIcon("img/recibos.png");	
		 mRecibos = new JMenu("Recibos");
		 mRecibos.setIcon(atRecibo);
		    Icon atAddrecibo = new ImageIcon("img/reciboAdd.png");
		 	sIRecibo = new JMenuItem("Asignar",atAddrecibo);
		    sIRecibo.addActionListener(control);
		    Icon atProcRecibo = new ImageIcon("img/reciboProc.png");
		 	sIProcRecibo = new JMenuItem("Procesar",atProcRecibo);
		 	sIProcRecibo.addActionListener(control);
		 	sIReportRecibo = new JMenuItem("Reporte",atIcon12);
		 	sIReportRecibo.addActionListener(control);
		    
		 mRecibos.add(sIRecibo); 	
		 mRecibos.add(sIProcRecibo);
		 mRecibos.addSeparator();
		 mRecibos.add(sIReportRecibo);
		
	 mOperaciones.add(itemContrato);	     
	 mOperaciones.add(mPrecinto);	
	 mOperaciones.add(mRecibos);
/*______________________________________________________________________________________________*/			  
		  
		  mCajas = new JMenu("Caja");
		    
		  	
		  	Icon atIcon3 = new ImageIcon("img/iconVistaConc.png");
		  	mCociliar = new JMenu("Concilar");
		  	mCociliar.setIcon(atIcon3);
			    
		  	    Icon atIcon4 = new ImageIcon("img/iconConcilia.png");
		  		sIEstCuenta = new JMenuItem("Importar Estados Bancarios",atIcon4);
		  		sIEstCuenta.addActionListener(control); 
		  	
		  		Icon atIcon5 = new ImageIcon("img/iconreferencia.png");
		  		sIReferencia  = new JMenuItem("Gestor de Referencias",atIcon5);
		  		sIReferencia.addActionListener(control);
		  		
		  		Icon atIcon6 = new ImageIcon("img/iconVistaRef.png");
		  		sIViewRefe = new JMenuItem("Visualizar Referencias",atIcon6);
		  		sIViewRefe.addActionListener(control);
		  		
		  		Icon atIcon7 = new ImageIcon("img/iconVistaConc.png");
		  		sIviewConcilia = new JMenuItem("Visualizar Conciliaciones",atIcon7);
		  		sIviewConcilia.addActionListener(control);
		  
		  		Icon atIcon9 = new ImageIcon("img/icoReporte.png");
		  		mReportCaja = new JMenu("Informes");
		  		mReportCaja.setIcon(atIcon9);
		  		
		  			Icon atIcon10 = new ImageIcon("img/icoInformes.png");
		  			sIReportReferencia = new JMenuItem("Gerencial (Refrencias)",atIcon10);
		  			sIReportReferencia.addActionListener(control);
		  		
		  			Icon atIcon13 = new ImageIcon("img/icoInformes.png");
		  			sIReportConciliaciones = new JMenuItem("Contable (Conciliaciones)",atIcon13);
		  			sIReportConciliaciones.addActionListener(control);
		  		
		  		mReportCaja.add(sIReportReferencia);	
		  		mReportCaja.add(sIReportConciliaciones);
		  		
		  	mCociliar.add(sIEstCuenta);
		  	mCociliar.addSeparator();
		  	mCociliar.add(sIReferencia);
		  	mCociliar.add(sIViewRefe);
		  	mCociliar.add(sIviewConcilia);
		  	mCociliar.addSeparator();
		  	mCociliar.add(mReportCaja);
		  	
		  mCajas.add(mCociliar);
		
/*______________________________________________________________________________________________*/		
		  
		  Icon atICall = new ImageIcon("img/callcenter.png");
		  Icon atICart = new ImageIcon("img/cartera.png");
		  Icon atITro = new ImageIcon("img/soporte.png");
		  Icon atIRec = new ImageIcon("img/iconCartera.png");
		  Icon atIOp = new ImageIcon("img/incopen.png");
		  
		  mSoporte = new JMenu("Soporte");
		  mCallCenter = new JMenu("Call Center");
		  mCallCenter.setIcon(atICall);
		      sITroubleshooting = new JMenuItem("Generar Incidencia",atITro);
		      sITroubleshooting.addActionListener(control);
		      sIreportCallCenter = new JMenuItem("Informe",atIcon12);
		      sIreportCallCenter.addActionListener(control);
		      sIListCC = new JMenuItem("Visualizar Incidencias",atIOp);
		      sIListCC.addActionListener(control);
		  mCallCenter.add(sITroubleshooting);
		  mCallCenter.add(sIListCC);
		  mCallCenter.addSeparator();
		  mCallCenter.add(sIreportCallCenter);
		  
		  mCartera = new JMenu("Cartera");
		  mCartera.setIcon(atICart);
	      	sICartera = new JMenuItem("Recuperacion",atIRec);
	      	sICartera.addActionListener(control);
	      	sIReportCartera = new JMenuItem("Informe",atIcon12);
	      	sIReportCartera.addActionListener(control);
	      mCartera.add(sICartera);
	      mCartera.addSeparator();
	      mCartera.add(sIReportCartera);
	      	
	      	
		  mSoporte.add(mCallCenter);
		  mSoporte.add(mCartera);
		 
/*_______________________________________________________________________________________________*/
      Icon atIcon8 = new ImageIcon("img/iconSalir.png");
      mISalir = new JMenu("Salir"); 
      mISalir.setIcon(atIcon8);
      mISalir.addMouseListener(control);

      menuBarra.add(mConfig);
	  menuBarra.add(mOperaciones);
	  menuBarra.add(mCajas);
	  menuBarra.add(mSoporte);
	  menuBarra.add(mISalir);
	
	  
    }


	public JMenu getmISalir() {
		return mISalir;
	}

	public void setmISalir(JMenu mISalir) {
		this.mISalir = mISalir;
	}
	
	
	
}

