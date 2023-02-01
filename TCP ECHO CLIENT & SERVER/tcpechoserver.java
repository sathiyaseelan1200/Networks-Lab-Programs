import java.net.*; 
import java.io.*;
public  class  tcpechoserver
{
public  static  void  main(String[]  arg)  throws  IOException
{
ServerSocket sock = null; 
BufferedReader fromClient = null; OutputStreamWriter toClient = null; 
Socket client = null;
try
{
sock = new ServerSocket(4000); System.out.println("Server Ready"); 
client = sock.accept(); 
System.out.println("Client Connected"); 
fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); 
toClient = new OutputStreamWriter(client.getOutputStream()); 
                 String line;
while  (true)
{
line  =  fromClient.readLine();
if ( (line == null) || line.equals("bye")) 
break;
System.out.println ("Client [ " + line + " ]"); 
toClient.write("Server [ "+ line +" ]\n"); 
toClient.flush();
}
fromClient.close(); toClient.close(); 
client.close(); 
sock.close();
System.out.println("Client  Disconnected");
}
catch  (IOException  ioe)
{
System.err.println(ioe);
}
}
}
//TCP  Echo  Client--tcpechoclient.java
import java.net.*; 
import java.io.*;
public  class  tcpechoclient
{
public static  void  main(String[]  args)  throws  IOException
{
BufferedReader fromServer = null, fromUser = null; 
PrintWriter toServer = null;
Socket sock = null; 
try
{
if  (args.length  ==  0)
sock = new Socket(InetAddress.getLocalHost(), 4000);
else
                 sock = new Socket(InetAddress.getByName(args[0]), 4000);
                    fromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));
fromUser = new BufferedReader(new 
InputStreamReader(System.in));
                 toServer = new PrintWriter(sock.getOutputStream(), true );
                 String Usrmsg,Srvmsg; 
System.out.println("Type \"bye\" to quit"); 
while (true)
{
System.out.print("Enter msg to server : "); 
Usrmsg = fromUser.readLine();
if  (Usrmsg==null  ||  Usrmsg.equals("bye"))
{
toServer.println("bye"); 
break;
}
else toServer.println(Usrmsg);
Srvmsg = fromServer.readLine(); System.out.println(Srvmsg);
}
fromUser.close(); fromServer.close(); toServer.close(); sock.close();
     }
catch  (IOException  ioe)
    {
System.err.println(ioe);
     }
            }
            } 
