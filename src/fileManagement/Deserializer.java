package fileManagement;

import сlasses.RequestedClass;
import сlasses.RequestedClass;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Optional;

public class Deserializer {
    public RequestedClass read(ByteBuffer buffer) throws IOException, ClassNotFoundException {
        //int num = channel.read(buffer);
        //if (num > 0) {
        if (buffer!=null) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(buffer.array()));
            RequestedClass command = (RequestedClass) objectInputStream.readObject();
            System.out.println(command.toString());
            return command;
        }
        else
//        } else if (num == 1) {
//            channel.close();
//        }
        return null;
    }


}
