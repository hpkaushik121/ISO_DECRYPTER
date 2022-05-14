package com.iso.decypter;

import javax.swing.*;
import java.io.InputStream;
import java.net.URL;

public class Icons {
    public static ImageIcon getResource(String urlName) {
        Class thisClass = Icons.class;

        URL url = thisClass.getResource(urlName);
        ImageIcon imageIcon = new ImageIcon(url);

        return imageIcon;
    }

    public static URL getResourceURL(String urlName) {
        Class thisClass = Icons.class;

        URL url = thisClass.getResource(urlName);

        return url;
    }
    public static InputStream getResourceStream(String urlName) {
        Class thisClass = Icons.class;


        return thisClass.getResourceAsStream(urlName);
    }
}
