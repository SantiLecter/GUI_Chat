import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket; //Socket para comunicarse con el cliente
    private BufferedWriter out; //Writer para enviar mensajes al cliente
    private BufferedReader in; //Reader para recibir mensajes del cliente
    private MainFrame mainFrame; //Referencia al mainFrame para actualizaciones de la UI y mensajes
    private String clientUsername;

    // Constructor para inicializar el clienHandler con un socket y referencia al MainFrame
    public ClientHandler(Socket socket, MainFrame mainFrame) {
        this.clientSocket = socket; //Asigna el socket
        this.mainFrame = mainFrame; // Asigna la referencia al MainFrame
        try {
            this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Intercambio de usuarios entre el cliente y servidor
            clientUsername = in.readLine(); // Lee el nombre del cliente
            String localUsername = mainFrame.getLocalUsername(); // COnsigue el nombre del servidor
            out.write(localUsername); // Envia el nombre del servidor al cliente
            out.newLine();
            out.flush();

            // notifica la nueva conexion
            String connectMessage = "El usuario " + clientUsername + " esta en linea!";
            mainFrame.broadcastMessage(connectMessage, this); // Notifica el mensaje de conexion a todos los otros clientes

            // Agrega el client handler a la lista en main frame
            mainFrame.addClientHandler(this);

            // lee los mensajes del cliente y los envia a traves del metodo broadcast. aca los argumentos usan "this" para diferenciar el que envia contra el destinatario y evitar duplicados
            String message;
            while ((message = in.readLine()) != null) {
                //Estas dos lineas estan sujetas a cambios, ya que hay un bug en el que se envia el mensaje dos veces
                // tengo la sospecha que tiene que ver con un llamado multiple del broadcast, toca analizar.
                mainFrame.appendToReceiveArea(message); // Agrega el mensaje a la UI del cliente
                mainFrame.broadcastMessage(message, this); // envia el mensaje a todos los otros clientes
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mainFrame.removeClientHandler(this);
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) throws IOException {
        out.write(message);
        out.newLine();
        out.flush();
    }
}