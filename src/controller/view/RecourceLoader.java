package controller.view;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by 777 on 24.02.2018.
 */
public class RecourceLoader {

    static RecourceLoader loader = new RecourceLoader();

    public static Image getImage(String fileName) {
        return Toolkit.getDefaultToolkit().getImage(loader.getClass().getResource("res/images/" + fileName));
    }

    public static InputStream getFile(String fileName) throws URISyntaxException {
        return RecourceLoader.class.getClassLoader().getResourceAsStream("files/" + fileName);
    }

    public static URL getFileOut(String fileName) throws FileNotFoundException {
        return RecourceLoader.class.getClassLoader().getResource("files/" + fileName);
    }

    // RecourceLoader.class.getResourceAsStream("res/files/" + fileName);
}