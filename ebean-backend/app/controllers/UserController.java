package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.TaApplication;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Random;

import java.util.ArrayList;


/**
 * @description: user reg/login
 * @author: Swati Bhat
 * @create: 2019-11-16 15:15
 */

public class UserController extends Controller {

    public Result authenticate() {

        System.out.println("In authenticate");
        JsonNode req = request().body().asJson();
        String username = req.get("username").asText();
        String password = req.get("password").asText();

        try {
            User user = User.findByName(username); // ( match where username and password both match )
            if(user!=null && username.equals(user.username) && password.equals(user.password)){
                return ok("true");
            }else{
                return ok("false");
            }
        }
        catch (Exception e) {
            return ok("false");
        }

    }


    /**
     * When a user register, check if the username is taken
     * save to database if valid
     * POST
     * @return success if valid, fail if already taken
     */
    public Result registerNew() {
        //TODO fix courses to list all courses taken not only take in one course
        System.out.println("In register");
        JsonNode req = request().body().asJson();
        String username = req.get("username").asText();
        String password = req.get("password").asText();
        String secQuestion1 = req.get("secQuestion1").asText();
        String secAnswer1 = req.get("secAnswer1").asText();
        String secQuestion2 = req.get("secQuestion1").asText();
        String secAnswer2 = req.get("secAnswer1").asText();
        String firstName = req.get("firstname").asText();
        String lastname = req.get("lastname").asText();
        String title = req.get("title").asText();
        String research = req.get("research").asText();
        String position = req.get("position").asText();
        String affiliation = req.get("affiliation").asText();
        String email = req.get("email").asText();
        String phone = req.get("phone").asText();
        String fax = req.get("fax").asText();
        String address = req.get("address").asText();
        String city = req.get("city").asText();
        String country = req.get("country").asText();
        String zipCode = req.get("zipCode").asText();
        String comments = req.get("comments").asText();
        String status = req.get("status").asText();
        String degreeplan = req.get("degreeplan").asText();
        String startingseason = req.get("startingseason").asText();
        String startingyear = req.get("startingyear").asText();
        String gradseason = req.get("gradseason").asText();
        String gradyear = req.get("gradyear").asText();
        String previouscourses = req.get("previouscourses").asText();


        User u = User.findByName(username);
        ObjectNode result = null;
        if (u == null) {
            System.out.println("new user");
            result = Json.newObject();
            User user = new User();
            user.status=status;
            user.degreeplan=degreeplan;
            user.startingseason=startingseason;
            user.startingyear=startingyear;
            user.gradyear=gradyear;
            user.gradseason=gradseason;
            user.previouscourses=previouscourses;
            user.username=username;
            user.password=password;
            user.secQuestion1=secQuestion1;
            user.secAnswer1=secAnswer1;
            user.secQuestion2=secQuestion2;
            user.secAnswer2=secAnswer2;
            user.title=title;
            user.affiliation=affiliation;
            user.position=position;
            user.research=research;
            user.firstname=firstName;
            user.lastname=lastname;
            user.email=email;
            user.phone=phone;
            user.fax=fax;
            user.address=address;
            user.city=city;
            user.country=country;
            user.zipCode=zipCode;
            user.comments=comments;


            user.save();
            result.put("body", username);
        }
        return ok(result);
    }


    public Result updatedata() {
        System.out.println("In update");
        JsonNode req = request().body().asJson();
        String username = req.get("username").asText();
        String password = req.get("password").asText();
        String secQuestion1 = req.get("secQuestion1").asText();
        String secAnswer1 = req.get("secAnswer1").asText();
        String secQuestion2 = req.get("secQuestion1").asText();
        String secAnswer2 = req.get("secAnswer1").asText();
        String firstName = req.get("firstname").asText();
        String lastname = req.get("lastname").asText();
        String title = req.get("title").asText();
        String research = req.get("research").asText();
        String position = req.get("position").asText();
        String affiliation = req.get("affiliation").asText();
        String email = req.get("email").asText();
        String phone = req.get("phone").asText();
        String fax = req.get("fax").asText();
        String address = req.get("address").asText();
        String city = req.get("city").asText();
        String country = req.get("country").asText();
        String zipCode = req.get("zipCode").asText();
        String comments = req.get("comments").asText();
        String status = req.get("status").asText();
        String degreeplan = req.get("degreeplan").asText();
        String startingseason = req.get("startingseason").asText();
        String startingyear = req.get("startingyear").asText();
        String gradseason = req.get("gradseason").asText();
        String gradyear = req.get("gradyear").asText();
        String previouscourses = req.get("previouscourses").asText();


        User u = User.findByName(username);
        ObjectNode result = null;

            System.out.println("new user");
            result = Json.newObject();
            User user = new User();
            user.status=status;
            user.degreeplan=degreeplan;
            user.startingseason=startingseason;
            user.startingyear=startingyear;
            user.gradyear=gradyear;
            user.gradseason=gradseason;
            user.previouscourses=previouscourses;
            user.username=username;
            user.password=password;
            user.secQuestion1=secQuestion1;
            user.secAnswer1=secAnswer1;
            user.secQuestion2=secQuestion2;
            user.secAnswer2=secAnswer2;
            user.title=title;
            user.affiliation=affiliation;
            user.position=position;
            user.research=research;
            user.firstname=firstName;
            user.lastname=lastname;
            user.email=email;
            user.phone=phone;
            user.fax=fax;
            user.address=address;
            user.city=city;
            user.country=country;
            user.zipCode=zipCode;
            user.comments=comments;


            user.save();//update rather than save
            result.put("body", username);

        return ok(result);

    }


    public Result NewTaForm() {
        //TODO add multi field and resume save

        System.out.println("In Taform");
        JsonNode req = request().body().asJson();

        String username = req.get("username").asText();
        String preference = req.get("preference1").asText();
        String preference1all = req.get("preference1all").asText();
        String preference2 = req.get("preference2").asText();
        String preference3 = req.get("preference3").asText();
        String notpreferred = req.get("notpreferred").asText();
        System.out.println("username = " + username);
        System.out.println("1st preference = " + preference);




            ObjectNode result1 = Json.newObject();

            TaApplication form = new TaApplication();
            form.username=username;
            form.preference=preference;
            form.preference1all=preference1all;
            form.preference2=preference2;
            form.preference3=preference3;
            form.notpreferred=notpreferred;



        System.out.println("new user");
            form.save();

            result1.put("body", username);
        System.out.println("returning");
        return ok(result1);
    }
    public JsonNode toJson(){

        JsonNode node = Json.toJson(this);
        return node;
    }
    public Result passwordChangeRequest(){
        System.out.println("In password change request");
        System.out.println("In password change request");
        JsonNode req = request().body().asJson();
        String username = req.get("username").asText();
        String email = req.get("email").asText();
        String a1 = req.get("secAnswer1").asText();
        String a2 = req.get("secAnswer2").asText();
        try {
            User user = User.findByName(username);
            if(user != null && username.equals(user.username) && email.equals(user.email) && a1.equals(user.secAnswer1) && a2.equals(user.secAnswer2))
            {
//                user.password = generatePassword();
//                System.out.println("Password: " + user.password);
                String newPass = generatePassword();
                user.setPassword(newPass);
//                user.password = newPass;
                user.save();
//                ObjectNode res = Json.newObject();
//                res.put("password", user.password);
                return ok("true");
            }else
            {
                return ok("false");
            }
        }
        catch(Exception e)
        {
            return ok("false");
        }
    }
    public static String generatePassword() {
        // Generate a random password of length 8
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

}
