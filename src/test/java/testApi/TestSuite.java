package testApi;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({SearchPerson.class, CreateAndUpdateClient.class, RegisterPolicy.class, ObtainPolicyDocument.class})

public class TestSuite{
    /*TEST SUITE*/
}