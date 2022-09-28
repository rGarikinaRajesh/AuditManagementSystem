package com.cognizant.AuditAuthenticationMicroservice.ModelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.AuditAuthenticationMicroservice.Model.ProjectManager;

@SpringBootTest
public class ProjectManagerTest {
    
    ProjectManager projectManager = new ProjectManager();
    

 

    /**
     * to test the all param constructor of userRetail
     */
    @Test
    public void testProjectManagerAllConstructor()
    {
        ProjectManager manager=new ProjectManager("abc", "123"," ");
        assertEquals( "abc" , manager.getUsername());
    }
    /**
     * to test the getter setter of Uid
     */
    @Test
    public void testUserid()
    {
        projectManager.setUsername("abc");
        assertEquals( "abc",  projectManager.getUsername());
    }
    /**
     * to test the getter setter of UserPassword
     */
    @Test
    public void testUserPassword()
    {
        projectManager.setPassword("abc");
        assertEquals( "abc" , projectManager.getPassword());
    }
    /**
     * to test the getter setter of AuthToken
     */
  
    /**
     * to test the toString
     */
    @Test
    public void testoString() {
        String string = projectManager.toString();
        assertEquals(string , projectManager.toString());
    }

 

}