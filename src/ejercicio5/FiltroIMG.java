package ejercicio5;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FiltroIMG  extends FileFilter {
    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
 
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        if (ext != null) {
            if (ext.equals("jpeg") || ext.equals("img") || ext.equals("jpg") || 
            		ext.equals("ico") || ext.equals("png"))
                    return true;
           else {
                return false;
            }
        }
 
        return false;
   }

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Imagenes";
	}

}	
