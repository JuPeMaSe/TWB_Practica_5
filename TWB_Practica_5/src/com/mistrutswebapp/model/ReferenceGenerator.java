package com.mistrutswebapp.model;

/**
 * Genera un identificador único, uniendo user_Id pasado como parámetro y generando aleatoriamente un número de tres cifras.
 * Sólo tiene un método estático para no tener que crear una instancia de la clase.
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class ReferenceGenerator{
	/**
	 * Método estático que crea un identificador único
	 * @param user_ID
	 * @return identificador único
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
