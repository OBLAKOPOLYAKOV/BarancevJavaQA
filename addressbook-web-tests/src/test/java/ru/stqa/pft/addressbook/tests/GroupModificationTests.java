package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(app.db().groups().size() ==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test2"));
        }
    }


    @Test
    public void testGroupModification(){
        Groups before = app.db().groups();
        GroupData modifyGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifyGroup.getId())
                .withName("test2Edit").withHeader("test1").withFooter("test3");
        app.goTo().groupPage();
        app.group().modify(group);
        assertThat(app.group().count(),equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(modifyGroup).withAdded(group)));
        verifyGroupListInUi();
    }
}
