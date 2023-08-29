package com.fabzdev;

public class StringBuilderTest{

public static void main(String[] args){
	runTestConcat();
	runTestSb();
}

public static void runTestConcat(){
	long start = System.currentTimeMillis();
	
	String stringBase = "Hola mundo";
	for(int i=0;i<100000;i++){
		stringBase = stringBase + i;
		}
	long end = System.currentTimeMillis();
	
	System.out.println("El tiempo transcurrido fue: " + (end-start) + " ms.");
	
	}

public static void runTestSb(){
	long start = System.currentTimeMillis();
	
	StringBuilder stringBase = new StringBuilder();
	stringBase.append("Hola mundo");
	for(int i=0;i<100000;i++){
		stringBase.append(i);
		}
	long end = System.currentTimeMillis();
	
	System.out.println("El tiempo transcurrido fue: " + (end-start) + " ms.");
	
	}

}

