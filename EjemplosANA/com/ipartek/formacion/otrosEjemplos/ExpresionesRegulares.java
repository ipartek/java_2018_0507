package com.ipartek.formacion.otrosEjemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {

	public static void main(String[] args) {
		System.out.println("c:\nuevos\trabajos");
		System.out.println("c:\\nuevos\\trabajos");
		
		
		//Expresion regular
		String regex="\\w+@\\w+\\.\\w+";
		System.out.println(regex);
		
		
		Pattern pattern =Pattern.compile(regex);
		Matcher matcher =pattern.matcher("formacion@ipartek.com");
		System.out.println("coincide con el patron? "+matcher.matches());
		
		
		System.out.println(matcher.matches());
		
		System.out.println("formacion@ipartek.com".matches(regex));
		

	}

}
