package com.tmbs.main;

import javax.swing.JOptionPane;

import com.tmbs.exercises.Exercise_01;
import com.tmbs.exercises.Exercise_02;
import com.tmbs.exercises.Exercise_03;
import com.tmbs.exercises.Exercise_04;
import com.tmbs.exercises.Exercise_05;
import com.tmbs.exercises.Exercise_06;
import com.tmbs.exercises.Exercise_07;
import com.tmbs.exercises.Exercise_08;
import com.tmbs.exercises.Exercise_09;

public class Menu {
	
	public static void menu() {
		
		String[] options = { "EJ 1", "EJ 2", "EJ 3", "EJ 4","EJ 5","EJ 6","EJ 7","EJ 8","EJ 9","Salir" };

		int i = JOptionPane.showOptionDialog(null, "Seleccione un ejercicio", "Unidad C2 TA 18",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[3]);

		if (i == JOptionPane.CLOSED_OPTION)
			i = 9; // Controlando el cierre JOPane

		switch (i) {
		case 0:
			JOptionPane.showMessageDialog(null, "El ejercicio 1 se mostrará por la consola");
			 Exercise_01.run();
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "El ejercicio 2 se mostrará por la consola");
			  Exercise_02.run();
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "El ejercicio 3 se mostrará por la consola");
			 Exercise_03.run();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "El ejercicio 4 se mostrará por la consola");
			Exercise_04.run();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "El ejercicio 5 se mostrará por la consola");
			Exercise_05.run();
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "El ejercicio 6 se mostrará por la consola");
			Exercise_06.run();
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "El ejercicio 7 se mostrará por la consola");
			Exercise_07.run();
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "El ejercicio 8 se mostrará por la consola");
			Exercise_08.run();
			break;
		case 8:
			JOptionPane.showMessageDialog(null, "El ejercicio 9 se mostrará por la consola");
			Exercise_09.run();
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "EXIT APP");
			break;
		}

	}

}
