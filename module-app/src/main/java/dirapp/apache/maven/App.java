package dirapp.apache.maven;

import com.google.gson.Gson;

public class App 
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();

        Person person = new Person("Dira Sanjaya Wardana");

        String json = gson.toJson(person);

        System.out.println(json);
    }
}
