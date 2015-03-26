package util;

import java.io.UnsupportedEncodingException;  
import java.util.Enumeration;  
import java.util.PropertyResourceBundle;  
import java.util.ResourceBundle; 

import javax.management.RuntimeErrorException;

public class ResourceBundleUtf8 extends ResourceBundle{
	
	PropertyResourceBundle bundle;
	
	public ResourceBundleUtf8(PropertyResourceBundle bundle) {
		// TODO Auto-generated constructor stub
		this.bundle = bundle;
	}
	
	@Override
	public Enumeration getKeys() {
		// TODO Auto-generated method stub
		return bundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		// TODO Auto-generated method stub
		String value = (String) bundle.handleGetObject(key);
		
		try {
			return new String(value.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
