package com.java.hilos.multichat.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Servidor {

	public static final int PORT = 4444;
	private static HashMap<String, Thread> listaHilos = new HashMap<String, Thread>();

	public static void main(String[] args) throws IOException {
		// Establece el puerto en el que escucha peticiones
		ServerSocket socketServidor = null;
		int contador = 1;
		try {
			socketServidor = new ServerSocket(PORT);
		} catch (IOException e) {
			System.out.println("No puede escuchar en el puerto: " + PORT);
			System.exit(-1);
		}

		Socket socketCliente = null;

		System.out.println("Escuchando: " + socketServidor);
		try {

			while (true) {
				socketCliente = socketServidor.accept();
				System.out.println("Connexión acceptada: " + socketCliente);
				Thread hilo = new Thread(new ServidorThread(String.valueOf(contador),socketCliente));
				listaHilos.put(String.valueOf(contador), hilo);
				hilo.start();
				++contador;
			}

		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}

		socketServidor.close();
	}

}
