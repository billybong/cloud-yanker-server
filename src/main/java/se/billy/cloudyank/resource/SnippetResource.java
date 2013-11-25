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

        snippets.put(user, snippet);
    }

    @GET
    @Path("/{user}")
    @Produces("text/plain")
    public String getSnippet(@PathParam("user") String user){

        return snippets.get(user)==null?"":snippets.get(user);
    }
}
