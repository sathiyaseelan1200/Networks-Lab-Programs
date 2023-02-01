import javax.swing.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException; import
javax.imageio.ImageIO;
public class Clientupload{

public static void main(String args[]) throws Exception{ Socket soc;
BufferedImage img = null;
soc=new Socket("localhost",5000);

System.out.println("Client is running. ");

System.out.println("Reading image from disk. ");

img = ImageIO.read(new File("digital_image_processing.jpg"));
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(img, "jpg", baos);
baos.flush();

byte[]  bytes = baos.toByteArray();
baos.close();
} 
} 
 
