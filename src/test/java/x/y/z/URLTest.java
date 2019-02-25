package x.y.z;

import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import org.junit.Test;

public class URLTest {

    @Test
    public void testURLClass() throws Exception {
        URL url = new URL("ftp://ftp.wwpdb.org/pub/pdb/data/structures/all/pdb/pdb132l.ent.gz");
        InputStream conn = new GZIPInputStream(url.openStream());
        conn.read();
    }

    @Test
    public void formatDateString() {
 
        SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat to = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date d = from.parse("0000-00-00");
            @SuppressWarnings("unused")
            String result = to.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
