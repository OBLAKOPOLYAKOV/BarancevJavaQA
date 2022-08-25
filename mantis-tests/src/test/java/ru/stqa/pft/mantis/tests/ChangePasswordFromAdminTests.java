package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordFromAdminTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() throws IOException {
        app.mail().start();
        if ( app.db().users().size()==0){
            long now = System.currentTimeMillis();
            String mail = String.format("user%s@localhost.localadmin", now);
            String userName = String.format("user%s", now);
            String password = "password";
            app.registration().start(userName,mail);
            List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
            String confirmationLink = app.user().findConfirmationLink(mailMessages, mail);
            app.registration().finish(confirmationLink, password);
        }
    }

    @Test
    public void testChangePassword() throws IOException {
        Users allUser = app.db().users();
        UserData user = allUser.iterator().next();
        app.user().loginAdmin();
        app.user().changePasswordByAdmin(user);

    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
