package tmp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class eJarLoader {
	public void load() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException{
		String jarPath = "C:\\Levon JB\\ictk.jar";
		ClassLoader jarLoader = new URLClassLoader(new URL[]{new URL(jarPath)}, this.getClass().getClassLoader());
		Class classToLoad = Class.forName ("ictk.boardgame.chess.ChessBoard", true, jarLoader);
		Method method = classToLoad.getDeclaredMethod ("hashCode");
		Object instance = classToLoad.newInstance ();
		Object result = method.invoke (instance);
		System.out.println(result);
	}
}
