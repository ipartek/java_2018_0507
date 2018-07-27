package com.ipartek.formacion.javaee.servlets;

public class MillasKmForm {
	private double millas;
	private double km;
	private String errorMillas;
	private String errorKm;
	private String error;
	public MillasKmForm(double millas, double km, String errorMillas, String errorKm, String error) {
		super();
		this.millas = millas;
		this.km = km;
		this.errorMillas = errorMillas;
		this.errorKm = errorKm;
		this.error = error;
	}
	public MillasKmForm(double millas, double km) {
		super();
		this.millas = millas;
		this.km = km;
	}
	public MillasKmForm() {
		super();
	}
	public double getMillas() {
		return millas;
	}
	public void setMillas(double millas) {
		this.millas = millas;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public String getErrorMillas() {
		return errorMillas;
	}
	public void setErrorMillas(String errorMillas) {
		this.errorMillas = errorMillas;
	}
	public String getErrorKm() {
		return errorKm;
	}
	public void setErrorKm(String errorKm) {
		this.errorKm = errorKm;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
