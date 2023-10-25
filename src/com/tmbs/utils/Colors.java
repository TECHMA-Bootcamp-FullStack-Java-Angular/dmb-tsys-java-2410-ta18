package com.tmbs.utils;

public class Colors {
	
	public static final String SEPARADOR = "—————————————————————————————————————————";	
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
 
    public static String txtGreen(String txt ) {
    	return ANSI_GREEN + txt + ANSI_RESET;
    }
    
    public static String txtCyan(String txt ) {
    	return ANSI_CYAN + txt + ANSI_RESET;
    }
    public static String txtYellow(String txt ) {
    	return ANSI_YELLOW + txt + ANSI_RESET;
    }
}


