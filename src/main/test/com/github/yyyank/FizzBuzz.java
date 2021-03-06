package com.github.yyyank;

import org.junit.*;
import org.junit.rules.TestName;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FizzBuzz {


    @Rule
    public TestName name = new TestName();

    long startTime;

    @Before
    public void start(){
        startTime = System.nanoTime();
        System.out.println("[" + name.getMethodName() + "]" + System.nanoTime());
    }

    @After
    public void end(){
        System.out.println("[" + name.getMethodName() + "]" + (new BigDecimal(System.nanoTime() - startTime).movePointLeft(9).toPlainString()) + "秒");
    }

    @Test
    public void fizzBuzz() {
        for (int i = 0; i < 100; i++)
            try {
                FizzBuzzPitcher.overThrow(i);
            } catch (FizzException fizz) {
                System.out.println("fizz");
            } catch (BuzzException buzz) {
                System.out.println("buzz");
            } catch (FizzBuzzException fizzbuzz) {
                System.out.println("fizzbuzz");
            } catch (SonomamaException not) {
                System.out.println(i);
            }
    }

    @Test(expected = FizzException.class)
    public void fizzBuzz_fizz() {
        FizzBuzzPitcher.overThrow(3);
    }

    @Test(expected = BuzzException.class)
    public void fizzBuzz_buzz() {
        FizzBuzzPitcher.overThrow(5);
    }

    @Test(expected = FizzBuzzException.class)
    public void fizzBuzz_fizzbuzz() {
        FizzBuzzPitcher.overThrow(15);
    }

    @Test(expected = SonomamaException.class)
    public void fizzBuzz_sonomama() {
        FizzBuzzPitcher.overThrow(16);
    }

    @Test
    public void make_fizz() {
        assertThat(make(3), is("fizz"));
    }

    @Test
    public void make_buzz() {
        assertThat(make(5), is("buzz"));
    }

    @Test
    public void make_fizzbuzz() {
        assertThat(make(15), is("fizzbuzz"));
    }
    @Test
    public void make_sonomama() {
        assertThat(make(16), is("16"));
    }


    @Test
    public void fizzBuzz2() throws Exception {
        for (int i = 0; i < 100; i++) FizzBuzzCatcher.receive(i);
    }


    @Test
    public void fizzBuzz3() throws Exception {
        IntStream.rangeClosed(0, 100).mapToObj(FizzBuzz::make).forEach(System.out::println);
    }

    private static String make(int i) {
        return  i != 0 && i % 15 == 0 ? "fizzbuzz" : i != 0 && i % 3 == 0  ? "fizz" : i != 0 && i % 5 == 0  ? "buzz" : String.valueOf(i);
    }

}
