import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/");
        assertEquals("There are 1391 total files to search.", h.handleRequest(rootPath));
	}
	
    @Test 
	public void testSearch() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=Resonance");
        String expect = "Found 2 paths:\n./technical/biomed/ar615.txt\n./technical/plos/journal.pbio.0020150.txt";
        assertEquals(expect, h.handleRequest(rootPath));
	}

    /*
     * Tests that it searches for the string "basepair"
     * correctly  
     */
    @Test 
	public void testSearchBasePair() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=basepair");
        String expect = "Found 10 paths:\n" + //
                        "./technical/biomed/1471-2091-4-5.txt\n" + //
                        "./technical/biomed/1471-2105-3-2.txt\n" + //
                        "./technical/biomed/1471-2105-3-30.txt\n" + //
                        "./technical/biomed/1471-2105-3-37.txt\n" + //
                        "./technical/biomed/1471-2164-2-7.txt\n" + //
                        "./technical/biomed/1471-2180-1-26.txt\n" + //
                        "./technical/biomed/1471-2180-2-13.txt\n" + //
                        "./technical/biomed/ar319.txt\n" + //
                        "./technical/plos/journal.pbio.0020133.txt\n" + //
                        "./technical/plos/journal.pbio.0020431.txt";
        assertEquals(expect, h.handleRequest(rootPath));
	}

    /*
     * Tests that it searches for the string "hohoho"
     * correctly  
     */
    @Test 
	public void testSearchDNE() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=hohoho");
        String expect = "Found 0 paths:\n";
        assertEquals(expect, h.handleRequest(rootPath));
	}

}

