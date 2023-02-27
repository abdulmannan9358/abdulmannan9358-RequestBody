

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;


/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();
        
        /**
         * problem1: retrieve the song object from the request body...
         *      1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        //app.post("/echo", ctx -> {
          //  String jsonString=ctx.body();
            //implement logic here
                
        //});
        app.post("/echo", ctx -> {
            String jsonString = ctx.body();
            Song song = om.readValue(jsonString, Song.class);
            ctx.contentType("application/json");
            ctx.result(om.writeValueAsString(song));
        });
        /**
         * problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object as JSON in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        
        app.post("/changeartisttobeatles", ctx -> {
            String jsonString = ctx.body();
            Song song = om.readValue(jsonString, Song.class);
            song.artistName("Beatles");
            ctx.contentType("application/json");
            ctx.result(om.writeValueAsString(song));
        });


        return app;
    }
    
}
