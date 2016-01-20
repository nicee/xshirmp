package psn.lotus.wechat.error;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信错误码
 *
 * @author: nicee
 * @since: 2015/12/30
 */
public class ErrorMessage {

    private static final Map<Integer, String> errors = new HashMap<Integer, String>();

    static {
        errors.put(-1, "System is busy, please try again later.");
        errors.put(40001, "Invalid credential, access_token is invalid or not latest.");
        errors.put(40002, "Invalid document types.");
        errors.put(40003, "Invalid open ID.");
        errors.put(40004, "Invalid media types");
        errors.put(40005, "Invalid file types.");
        errors.put(40006, "Invalid file size.");
        errors.put(40007, "Invalid identify of media file.");
        errors.put(40008, "Invalid message types.");
        errors.put(40009, "Invalid images file size.");
        errors.put(40010, "Invalid voice file size.");
        errors.put(40011, "Invalid video file size.");
        errors.put(40012, "Invalid thumbnail file size.");
        errors.put(40013, "Invalid app_id.");
        errors.put(40014, "Invalid access token.");
        errors.put(40015, "Invalid menu type.");
        errors.put(40016, "Invalid number of buttons.");
        errors.put(40017, "Invalid number of buttons.");
        errors.put(40018, "Invalid buttons name length.");
        errors.put(40019, "Invalid button key length.");
        errors.put(40020, "Invalid button URL length.");
        errors.put(40021, "Invalid menu version number.");
        errors.put(40022, "Invalid submenu series.");
        errors.put(40023, "Invalid number of submenu buttons.");
        errors.put(40024, "Invalid submenu buttons types.");
        errors.put(40025, "Invalid submenu buttons name length.");
        errors.put(40026, "Invalid submenu button key length.");
        errors.put(40027, "Invalid submenu button URL length.");
        errors.put(40028, "Invalid to setting custom menu.");
        errors.put(40029, "Invalid oauth code.");
        errors.put(40030, "Invalid refresh token.");
        errors.put(40031, "Invalid list of open ids.");
        errors.put(40032, "Invalid open id's length.");
        errors.put(40033, "Invalid request characters, could not include format of '\\uxxxx'.");
        errors.put(40035, "Invalid request parameter.");
        errors.put(40038, "Invalid request format.");
        errors.put(40039, "Invalid URL length.");
        errors.put(40050, "Invalid group id.");
        errors.put(40051, "Invalid group name. ");
        errors.put(40053, "Invalid action info.");

        errors.put(41001, "Missing access token parameters.");
        errors.put(41002, "Missing app id parameters.");
        errors.put(41003, "Missing refresh token parameters.");
        errors.put(41004, "Missing app secret parameters.");
        errors.put(41005, "Missing multimedia files.");
        errors.put(41006, "Missing media id parameters.");
        errors.put(41007, "Missing submenu data.");
        errors.put(41008, "Missing oauth code parameters.");
        errors.put(41009, "Missing open id parameters.");

        errors.put(42001, "Access token timeout.");
        errors.put(42002, "Refresh token timeout.");
        errors.put(42003, "Oauth code timeout.");

        errors.put(43001, "Only supports GET requests.");
        errors.put(43002, "Only supports POST requests.");
        errors.put(43003, "Need HTTPS requests.");
        errors.put(43004, "Require user attention first.");
        errors.put(43005, "Require mutual friends first.");

        errors.put(44001, "Multimedia file is empty.");
        errors.put(44002, "POST request packet data is empty.");
        errors.put(44003, "Photo message content is empty.");
        errors.put(44004, "Text message content is empty.");

        errors.put(45001, "Multimedia file size over the limit.");
        errors.put(45002, "Message size over the limit.");
        errors.put(45003, "The title field length over the limit.");
        errors.put(45004, "The description field length over the limit.");
        errors.put(45005, "The link field length over the limit.");
        errors.put(45006, "The image link field length over the limit.");
        errors.put(45007, "The video playback time over the limit.");
        errors.put(45008, "The photo message over the limit.");
        errors.put(45009, "The interface calls over the limit.");
        errors.put(45010, "Create number of menu over the limit.");
        errors.put(45015, "Reply timeout.");
        errors.put(45016, "Not to rename of default group.");
        errors.put(45017, "The group name is too long.");
        errors.put(45018, "Number of group over the limit.");
        errors.put(46001, "Media data could not be found.");
        errors.put(46002, "Wrong version number of menu.");
        errors.put(46003, "Menu data could not be found.");
        errors.put(46004, "The user is not exist.");
        errors.put(47001, "Parse JSON / XML content errors.");

        errors.put(48001, "Unauthorized API function.");

        errors.put(50001, "The user is not authorized api.");
    }


}
