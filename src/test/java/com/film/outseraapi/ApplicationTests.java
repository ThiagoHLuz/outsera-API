package com.film.outseraapi;

import com.film.outseraapi.controller.MovieControllerIntegrationTest;
import com.film.outseraapi.controller.ProducerControllerIntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		MovieControllerIntegrationTest.class,
		ProducerControllerIntegrationTest.class
})
@SpringBootTest
class ApplicationTests {

}
