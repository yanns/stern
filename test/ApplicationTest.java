import org.junit.*;

import play.Logger;
import play.templates.TemplateLoader;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        for (int i = 0 ; i < 20 ; i++) {
            for (int j = 0 ; j < 10000 ; j++) {
                Response response = GET("/" + j);
                assertIsOk(response);
                assertContentType("text/html", response);
                assertCharset(play.Play.defaultWebEncoding, response);
            }
            Logger.info("clean template compiled cache");
            TemplateLoader.cleanCompiledCache();
            System.gc();
        }
    }

}