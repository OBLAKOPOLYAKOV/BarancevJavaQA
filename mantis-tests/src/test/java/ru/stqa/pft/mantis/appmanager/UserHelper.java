package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager app) {
        super(app);
    }

    public String findConfirmationLink(List<MailMessage> mailMessages, String mail) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(mail)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    public void loginAdmin(){
        wd.get(app.getProperty("web.baseUrl"));
        type(By.name("username"), app.getProperty("web.adminLogin"));
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), app.getProperty("web.adminPassword"));
        click(By.cssSelector("input[type='submit']"));
    }

    public void changePasswordByAdmin(UserData user) {
        app.goTo().settingPage();
        app.goTo().settingUserPage();
        click(By.xpath("//a[contains(@href, '?user_id="+user.getId()+"')]"));

    }
}
