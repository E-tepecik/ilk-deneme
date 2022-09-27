package day06;

public class Assertions_methodları {
    // En çok kullanılan ASSERTION methodları:
    // 1) Assert.assertTrue(koşul) ---> Doğru olmasını istediğimiz koşullarda bunu kullanıyoruz (sonucun doğru olmasını bekliyorsak)
    // 2) Assert.assertFalse(koşul) ---> Bir şartın yanlış olmasını bekliyorsak bunu kullanırız (sonucun false olmasını bekliyorsak)
    // 3) Assert.assertEqual(expected, actual) ---> İki değer verip bu iki değerin birbirine eşit olmasını bekliyorsak
    // NOT: Hangi methodu seçeceğimize bize verilen değerlere göre değil, test senaryosunun neyi öngördüğüne göre karar veririz.
    // assertTrue (TRUE) ---> PASSED
    // assertFalse (FALSE) ---> PASSED
    // assertTrue (FALSE) ---> FAILED
    // assertFalse (TRUE) ---> FAILED
    // assertEquals (EQUALS) ---> PASSED
    // assertEquals (NOT EQUALS) ---> FAILED
}
