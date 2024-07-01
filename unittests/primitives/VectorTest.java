package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

/**
 * Unit tests for primitives.Vector class
 *
 * @author Eti and Gitty
 */

class VectorTest {

    public static final double DELTA = 0.00001;

    /**
     * Test method for {@link primitives.Vector#add(primitives.Vector)}.
     */
    @Test
    void testAdd() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(1, 0, 0);

        // ============ Equivalence Partitions Tests ==============
        assertEquals(new Vector(2, 2, 3), v1.add(v2), "Wrong result of adding");

        // =============== Boundary Values Tests ==================
        assertThrows(
                IllegalArgumentException.class,
                () -> v1.add(new Vector(-1, -2, -3)),
                "ERROR: Vector + -itself does not throw an exception"
        );

    }

    /**
     * Test method for {@link primitives.Vector#scale(double)}.
     */
    @Test
    void testScale() {
        // ============ Equivalence Partitions Tests ==============
        Vector v = new Vector(1, 2, 3);
        assertEquals(new Vector(2, 4, 6), v.scale(2), "Wrong result for multiplying vector with scalar");
        //checks multiplying by negative
        assertEquals(new Vector(-1, -2, -3), v.scale(-1), "Wrong result for multiplying vector with scalar");
        // We didn't do check for multiplying vector with 0, because we cant create zero vector
    }

    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @Test
    void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);
        Vector v3 = new Vector(0, 3, -2);

        // =============== Boundary Values Tests ==================
        assertEquals(0d, v1.dotProduct(v3), DELTA, "ERROR: dotProduct() for orthogonal vectors is not zero");

        // ============ Equivalence Partitions Tests ==============
        assertEquals(-28d, v1.dotProduct(v2), DELTA, "ERROR: dotProduct() wrong value");
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);
        Vector v3 = new Vector(0, 3, -2);
        // =============== Boundary Values Tests ==================
        assertThrows(
                IllegalArgumentException.class,
                () -> v1.crossProduct(v2),
                "ERROR: crossProduct() for parallel vectors does not throw an exception"
        );

        // ============ Equivalence Partitions Tests ==============
        Vector vr = v1.crossProduct(v3);
        // TC01: Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals(v1.length() * v3.length(),
                vr.length(),
                DELTA,
                "ERROR: crossProduct() wrong result length");
        // TC02: Test cross-product result orthogonality to its operands
        assertTrue(
                isZero(vr.dotProduct(v1)) && isZero(vr.dotProduct(v3)),
                "ERROR: crossProduct() result is not orthogonal to its operands"
        );
    }

    /**
     * Test method for {@link primitives.Vector#lengthSquared()}.
     */
    @Test
    void testLengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(14,
                v1.lengthSquared(),
                DELTA,
                "ERROR: lengthSquared() wrong value");
    }

    /**
     * Test method for {@link primitives.Vector#length()}.
     */
    @Test
    void testLength() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(2, 4, 4);
        assertEquals(6, v1.length(), DELTA, "ERROR: lengthSquared() wrong value");
    }

    /**
     * Test method for {@link primitives.Vector#normalize()}.
     */
    @Test
    void testNormalize() {
        Vector v = new Vector(1, 2, 3);
        Vector u = v.normalize();
        // ============ Equivalence Partitions Tests ==============
        //TC01 test that the length of normalized vector equal 1.
        assertEquals(1,
                u.length(),
                DELTA,
                "ERROR: the normalized vector is not a unit vector");

        //TC02 test that the normalized vector is parallel to the original one.
        assertThrows(
                IllegalArgumentException.class,
                () -> v.crossProduct(u),
                "ERROR: the normalized vector is not parallel to the original one"
        );

        //TC03 test that the normalized vector have the same direction to the original one.
        assertFalse(v.dotProduct(u) < 0, "ERROR: the normalized vector is opposite to the original one");
    }
}