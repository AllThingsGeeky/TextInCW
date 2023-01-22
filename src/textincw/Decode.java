package textincw;

import java.awt.AWTException;
//We will use Robot to automate keystrokes
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Decode {
	public static String letter = "-.-.-.";
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		new Decode();
	}
	
	Decode() throws AWTException {
		//Morse code lookup table
		switch (letter) {
			//The alphabet (A to Z)
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
			
			//Numbers
			case ".----": type('1'); break;
			case "..---": type('2'); break;
			case "...--": type('3'); break;
			case "....-": type('4'); break;
			case ".....": type('5'); break;
			case "-....": type('6'); break;
			case "--...": type('7'); break;
			case "---..": type('8'); break;
			case "----.": type('9'); break;
			case "-----": type('0'); break;
			
			//Punctuation
			case ".-.-.-": type('.'); break;
			case "--..--": type(','); break;
			case "..--..": type('?'); break;
			case "-.-.--": type('!'); break;
			case "-....-": type('-'); break;
			case ".----.": type('\''); break;
			case ".-..-.": type('"'); break;
			case "---...": type(':'); break;
			case "-.-.-.": type(';'); break;
		}
	}
	
	public void type(char ch) throws AWTException {
		//The robot class in java.awt will simulate
		//keyboard keystrokes a valid letter is sent
		Robot robot = new Robot();
		
		switch(ch) {
		case '\'':
			robot.keyPress(KeyEvent.VK_QUOTE);
			robot.keyRelease(KeyEvent.VK_QUOTE);
			System.out.println(ch);
			break;
		case '?':
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_SLASH);
			robot.keyRelease(KeyEvent.VK_SLASH);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			break;
		case '!':
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_1);
			robot.keyRelease(KeyEvent.VK_1);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			break;
		case '"':
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_QUOTE);
			robot.keyRelease(KeyEvent.VK_QUOTE);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			break;
		case ':':
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_SEMICOLON);
			robot.keyRelease(KeyEvent.VK_SEMICOLON);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			break;
			
			default:
				//The following 4 lines will type a capital
				//letter from the lookup table.
				//robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(ch);
				robot.keyRelease(ch);
				//robot.keyRelease(KeyEvent.VK_SHIFT);
				System.out.println(ch);
				break;
		}
	}
}
