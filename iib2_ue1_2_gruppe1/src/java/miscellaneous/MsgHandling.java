package miscellaneous;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Florian
 */
public final class MsgHandling {

    public static String printMsg(int _error) {
        String result = "";
        switch (_error) {
            case 403:
                result = "<p>Um Zugriff auf diese Seite zu bekommen, m&uuml;ssen Sie sich "
                        + "<a href = \"./index.html\" title = \"anmelden\" >anmelden</a >.</p >";
                break;
        }
        return result;
    }
}
