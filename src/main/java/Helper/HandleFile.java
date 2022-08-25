package Helper;

import java.io.*;

public class HandleFile {
    public static Object readObj(String path) throws IOException, ClassNotFoundException {
        try (
                FileInputStream fileInputStream = new FileInputStream(path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            Object obj = objectInputStream.readObject();
            return obj;
        }
    }

    // Write File
    public static void writeObject(String path, Object object) throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        )
        {
            objectOutputStream.writeObject(object);
        }
    }
}
