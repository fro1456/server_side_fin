package fileManagement;

import com.google.gson.Gson;
import commands.CommandWorker;
import commands.HelpCommand;
import сlasses.AnswerClass;
import сlasses.Dragon;
import сlasses.RequestedClass;

import java.io.*;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

public class Receiver {
    private ServerSocketChannel channel;
    //    public static HashMap<Long, Dragon> collection = new HashMap<Long, Dragon>();
    private SocketChannel socketChannel;
    private Selector selector;
    private final InetSocketAddress address = new InetSocketAddress("localhost", 12842);
    private Console cons;
    private Gson gson;
    private String firstCommand;//field to handle with commands
    private String envVar;
    private RequestedClass data;
    public RequestedClass dataOut;
    private AnswerClass message;
    CommandWorker commandWorker = new CommandWorker();
    private Deserializer deserializer = new Deserializer();
    private boolean newOS = true;
    private ObjectInputStream ois;

    public void writing(SelectionKey key) throws IOException {
        socketChannel = (SocketChannel) key.channel();
        socketChannel.configureBlocking(false);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        message = new AnswerClass(CommandWorker.messageToClient.getMessage());
        oos.writeObject(message);
        oos.flush();
        byte[] bytes = baos.toByteArray();
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        socketChannel.write(byteBuffer);
//        ByteBuffer buffer = ByteBuffer.wrap(baos.toByteArray());
        //socketChannel.write(buffer);
//        try {
//            if (dataOut.getCommand().equals("exit")) {
//                System.exit(0);
//            }
//        } catch (NullPointerException e) {
//
//        }
        socketChannel.register(selector, SelectionKey.OP_READ);

    }

    public void reading(SelectionKey key) throws IOException, ClassNotFoundException, InterruptedException {
        try {
            socketChannel.configureBlocking(false);
            if (newOS) {
                ByteBuffer buffer = ByteBuffer.allocate(8192);
                socketChannel.read(buffer);
                //System.out.println("Oh my god! They killed connection... Bastards!!!");
                ByteArrayInputStream bais = new ByteArrayInputStream(buffer.array());
                ois = new ObjectInputStream(bais);
                newOS = false;
            } else ois.reset();
            data = (RequestedClass) ois.readObject();
            firstCommand = data.getCommandName();
            System.out.println(socketChannel.getRemoteAddress() + ": " + firstCommand);
            commandWorker.worker(data);
            socketChannel.register(selector, SelectionKey.OP_WRITE);
            //System.out.println(data.toString());
        } catch (SocketException e) {
            //workWithServer();
        } catch (StreamCorruptedException e) {
            socketChannel.register(selector, SelectionKey.OP_WRITE);
            e.printStackTrace();
        }
    }

    public void accepting() throws IOException {
        socketChannel = channel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("adress: " + socketChannel.getRemoteAddress());
    }

    public void setConnection() throws IOException, ClassNotFoundException, InterruptedException {
        selector = Selector.open();
        channel = ServerSocketChannel.open();
        System.out.println("Starting server ... \n *scary robot sounds* \n beeep bop bop \n bop bop beep \n *done*");
        channel.socket().bind(address);


        workWithServer();
    }
    public void workWithServer() throws IOException,ClassNotFoundException,InterruptedException{

        while (true) {
            channel.socket().setReuseAddress(true);
            System.out.println("port: " + channel.socket().getLocalPort());
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);
            try {
                // System.out.println(channel.socket().getInetAddress());
                while (true) {
                    selector.select();
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            accepting();
                        }
                        else if (key.isReadable()) {

                            reading(key);
                        }
                        else if (key.isWritable()) {
                            writing(key);
                        }
                        iterator.remove();
                    }
                }
            } catch (AlreadyBoundException | BindException ignored) {
                ignored.printStackTrace();


            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("connection LOOOOST :(");
                Thread.sleep(5000);
            }
        }

//    public void configure() throws IOException {
//
//
//            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//            server = ServerSocketChannel.open();
//            server.socket().bind(new InetSocketAddress(12842));
//        while (true) {
//            SocketChannel s = server.accept();
//            Socket s1 = s.socket();
//            s.read(byteBuffer);
//            byte[] arr = byteBuffer.array();
//            try {
//                RequestedClass command = deserializer.read(byteBuffer);
//                //ByteArrayInputStream bis = new ByteArrayInputStream(arr);
//                //ObjectInputStream ois = new ObjectInputStream(bis);
//
//                //System.out.println(command.getCommandName());
//                commandWorker.worker(command);
//                byteBuffer.clear();
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//
//
//            //InputStream i = s1.getInputStream();
//            //System.out.println(i);
//
//        }

//    public void connect() throws IOException {
//        configure();
//        try (SocketChannel channel = server.accept()) {
//            Deserializer deserializer = new Deserializer();
////            deserializer.read(channel);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("новое подключение");


    } }

//    public void recieveCommand(SocketChannel channel) throws IOException {
//        try {
//            Optional<RequestedCommand> command = reader.read(channel);
//            if (command.isPresent()) {
//                //тут проверка существует ли такая комманла
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        ServerSocketChannel server = ServerSocketChannel.open();
//        server.socket().bind(new InetSocketAddress(8000));
//        System.out.println("server started");
//        while (true) {
//            try (
//                    SocketChannel socket = server.accept();
//                    //BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//            ) {
//
////                    InputStreamReader input = new InputStreamReader();
////                    System.out.println(request);
//                ///////////String message = org.apache.commons.io.IOUtils.toString(reader);
//                //System.out.println("connected " + message);
////                    writer.write(request);
//
//            } catch (NullPointerException e) {
//                e.printStackTrace();
//            }
//        }





