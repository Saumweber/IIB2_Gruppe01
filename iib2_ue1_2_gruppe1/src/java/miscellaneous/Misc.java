/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.nio.charset.Charset;

/**
 *
 * @author Florian
 */
public class Misc {

    public static String encodeUTF8(String _toEncode) {
        byte[] bytes = _toEncode.getBytes(Charset.forName("UTF-8"));
        return new String(bytes, Charset.forName("UTF-8"));
    }
}
