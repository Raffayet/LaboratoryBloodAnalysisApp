package testiranje;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testiranje.controller.AnalizaControllerTest;
import testiranje.controller.EnumeracijeControllerTest;
import testiranje.controller.MusterijaControllerTest;

@RunWith(Suite.class)
@SuiteClasses({AnalizaControllerTest.class, EnumeracijeControllerTest.class, MusterijaControllerTest.class})
public class SviTestovi {

}
