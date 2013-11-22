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

    private Map<String, Queue<String>> snippets = new HashMap<String, Queue<String>>();

    @POST
    @Path("/{user}")
    public void addSnippet(@PathParam("user") String user, String snippet, @Context Request req){
        if(snippet == null || snippet.equals("")){
            return;
        }

        //UGLY mofo. Get my character codes right next time!
        snippet = snippet.replaceAll("\\u0000", "");

        Queue<String> storedSnippets = snippets.get(user);
        if(storedSnippets == null){
            storedSnippets = Collections.asLifoQueue(new ArrayDeque<String>());
        }

        storedSnippets.offer(snippet);
        snippets.put(user, storedSnippets);
    }

    @GET
    @Path("/{user}")
    @Produces("text/plain")
    public String getSnippet(@PathParam("user") String user){
        final Queue<String> storedSnippets = snippets.get(user);

        if(storedSnippets == null || storedSnippets.peek() == null){
            return "";
        }

        return storedSnippets.remove();
    }
}
