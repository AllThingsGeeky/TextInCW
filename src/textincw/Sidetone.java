/* This class generates the sidetone.
 * 
 */

package textincw;

import java.util.*;
import javax.sound.sampled.*;

public class Sidetone {
	//VBand seems to have a higher rate, but this seems to work just fine.
	public static float SAMPLE_RATE = 8000f;
	
	//I am going to move this somewhere else.
	public static int hz = 600;
	
	public static void transmit(int Hz, int msecs, double vol)
			throws LineUnavailableException {
				if (Hz <= 0)
					throw new IllegalArgumentException("Frequency <= 0 Hz");

				if (msecs <= 0)
					throw new IllegalArgumentException("Duration <= 0 msecs");

				if (vol > 1.0 || vol < 0.0)
					throw new IllegalArgumentException("Volume out of range 0.0-1.0");

				byte[] buf = new byte[(int)SAMPLE_RATE * msecs / 1000];

				for (int i=0; i<buf.length; i++) {
					double angle = i / (SAMPLE_RATE / Hz) * 2.0 * Math.PI;
					buf[i] = (byte)(Math.sin(angle) * 127.0 * vol);
				}

				// shape the front and back 10ms of the wave form
				/*for (int i=0; i < SAMPLE_RATE / 100.0 && i < buf.length / 2; i++) {
					buf[i] = (byte)(buf[i] * i / (SAMPLE_RATE / 100.0));
					buf[buf.length-1-i] = (byte)(buf[buf.length-1-i] * i / (SAMPLE_RATE / 100.0));
				}*/

				AudioFormat audioformat = new AudioFormat(SAMPLE_RATE,8,1,true,false);
				SourceDataLine sdl = AudioSystem.getSourceDataLine(audioformat);
				sdl.open(audioformat);
				sdl.start();
				sdl.write(buf,0,buf.length);
				sdl.drain();
				sdl.close();
		}
	
	//I have no intention to keep this method. This will just allow
	//us to run and test this one class only.
	public static void main(String[] args) throws LineUnavailableException {
		Sidetone.transmit(hz,1000,0.8);
	}
}