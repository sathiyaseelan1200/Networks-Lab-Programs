import java.io.*;
import java.net.*;
class tracert
{
   public static void main(String args[])
{
try
{
String str;

System.out.print(" Enter the IP Address to be tracert : "); 
BufferedReader buf1=new BufferedReader(new InputStreamReader(System.in)); 
String ip=buf1.readLine();

Runtime H=Runtime.getRuntime();
Process p=H.exec("tracert " + ip);
InputStream in=p.getInputStream();
BufferedReader buf2=new BufferedReader(new
InputStreamReader(in));
while((str=buf2.readLine())!=null)
{
   System.out.println(" " + str);
}
}
catch(Exception e)
{
   System.out.println(e.getMessage());
}
}
}
