/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class LogLevels {

    public static String message(String logLine) {
        String s1 = logLine.split(":")[1].trim();
        if (s1.contains("\\")) {
            s1.replace("\\", "&");
            String s2 = s1.split("&")[0];
            return s2;
        }
        return s1;
    }

    public static String logLevel(String logLine) {
        return logLine.substring(1).split("]")[0].toLowerCase();
    }
    
    public static String reformat(String logLine) {
        String s1 = LogLevels.message(logLine);
        String s2 = LogLevels.logLevel(logLine);
        return s1 + " (" + s2 + ")";
    }

    public static void main(String[] args) {
        System.out.println(LogLevels.message("[WARNING]:  Disk almost full\r\n"));
        System.out.println(LogLevels.logLevel("[ERROR]: Invalid operation"));
        System.out.println(LogLevels.reformat("[INFO]: Operation completed"));

    }
}
