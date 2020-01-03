package com.java.general.reporductorVoz;

import com.java.general.reporductorVoz.talker.Talker;

/**
 * author: Samuel Garcia
 * Este programa saluda y te dice el nombre del que habla
 *
 */
public class App {

	public static void main(String[] args) {
		Talker talker = new Talker("Sam");
		talker.talk();
	}

}
