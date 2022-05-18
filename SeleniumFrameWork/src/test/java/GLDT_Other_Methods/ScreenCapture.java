
package GLDT_Other_Methods;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
 
import javax.imageio.ImageIO;
import java.awt.datatransfer.*;
import java.awt.image.*;
import java.io.*;

 
public class ScreenCapture implements ClipboardOwner {


public void test() {

try {
Robot robot = new Robot();
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
Rectangle screen = new Rectangle(screenSize);
BufferedImage i = robot.createScreenCapture(screen);
TransferableImage trans = new TransferableImage(i);
Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
c.setContents(trans,   this);
} catch (AWTException x) {
x.printStackTrace();
System.exit(1);

}
}
 
    public static void main(String[] args) {
    	ScreenCapture captureExample=new ScreenCapture();
    captureExample.test();
    }
   
    public ScreenCapture() {

    }
private class TransferableImage implements Transferable {

Image i;

public TransferableImage(Image i) {
this.i = i;
}

public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
if (flavor.equals(DataFlavor.imageFlavor) && i != null) {
return i;
} else {
throw new UnsupportedFlavorException(flavor);
}
}

public DataFlavor[] getTransferDataFlavors() {
DataFlavor[] flavors = new DataFlavor[1];
flavors[0] = DataFlavor.imageFlavor;
return flavors;
}

public boolean isDataFlavorSupported(DataFlavor flavor) {
DataFlavor[] flavors = getTransferDataFlavors();
for (int i = 0; i < flavors.length; i++) {
if (flavor.equals(flavors[i])) {
return true;
}
}

return false;
}
}
@Override
public void lostOwnership(Clipboard clipboard, Transferable contents) {
System.out.println("Lost Clipboard Ownership");

}

    }
