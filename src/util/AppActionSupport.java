package util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
  
public class AppActionSupport extends ActionSupport {

	@Override
	public String getText(String textName) {
		return convert(super.getText(textName));
	}  

	@Override
	public String getText(String textName, List args) {
		return convert(super.getText(textName, args));
	}  

	@Override
	public String getText(String key, String defaultValue, List args,ValueStack stack) {
		return convert(super.getText(key, defaultValue, args, stack));
	}

	@Override
	public String getText(String textName, String defaultValue, List args) {
		return convert(super.getText(textName, defaultValue, args));
	}

	@Override
	public String getText(String textName, String defaultValue, String obj) {
		return convert(super.getText(textName, defaultValue, obj));
	}

	@Override
	public String getText(String key, String defaultValue, String[] args, ValueStack stack) {
		return convert(super.getText(key, defaultValue, args, stack));
	}

	@Override
	public String getText(String key, String defaultValue, String[] args) {
		return convert(super.getText(key, defaultValue, args));
	}

	@Override
	public String getText(String textName, String defaultValue) {
		return convert(super.getText(textName, defaultValue));
	}

	@Override
	public String getText(String key, String[] args) {
		return convert(super.getText(key, args));
	}

	@Override
	public ResourceBundle getTexts() {
		return new ResourceBundleUtf8((PropertyResourceBundle) super.getTexts());
	}

	@Override
	public ResourceBundle getTexts(String bundleName) {
		return new ResourceBundleUtf8((PropertyResourceBundle) super.getTexts(bundleName));
	}

	private static final String convert(String text) {
		String textUtf8 = text;

		if (textUtf8 == null) {
			return null;
		}

		try {
			textUtf8 = new String(text.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		return textUtf8;
	}
}
