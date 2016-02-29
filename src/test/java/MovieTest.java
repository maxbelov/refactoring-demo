/**
 * Created by askryl on 29.02.16.
 */

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class MovieTest {
    @Test
    public void shouldReturnPriceCodeAndTitleAfterCreate() {

        Movie sut = new Movie("Test1", PriceCodes.Childrens);

        assertTrue( sut.getPriceCode() == PriceCodes.Childrens );
        assertTrue( "Test1".equals( sut.getTitle() ) );


    }
}
