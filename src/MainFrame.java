import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends javax.swing.JFrame implements Runnable {
    private List<ClientHandler> clientHandlers = new ArrayList<>();

    /**
     *Crea un nuevo marco
     */
    public MainFrame() {
        super("GUI Chat Application"); //Agrega el nombre al marco
        initComponents(); //Inicia la GUI
        this.setVisible(true); // Hace la ventana visible
        this.sendButton.setEnabled(false); // Deshabilita el boton de enviado si no hay al menos dos usuarios conectados
        this.isClosed = false;
    }

    /**
     * ADVERTENCIA: NO MODIFIQUE ESTE CODIGO, el contenido de este metodo siempre es generado automaticamente por el "Form Editor"
     *
     * LO UNICO MODIFICABLE, SON LOS STRINGS ASIGNADOS A LOS BOTONES, LOS CUALES SE MUESTRAN EN LA GUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        receiveTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        sendTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        usernameTextArea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        enableServer = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        serverIpAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        receiveTextArea.setColumns(20);
        receiveTextArea.setRows(5);
        jScrollPane1.setViewportView(receiveTextArea);

        sendTextArea.setColumns(20);
        sendTextArea.setRows(5);
        jScrollPane2.setViewportView(sendTextArea);

        sendButton.setText("Enviar");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("             Nombre de usuario:");

        enableServer.setText("Habilitar servidor");
        enableServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableServerActionPerformed(evt);
            }
        });

        serverIpAddress.setText("127.0.0.1");// ESTA NO DEBERIA MODIFICARSE, SUJETA A CAMBIOS. SI SE CAMBIA A LOCALHOST, NO SE PUEDE CORRER EN PARALELO

        jLabel2.setText("Dirección IP:");

        connectButton.setText("Conectarse");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usernameTextArea)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(enableServer)
                                        .addComponent(jSeparator1)
                                        .addComponent(jSeparator2)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(serverIpAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(431, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usernameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(enableServer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(serverIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(connectButton)
                                                .addGap(132, 132, 132))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     *    Este metodo se ejecuta cuando el boton "Habilitar servidor" sea accionado
     */
    private void enableServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableServerActionPerformed
        // TODO add your handling code here:
        if(enableServer.isSelected()) //Verifica si el boton Habilitar servidor fue seleccionado a traves del metodo isSelected. Devuelve "true" si fue seleccionado.
        {
            //Si fue seleccionado, acciona el modo servidor para hostear la aplicacion
            receiveTextArea.setText("Servidor habilitado. Esperando conexion de usuarios...");
            serverIpAddress.setEditable(false); //Deshabilita la direccion IP una vez se inicie el servidor
            connectButton.setEnabled(false); //Deshabilita el boton conexion si entra en modo servidor.
            this.isServer = true;  //Setea isServer a true, es una variable global que se usa en el run method para inicializar el servidor.
        }
        else //Si esta en modo cliente o necesita conectarse al servidor
        {
            receiveTextArea.setText("");  //Limpia cualquier mensaje de la area de recibir mensajes
            serverIpAddress.setEditable(true); //Habilita el modo cliente. Hace el area de direccion IP editable para conectarse al servidor.
            connectButton.setEnabled(true); //Habilita el boton Conectase
            this.isServer = false; //Configura la variable isServer a false, se usa esta variable para inicializar el modo servidor o cliente segun su valor booleano.
        }
    }//GEN-LAST:event_enableServerActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
        connectToServer = true; //Setea la variable a true para entrar en modo cliente
    }//GEN-LAST:event_connectButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        String message = sendTextArea.getText(); //Consigue los mensajes
        message = localUsername + ": " + message; //Agrega el nombre de usuario
        try
        {
            appendToReceiveArea(message);
            out.write(message); // Escribir mensajes
            out.newLine(); //Se agregan nuevas lineas al modo de escritura
            out.flush(); //Se hace un flush para recibir los mensajes
            sendTextArea.setText(""); //Limpia el area de escritura cuandos se envia el mensaje
            //receiveTextArea.setText(allText); //Agrega el mensaje al recuadro de mensajes
        }
        catch(Exception e)
        {
            disconnect(); //Si no se puede enviar el mensaje, se desconecta
        }
    }//GEN-LAST:event_sendButtonActionPerformed


    public void run()
    {
        while(!isClosed) //Corre la app hasta que se cierre manualmente
        {
            sleep(100);
            if(isServer) //Si esta en modo servidor, se llama initializeServerMode para empezar el servidor
            {
                initializeServerMode();
            }
            if(connectToServer) //Si se le da click a "Conectarse", la aplicacion intenta conectarse al servidor con modo cliente
            {
                initializeClientMode();
                //readIncomingMessages(); //lee todos los mensajes entrantes
            }
        }
    }

    public synchronized void addClientHandler(ClientHandler clientHandler) {
        clientHandlers.add(clientHandler);
    }

    public synchronized void removeClientHandler(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
    }

    /*
     * Metodo de modo servidor
     */
    private void initializeServerMode()
    {
        try {
            server = new ServerSocket(portNumber); //Crea el socket
            receiveTextArea.setText("Servidor habilitado. Esperando conexion de usuarios...");

            while (true) {
                Socket clientSocket = server.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                addClientHandler(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (BindException e1) {
            receiveTextArea.setText("El puerto " + portNumber + "ya esta siendo usado por otra aplicacion");
        } catch (Exception e) {
            System.out.println("Error de servidor: " + e.toString());
            disconnect();
        }
    }

    private void initializeClientMode()
    {
        try
        {
            String ip = serverIpAddress.getText(); //Obtiene la direccion IP de la area de direccion IP en la GUI
            client = new Socket(ip, portNumber); //Intenta conectarse al servidor
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            //Igual que el servidor, lo primero es obtener los nombres de usuario
            //1. Envia el nombre de usuario al servidor
            localUsername = usernameTextArea.getText(); //obtiene el nombre de la area de texto
            if(localUsername.length() == 0) //Crea uno por defecto si no se introdujo ninguno
            {
                localUsername = "Client"; //el nombre por defecto es cliente
            }

            localUsername = localUsername.trim(); //remueve espacios blancos
            out.write(localUsername); //envia el nombre de usuario
            out.newLine();
            out.flush();

            //2. El cliente espera para recibir el nombre del servidor
            remoteUsername = in.readLine(); //Lee el nombre de usuario y lo almacena


            //Despues del intercambio de nombres:

            //1. Informa al usuario que el otro usuario se conecto y que pueden conversar;
            receiveTextArea.setText("El usuario: " + remoteUsername + " está en línea! Escriba un mensaje");
            //2. habilita el boton de enviar
            sendButton.setEnabled(true);
            //3. Desactiva el boton habilitar servidor
            enableServer.setEnabled(false);
            //4. Desactiva el boton de conexion
            connectButton.setEnabled(false);

            readIncomingMessages(); //lee todos los mensajes entrantes
        }
        catch(UnknownHostException e2)
        {
            receiveTextArea.setText("No se encontro la direccion IP!");
        }
        catch(ConnectException e1)
        {
            receiveTextArea.setText("El servidor no es accesible!");
        }
        catch(Exception e)
        {
            //Si la IP no es correcta
            System.out.println("Error de cliente!" + e.toString());
            disconnect();
        }
    }

    /**
     * Agrega los mensajes a la area de recepcion en la GUI
     */
    public synchronized void appendToReceiveArea(String message) {
        receiveTextArea.append("\n" + message);
    }

    public String getLocalUsername() {
        return usernameTextArea.getText().trim();
    }


    public void readIncomingMessages()
    {
        try
        {
            while(true)
            {
                String message = in.readLine(); //lee mensajes de la conexion
                if (message != null){
                    appendToReceiveArea(message);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString() + "en readIncomingMessages");
            disconnect(); //Si hay error, cierra la conexion
        }
    }

    // Realiza el envio de los mensajes a los clientes/destinatarios(threads)
    public synchronized void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler clientHandler : clientHandlers) {
            if (clientHandler != sender) { // Se valida que el que envia el mensaje no sea el destinatario para evitar duplicados y que el mensaje se muestre dos veces en la ventana del que envia
                try {
                    clientHandler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void disconnect()
    {
        try
        {
            String allText = receiveTextArea.getText(); //consigue el texto
            allText = allText + "\n" + this.remoteUsername + " se ha desconectado! \nLa conexion fue cerrada.";
            receiveTextArea.setText(allText);
            if(isServer) //Si esta en modo servidor
            {
                /*
                    Verifica si el inputstream no es nulo, hay casos donde si es nulo (hay que revisar despues en caso de un posible bug).
                    Ejemplo: Si en el modo servidor, la aplicacion fue cerrada cuando estaba esperando la conexion, el metodo accept no va a devolver
                    un objeto tipo socket y el inputstream no se crea porque no existe un socke.

                    Por ende, como consecuencia se obtiene un objeto inputstream nulo y si intentamos cerrarlo, se tira un error.

                    Para evitar este bug, se agrego la validacion con el fin de evitar el bug.
                */
                if(in != null)
                {
                    in.close(); //cierra el intpustream
                }
                if(out != null)
                {
                    out.close(); //cierra el outputstream
                }
                if(client != null)
                {
                    client.close();
                }
                if(server != null)
                {
                    server.close();
                }
                enableServer.setEnabled(true); // habilita el boton de conectarse
                enableServer.setSelected(false);
                serverIpAddress.setEditable(true);
                connectButton.setEnabled(true);
                sendButton.setEnabled(false); // deshabilita le boton enviar
                isServer = false; //se deshabilita el modo servidor
            }
            if(connectToServer)
            {
                if(in != null)
                {
                    in.close(); //cierra el inputstream
                }
                if(out != null)
                {
                    out.close(); //cierra el outputstream
                }
                if(client != null)
                {
                    client.close(); //cierra el socket del cliente
                }
                enableServer.setEnabled(true);
                enableServer.setSelected(false);
                serverIpAddress.setEditable(true);
                connectButton.setEnabled(true);
                sendButton.setEnabled(false);
                connectToServer = false;  //deshabilita el modod cliente
            }
        }
        catch(Exception e)
        {
            System.out.println("en disconnect" + e.toString());
        }
    }

    private void sleep(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch(Exception e)
        {
            System.exit(1);
        }
    }

    private boolean isServer = false;
    private boolean connectToServer = false;
    private ServerSocket server;
    private Socket client;
    private final int portNumber = 9090;
    private BufferedWriter out;
    private BufferedReader in;
    private String localUsername;
    private String remoteUsername;
    private boolean isClosed = true; //usado para cerrar el thread (la aplicacion misma)



    // Declaracion de variables - NO MODIFICAR!!!!!//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JRadioButton enableServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea receiveTextArea;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextArea sendTextArea;
    private javax.swing.JTextField serverIpAddress;
    private javax.swing.JTextField usernameTextArea;
    // Fin de la declaracion de variables//GEN-END:variables
}