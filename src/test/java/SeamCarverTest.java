import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeamCarverTest {

    private SeamCarver seamCarver;

    @Before
    public void setUp() {
        seamCarver = new SeamCarver(new Picture("files/3x7.png"));

        Assert.assertNotNull(seamCarver);
    }

    @Test
    public void testPicture() throws Exception {

    }

    @Test
    public void testWidth() throws Exception {

    }

    @Test
    public void testHeight() throws Exception {

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEnergyXOutOfBounds() throws Exception {
        seamCarver.energy(20, 20);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEnergyYOutOfBounds() throws Exception {
        seamCarver.energy(20, 20);
    }

    @Test
    public void testEnergy() throws Exception {

    }

    @Test
    public void testFindHorizontalSeam() throws Exception {

    }

    @Test
    public void testFindVerticalSeam() throws Exception {

    }


    @Test(expected = NullPointerException.class)
    public void testHorizontalSeamWithNullArray() throws Exception {
        seamCarver.removeHorizontalSeam(null);
    }

    @Test(expected = NullPointerException.class)
    public void testVerticalSeamWithNullArray() throws Exception {
        seamCarver.removeVerticalSeam(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHorizontalSeamLengthDifferent() throws Exception {

        int[] seam = new int[4];

        seamCarver.removeHorizontalSeam(seam);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHorizontalSeamLengthDifferent2() throws Exception {

        int[] seam = new int[0];

        seamCarver.removeHorizontalSeam(seam);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHorizontalSeamLengthDifferentVertical() throws Exception {

        int[] seam = new int[10];

        seamCarver.removeVerticalSeam(seam);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHorizontalSeamLengthDifferentVertical2() throws Exception {

        int[] seam = new int[0];

        seamCarver.removeVerticalSeam(seam);
    }

    @Test
    public void testRemoveHorizontalSeam() throws Exception {

    }

    @Test
    public void testRemoveVerticalSeam() throws Exception {

    }
}