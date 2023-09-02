package com.fabzdev.annotations;

@IMessage(message="Hola Mundo.")
public class HelloWorld{
	
	public void main(String[] args){
	
		IMessage msg = HelloWorld.class.getAnnotation(IMessage.class);
	
			System.out.println(msg.message());

	}
}