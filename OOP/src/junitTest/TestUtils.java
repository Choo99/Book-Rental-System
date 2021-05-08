package junitTest;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;

import javax.swing.JMenu;

public class TestUtils {
	static int counter;
	
	public static Component getChildNamed(Component parent,String name) {
		if(name.equals(parent.getName())) {
			return parent;
		}
		
	if(parent instanceof Container) {
		Component[] children = (parent instanceof JMenu)?((JMenu)parent).getMenuComponents():((Container)parent).getComponents();
		
		for(int i = 0; i < children.length;++i) {
			Component child = getChildNamed(children[i],name);
			if(child != null) {return child;}
		}
	}
	return null;
	}


	public static Component getChildIndexed(Component parent, String name, int index){
		
		counter = 0;
		if (parent instanceof Window)
		{
			Component [] children = ((Window)parent).getOwnedWindows();

			for(int i =0; i< children.length; i++)
			{
				if(children[i] instanceof Window && !((Window)children[i]).isActive()){
					continue;
					}
					Component child = getChildIndexedInternal(children[i], name, index);
					if (child != null)
					return child;
			}
		}
		return null;
	}

	public static Component getChildIndexedInternal(Component parent,String name,int index){
		if(parent.getClass().toString().endsWith(name))
		{
			if(counter==index)
			return parent;
			++counter;
			
		}
		if(parent instanceof Container){
			Component[]children=(parent instanceof JMenu)?
			((JMenu)parent).getMenuComponents():
			((Container)parent).getComponents();
			
			for(int i=0;i<children.length;++i){
				Component child=getChildIndexedInternal(children[i],name,index);
				if(child!=null)
				{return child;}
			}
		}
		return null;
	}
}
