package com.ipartek.formacion.javaee.modelos;

public class ConversorForm {

	// 1KM = 0.62 Millas
	private static final double KM_A_MILLA = 0.621371;
	// 1 Milla = 1.61 KM
	private static final double MILLA_A_KM = 1.60934;
	
	private String kms = "";
	private String millas = "";
	
	private String kmsaMillas = "0";
	private String millasaKms = "0";
	
	private boolean erroneo = false;
	
	
	public ConversorForm() {
	}

	public String getKms() {
		return kms;
	}


	public void setKms(String kms){
		try{  
		    Double.parseDouble(kms);  
		    this.kms = kms;
		}catch(NumberFormatException nfe){  
		    setErroneo(true);
		    throw new RuntimeException("ERROR NUMERICO");
		}  
	}

	public String getMillas() {
		return millas;
	}


	public void setMillas(String millas) {
		try{  
		    Double.parseDouble(millas);  
		    this.millas = millas;
		}catch(NumberFormatException nfe){  
		    setErroneo(true);
		    throw new RuntimeException("ERROR NUMERICO");
		}  
	}


	public String getKmsAMillas() {
		return kmsaMillas;
	}


	public void setKmsAMillas(String kmsaMillas) {
		this.kmsaMillas = kmsaMillas;
	}


	public String getMillasAKms() {
		return millasaKms;
	}


	public void setMillasAKms(String millasaKms) {
		this.millasaKms = millasaKms;
	}
	
	public boolean isErroneo() {
		return erroneo;
	}

	public void setErroneo(boolean erroneo) {
		this.erroneo = erroneo;
	}

	public static double kmsaMillas(String kms) {
		// 1KM = 0.62 Millas
		return Double.parseDouble(kms) * KM_A_MILLA;
	}
	
	public static double millasAKms(String millas) {
		// 1 Milla = 1.61 KM
		return Double.parseDouble(millas) * MILLA_A_KM;
	}
	
	
	
	
}
