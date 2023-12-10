/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.enums;

/**
 *
 * @author fabio
 */
public class InterfaceEnumDemo {

    interface IValidator {

        boolean isValid(Object o);
    }

    public static boolean validator(Object o, IValidator... validatorList) {
        for (IValidator iv : validatorList) {
            if (!iv.isValid(o)){
                return false;
            }
        }
        return true;
    }

    enum Rule implements IValidator {
        NOTNULL {
            @Override
            public boolean isValid(Object o) {
                return (o != null);
            }

        },
        ISTEXT {
            @Override
            public boolean isValid(Object o) {
                return o instanceof String;
            }

        },
        ISNUMBER {
            @Override
            public boolean isValid(Object o) {
                try {
                    Integer.parseInt(o.toString());
                    return true;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    return false;
                }

            }
        };
    }
    
    public static void main(String[] args) {
        int s=4;
        
        System.out.println(InterfaceEnumDemo.validator(s, Rule.NOTNULL,Rule.ISNUMBER, o -> (int)o > 5));
    }

}
