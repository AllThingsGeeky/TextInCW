/*
 * This class covers the functions of supported key types. List of supported key type follows.
 * 
 * Iambic mode B
 * While the left control key is being held down, dits continuously play
 * While the right control key is being held down, dahs continuously play
 */

package textincw;

//Imported external library. JNativeHook will allow us to
//listen and respond to keyboard actions even in the background
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import static com.github.kwhat.jnativehook.GlobalScreen.*;
import static com.github.kwhat.jnativehook.keyboard.NativeKeyEvent.getKeyText;

//Normal stuff
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.util.Timer;

import javax.sound.sampled.LineUnavailableException;

import java.awt.*;

public class Keyers implements NativeKeyListener {
	public static int wpm = 20;
	public static int dit = 1200/wpm;
	public static int dah = dit * 3;
	public static int hz = 800;
	public static String keyType = "Iambic Mode B";
	
	static int timertaskdelay = 0;
	
	Timer timer = new Timer();
	TimerTask timertask;
	
	//I just added the main method here so we can just run the class on its own for testing
	public static void main(String[] args) {
		System.out.println("Initializing...");
		try {
			GlobalScreen.registerNativeHook();
		}
		
		catch(NativeHookException ex) {
			System.out.println("There was a problem with the native hook");
			System.out.println(ex.getMessage());
			
			System.exit(1);
		}
		
		addNativeKeyListener(new Keyers());
		System.out.println("Loaded NativeHook successfully... You may start pounding brass.");
	}
	
	/*Keyers() {
		System.out.println("Initializing...");
		try {
			GlobalScreen.registerNativeHook();
		}
		
		catch(NativeHookException ex) {
			System.out.println("There was a problem with the native hook");
			System.out.println(ex.getMessage());
			
			System.exit(1);
		}
		
		addNativeKeyListener(new Keyers());
		System.out.println("Loaded NativeHook successfully... You may start pounding brass.");
	}*/
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		if (timertask != null)
            return;

        timertask = new TimerTask() {
            @Override
            public void run() {
                if(keyType=="Iambic Mode B") {
                	
                	//This will be ran when the left control key is pressed.
                	if(e.getKeyLocation() == 2 && e.getKeyCode()==29) {
                		System.out.print(".");
                		try {
							Sidetone.transmit(hz, dit, 0.8);
						} catch (LineUnavailableException e1) {
							System.out.println("The sidetone was unable to play.");
							e1.printStackTrace();
						}
                	}
                	
                	//This will be ran when the right control key is pressed.
                	if(e.getKeyLocation() == 3 && e.getKeyCode()==29) {
                		System.out.print("-");
                		try {
							Sidetone.transmit(hz, dah, 0.8);
						} catch (LineUnavailableException e1) {
							System.out.println("The sidetone was unable to play");
							e1.printStackTrace();
						}
                	}
                }
            }
        };

        timer.scheduleAtFixedRate(timertask, 0, dit+timertaskdelay);
        
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		System.out.print(" ");
		
		timertask.cancel();
        timertask = null;
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e ) {}
}
