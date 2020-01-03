package com.java.general.reporductorVoz.talker;

import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Talker {
	
	private String name;
	
	public Talker() {
		
	}
	
	public Talker(String name) {
		this.name = name;
	}
	
	
	public void talk() {
		try {
			// Set property as Kevin Dictionary
			System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");

			// Register Engine
			Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");

			// Create a Synthesizer
			Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

			// Allocate synthesizer
			synthesizer.allocate();

			// Resume Synthesizer
			synthesizer.resume();

			// Speaks the given text
			// until the queue is empty.
			synthesizer.speakPlainText("Hola", null);
			synthesizer.speakPlainText("Mi nombre es", null);
			synthesizer.speakPlainText(this.name, null);
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

			// Deallocate the Synthesizer.
			synthesizer.deallocate();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
