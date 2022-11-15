package textincw;

import java.awt.AWTException;
//We will use Robot to automate keystrokes
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Decode {
	public static String letter = ".--";
	
	public static void main(String[] args) throws AWTException {
		new Decode();
	}
	
	Decode() throws AWTException {
		//Morse code lookup table
		switch (letter) {
			case ".-":   type('A'); break;
			case "-...": type('B'); break;
			case "-.-.": type('C'); break;
			case "-..":  type('D'); break;
			case ".":    type('E'); break;
			case "..-.": type('F'); break;
			case "--.":  type('G'); break;
			case "....": type('H'); break;
			case "..":   type('I'); break;
			case ".---": type('J'); break;
			case "-.-":  type('K'); break;
			case ".-..": type('L'); break;
			case "--":   type('M'); break;
			case "-.":   type('N'); break;
			case "---":  type('O'); break;
			case ".--.": type('P'); break;
			case "--.-": type('Q'); break;
			case ".-.":  type('R'); break;
			case "...":  type('S'); break;
			case "-":    type('T'); break;
			case "..-":  type('U'); break;
			case "...-": type('V'); break;
			case ".--":  type('W'); break;
			case "-..-": type('X'); break;
			case "-.--": type('Y'); break;
			case "--..": type('Z'); break;
		}
	}
	
	public void type(char ch) throws AWTException {
		//The robot class in java.awt will simulate
		//keyboard keystrokes a valid letter is sent
		Robot robot = new Robot();
		
		//The following 4 lines will type a capital
		//letter from the lookup table.
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(ch);
		robot.keyRelease(ch);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
}
