import java.net.*;
import java.io.*;

public class Main
{
    public static void main(String [] args)
    {
        MainFrame mainFrame = new MainFrame(); //Crea el objeto mainFrame
        Thread thread  = new Thread(mainFrame); //Corre un nuevo thread (la aplicacion misma)
        thread.start(); //Empieza el thread
    }
}