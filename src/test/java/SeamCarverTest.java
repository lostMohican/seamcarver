import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.lang.reflect.Method;


public class SeamCarverTest {

    private SeamCarver seamCarver;

    @Before
    public void setUp() {
        seamCarver = new SeamCarver(new Picture("files/3x7.png"));

        Assert.assertNotNull(seamCarver);
    }

    @Test
    public void testPicture() throws Exception {
        Assert.assertNotNull(seamCarver.picture());
    }

    @Test
    public void testWidth() throws Exception {
        Assert.assertEquals(3, seamCarver.width());
    }

    @Test
    public void testHeight() throws Exception {
        Assert.assertEquals(7, seamCarver.height());
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
        int[] seam = seamCarver.findHorizontalSeam();

        Assert.assertNotNull(seam);
        Assert.assertTrue(seam.length == seamCarver.picture().width());
    }

    @Test
    public void testFindVerticalSeam() throws Exception {
        int[] seam = seamCarver.findVerticalSeam();

        Assert.assertNotNull(seam);
        Assert.assertTrue(seam.length == seamCarver.picture().height());
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

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveVerticalSeamIllegalArgument() throws Exception {
        int[] seam = seamCarver.findVerticalSeam();
        seam[0] = 5;

        seamCarver.removeVerticalSeam(seam);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveVerticalSeamNotValid() throws Exception {
        int[] seam = seamCarver.findVerticalSeam();
        seam[0] = 0;
        seam[1] = 2;

        seamCarver.removeVerticalSeam(seam);
    }

    @Test
    public void testComputeEnergy() throws Exception {
        Color c1 = new Color(255, 203, 51);
        Color c2 = new Color(255, 205, 255);

        Method method = SeamCarver.class.getDeclaredMethod("computeEnergy", Color.class, Color.class);
        method.setAccessible(true);
        int energy = (Integer) method.invoke(seamCarver, c1, c2);

        Assert.assertEquals(41620, energy);
    }

    @Test
    public void testAdjacency0() throws Exception {
        Method method = getAdjacentMethod();
        int[] adj = (int[]) method.invoke(seamCarver, 0);
        //int[] adj = seamCarver.adjacent(0);
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        Assert.assertArrayEquals(expected, adj);
    }


    @Test
    public void testAdjacency1() throws Exception {
        Method method = getAdjacentMethod();
        int[] adj = (int[]) method.invoke(seamCarver, 1);
        //int[] adj = seamCarver.adjacent(1);
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;

        Assert.assertArrayEquals(expected, adj);
    }

    @Test
    public void testAdjacency2() throws Exception {
        Method method = getAdjacentMethod();
        int[] adj = (int[]) method.invoke(seamCarver, 2);
        //int[] adj = seamCarver.adjacent(2);
        int[] expected = new int[2];
        expected[0] = 1;
        expected[1] = 2;

        Assert.assertArrayEquals(expected, adj);
    }

    private Method getAdjacentMethod() throws NoSuchMethodException {
        Method method = SeamCarver.class.getDeclaredMethod("adjacent", int.class);
        method.setAccessible(true);

        return method;
    }
}