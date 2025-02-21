ppackage id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    private MainController mainController; // Gunakan MainController, bukan MainControllerTest

    @BeforeEach
    void setUp() {
        mainController = new MainController(); // Inisialisasi objek MainController
    }

    @Test
    void testMainPage() {
        String view = mainController.testMainPage(); // Memanggil metode yang diuji
        assertEquals("homePage", view); // Bandingkan hasil return dengan "homePage"
    }
}
