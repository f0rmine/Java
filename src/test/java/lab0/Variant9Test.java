package lab0;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;

public class Variant9Test {

    @Test
    public void testIntegerTask() {
        assertEquals(new Variant9().integerTask(123), 1); // 123 -> 1 (перша цифра)
        assertEquals(new Variant9().integerTask(456), 4); // 456 -> 4 (перша цифра)
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIntegerTaskInvalid() {
        new Variant9().integerTask(99); // має видати виключення для нетризначного числа
    }

    @Test
    public void testBooleanTask() {
        assertFalse(new Variant9().booleanTask(2, 4)); // обидва парні
        assertTrue(new Variant9().booleanTask(1, 4)); // перше непарне
        assertTrue(new Variant9().booleanTask(2, 3)); // друге непарне
    }

    @Test
    public void testIfTask() {
        assertEquals(new Variant9().ifTask(5.0, 3.0), new double[]{3.0, 5.0}); // заміна, так як 5 > 3
        assertEquals(new Variant9().ifTask(2.0, 8.0), new double[]{2.0, 8.0}); // заміни не буде, так як 2 < 8
    }

    @Test
    public void testSwitchTask() {
        assertEquals(new Variant9().caseTask(31, 12), new int[]{1, 1}); // Наступний день це 1 січня
        assertEquals(new Variant9().caseTask(28, 2), new int[]{1, 3}); // Наступний день це 1 березня
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSwitchTaskInvalid() {
        new Variant9().caseTask(32, 13); // має видати виключення для неправильної дати
    }

    @Test
    public void testForTask() {
        assertEquals(new Variant9().forTask(1, 3), 14); // 1^2 + 2^2 + 3^2 = 1 + 4 + 9 = 14
        assertEquals(new Variant9().forTask(2, 5), 54); // 2^2 + 3^2 + 4^2 + 5^2 = 4 + 9 + 16 + 25 = 54
    }

    @Test
    public void testWhileTask() {
        assertEquals(new Variant9().whileTask(10), 3); // 3^3 = 27 > 10
        assertEquals(new Variant9().whileTask(27), 3); // 3^3 = 27
        assertEquals(new Variant9().whileTask(80), 4); // 3^4 = 81 > 80
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWhileTaskInvalid() {
        new Variant9().whileTask(1); // має видати виключення через n <= 1
    }

    @Test
    public void testArrayTask() {
        assertEquals(new Variant9().arrayTask(new int[]{1, 2, 3, 4, 5, 6}), Arrays.asList(6, 4, 2)); // Парні числа в зворотньому порядку
        assertEquals(new Variant9().arrayTask(new int[]{7, 8, 9, 10}), Arrays.asList(10, 8)); // Парні числа в зворотньому порядку
        assertEquals(new Variant9().arrayTask(new int[]{1, 3, 5, 7}), Arrays.asList()); // Немає парних
    }
//
//    @Test
//    public void testMatrixTask() {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        assertEquals(new Variant9().matrixTask(matrix, 1), new int[]{1, 4, 7}); // перший стовбець
//        assertEquals(new Variant9().matrixTask(matrix, 2), new int[]{2, 5, 8}); // другий стовбець
//        assertEquals(new Variant9().matrixTask(matrix, 3), new int[]{3, 6, 9}); // третій стовбець
//    }
//
//    @Test(expectedExceptions = IllegalArgumentException.class)
//    public void testMatrixTaskInvalid() {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        new Variant9().matrixTask(matrix, 4); // Should throw exception for K > N
//    }

}
