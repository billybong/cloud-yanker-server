package se.billy.cloudyank.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import java.util.*;

/**
 * User: bisj
 * Date: 2013-11-22
 * Time: 08:28
 */
@Path("/snippets")
public class SnippetResource {

    private Map<String, String> snippets = new HashMap<String, String>();

    @POST
    @Path("/{user}")
    public void addSnippet(@PathParam("user") String user, String snippet, @Context Request req){
        if(snippet == null || snippet.equals("")){
            return;
        }

        //UGLY mofo. Get my character codes right next time!
        snippet = snippet.replaceAll("\\u0000", "");
        snippets.put(user, snippet);
    }

    @GET
    @Path("/{user}")
    @Produces("text/plain")
    public String getSnippet(@PathParam("user") String user){
        final String storedSnippet = snippets.get(user);

        if(storedSnippet == null){
            return "";
        }

        return storedSnippet;
    }
}
