package com.mistrutswebapp.model;

/**
 * Genera un identificador �nico, uniendo user_Id pasado como par�metro y generando aleatoriamente un n�mero de tres cifras.
 * S�lo tiene un m�todo est�tico para no tener que crear una instancia de la clase.
 * @author Grupo 7 Pr�cticas Tecnolog�as Web 2014-2015
 *
 */
public class ReferenceGenerator{
	/**
	 * M�todo est�tico que crea un identificador �nico
	 * @param user_ID
	 * @return identificador �nico
	 */
	public static String getReference(String user_ID){
		StringBuffer reference = new StringBuffer();
		reference.append(user_ID);
		int rand = (int)Math.floor(Math.random()*999);
		reference.append(rand);
		//System.out.println("reference = " + reference.toString());
		return reference.toString();
	}
	
}
