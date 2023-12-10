package com.fabzdev.annotations;


@IMessage(message = "Hola mundo.")
public class HelloWorld{
	
	public static void main(String[] args){
		IMessage msg = HelloWorld.class.getAnnotation(IMessage.class);
		System.out.println(msg.message());	
	}
}