/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class LogLevels {

    public static String message(String logLine) {
        String message = logLine.split(":")[1].trim();
        return message;
    }

    public static String logLevel(String logLine) {
        return logLine.substring(1,logLine.indexOf(']')).toLowerCase();
    }
    
    public static String reformat(String logLine) {
        String format1 = LogLevels.message(logLine);
        String format2 = LogLevels.logLevel(logLine);
        return format1 + " (" + format2 + ")";
    }

    public static void main(String[] args) {
        System.out.println(message("[WARNING]:  Disk almost full\r\n"));
        System.out.println(logLevel("[ERROR]: Invalid operation"));
        System.out.println(reformat("[INFO]: Operation completed"));
    }
}
