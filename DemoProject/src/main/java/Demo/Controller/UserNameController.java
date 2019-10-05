package Demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.Bean.UserName;
import Demo.Dao.UserNameDao;

@RestController
public class UserNameController {

	@Autowired
	private UserNameDao userNameDao;

	/*
	 * @RequestMapping(value = "/query", // method = RequestMethod.GET, produces
	 * = { MediaType.APPLICATION_JSON_VALUE })
	 * 
	 * @ResponseBody public String welcome(UserName emp) { List<JSONObject>
	 * entities = new ArrayList<JSONObject>(); List<UserName> lst =
	 * userNameDao.getListByUserName(); JSONObject entityObject = new
	 * JSONObject(); for (UserName n : lst) { JSONObject entity = new
	 * JSONObject(); entity.put("userName", n.getUSER_NAME());
	 * entity.put("fistName", n.getUSER_FISTNAME()); entity.put("lastName",
	 * n.getUSER_LASTNAME()); entity.put("company", n.getUSER_COMPANY());
	 * entity.put("id", n.getUSER_ID()); entities.add(entity); }
	 * entityObject.put("arr", entities.toString()); return entities.toString();
	 * }
	 */

	@RequestMapping(value = "/dang-nhap", //
	method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String getUserByid(@RequestBody String jsonString) {

		JSONParser parser = new JSONParser();
		JSONObject json=null;
		try {
			json = (JSONObject) parser.parse(jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject=new JSONObject();
		UserName userName = new UserName();
		userName.setUSER_NAME((String)json.get("user_name"));
		userName.setUSER_PASSWORD((String)json.get("user_password"));
	    boolean susess=	userNameDao.getlistById(userName);
	    UUID uuid=null;
	    String string=null;
	    if(susess){
			 uuid = UUID.randomUUID();
			 string= uuid.toString();
	    }
	    
	    jsonObject.put("susess", susess);
	    jsonObject.put("key", string);
		return jsonObject.toString();
	}

}
