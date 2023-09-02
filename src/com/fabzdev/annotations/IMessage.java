package com.fabzdev.annotations;

import java.lang.annotations.Retention;
import java.lang.annotations.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Interface IMessage {
	
	String message();
	
}