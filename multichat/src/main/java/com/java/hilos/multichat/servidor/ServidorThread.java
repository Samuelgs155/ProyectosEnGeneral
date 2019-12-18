package com.java.hilos.multichat.servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorThread implements Runnable {

	private String name;
	private Socket socketCliente;

	public ServidorThread() {

	}

	public ServidorThread(String name, Socket socketCliente) {
		this.name = name;
		this.socketCliente = socketCliente;
	}

	public void run() {

		BufferedReader entrada = null;
	    PrintWriter salida = null;

		System.out.println("Nuevo hilo escuchado: " + this.socketCliente);
		try {
			// Establece canal de entrada
			entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));
			// Establece canal de salida
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socketCliente.getOutputStream())),
					true);
			
			// Hace eco de lo que le proporciona el cliente, hasta que recibe "Adios"
		      while (true) {  
		        String str = entrada.readLine();
				System.out.println("Cliente: " + str);
				salida.println(str);
				if (str.equals("Adios")) break;
		      }
		      
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}	
		
	    try {
	    	salida.close();
			entrada.close();
			this.socketCliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
