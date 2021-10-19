package rindus.automationtest.pages;

import java.lang.reflect.InvocationTargetException;

public class PageFactory <T> {
	public static <T> T create(Class<T> pageClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        return (T) pageClass.getDeclaredConstructor().newInstance();
	 }	
}
